package vsHangmen;
///////////


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.DropMode;
import javax.swing.border.BevelBorder;

public class Hangmen_1 extends JFrame {
	
	int player1life = 20;
	int player1score = 0;
	String quiz;
	//String answer = null;
	String answer;
	String playerclick = null;
	char [] chquiz = {};
	char [] chanswer = {};
	//char[] chImsi = {};
	
	private JPanel contentPane;
	private JLabel txtPlayer;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JPanel panel_1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField txtA_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel Heart_NewLabel_4;
	private JLabel HP_textField_7;
	private JPanel Alpa_panel_2;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;
	private JButton button_19;
	private JButton btnV;
	private JButton btnW;
	private JButton btnX;
	private JButton btnY;
	private JButton btnZ;
	private JTextField txtComputer;
	private JTextField textField_9;
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hangmen_1 frame = new Hangmen_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//////////////////////////////////////////////////////////////////////////자판모음 리스트
	ArrayList <JButton> jbs1 = new ArrayList <JButton>();
	private JPanel panel_2;
	private JLabel textField;
	private JLabel txtScore;
	private JTextField textField_10;
	private JLabel txtPlayer_1;
	private JTextField txtAsdsd;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel lblNewLabel_4;
	
	////////////////////////////////////////////////////////////////superHangmen
		private void superHangmen(String answerButton, JButton a, char[] chquiz,char[] chanswer) {
			/////행맨게임 메소드
		int sw = hangmen(answerButton, chquiz,chanswer);
		
		if(sw != -1) {										//정답이면
			chanswer[sw] = answerButton.charAt(0);
			txtComputer.setText(new String(chanswer));//맞은 경우 밑줄에 알파벳넣기								
			a.setBackground(new Color(50,255,50));		
			
			////////////점수 오름
			for(int i = 0 ; i < chquiz.length ; i++) {
				if(answerButton.charAt(0) == (chquiz[i])) {	
					player1score += 10;
				}
			}
			textField_9.setText(Integer.toString(player1score));
			///////////////////////////////////////////////////////정답을 다 맞췄을 시 
				if(new String(chanswer).equals(quiz)) {	
					/////////정답입니다 다이얼로그	
					JOptionPane.showMessageDialog(						
							null,"정답입니다. 새로운 문제를 출력합니다.","알림",JOptionPane.INFORMATION_MESSAGE);	
					
					/////////자판리셋
						for(int i = 0 ; i < jbs1.size() ; i++) {
							jbs1.get(i).setEnabled(true);
							jbs1.get(i).setBackground(new Color(135, 206, 250));
						}
					
					////////////퀴즈리셋
					quizreset();
						
				}
																	
		}else if (sw == -1){														//오답이면
			a.setBackground(new Color(255,50,50));					
			player1life --;										
			
			HP_textField_7.setText(Integer.toString(player1life));//목숨-1
			
			// 체력상황에 따라 이미지 변경
			if(player1life == 10) 
				lblNewLabel_4.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/1-10.png")));
			 else if(player1life == 5) 
				 lblNewLabel_4.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/1-5.png")));
			 else if(player1life == 0) 
				 lblNewLabel_4.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/1-0.png")));
			
			///////////////////////////목숨0이 될때
			if(player1life == 0)	{											
				panel_2.setVisible(true);//최종점수창
				textField_10.setText(Integer.toString(player1score));//플레이어점수표시
				txtAsdsd.setText(Import_Class.player1name);
				Alpa_panel_2.setVisible(false);//자판가리기
				///////////////////////////////////////////// 랭킹반영
				int [] jumsurank = {Import_Class.jumsu1,Import_Class.jumsu2,Import_Class.jumsu3,Import_Class.jumsu4
						,Import_Class.jumsu5,player1score};
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
				} 
				
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
				}
			}
	}//superHangmen메소드 끝
		
	
private void quizreset() {
	int q=0;
	while(true) {
		int count =0;
		//0부터9까지 랜덤으로 나온 수를 q에 담는다
		q = (int)Math.ceil((Import_Class.questionwords.length)*Math.random())-1;
		quiz = Import_Class.questionwords[q];//q의 수를 문제목록 문자배열에 반영해서 quiz에 담는다
		///중복방지
		for(int i=0; i<Import_Class.reviewwords.size(); i++) {
			if(quiz.equals(Import_Class.reviewwords.get(i))) {
				count ++;
			}
		}
		if( count == 0) {
			break;
		}
	}
	quiz = Import_Class.questionwords[q];//중복방지 처리 후 랜덤으로 나온 문자를 quiz에 담는다
	Import_Class.reviewwords.add(quiz);//지금까지 나온 문제를 출제한 목록에 담는다
	String tmp = "_";
	
	for(int i=0; i<quiz.length()-1; i++) {//문제의 길이 만큼 밑줄표시
		tmp = "_" + tmp;
	}
	answer = tmp;
	txtComputer.setText(answer);
	chquiz = quiz.toCharArray();
	chanswer = answer.toCharArray();
		
	}


