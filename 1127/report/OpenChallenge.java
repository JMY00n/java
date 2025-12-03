package chapter16;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OpenChallenge extends JFrame {
	private static final long serialVersionUID = 1L;

	// DB 연결 객체 저장용
	private Connection conn; 
	// 현재 보여주고 있는 이미지의 ID (0부터 시작해서 버튼 누르면 1로 만듦)
	private int currentId = 0; 

	private JPanel panel = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("메뉴");
	private JMenu exit = new JMenu("종료");
	private JMenuItem open = new JMenuItem("열기");
	private JFileChooser fileChooser = new JFileChooser();
	
	private JPanel pn = new JPanel();
	private JPanel pc = new JPanel();
	private JPanel ps = new JPanel();
	
	private JButton nextBtn = new JButton("다음 시작");
	private JLabel imageLabel = new JLabel("사진 없음"); 

	// 생성자에서 Connection을 받도록 수정
	public OpenChallenge(Connection conn) {
		super("이미지 데이터 베이스");
		this.conn = conn; // 받아온 연결 객체 저장
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new BorderLayout()); 
		setContentPane(panel);
		setSize(400, 400);

		menu.add(open);
		menuBar.add(menu);
		menuBar.add(exit);
		
		ps.add(nextBtn);
		
		pc.setLayout(new BorderLayout());
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pc.add(imageLabel, BorderLayout.CENTER);
		
		panel.add(pn, BorderLayout.NORTH);
		panel.add(pc, BorderLayout.CENTER);
		panel.add(ps, BorderLayout.SOUTH);

		// [열기] 메뉴: 파일 선택 기능 (기존 유지)
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(OpenChallenge.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					displayImage(selectedFile.getPath()); // 이미지 띄우기 메서드 호출
				}
			}
		});

		// [다음 시작] 버튼: DB에서 다음 이미지 불러오기
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadNextImageFromDB();
			}
		});

		setJMenuBar(menuBar);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// DB에서 다음 이미지 경로를 가져오는 메서드
	private void loadNextImageFromDB() {
		currentId++; // ID 증가
		
		String sql = "SELECT file_path FROM pictures WHERE id = ?";
		
		try {
			// 1. 쿼리 준비
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, currentId);
			
			// 2. 쿼리 실행
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// 데이터가 있으면 경로를 가져와서 이미지 표시
				String path = rs.getString("file_path");
				System.out.println("ID " + currentId + "번 이미지 로드: " + path);
				displayImage(path);
			} else {
				// 데이터가 없으면 (5번 이후) 다시 1번으로 돌아가기
				System.out.println("마지막 이미지입니다. 처음으로 돌아갑니다.");
				currentId = 0; // 0으로 초기화하고 재귀호출하면 1번부터 다시 시작
				loadNextImageFromDB();
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			imageLabel.setText("DB 오류 발생");
		}
	}

	// 이미지 경로를 받아 화면에 그리는 공통 메서드
	private void displayImage(String path) {
		ImageIcon icon = new ImageIcon(path);
		
		// 이미지 파일이 실제로 존재하는지 확인 (경로 오류 방지)
		File f = new File(path);
		if(!f.exists()) {
			imageLabel.setText("파일을 찾을 수 없음: " + f.getName());
			imageLabel.setIcon(null);
			return;
		}

		Image img = icon.getImage();
		// 라벨 크기에 맞춰 이미지 리사이징 (화면 깨짐 방지)
		// pc패널의 크기를 가져오되, 처음에 0일 수 있으므로 기본값 300 사용
		int width = pc.getWidth() > 0 ? pc.getWidth() : 300;
		int height = pc.getHeight() > 0 ? pc.getHeight() : 300;
		
		Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(scaledImg));
		imageLabel.setText(""); // 텍스트 제거
	}

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB 정보 수정 필요
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openchallenge", "root", "wjdalsdl!590");
			System.out.println("DB 연결 성공, GUI 실행");
			
			// 연결된 conn 객체를 가지고 GUI 생성
			new OpenChallenge(conn);
			
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
	}
}