package vsHangmen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;

public class Hangmen_main extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hangmen_main frame = new Hangmen_main();
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
	public Hangmen_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135,206,250));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// 순위보기 버튼
		JButton btnNewButton = new JButton("\uC21C\uC704\uD655\uC778");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Hangmen_ranking().setVisible(true);
			}
		});
		
		// 닉네임 적는 판넬창
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(117, 188, 203, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("player1 \uB2C9\uB124\uC784");
		lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 22, 179, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblPlayer = new JLabel("player2 \uB2C9\uB124\uC784");
		lblPlayer.setFont(new Font("한컴산뜻돋움", Font.BOLD | Font.ITALIC, 15));
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setBounds(12, 105, 179, 34);
		panel.add(lblPlayer);
		
		// 닉네임 적는 판넬창 확인버튼
		JButton btnNewButton_3 = new JButton("\uD655\uC778");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Import_Class.player1name = textField.getText();
				Import_Class.player2name = textField_1.getText();
				panel.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		btnNewButton_3.setBounds(48, 195, 118, 34);
		panel.add(btnNewButton_3);
		
		textField_1 = new JTextField();
		textField_1.setText(Import_Class.player2name);
		textField_1.setColumns(10);
		textField_1.setBounds(56, 136, 135, 39);
		panel.add(textField_1);
		
		textField = new JTextField();
		textField.setText(Import_Class.player1name);
		textField.setColumns(10);
		textField.setBounds(56, 56, 135, 39);
		panel.add(textField);
		
		panel.setVisible(false);
		
		// 닉넴임 적는 판넬창 - end
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 56, 45, 39);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Hangmen_main.class.getResource("/image/iconmonstr-user-5-24.png")));
		lblNewLabel_2.setBounds(12, 0, 45, 39);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 136, 45, 39);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Hangmen_main.class.getResource("/image/iconmonstr-user-5-24.png")));
		label.setBounds(12, 0, 45, 39);
		panel_2.add(label);
		btnNewButton.setFont(new Font("한컴산뜻돋움", Font.BOLD, 25));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setBounds(350, 458, 225, 70);
		contentPane.add(btnNewButton);
		
		// 둘이서하기 버튼
		JButton button = new JButton("\uB458\uC774\uC11C\uD558\uAE30");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				setVisible(false);
				new Hangmen_2().setVisible(true);
				
			}
		});
		button.setFont(new Font("한컴산뜻돋움", Font.BOLD, 25));
		button.setForeground(Color.WHITE);
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(350, 378, 225, 70);
		contentPane.add(button);
		
		/// 혼자서 하기 버튼
		JButton button_1 = new JButton("\uD63C\uC790\uD558\uAE30");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Hangmen_1().setVisible(true);
				
			}
		});
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(192, 192, 192));
		button_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 25));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(350, 298, 225, 70);
		contentPane.add(button_1);
		
		// 이름바꾸기 표시버튼
		JButton btnNewButton_1 = new JButton("<html>플레이어<br/><br/> 이름변경</html>");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.setFont(new Font("휴먼매직체", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(391, 188, 140, 79);
		contentPane.add(btnNewButton_1);
		
		// 끝내기 버튼
		JButton btnNewButton_2 = new JButton("\uB05D\uB0B4\uAE30");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 예,아니오,취소 세가지 선택의 리턴값을 받기위해 int bada를 만든다
				int bada1 = JOptionPane.showConfirmDialog( null, "정말 끝내실건가요?"
						,"프로그램 끝내기 창", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
				// yes면 0, no면 1, 취소는 2	
				if(bada1==0) { // 예 라고 누르면 프로그램 종료
					dispose();
					setVisible(false);
				}
			}
		});
		
		btnNewButton_2.setBackground(new Color(240, 255, 240));
		btnNewButton_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
		btnNewButton_2.setBounds(785, 476, 127, 52);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("VS hangman");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 80));
		lblNewLabel.setBounds(189, 41, 531, 127);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Hangmen_main.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		lblNewLabel_3.setBounds(544, 0, 140, 110);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Hangmen_main.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_1.setBounds(701, 219, 140, 110);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Hangmen_main.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_2.setBounds(143, 37, 140, 110);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Hangmen_main.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_3.setBounds(526, 378, 140, 110);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Hangmen_main.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_4.setBounds(79, 405, 140, 110);
		contentPane.add(label_4);
	}
}