/////////////////////////////////////////////////////////////////행맨게임 메소드
	private int hangmen(String answerButton, char[] chquiz2, char[] chanswer2) {
		for(int j = 0 ; j < chquiz.length ; j++) {
			if(answerButton.charAt(0) == (chquiz[j])){	
				return j;
			}
		}
		return -1;
	}



	/**
	 * Create the frame.
	 */
	public Hangmen_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));			//배경색
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(237, 76, 427, 412);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		textField = new JLabel();
		textField.setForeground(new Color(0, 0, 128));
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("휴먼매직체", Font.PLAIN, 45));
		textField.setBounds(141, 32, 160, 44);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("게임종료");
		panel_2.add(textField);
		
		txtScore = new JLabel();
		txtScore.setBackground(new Color(192, 192, 192));
		txtScore.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore.setText("SCORE");
		txtScore.setBounds(90, 219, 118, 50);
		panel_2.add(txtScore);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setText("0");
		textField_10.setBounds(244, 223, 79, 44);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		txtPlayer_1 = new JLabel();
		txtPlayer_1.setBackground(new Color(192, 192, 192));
		txtPlayer_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayer_1.setText("PLAYER");
		txtPlayer_1.setBounds(90, 133, 118, 50);
		panel_2.add(txtPlayer_1);
		
		txtAsdsd = new JTextField();
		txtAsdsd.setEditable(false);
		txtAsdsd.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 25));
		txtAsdsd.setText(Import_Class.player1name);
		txtAsdsd.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsdsd.setColumns(10);
		txtAsdsd.setBounds(234, 133, 100, 50);
		panel_2.add(txtAsdsd);
		
		JButton button_20 = new JButton("\uB2E4\uC2DC\uD558\uAE30");
		button_20.setFont(new Font("함초롬돋움", Font.BOLD, 23));
		button_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				setVisible(false);
				new Hangmen_1().setVisible(true);
			}
		});
		button_20.setBounds(59, 347, 141, 50);
		panel_2.add(button_20);
		
		JButton button_21 = new JButton("\uBA54\uC778\uD654\uBA74");
		button_21.setFont(new Font("함초롬돋움", Font.BOLD, 23));
		button_21.addMouseListener(new MouseAdapter() {
			@Override
		///////////////////////////////////////////////////////////메인화면
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Hangmen_main().setVisible(true);
			}
		});
		button_21.setBounds(234, 347, 141, 50);
		panel_2.add(button_21);
				
		Alpa_panel_2 = new JPanel();											//알파벳 24개 구역
		Alpa_panel_2.setBackground(new Color(240, 230, 140));
		Alpa_panel_2.setVisible(false);
		Alpa_panel_2.setBorder(new LineBorder(new Color(192, 192, 192), 4, true));
		Alpa_panel_2.setBounds(151, 368, 581, 183);
		contentPane.add(Alpa_panel_2);
		Alpa_panel_2.setLayout(null);
		
		btnNewButton = new JButton("a");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.addMouseListener(new MouseAdapter() {							//알파벳클릭 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "a";
				superHangmen(answerButton,btnNewButton,chquiz,chanswer);	
				btnNewButton.setEnabled(false);		
			}


			
		});
		btnNewButton.setBounds(26, 10, 46, 39);
		Alpa_panel_2.add(btnNewButton);
		
		button = new JButton("b");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "b";
				superHangmen(answerButton,button,chquiz,chanswer);	
				button.setEnabled(false);	
		
				
				
			}
		});
		button.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button.setBackground(new Color(135, 206, 250));
		button.setBounds(84, 10, 46, 39);
		Alpa_panel_2.add(button);
		
		button_1 = new JButton("c");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "c";
				superHangmen(answerButton,button_1,chquiz,chanswer);
				button_1.setEnabled(false);		

				}
		});
		button_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_1.setBackground(new Color(135, 206, 250));
		button_1.setBounds(142, 10, 46, 39);
		Alpa_panel_2.add(button_1);
		
		button_2 = new JButton("d");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "d";
				superHangmen(answerButton,button_2,chquiz,chanswer);
				button_2.setEnabled(false);
				
			}
		});
		button_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_2.setBackground(new Color(135, 206, 250));
		button_2.setBounds(200, 10, 46, 39);
		Alpa_panel_2.add(button_2);
		
		button_3 = new JButton("e");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "e";
				button_3.setEnabled(false);
				superHangmen(answerButton,button_3,chquiz,chanswer);
			}
		});
		
		button_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_3.setBackground(new Color(135, 206, 250));
		button_3.setBounds(258, 10, 46, 39);
		Alpa_panel_2.add(button_3);
		
		button_4 = new JButton("f");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "f";
				button_4.setEnabled(false);		
				superHangmen(answerButton,button_4,chquiz,chanswer);
			}
		});
		button_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_4.setBackground(new Color(135, 206, 250));
		button_4.setBounds(316, 10, 46, 39);
		Alpa_panel_2.add(button_4);
		
		button_5 = new JButton("g");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "g";
				button_5.setEnabled(false);
				superHangmen(answerButton,button_5,chquiz,chanswer);
			}
		});
		
		button_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_5.setBackground(new Color(135, 206, 250));
		button_5.setBounds(374, 10, 46, 39);
		Alpa_panel_2.add(button_5);
		
		button_6 = new JButton("h");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "h";
				button_6.setEnabled(false);
				superHangmen(answerButton,button_6,chquiz,chanswer);
			}
		});
		button_6.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_6.setBackground(new Color(135, 206, 250));
		button_6.setBounds(439, 10, 46, 39);
		Alpa_panel_2.add(button_6);
		
		button_7 = new JButton("i");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "i";
				button_7.setEnabled(false);
				superHangmen(answerButton,button_7,chquiz,chanswer);
			}
		});
		button_7.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_7.setBackground(new Color(135, 206, 250));
		button_7.setBounds(497, 10, 46, 39);
		Alpa_panel_2.add(button_7);
		
		button_8 = new JButton("j");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "j";
				button_8.setEnabled(false);
				superHangmen(answerButton,button_8,chquiz,chanswer);
			}
		});
		button_8.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_8.setBackground(new Color(135, 206, 250));
		button_8.setBounds(26, 72, 46, 39);
		Alpa_panel_2.add(button_8);
		
		button_9 = new JButton("k");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "k";
				button_9.setEnabled(false);
				superHangmen(answerButton,button_9,chquiz,chanswer);
			}
		});
		button_9.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_9.setBackground(new Color(135, 206, 250));
		button_9.setBounds(84, 72, 46, 39);
		Alpa_panel_2.add(button_9);
		
		button_10 = new JButton("l");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "l";
				button_10.setEnabled(false);
				superHangmen(answerButton,button_10,chquiz,chanswer);
			}
		});
		button_10.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_10.setBackground(new Color(135, 206, 250));
		button_10.setBounds(142, 72, 46, 39);
		Alpa_panel_2.add(button_10);
		
		button_11 = new JButton("m");
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "m";
				button_11.setEnabled(false);
				superHangmen(answerButton,button_11,chquiz,chanswer);
			}
		});
		button_11.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		button_11.setBackground(new Color(135, 206, 250));
		button_11.setBounds(200, 72, 46, 39);
		Alpa_panel_2.add(button_11);
		
		button_12 = new JButton("n");
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "n";
				button_12.setEnabled(false);
				superHangmen(answerButton,button_12,chquiz,chanswer);
			}
		});
		button_12.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_12.setBackground(new Color(135, 206, 250));
		button_12.setBounds(258, 72, 46, 39);
		Alpa_panel_2.add(button_12);
		
		button_13 = new JButton("o");															//버튼 o
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "o";
				button_13.setEnabled(false);
				superHangmen(answerButton,button_13,chquiz,chanswer);
			}
		});
		button_13.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_13.setBackground(new Color(135, 206, 250));
		button_13.setBounds(316, 72, 46, 39);
		Alpa_panel_2.add(button_13);
		
		button_14 = new JButton("p");
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "p";
				button_14.setEnabled(false);
				superHangmen(answerButton,button_14,chquiz,chanswer);
			}
		});
		button_14.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_14.setBackground(new Color(135, 206, 250));
		button_14.setBounds(374, 72, 46, 39);
		Alpa_panel_2.add(button_14);
		
		button_15 = new JButton("q");
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "q";
				button_15.setEnabled(false);
				superHangmen(answerButton,button_15,chquiz,chanswer);
			}
		});
		button_15.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_15.setBackground(new Color(135, 206, 250));
		button_15.setBounds(439, 72, 46, 39);
		Alpa_panel_2.add(button_15);
		
		button_16 = new JButton("r");
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "r";
				button_16.setEnabled(false);
				superHangmen(answerButton,button_16,chquiz,chanswer);
			}
		});
		button_16.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_16.setBackground(new Color(135, 206, 250));
		button_16.setBounds(497, 72, 46, 39);
		Alpa_panel_2.add(button_16);
		
		button_17 = new JButton("s");
		button_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "s";
				button_17.setEnabled(false);
				superHangmen(answerButton,button_17,chquiz,chanswer);
			}
		});
		button_17.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_17.setBackground(new Color(135, 206, 250));
		button_17.setBounds(26, 134, 46, 39);
		Alpa_panel_2.add(button_17);
		
		button_18 = new JButton("t");
		button_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "t";
				button_18.setEnabled(false);
				superHangmen(answerButton,button_18,chquiz,chanswer);
			}
		});
		button_18.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_18.setBackground(new Color(135, 206, 250));
		button_18.setBounds(84, 134, 46, 39);
		Alpa_panel_2.add(button_18);
		
		button_19 = new JButton("u");
		button_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "u";
				button_19.setEnabled(false);
				superHangmen(answerButton,button_19,chquiz,chanswer);
			}
		});
		button_19.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		button_19.setBackground(new Color(135, 206, 250));
		button_19.setBounds(142, 134, 46, 39);
		Alpa_panel_2.add(button_19);
		
		btnV = new JButton("v");
		btnV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "v";
				btnV.setEnabled(false);
				superHangmen(answerButton,btnV,chquiz,chanswer);
			}
		});
		btnV.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnV.setBackground(new Color(135, 206, 250));
		btnV.setBounds(200, 134, 46, 39);
		Alpa_panel_2.add(btnV);
		
		btnW = new JButton("w");
		btnW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "w";
				btnW.setEnabled(false);
				superHangmen(answerButton,btnW,chquiz,chanswer);
			}
		});
		btnW.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		btnW.setBackground(new Color(135, 206, 250));
		btnW.setBounds(258, 134, 46, 39);
		Alpa_panel_2.add(btnW);
		
		btnX = new JButton("x");
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "x";
				btnX.setEnabled(false);
				superHangmen(answerButton,btnX,chquiz,chanswer);
			}
		});
		btnX.setFont(new Font("굴림", Font.BOLD, 17));
		btnX.setBackground(new Color(135, 206, 250));
		btnX.setBounds(316, 134, 46, 39);
		Alpa_panel_2.add(btnX);
		
		btnY = new JButton("y");
		btnY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answerButton = "y";
				btnY.setEnabled(false);
				superHangmen(answerButton,btnY,chquiz,chanswer);
			}
		});
		btnY.setFont(new Font("굴림", Font.BOLD, 20));
		btnY.setBackground(new Color(135, 206, 250));
		btnY.setBounds(374, 134, 46, 39);
		Alpa_panel_2.add(btnY);
		
		btnZ = new JButton("z");
		btnZ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String answer = "z";
				btnZ.setEnabled(false);
				superHangmen(answer,btnZ,chquiz,chanswer);
			}
		});
		btnZ.setFont(new Font("굴림", Font.BOLD, 20));
		btnZ.setBackground(new Color(135, 206, 250));
		btnZ.setBounds(439, 134, 46, 39);
		Alpa_panel_2.add(btnZ);
		
		JLabel lblNewLabel = new JLabel("");							//유저 사진
		lblNewLabel.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/user.png")));
		lblNewLabel.setBounds(716, 43, 104, 120);
		contentPane.add(lblNewLabel);
		
		txtPlayer = new JLabel();
		txtPlayer.setBackground(new Color(135,206,250));
		txtPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayer.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 24));
		txtPlayer.setText(Import_Class.player1name);
		txtPlayer.setBounds(698, 161, 131, 33);
		contentPane.add(txtPlayer);
		
		lblNewLabel_1 = new JLabel("");									//베스트 스코어 별
		lblNewLabel_1.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/bestScore star.png")));
		lblNewLabel_1.setBounds(12, 10, 44, 56);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("BEST SCORE");						//베스트 스코어
		lblNewLabel_2.setFont(new Font("High Tower Text", Font.ITALIC, 28));
		lblNewLabel_2.setBackground(new Color(135,206,250));
		lblNewLabel_2.setBounds(52, 20, 175, 43);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setText(Integer.toString(Import_Class.jumsu1));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Bernard MT Condensed", Font.BOLD, 24));
		textField_1.setBounds(227, 10, 70, 54);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();								//행맨 그림 넣는 구역
		panel.setBounds(52, 95, 144, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/1-15.png")));
		lblNewLabel_4.setBounds(0, 0, 144, 210);
		panel.add(lblNewLabel_4);
		
		HP_textField_7 = new JLabel();								//하트 HP
		HP_textField_7.setForeground(new Color(255, 255, 255));
		HP_textField_7.setFont(new Font("Dialog", Font.BOLD, 18));
		HP_textField_7.setBackground(new Color(255, 43, 43));
		HP_textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		HP_textField_7.setText("20");
		HP_textField_7.setBounds(106, 315, 25, 30);
		contentPane.add(HP_textField_7);
		
		Heart_NewLabel_4 = new JLabel("");
		Heart_NewLabel_4.setFont(new Font("굴림", Font.PLAIN, 18));
		Heart_NewLabel_4.setForeground(new Color(30, 144, 255));
		Heart_NewLabel_4.setBackground(new Color(0, 0, 0));
		Heart_NewLabel_4.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/heart.png")));
		Heart_NewLabel_4.setBounds(94, 304, 57, 56);
		contentPane.add(Heart_NewLabel_4);
		
		txtComputer = new JTextField();
		txtComputer.setEditable(false);
		txtComputer.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
		txtComputer.setHorizontalAlignment(SwingConstants.CENTER);
		txtComputer.setText(answer);
		txtComputer.setBounds(312, 273, 259, 48);
		contentPane.add(txtComputer);
		txtComputer.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("START");					//게임시작 버튼
		btnNewButton_1.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {	
				int q = (int)Math.ceil((Import_Class.questionwords.length)*Math.random())-1;
				quiz = Import_Class.questionwords[q];
				String tmp = "_";
				for(int i=0; i<quiz.length()-1; i++) {
					tmp ="_" + tmp;
				}
				answer = tmp;
				txtComputer.setText(answer);
				Import_Class.reviewwords.clear();
				btnNewButton_1.setVisible(false); // 시작버튼 사라지기
				Alpa_panel_2.setVisible(true);
				chquiz = quiz.toCharArray();
				chanswer = answer.toCharArray();
				
				Import_Class.reviewwords.add(quiz);//위 문제 배열에 넣는다
				
				btnNewButton_1.setEnabled(false);			
			}
			
		});															
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		btnNewButton_1.setBounds(312, 161, 259, 93);
		contentPane.add(btnNewButton_1);
		
		
		
		/////////////////////////////////////////////////////////////////메인으로 돌아가는 버튼
		JButton btnNewButton_2 = new JButton("메인으로");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int yes = JOptionPane.showConfirmDialog(
						btnNewButton_2,"메인화면으로","알림",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
				if(yes == 0) {									//예 누르면 메인화면으로
					dispose();
					setVisible(false);
					new Hangmen_main().setVisible(true);
				}
			}
			
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
		btnNewButton_2.setBounds(758, 473, 91, 65);
		contentPane.add(btnNewButton_2);
		
		textField_9 = new JTextField();								//현재점수
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setText("0");
		textField_9.setBounds(792, 202, 57, 56);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		
		//////////////////////////////////////////////////////////		자판 모음 
		
		jbs1.add(btnNewButton);
		jbs1.add(button);
		jbs1.add(button_1);
		jbs1.add(button_2);
		jbs1.add(button_3);
		jbs1.add(button_4);
		jbs1.add(button_5);
		jbs1.add(button_6);
		jbs1.add(button_7);
		jbs1.add(button_8);
		jbs1.add(button_9);
		jbs1.add(button_10);
		jbs1.add(button_11);
		jbs1.add(button_12);
		jbs1.add(button_13);
		jbs1.add(button_14);
		jbs1.add(button_15);
		jbs1.add(button_16);
		jbs1.add(button_17);
		jbs1.add(button_18);
		jbs1.add(button_19);
		jbs1.add(btnV);
		jbs1.add(btnW);
		jbs1.add(btnX);
		jbs1.add(btnY);
		jbs1.add(btnZ);
		
		JLabel label = new JLabel("");
		label.setBounds(52, 378, 140, 110);
		contentPane.add(label);
		label.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		
		label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_9.setBounds(619, 29, 140, 110);
		contentPane.add(label_9);
		
		label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_7.setBounds(633, 248, 140, 110);
		contentPane.add(label_7);
		
		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Hangmen_1.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_8.setBounds(165, 93, 140, 110);
		contentPane.add(label_8);
		
		JLabel lblNewLabel_3 = new JLabel("현재점수");
		lblNewLabel_3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(685, 209, 99, 43);
		contentPane.add(lblNewLabel_3);
		//////////////////////////////////////////////////////////////////////////////
	}
}
