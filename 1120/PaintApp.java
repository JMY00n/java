package graphic;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PaintApp extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private DrawPanel drawPanel;
    private Color currentColor = Color.BLACK; 
    private Tool currentTool = Tool.PENCIL;   
    private float currentSize = 3.0f; 

    private Point startPoint = null;
    private Point endPoint = null;
    
    // [추가됨] 선택 영역을 저장할 사각형 변수
    private Rectangle selectionRect = null; 

    private enum Tool {
        SELECT, // [추가됨] 선택 도구
        PENCIL, ERASER, LINE, RECTANGLE, OVAL
    }

    public PaintApp() { 
        super("프로 그림판 (선택 도구 추가)");
        
        setLayout(new BorderLayout());
        
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);
        
        createMenuBar();
        createToolBar();

        setSize(1200, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // [파일] 메뉴
        JMenu fileMenu = new JMenu("파일(F)");
        fileMenu.setMnemonic('F');

        JMenuItem newItem = new JMenuItem("새로 만들기(N)");
        newItem.addActionListener(e -> { drawPanel.clear(); selectionRect = null; });
        JMenuItem openItem = new JMenuItem("불러오기(O)...");
        openItem.addActionListener(e -> openImage());
        JMenuItem saveItem = new JMenuItem("저장(S)...");
        saveItem.addActionListener(e -> saveImage());
        JMenuItem exitItem = new JMenuItem("종료(X)");
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // [편집] 메뉴
        JMenu editMenu = new JMenu("편집(E)");
        editMenu.setMnemonic('E');

        JMenuItem cutItem = new JMenuItem("자르기(T)"); // 선택 영역 잘라내기 구현 가능
        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        cutItem.addActionListener(e -> cutToClipboard());

        JMenuItem copyItem = new JMenuItem("복사(C)");
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        copyItem.addActionListener(e -> copyToClipboard());

        JMenuItem pasteItem = new JMenuItem("붙여넣기(P)");
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        pasteItem.addActionListener(e -> pasteFromClipboard());

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // [홈] 메뉴
        JMenu homeMenu = new JMenu("홈(H)");
        homeMenu.setMnemonic('H');
        
        JMenuItem chooseColorItem = new JMenuItem("색상 선택...");
        chooseColorItem.addActionListener(e -> pickColor());
        
        JMenuItem infoItem = new JMenuItem("정보(I)");
        infoItem.addActionListener(e -> showStudentInfo());

        homeMenu.add(chooseColorItem);
        homeMenu.addSeparator();
        homeMenu.add(infoItem);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(homeMenu);
        
        setJMenuBar(menuBar);
    }

    private void createToolBar() {
        JToolBar toolBar = new JToolBar("도구");
        toolBar.setFloatable(false);
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        // 1. 색상 버튼
        JPanel colorDisplayPanel = new JPanel() {
            @Override protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(currentColor);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.BLACK);
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            }
        };
        colorDisplayPanel.setPreferredSize(new Dimension(25, 25));
        JButton colorBtn = new JButton("색상");
        colorBtn.addActionListener(e -> { pickColor(); colorDisplayPanel.repaint(); });
        toolBar.add(colorBtn);
        toolBar.add(colorDisplayPanel);
        
        toolBar.addSeparator();

        // 2. [선택] 도구 (색상과 연필 사이)
        JButton selectBtn = createToolButton("선택", Tool.SELECT);
        selectBtn.setToolTipText("영역을 선택하여 복사할 수 있습니다.");
        toolBar.add(selectBtn);

        toolBar.addSeparator();

        // 3. 그리기 도구들
        toolBar.add(createToolButton("연필", Tool.PENCIL));
        toolBar.add(createToolButton("지우개", Tool.ERASER));
        toolBar.add(createToolButton("직선", Tool.LINE));
        toolBar.add(createToolButton("사각형", Tool.RECTANGLE));
        toolBar.add(createToolButton("원", Tool.OVAL));
        toolBar.addSeparator();

        toolBar.add(new JLabel(" 크기: "));
        JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(3, 1, 100, 1));
        sizeSpinner.addChangeListener(e -> {
            currentSize = ((Integer) sizeSpinner.getValue()).floatValue();
            drawPanel.requestFocus(); 
        });
        toolBar.add(sizeSpinner);
        toolBar.addSeparator();

        JButton clearBtn = new JButton("모두 지우기");
        clearBtn.addActionListener(e -> { drawPanel.clear(); selectionRect = null; });
        toolBar.add(clearBtn);

        add(toolBar, BorderLayout.NORTH);
    }
    
    // 도구 버튼 클릭 시 selectionRect 초기화 (다른 도구 가면 선택 해제)
    private JButton createToolButton(String name, Tool tool) {
        JButton btn = new JButton(name);
        btn.addActionListener(e -> {
            currentTool = tool;
            selectionRect = null; // 도구를 바꾸면 선택 영역 해제
            drawPanel.repaint();
        });
        return btn;
    }

    // ---------------------- 로직 메소드 ----------------------

    private void showStudentInfo() {
        JOptionPane.showMessageDialog(this, "202530533 컴퓨터소프트웨어학과 윤정민", "정보", JOptionPane.INFORMATION_MESSAGE);
    }

    private void pickColor() {
        Color chosen = JColorChooser.showDialog(this, "색상 선택", currentColor);
        if (chosen != null) currentColor = chosen;
    }

    // 1. 자르기 (복사 후 해당 영역 흰색으로 칠하기)
    private void cutToClipboard() {
        copyToClipboard(); // 먼저 복사
        if (selectionRect != null && drawPanel.g2 != null) {
            drawPanel.g2.setPaint(Color.WHITE);
            drawPanel.g2.fill(selectionRect); // 선택 영역 지우기
            drawPanel.repaint();
            selectionRect = null; // 선택 해제
        }
    }

    // 2. 복사 (선택 영역이 있으면 그것만, 없으면 전체)
    private void copyToClipboard() {
        if (drawPanel.image == null) return;
        
        BufferedImage imgToCopy;
        
        if (selectionRect != null) {
            // 선택된 영역만 잘라내서(Subimage) 복사
            // 좌표가 이미지 범위를 벗어나지 않도록 조정
            int x = Math.max(0, selectionRect.x);
            int y = Math.max(0, selectionRect.y);
            int w = Math.min(drawPanel.image.getWidth() - x, selectionRect.width);
            int h = Math.min(drawPanel.image.getHeight() - y, selectionRect.height);
            
            if (w <= 0 || h <= 0) return; // 유효하지 않은 영역
            
            imgToCopy = drawPanel.image.getSubimage(x, y, w, h);
        } else {
            // 선택 영역 없으면 전체 복사
            imgToCopy = drawPanel.image;
        }

        TransferableImage trans = new TransferableImage(imgToCopy);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);
        
        String msg = (selectionRect != null) ? "선택 영역이 복사되었습니다." : "전체 화면이 복사되었습니다.";
        JOptionPane.showMessageDialog(this, msg);
    }

    // 3. 붙여넣기
    private void pasteFromClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        if (contents != null && contents.isDataFlavorSupported(DataFlavor.imageFlavor)) {
            try {
                Image img = (Image) contents.getTransferData(DataFlavor.imageFlavor);
                if (img != null) {
                    BufferedImage bImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                    Graphics g = bImg.getGraphics();
                    g.drawImage(img, 0, 0, null);
                    g.dispose();
                    
                    // 왼쪽 상단에 붙여넣기
                    drawPanel.pasteImage(bImg);
                    
                    selectionRect = null; // 붙여넣기 후 선택 영역 해제
                    drawPanel.repaint();
                }
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }

    private class TransferableImage implements Transferable {
        private Image image;
        public TransferableImage(Image image) { this.image = image; }
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
            if (isDataFlavorSupported(flavor)) return image;
            throw new UnsupportedFlavorException(flavor);
        }
        public DataFlavor[] getTransferDataFlavors() { return new DataFlavor[]{DataFlavor.imageFlavor}; }
        public boolean isDataFlavorSupported(DataFlavor flavor) { return DataFlavor.imageFlavor.equals(flavor); }
    }
    
    private void openImage() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("이미지", "png", "jpg"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try { drawPanel.loadImage(ImageIO.read(fc.getSelectedFile())); } catch(Exception e) {}
        }
    }
    
    private void saveImage() {
        if (drawPanel.image == null) return;
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("PNG", "png"));
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try { ImageIO.write(drawPanel.image, "png", new File(fc.getSelectedFile().getPath() + ".png")); } catch(Exception e) {}
        }
    }

    // ---------------------- DrawPanel ----------------------
    class DrawPanel extends JPanel {
        BufferedImage image;
        Graphics2D g2;
        int prevX, prevY;

        public DrawPanel() {
            setDoubleBuffered(false);
            setBackground(Color.WHITE);
            MyMouseAdapter handler = new MyMouseAdapter();
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }
        
        public void loadImage(BufferedImage loadedImg) {
            image = new BufferedImage(loadedImg.getWidth(), loadedImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, image.getWidth(), image.getHeight());
            g2.drawImage(loadedImg, 0, 0, null);
            repaint();
        }
        
        public void pasteImage(BufferedImage pastedImg) {
            if (g2 != null) {
                g2.drawImage(pastedImg, 0, 0, null);
                repaint();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image == null) {
                image = new BufferedImage(Math.max(getWidth(), 1), Math.max(getHeight(), 1), BufferedImage.TYPE_INT_ARGB);
                g2 = (Graphics2D) image.getGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                clear();
            }
            g.drawImage(image, 0, 0, null);
            
            Graphics2D g2d = (Graphics2D) g;
            
            // 1. 도형 그리기 미리보기 (기존 기능)
            if (startPoint != null && endPoint != null && currentTool != Tool.SELECT &&
                (currentTool == Tool.LINE || currentTool == Tool.RECTANGLE || currentTool == Tool.OVAL)) {
                
                g2d.setColor(currentColor);
                g2d.setStroke(new BasicStroke(currentSize, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
                int x = Math.min(startPoint.x, endPoint.x);
                int y = Math.min(startPoint.y, endPoint.y);
                int w = Math.abs(startPoint.x - endPoint.x);
                int h = Math.abs(startPoint.y - endPoint.y);

                if (currentTool == Tool.LINE) g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                else if (currentTool == Tool.RECTANGLE) g2d.drawRect(x, y, w, h);
                else if (currentTool == Tool.OVAL) g2d.drawOval(x, y, w, h);
            }
            
            // 2. [추가됨] 선택 영역 점선 그리기 (검정/흰색 2중선으로 잘 보이게)
            if (selectionRect != null) {
                g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
                g2d.setColor(Color.BLACK);
                g2d.draw(selectionRect);
                g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 5)); // 오프셋을 줘서 겹치게
                g2d.setColor(Color.WHITE);
                g2d.draw(selectionRect);
            }
        }
        
        public void clear() {
            if (g2 != null) {
                g2.setPaint(Color.WHITE);
                g2.fillRect(0, 0, 2000, 2000);
                repaint();
            }
        }

        private class MyMouseAdapter extends MouseAdapter {
            @Override
            public void mousePressed(MouseEvent e) {
                prevX = e.getX(); prevY = e.getY();
                startPoint = e.getPoint(); endPoint = startPoint;
                
                // 선택 도구일 때, 클릭하면 일단 이전 선택 영역 해제 후 새로 시작
                if (currentTool == Tool.SELECT) {
                    selectionRect = null;
                    repaint();
                }
            }
    
            @Override
            public void mouseDragged(MouseEvent e) {
                if (g2 == null) return;
                
                if (currentTool == Tool.SELECT) {
                    // 선택 영역 계산 (드래그 중)
                    endPoint = e.getPoint();
                    int x = Math.min(startPoint.x, endPoint.x);
                    int y = Math.min(startPoint.y, endPoint.y);
                    int w = Math.abs(startPoint.x - endPoint.x);
                    int h = Math.abs(startPoint.y - endPoint.y);
                    selectionRect = new Rectangle(x, y, w, h);
                    repaint(); // 점선 다시 그리기
                }
                else if (currentTool == Tool.PENCIL || currentTool == Tool.ERASER) {
                    BasicStroke stroke = new BasicStroke(currentSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                    g2.setStroke(stroke);
                    g2.setPaint(currentTool == Tool.PENCIL ? currentColor : Color.WHITE);
                    g2.drawLine(prevX, prevY, e.getX(), e.getY());
                    prevX = e.getX(); prevY = e.getY();
                    repaint();
                }
                else { // 도형 도구
                    endPoint = e.getPoint();
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentTool == Tool.SELECT) {
                    // 마우스를 떼면 selectionRect가 확정됨 (null 처리 안함)
                }
                else if (startPoint != null && endPoint != null && 
                   (currentTool == Tool.LINE || currentTool == Tool.RECTANGLE || currentTool == Tool.OVAL)) {
                    g2.setPaint(currentColor);
                    g2.setStroke(new BasicStroke(currentSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    int x = Math.min(startPoint.x, endPoint.x);
                    int y = Math.min(startPoint.y, endPoint.y);
                    int w = Math.abs(startPoint.x - endPoint.x);
                    int h = Math.abs(startPoint.y - endPoint.y);
                    
                    if (currentTool == Tool.LINE) g2.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                    else if (currentTool == Tool.RECTANGLE) g2.drawRect(x, y, w, h);
                    else if (currentTool == Tool.OVAL) g2.drawOval(x, y, w, h);
                    
                    startPoint = null; endPoint = null; repaint();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PaintApp::new);
    }
}