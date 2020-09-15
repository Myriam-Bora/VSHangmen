package vsHangmen; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

public class Hangmen_2 extends JFrame {

	private JPanel contentPane;
	private JTextField Player_1;
	private JTextField Player_2_textField_1;
	private JTextField txtVs;
	static int player1score = 0; 
	static int player2score = 0;
	static int player1life = 20;
	static int player2life = 20;
	String quiz;
	String answer;
	String playerclick = null;
	char [] chquiz = {};
	char [] chanswer = {};
	private JTextField txtComputer;
	private JTextField textField;
	private JTextField textField_1;
	// turn 이 1일경우 플레이어1의 턴, -1일 경우 플레이어2의 턴
	int turn = 1;
	// 이긴플레이어 이름 저장 메소드
	String winner = null; 
	
	// 버튼 모음집
	ArrayList<JButton> buttons = new ArrayList<JButton>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hangmen_2 frame = new Hangmen_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hangmen_2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(135, 206, 250));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 결과창 뜨는 판넬
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(221, 67, 482, 441);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		// 판넬 제목 - 게임종료
		JLabel lblNewLabel_3 = new JLabel("\uAC8C\uC784\uC885\uB8CC");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("휴먼매직체", Font.PLAIN, 45));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(50, 21, 379, 72);
		panel_2.add(lblNewLabel_3);
		
		// 결과창 player1 name
		JLabel lblNewLabel_4 = new JLabel(Import_Class.player1name);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("한컴산뜻돋움", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_4.setBounds(65, 105, 85, 61);
		panel_2.add(lblNewLabel_4);
		
		// 결과창 player2 name
		JLabel label_3 = new JLabel(Import_Class.player2name);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("한컴산뜻돋움", Font.BOLD | Font.ITALIC, 24));
		label_3.setBounds(323, 105, 89, 61);
		panel_2.add(label_3);
		
		// 결과창 player1 점수
		JLabel lblNewLabel_5 = new JLabel(Integer.toString(player1score));
		lblNewLabel_5.setFont(new Font("Bernard MT Condensed", Font.BOLD, 50));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(50, 191, 99, 50);
		panel_2.add(lblNewLabel_5);
		
		// 결과창 player2 점수
		JLabel label_4 = new JLabel(Integer.toString(player2score));
		label_4.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(323, 191, 89, 50);
		panel_2.add(label_4);
		
		// 결과창 이름
		JLabel lblNewLabel_6 = new JLabel("PLAYER");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(168, 116, 143, 50);
		panel_2.add(lblNewLabel_6);
		
		// 결과창 점수 
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setBackground(new Color(0, 0, 0));
		lblScore.setForeground(new Color(0, 0, 0));
		lblScore.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(179, 198, 122, 50);
		panel_2.add(lblScore);
		
		// 결과창 승리자 이름 출력 라벨
		if(player1score > player2score) 
			winner = Import_Class.player1name+"의 승리";
		else if(player1score < player2score) 
			winner = Import_Class.player2name+"의 승리";
		else if(player1score == player2score)
			winner = "무승부";
		
		JLabel lblNewLabel_7 = new JLabel(winner+"입니다!");
		lblNewLabel_7.setForeground(new Color(0, 0, 128));
		lblNewLabel_7.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(33, 266, 437, 96);
		panel_2.add(lblNewLabel_7);
		
		/// 결과창 다시하기 버튼
		JButton btnNewButton_3 = new JButton("\uB2E4\uC2DC\uD558\uAE30");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Hangmen_2().setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_3.setBounds(65, 365, 147, 50);
		panel_2.add(btnNewButton_3);
		
		// 결과창 시작화면으로 버튼
		JButton button_25 = new JButton("\uBA54\uC778\uD654\uBA74\uC73C\uB85C");
		button_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Hangmen_main().setVisible(true);
			}
		});
		button_25.setFont(new Font("굴림", Font.BOLD, 15));
		button_25.setBounds(265, 365, 147, 50);
		panel_2.add(button_25);
		
		panel_2.setVisible(false); // 결과창 판넬 숨기기
		///// 결과창 판넬 끝
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/user.png")));
		lblNewLabel.setBounds(748, 10, 111, 111);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/user.png")));
		label.setBounds(45, 10, 96, 111);
		contentPane.add(label);
		
		// player 1 name
		Player_1 = new JTextField(Import_Class.player1name);
		Player_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		Player_1.setHorizontalAlignment(SwingConstants.CENTER);
		Player_1.setEditable(false);
		Player_1.setBounds(32, 116, 128, 30);
		contentPane.add(Player_1);
		Player_1.setColumns(10);
		
		// player 2 name
		Player_2_textField_1 = new JTextField(Import_Class.player2name);
		Player_2_textField_1.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 15));
		Player_2_textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		Player_2_textField_1.setEditable(false);
		Player_2_textField_1.setBounds(731, 116, 128, 30);
		contentPane.add(Player_2_textField_1);
		Player_2_textField_1.setColumns(10);
		

		JPanel panel = new JPanel();
		panel.setBounds(32, 147, 143, 211);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// hangman 이미지 들어갈 장소1
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/1-15.png")));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(0, 0, 143, 211);
		panel.add(label_9);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(716, 147, 143, 211);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		// hangman 이미지 들어갈 장소2
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/2-15.png")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(0, 0, 143, 211);
		panel_1.add(label_6);
		
		txtVs = new JTextField();
		txtVs.setBackground(new Color(32, 178, 170));
		txtVs.setFont(new Font("Algerian", Font.BOLD, 35));
		txtVs.setHorizontalAlignment(SwingConstants.CENTER);
		txtVs.setText("VS");
		txtVs.setBounds(406, 178, 89, 77);
		contentPane.add(txtVs);
		txtVs.setColumns(10);
		
		
		// 메인화면으로 돌아가는 버튼
		JButton btnNewButton_1 = new JButton("\uCC98\uC74C\uC73C\uB85C");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 예,아니오,취소 세가지 선택의 리턴값을 받기위해 int bada를 만든다
				int bada1 = JOptionPane.showConfirmDialog( null, "정말 메인화면으로?"
						,"메인화면으로~", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
				// yes면 0, no면 1, 취소는 2	
				if(bada1==0) { // 예 라고 누르면 프로그램 종료
					dispose();
					setVisible(false);
					new Hangmen_main().setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(776, 503, 96, 48);
		contentPane.add(btnNewButton_1);
		
		// 플레이어 1 목숨
		JLabel label_7 = new JLabel(Integer.toString(player1life));
		label_7.setBackground(new Color(255, 255, 255));
		label_7.setFont(new Font("굴림", Font.BOLD, 15));
		label_7.setBounds(92, 381, 24, 21);
		contentPane.add(label_7);
		
		// 플레이어 2 목숨
		JLabel label_8 = new JLabel(Integer.toString(player2life));
		label_8.setFont(new Font("굴림", Font.BOLD, 15));
		label_8.setBounds(781, 382, 24, 18);
		contentPane.add(label_8);
		
		JLabel lblNewLabel_1 = new JLabel("");		//유저1 하트
		lblNewLabel_1.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/heart.png")));
		lblNewLabel_1.setBounds(77, 368, 55, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("");			//유저2하트
		label_1.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/heart.png")));
		label_1.setBounds(767, 368, 55, 48);
		contentPane.add(label_1);
		
		
		// 답안지 출력란
		txtComputer = new JTextField();
		txtComputer.setEditable(false);
		txtComputer.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
		txtComputer.setHorizontalAlignment(SwingConstants.CENTER);
		txtComputer.setText(answer);
		txtComputer.setBounds(316, 299, 259, 48);
		contentPane.add(txtComputer);
		txtComputer.setColumns(10);
		
		// 플레이어1 현재점수판
		textField = new JTextField("0");
		textField.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
		textField.setEditable(false);
		textField.setText(Integer.toString(player1score));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(165, 10, 55, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// 플레이어2 현재점수판
		textField_1 = new JTextField("0");
		textField_1.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
		textField_1.setEditable(false);
		textField_1.setText(Integer.toString(player2score));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(668, 12, 55, 48);
		contentPane.add(textField_1);
		
		// 플레이어1 턴표시 화살표
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/finger-red-left.png")));
		lblNewLabel_2.setBounds(153, 70, 37, 48);
		contentPane.add(lblNewLabel_2);
		
		// 플레이어2 턴표시 화살표
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/finger-red-right.png")));
		label_2.setBounds(699, 70, 37, 48);
		contentPane.add(label_2);
		
		// 초기 턴 표시용 
		turnchange(turn,lblNewLabel_2,label_2);
		
		// 자판 판넬 시작
		JPanel Alpa_panel = new JPanel();
		contentPane.add(Alpa_panel);
		Alpa_panel.setBackground(new Color(240, 230, 140));
		Alpa_panel.setBorder(new LineBorder(new Color(192, 192, 192), 4, true));
		Alpa_panel.setBounds(154, 368, 581, 183);
		contentPane.add(Alpa_panel);
		Alpa_panel.setLayout(null);
		Alpa_panel.setVisible(false);
		JButton btnNewButton = new JButton("a");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(btnNewButton,'a',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}


		});
		btnNewButton.setBounds(12, 10, 50, 39);
		Alpa_panel.add(btnNewButton);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(26, 10, 46, 39);
		Alpa_panel.add(btnNewButton);
		
		JButton button = new JButton("b");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button,'b',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 20));
		button.setBackground(new Color(135, 206, 250));
		button.setBounds(84, 10, 46, 39);
		Alpa_panel.add(button);
		
		JButton button_1 = new JButton("c");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_1,'c',chquiz,chanswer,answer,quiz,turn,
							label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
							,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 20));
		button_1.setBackground(new Color(135, 206, 250));
		button_1.setBounds(142, 10, 46, 39);
		Alpa_panel.add(button_1);
		
		JButton button_2 = new JButton("d");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_2,'d',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_2.setFont(new Font("굴림", Font.BOLD, 20));
		button_2.setBackground(new Color(135, 206, 250));
		button_2.setBounds(200, 10, 46, 39);
		Alpa_panel.add(button_2);
		
		JButton button_3 = new JButton("e");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_3,'e',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_3.setFont(new Font("굴림", Font.BOLD, 20));
		button_3.setBackground(new Color(135, 206, 250));
		button_3.setBounds(258, 10, 46, 39);
		Alpa_panel.add(button_3);
		
		JButton button_4 = new JButton("f");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_4,'f',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_4.setFont(new Font("굴림", Font.BOLD, 20));
		button_4.setBackground(new Color(135, 206, 250));
		button_4.setBounds(316, 10, 46, 39);
		Alpa_panel.add(button_4);
		
		JButton button_5 = new JButton("g");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_5,'g',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_5.setFont(new Font("굴림", Font.BOLD, 20));
		button_5.setBackground(new Color(135, 206, 250));
		button_5.setBounds(374, 10, 46, 39);
		Alpa_panel.add(button_5);
		
		JButton button_6 = new JButton("h");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_6,'h',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_6.setFont(new Font("굴림", Font.BOLD, 20));
		button_6.setBackground(new Color(135, 206, 250));
		button_6.setBounds(432, 10, 46, 39);
		Alpa_panel.add(button_6);
		
		JButton button_7 = new JButton("i");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_7,'i',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_7.setFont(new Font("굴림", Font.BOLD, 20));
		button_7.setBackground(new Color(135, 206, 250));
		button_7.setBounds(490, 10, 46, 39);
		Alpa_panel.add(button_7);
		
		JButton button_8 = new JButton("j");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_8,'j',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_8.setFont(new Font("굴림", Font.BOLD, 20));
		button_8.setBackground(new Color(135, 206, 250));
		button_8.setBounds(26, 72, 46, 39);
		Alpa_panel.add(button_8);
		
		JButton button_9 = new JButton("k");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_9,'k',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_9.setFont(new Font("굴림", Font.BOLD, 20));
		button_9.setBackground(new Color(135, 206, 250));
		button_9.setBounds(84, 72, 46, 39);
		Alpa_panel.add(button_9);
		
		JButton button_10 = new JButton("l");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_10,'l',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_10.setFont(new Font("굴림", Font.BOLD, 20));
		button_10.setBackground(new Color(135, 206, 250));
		button_10.setBounds(142, 72, 46, 39);
		Alpa_panel.add(button_10);
		
		JButton button_11 = new JButton("m");
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_11,'m',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_11.setFont(new Font("굴림", Font.BOLD, 15));
		button_11.setBackground(new Color(135, 206, 250));
		button_11.setBounds(200, 72, 46, 39);
		Alpa_panel.add(button_11);
		
		JButton button_12 = new JButton("n");
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_12,'n',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_12.setFont(new Font("굴림", Font.BOLD, 20));
		button_12.setBackground(new Color(135, 206, 250));
		button_12.setBounds(258, 72, 46, 39);
		Alpa_panel.add(button_12);
		
		JButton button_13 = new JButton("o");
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_13,'o',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_13.setFont(new Font("굴림", Font.BOLD, 20));
		button_13.setBackground(new Color(135, 206, 250));
		button_13.setBounds(316, 72, 46, 39);
		Alpa_panel.add(button_13);
		
		JButton button_14 = new JButton("p");
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_14,'p',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_14.setFont(new Font("굴림", Font.BOLD, 20));
		button_14.setBackground(new Color(135, 206, 250));
		button_14.setBounds(374, 72, 46, 39);
		Alpa_panel.add(button_14);
		
		JButton button_15 = new JButton("q");
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_15,'q',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_15.setFont(new Font("굴림", Font.BOLD, 20));
		button_15.setBackground(new Color(135, 206, 250));
		button_15.setBounds(432, 72, 46, 39);
		Alpa_panel.add(button_15);
		
		JButton button_16 = new JButton("r");
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_16,'r',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_16.setFont(new Font("굴림", Font.BOLD, 20));
		button_16.setBackground(new Color(135, 206, 250));
		button_16.setBounds(490, 72, 46, 39);
		Alpa_panel.add(button_16);
		
		JButton button_17 = new JButton("s");
		button_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_17,'s',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_17.setFont(new Font("굴림", Font.BOLD, 20));
		button_17.setBackground(new Color(135, 206, 250));
		button_17.setBounds(26, 134, 46, 39);
		Alpa_panel.add(button_17);
		
		JButton button_18 = new JButton("t");
		button_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_18,'t',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_18.setFont(new Font("굴림", Font.BOLD, 20));
		button_18.setBackground(new Color(135, 206, 250));
		button_18.setBounds(84, 134, 46, 39);
		Alpa_panel.add(button_18);
		
		JButton button_19 = new JButton("u");
		button_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_19,'u',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_19.setFont(new Font("굴림", Font.BOLD, 20));
		button_19.setBackground(new Color(135, 206, 250));
		button_19.setBounds(142, 134, 46, 39);
		Alpa_panel.add(button_19);
		
		JButton button_20 = new JButton("v");
		button_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_20,'v',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_20.setFont(new Font("굴림", Font.BOLD, 20));
		button_20.setBackground(new Color(135, 206, 250));
		button_20.setBounds(200, 134, 46, 39);
		Alpa_panel.add(button_20);
		
		JButton button_21 = new JButton("w");
		button_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_21,'w',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_21.setFont(new Font("굴림", Font.BOLD, 17));
		button_21.setBackground(new Color(135, 206, 250));
		button_21.setBounds(258, 135, 46, 39);
		Alpa_panel.add(button_21);
		
		JButton button_22 = new JButton("x");
		button_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_22,'x',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_22.setFont(new Font("굴림", Font.BOLD, 20));
		button_22.setBackground(new Color(135, 206, 250));
		button_22.setBounds(316, 134, 46, 39);
		Alpa_panel.add(button_22);
		
		JButton button_23 = new JButton("y");
		button_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_23,'y',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_23.setFont(new Font("굴림", Font.BOLD, 20));
		button_23.setBackground(new Color(135, 206, 250));
		button_23.setBounds(374, 134, 46, 39);
		Alpa_panel.add(button_23);
		
		
		JButton button_24 = new JButton("z");
		button_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turn = superkaja(button_24,'z',chquiz,chanswer,answer,quiz,turn,
						label_7,label_8,lblNewLabel_2,label_2,textField,textField_1,txtComputer,panel_2
						,lblNewLabel_5,label_4,lblNewLabel_7,Alpa_panel,label_9,label_6);
			}
		});
		button_24.setFont(new Font("굴림", Font.BOLD, 20));
		button_24.setBackground(new Color(135, 206, 250));
		button_24.setBounds(432, 134, 46, 39);
		Alpa_panel.add(button_24);
		
		// 처음 게임 시작버튼
		JButton btnNewButton_2 = new JButton("start");
		btnNewButton_2.setBounds(266, 152, 359, 137);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD, 60));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int q = (int)Math.ceil((Import_Class.questionwords.length)*Math.random())-1;
				quiz = Import_Class.questionwords[q];
				String tmp = "_";
				for(int i=0; i<quiz.length()-1; i++) {
					tmp ="_" + tmp;
				}
				Import_Class.reviewwords.clear();//초기화
				answer = tmp;
				txtComputer.setText(answer);
				btnNewButton_2.setVisible(false); // 시작버튼 사라지기
				chquiz = quiz.toCharArray();
				chanswer = answer.toCharArray();
				Alpa_panel.setVisible(true); // 자판 판넬 보이기
				// 각 값들 초기화하기
				player1score = 0;
				player2score = 0;
				player1life = 20;
				player2life = 20;
				textField.setText(Integer.toString(player1score));
				textField_1.setText(Integer.toString(player2score));
				label_7.setText(Integer.toString(player1life));
				label_8.setText(Integer.toString(player2life));
				label_9.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/1-15.png")));
				label_6.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/2-15.png")));
				// 나온 문제 배열에 넣기
				Import_Class.reviewwords.add(quiz);
				
			}
		});
		
		
		
		// 버튼 리스트에 버튼들 넣기 (키보드 초기화 메소드에 쓰기위해)
		buttons.add(btnNewButton);
		buttons.add(btnNewButton_2);
		buttons.add(button);
		buttons.add(button_1);
		buttons.add(button_2);
		buttons.add(button_3);
		buttons.add(button_4);
		buttons.add(button_5);
		buttons.add(button_6);
		buttons.add(button_7);
		buttons.add(button_8);
		buttons.add(button_9);
		buttons.add(button_10);
		buttons.add(button_11);
		buttons.add(button_12);
		buttons.add(button_13);
		buttons.add(button_14);
		buttons.add(button_15);
		buttons.add(button_16);
		buttons.add(button_17);
		buttons.add(button_18);
		buttons.add(button_19);
		buttons.add(button_20);
		buttons.add(button_21);
		buttons.add(button_22);
		buttons.add(button_23);
		buttons.add(button_24);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		lblNewLabel_8.setBounds(105, 103, 149, 111);
		contentPane.add(lblNewLabel_8);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(682, 397, 149, 111);
		contentPane.add(label_11);
		label_11.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_10.setBounds(87, 397, 149, 111);
		contentPane.add(label_10);
		
	}
	
	// 버튼안에 넣는 종합 메소드
	private int superkaja(JButton btnNewButton, char c, char[] chquiz, char[] chanswer, String answer,
			String quiz, int turn, JLabel label_7, JLabel label_8, JLabel lblNewLabel_2, JLabel label_2,
			JTextField textField, JTextField textField_1, JTextField txtComputer, JPanel panel_2, 
			JLabel lblNewLabel_5, JLabel label_4, JLabel lblNewLabel_7, JPanel alpa_panel, JLabel label_9
			, JLabel label_6) {
		
		int i = kaja(c,chquiz,chanswer); // 행맨 로직 메소드
		if(i==-1) { // 틀렸을때
			btnNewButton.setBackground(new Color(255,50,50)); //버튼 배경 빨간색으로
			lifedown(turn,label_7,label_8); // 목숨 깎기 메소드
			turn = turn*(-1); // 턴 바뀜
			turnchange(turn,lblNewLabel_2,label_2); // 턴바뀜 표시 메소드
			btnNewButton.setEnabled(false); // 해당버튼 잠구기
			hangmanImg(label_9,label_6); // 체력상황에 따라 이미지 바꿔주는 메소드
			gameover(panel_2,alpa_panel); // 둘다 체력 0되어 게임이 끝났을 시 메소드
			return turn;
		}
		else { // 맞았을때
			chanswer[i] = c;   // 해당 칸에 해당 스펠링 넣기
			txtComputer.setText(answer = new String(chanswer));
			btnNewButton.setBackground(new Color(50,255,50)); // 버튼 배경 초록색으로
			scoreUp(turn,textField,textField_1,lblNewLabel_5,label_4,lblNewLabel_7); // 점수 올려주는 메소드
			btnNewButton.setEnabled(false);
			
			if(answer.equals(quiz)) { // 정답 다 맞추었을시
				JOptionPane.showMessageDialog(null, "정답입니다~ 다음문제로 넘어갑니다~",
						"정답정답",JOptionPane.INFORMATION_MESSAGE);
				// JOptionPane.showMessageDialog(메시지출력위치, 메시지 내용, 메시지 제목, 메시지아이콘)
				kbReset(buttons); // 키보드 초기화 메소드
				questionReset(); // 문제 초기화 메소드
				return turn;
				
			}
			return turn;
		}
		
		
	}

	// 맞는단어 찾는 메소드
	private int kaja(char a, char[] chquiz, char[] chanswer) {
		for(int i=0;i<chquiz.length;i++) {
			if(a == (chquiz[i])) {
				return i; // 겹치는 부분이 있다면 해당 인덱스번호 리턴
			}
		}
		return -1; // 오답을 골라서 겹치는 값이 없다면 -1 리턴
	}
	
	// 틀렸을 때 목숨 깎는 메소드
	private void lifedown(int turn, JLabel label_7, JLabel label_8) {
		if(turn == 1) {
			player1life = player1life-1;
			label_7.setText(Integer.toString(player1life));
		}
		if(turn == -1) {
			player2life = player2life-1;
			label_8.setText(Integer.toString(player2life));
		}
	}
	
	// 턴 표시등 바꾸는 메소드
	private void turnchange(int turn, JLabel lblNewLabel_2, JLabel label_2) {
		if(turn == 1) {  // 플레이어 1 턴일 시
			lblNewLabel_2.setVisible(true); //플레이어 1 표시 켜기
			label_2.setVisible(false);  // 플레이어 2 표시 끄기
		}
		if(turn == -1) { // 반대
			lblNewLabel_2.setVisible(false);
			label_2.setVisible(true);
		}
	}
	
	// 점수 올려주는 메소드
	private void scoreUp(int turn, JTextField textField, JTextField textField_1, JLabel lblNewLabel_5, JLabel label_4, JLabel lblNewLabel_7) {
		if(turn == 1) { // 플레이어 1이 맞추었을 시
			player1score = player1score + 10;
			textField.setText(Integer.toString(player1score)); // 현재점수 표시 갱신
			lblNewLabel_5.setText(Integer.toString(player1score)); // 결과판 점수 표시 갱신
		}
		if(turn == -1) {
			player2score = player2score + 10;
			textField_1.setText(Integer.toString(player2score));
			label_4.setText(Integer.toString(player2score));
		}
		// 결과창에 점수 높은플레이어 이름 저장
		if(player1score > player2score) 
			winner = Import_Class.player1name+"의 승리";
		else if(player1score < player2score) 
			winner = Import_Class.player2name+"의 승리";
		else if(player1score == player2score)
			winner = "무승부";
		lblNewLabel_7.setText(winner+"입니다!");
	}
	
	// 키보드 초기화 메소드
	private void kbReset(ArrayList<JButton> buttons) {
		for(int i=0; i<buttons.size(); i++) {
			buttons.get(i).setEnabled(true);
			buttons.get(i).setBackground(new Color(135, 206, 250));
		}
	}
	
	// 문제 초기화 메소드
	private void questionReset() {
		int q=0;
		while(true) {
			int cnt=0;
			q = (int)Math.ceil((Import_Class.questionwords.length)*Math.random())-1;
			quiz = Import_Class.questionwords[q];
			for(int i=0; i<Import_Class.reviewwords.size(); i++) {
				if(quiz.equals(Import_Class.reviewwords.get(i))) {
					cnt++;
				}
			}
			if(cnt == 0) {
				break;
			}
		}
		//int q = (int)Math.ceil(Import_Class.questionwords.length*Math.random())-1;
		quiz = Import_Class.questionwords[q];
		Import_Class.reviewwords.add(quiz);
		String tmp = "_";
		for(int i=0; i<quiz.length()-1; i++) {
			tmp ="_" + tmp;
		}
		answer = tmp;
		txtComputer.setText(answer);
		chquiz = quiz.toCharArray();
		chanswer = answer.toCharArray();
		
	}
	
	/// 체력상황에 따라 이미지 바꾸는 메소드
	private void hangmanImg(JLabel label_9, JLabel label_6) {
		
		// 플레이어 1 이미지 변화
		if(player1life == 10) 
			label_9.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/1-10.png")));
		 else if(player1life == 5) 
			label_9.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/1-5.png")));
		 else if(player1life == 0) 
			label_9.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/1-0.png")));
		
		// 플리에어2 이미지 변화
		if(player2life == 10) 
			label_6.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/2-10.png")));
		 else if(player2life == 5) 
			label_6.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/2-5.png")));
		 else if(player2life == 0) 
			label_6.setIcon(new ImageIcon(Hangmen_2.class.getResource("/image/2-0.png")));
		
	}
	
	// 둘다 죽어서 게임 끝 메소드
	private void gameover(JPanel panel_2, JPanel alpa_panel) {
		if(player1life==0 && player2life == 0) {
			panel_2.setVisible(true); // 결과창 띄우기
			alpa_panel.setVisible(false); // 자판창 숨기기
			Import_Class.reviewwords.clear();
			
			
			// 랭킹 갱신
			// 각 배열에 1~5위 + 현재 플레이어 2명 점수,이름 입력
			int [] jumsurank = {Import_Class.jumsu1,Import_Class.jumsu2,Import_Class.jumsu3,Import_Class.jumsu4
					,Import_Class.jumsu5,player1score,player2score};
			String [] namerank = {Import_Class.rank1name,Import_Class.rank1name,Import_Class.rank1name,
					Import_Class.rank1name,Import_Class.rank1name,Import_Class.player1name,Import_Class.player2name};
			
			// sort
			for(int i=0;i<jumsurank.length-1;i++) {
				for(int j=0;j<jumsurank.length-1-i;j++) {
					int tmp;
					String imsi;
					if(jumsurank[j]<jumsurank[j+1]) {
						tmp = jumsurank[j];
						jumsurank[j] = jumsurank[j+1];
						jumsurank[j+1] = tmp;
						
						imsi = namerank[j];
						namerank[j] = namerank[j+1];
						namerank[j+1] = imsi;
					}
				}		
			} // for - end
			//// sort된 점수 랭킹에 반영
			Import_Class.jumsu1 = jumsurank[0];
			Import_Class.rank1name = namerank[0];
			Import_Class.jumsu2 = jumsurank[1];
			Import_Class.rank2name = namerank[1];
			Import_Class.jumsu3 = jumsurank[2];
			Import_Class.rank3name = namerank[2];
			Import_Class.jumsu4 = jumsurank[3];
			Import_Class.rank4name = namerank[3];
			Import_Class.jumsu5 = jumsurank[4];
			Import_Class.rank5name = namerank[4];
		} // if - end		
	} // gameover -end
}
