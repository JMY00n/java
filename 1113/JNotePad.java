package chapter10; // 패키지 이름은 본인 환경에 맞게 수정하세요

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class JNotePad extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextPane _textPane;
	private ActionMap _actionMap;
	private boolean _isSaved = true;
	private JFileChooser _fc = new JFileChooser(".");
	private File _file = null;
	private FindDialog _findDialog = null;

	public JNotePad() {
		super("JNotePad (메모장)"); // 텍스트가 없는 제목 대신 이름 설정
		_textPane = new JTextPane();
		_textPane.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				_isSaved = false;
			}

			public void removeUpdate(DocumentEvent e) {
				_isSaved = false;
			}

			public void changedUpdate(DocumentEvent e) {
				_isSaved = false;
			}
		});
		JScrollPane p = new JScrollPane(_textPane);
		add(p);
		_actionMap = createActionMap();
		setJMenuBar(createMenuBar());
		add(createToolBar(), BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ----------------------------------------------------
	// GUI 생성 (메뉴바, 툴바)
	// ----------------------------------------------------
	private JMenuBar createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		JMenu m;

		// File
		m = new JMenu("파일");
		m.add(new JMenuItem(_actionMap.get("새파일")));
		m.add(new JMenuItem(_actionMap.get("열기")));
		m.add(new JMenuItem(_actionMap.get("저장")));
		m.add(new JMenuItem(_actionMap.get("다른이름으로 저장")));
		m.addSeparator();
		m.add(new JMenuItem(_actionMap.get("종료")));
		menubar.add(m);

		// Edit
		m = new JMenu("수정");
		m.add(new JMenuItem(_actionMap.get("잘라내기")));
		m.add(new JMenuItem(_actionMap.get("복사")));
		m.add(new JMenuItem(_actionMap.get("붙여넣기")));
		m.add(new JMenuItem(_actionMap.get("찾기")));
		menubar.add(m);

		// Help
		m = new JMenu("도움말");
		m.add(new JMenuItem(_actionMap.get("도움말")));
		m.add(new JMenuItem(_actionMap.get("정보")));
		menubar.add(m);

		return menubar;
	}

	private JToolBar createToolBar() {
		JToolBar toolbar = new JToolBar();
		toolbar.add(new JButton(_actionMap.get("새파일")));
		toolbar.add(new JButton(_actionMap.get("열기")));
		toolbar.add(new JButton(_actionMap.get("저장")));
		toolbar.add(new JButton(_actionMap.get("다른이름으로 저장")));
		toolbar.addSeparator();

		toolbar.add(new JButton(_actionMap.get("복사")));
		toolbar.add(new JButton(_actionMap.get("잘라내기")));
		toolbar.add(new JButton(_actionMap.get("붙여넣기")));
		toolbar.add(new JButton(_actionMap.get("찾기")));
		toolbar.addSeparator();

		toolbar.add(new JButton(_actionMap.get("도움말")));
		toolbar.add(new JButton(_actionMap.get("정보")));

		Component[] comps = toolbar.getComponents();
		for (Component c : comps) {
			if (c instanceof JButton)
				c.setFocusable(false);
		}
		return toolbar;
	}

	// ----------------------------------------------------
	// 파일 처리 메서드 (열기, 저장, 다른이름으로 저장)
	// ----------------------------------------------------
	
	private boolean open() {
		// ❌ 오류 수정: if문 뒤의 ; 제거 및 {} 위치 수정
		if (_fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = _fc.getSelectedFile();
			try {
				open(file);
				_file = file;
				setTitle(file.getName() + " - JNotePad");
				return true;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "파일을 열 수 없습니다: " + file, "텍스트 에디터", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return false;
	}
	
	private void open(File file) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(file));
		StringBuffer sbuf = new StringBuffer();
		char[] buf = new char[1024];
		int nread;

		while ((nread = r.read(buf)) != -1) {
			sbuf.append(buf, 0, nread);
		}
		r.close();
		_textPane.setText(sbuf.toString());
	}
	
	private boolean confirmSave() {
		if (_isSaved)
			return true;
		int ret = JOptionPane.showConfirmDialog(this, "내용이 수정되었습니다. 저장하겠습니까?", "텍스트 에디터",
				JOptionPane.YES_NO_CANCEL_OPTION);
		switch (ret) {
		case JOptionPane.YES_OPTION:
			save();
			return true;
		case JOptionPane.NO_OPTION:
			return true;
		default: // CANCEL 또는 닫기
			return false;
		}
	}
	
	private boolean save() {
		if (_file == null)
			return saveAs();
		else
			try {
				save(_file);
				return true;
			} catch (IOException e) {
				showSaveErrorMessage(e);
			}
		return false;
	}
	
	public boolean saveAs() {
		if (_fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = _fc.getSelectedFile();
			try {
				save(file);
				_file = file;
				setTitle(file.getName() + " - 텍스트 에디터");
				return true;
			} catch (IOException e) {
				showSaveErrorMessage(e);
				return false;
			}
		}
		return false;
	}
	
	private void save(File file) throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter(file));
		w.write(_textPane.getText());
		w.close();
		_isSaved = true; // 저장이 완료되었으므로 상태 변경
	}
	
	private void showSaveErrorMessage(IOException e) {
		e.printStackTrace();
		String[] mesg = { "저장 할 수 없습니다." + _file, "접근불가" };
		JOptionPane.showMessageDialog(this, mesg, "텍스트 에디터", JOptionPane.ERROR_MESSAGE);
	}

	// ----------------------------------------------------
	// Action 내부 클래스들
	// ----------------------------------------------------
	
	private class NewAction extends AbstractAction {
		public NewAction() {
			super("새파일");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control N"));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
		}
		public void actionPerformed(ActionEvent e) {
			if (!confirmSave()) return;
			_textPane.setText("");
			_file = null; // 새 파일이므로 파일 객체 초기화
			setTitle("JNotePad"); // 제목 초기화
			_isSaved = true;
		}
	}

	private class OpenAction extends AbstractAction {
		public OpenAction() {
			super("열기");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control O"));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_O);
		}
		public void actionPerformed(ActionEvent e) {
			if (!confirmSave())
				return;
			_isSaved = open();
		}
	}
	
	private class SaveAction extends AbstractAction {
		public SaveAction() {
			super("저장");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
		}
		public void actionPerformed(ActionEvent e) {
			_isSaved = save();
		}
	}

	private class SaveAsAction extends AbstractAction {
		public SaveAsAction() {
			super("다른이름으로 저장");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control A"));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
		}
		public void actionPerformed(ActionEvent e) {
			// ❌ 오류 수정: 중복 호출 제거
			_isSaved = saveAs(); 
		}
	}
	
	private class ExitAction extends AbstractAction {
		public ExitAction() {
			super("종료");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control E"));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
		}
		public void actionPerformed(ActionEvent e) {
			if (!confirmSave())
				return;
			System.exit(0);
		}
	}

	private class CutAction extends AbstractAction {
		public CutAction() {
			super("잘라내기");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
		}
		public void actionPerformed(ActionEvent e) {
			_textPane.cut();
		}
	}

	private class CopyAction extends AbstractAction {
		public CopyAction() {
			super("복사"); // "복사하기" -> "복사"로 통일
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		}
		public void actionPerformed(ActionEvent e) {
			_textPane.copy();
		}
	}

	private class PasteAction extends AbstractAction {
		public PasteAction() {
			super("붙여넣기");
			// ❌ 오류 수정: Ctrl+O (열기)와 중복되므로 Ctrl+V로 변경
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V")); 
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P); 
		}
		public void actionPerformed(ActionEvent e) {
			_textPane.paste();
		}
	}

	// ----------------------------------------------------
	// ⭐ 찾기 (Find) 기능 구현
	// ----------------------------------------------------
	
	private class FindAction extends AbstractAction {
		public FindAction() {
			super("찾기");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control F"));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_F);
		}
		public void actionPerformed(ActionEvent e) {
			if (_findDialog == null) {
				_findDialog = new FindDialog(JNotePad.this);
			}
			_findDialog.setVisible(true);
			// ❌ 오류 수정: JDialog 자체가 아닌 내부 텍스트필드에 포커스 요청
			_findDialog.findField.requestFocusInWindow(); 
		}
	}

	private class FindDialog extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;
		JTextField findField = new JTextField(20); // ❌ _findDialog.findField에서 접근하도록 private -> default
		private JButton findButton = new JButton("다음 찾기");
		private Highlighter highlighter;
		private Highlighter.HighlightPainter painter;
		private int searchStartIndex = 0; 

		public FindDialog(JFrame owner) {
			super(owner, "텍스트 찾기", false); 
			this.highlighter = _textPane.getHighlighter();
			this.painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);

			setLayout(new FlowLayout());
			add(new JLabel("검색어: "));
			add(findField);
			add(findButton);

			findButton.addActionListener(this); 
			findField.addActionListener(this); 
			setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			setSize(300, 150); 
			setLocationRelativeTo(owner);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			findAndHighlight(e.getSource()); 
		}

		private void findAndHighlight(Object source) {
			highlighter.removeAllHighlights();
			String searchText = findField.getText();
			if (searchText.isEmpty()) return;

			String content;
			try {
				content = _textPane.getDocument().getText(0, _textPane.getDocument().getLength());
			} catch (Exception ex) {
				return;
			}
			
			// ❌ 오류 수정: "다음 찾기" 버튼이 아닐 때만 인덱스 초기화
			if (source != findButton) { 
				searchStartIndex = 0;
			}
			
			int index = content.indexOf(searchText, searchStartIndex);

			if (index >= 0) {
				try {
					int end = index + searchText.length();
					highlighter.addHighlight(index, end, painter);
					_textPane.setCaretPosition(end);
					searchStartIndex = end; // 다음 검색 위치 갱신
					setTitle("텍스트 찾기 (" + searchText + ")");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, "더 이상 찾는 텍스트가 없습니다.", "텍스트 에디터", JOptionPane.INFORMATION_MESSAGE);
				searchStartIndex = 0; 
			}
		}
	}
	
	// ----------------------------------------------------
	// 도움말 및 정보
	// ----------------------------------------------------
	
	private class AboutAction extends AbstractAction {
		public AboutAction() {
			super("정보");
		}
		public void actionPerformed(ActionEvent e) {
			String[] mesg = { "텍스트 에디터 v1", "제작자: 최경섭 (수정)" };
			JOptionPane.showMessageDialog(JNotePad.this, mesg, "텍스트 에디터 정보", JOptionPane.INFORMATION_MESSAGE);
		}
	}
    
	private class HelpAction extends AbstractAction {
		public HelpAction() {
			super("도움말");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control H"));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_H);
		}
		public void actionPerformed(ActionEvent e) {
			String[] mesg = { "아직 지원하지 않습니다." };
			JOptionPane.showMessageDialog(JNotePad.this, mesg, "텍스트 에디터", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// ----------------------------------------------------
	// ActionMap 생성 및 Main
	// ----------------------------------------------------

	private ActionMap createActionMap() {
		ActionMap am = new ActionMap();
		am.put("정보", new AboutAction());
		am.put("도움말", new HelpAction());
		am.put("잘라내기", new CutAction());
		am.put("복사", new CopyAction());
		am.put("붙여넣기", new PasteAction());
		am.put("찾기", new FindAction()); // FindAction 등록
		am.put("종료", new ExitAction());
		am.put("새파일", new NewAction());
		am.put("열기", new OpenAction());
		am.put("저장", new SaveAction());
		am.put("다른이름으로 저장", new SaveAsAction());
		return am;
	}

	private void start() {
		setSize(600, 480);
		setLocationRelativeTo(null); // 화면 중앙 배치
		setVisible(true);
	}

	public static void main(String[] args) {
		new JNotePad().start();
	}
}