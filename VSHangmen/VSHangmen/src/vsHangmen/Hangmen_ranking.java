package vsHangmen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.time.temporal.JulianFields;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.Box;

public class Hangmen_ranking extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hangmen_ranking frame = new Hangmen_ranking();
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
	public  Hangmen_ranking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135,206,250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(187, 217, 47, 43);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(Hangmen_ranking.class.getResource("/image/iconmonstr-crown-5-32.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135,206,250));
		panel.setBounds(202, 52, 510, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BEST RANKING");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("휴먼매직체", Font.BOLD, 50));
		lblNewLabel_2.setBounds(-27, 14, 531, 70);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Hangmen_ranking.class.getResource("/image/iconmonstr-thumb-10-48.png")));
		lblNewLabel_3.setBounds(459, 10, 61, 59);
		panel.add(lblNewLabel_3);
		
		// 처음으로 화면 버튼
		JButton btnNewButton = new JButton("메인으로");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Hangmen_main().setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("함초롬돋움", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(774, 473, 94, 66);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Hangmen_ranking.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		lblNewLabel.setBounds(34, 52, 126, 115);
		contentPane.add(lblNewLabel);
		
		// 테이블 시작
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(SystemColor.windowText));
		table_1.setEnabled(false);
		table_1.setForeground(SystemColor.textInactiveText);
		table_1.setGridColor(SystemColor.textInactiveText);
		table_1.setBackground(SystemColor.inactiveCaption);
		table_1.setFont(new Font("굴림", Font.BOLD, 20));
		table_1.setRowHeight(65); // 행의 높이
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", Import_Class.rank1name, Import_Class.jumsu1},
				{"2", Import_Class.rank2name, Import_Class.jumsu2},
				{"3", Import_Class.rank3name, Import_Class.jumsu3},
				{"4", Import_Class.rank4name, Import_Class.jumsu4},
				{"5", Import_Class.rank5name, Import_Class.jumsu5},
			},
			new String[] {
				"\uC21C\uC704", "\uB2C9\uB124\uC784", "\uC810\uC218"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		////////////////// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		/////////////////// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		/////////////////// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = table_1.getColumnModel();
		/////////////////// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++)
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		
		
		table_1.setBounds(177, 217, 541, 322);
		contentPane.add(table_1);
		
		// 테이블 끝
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Hangmen_ranking.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label.setBounds(724, 106, 126, 115);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Hangmen_ranking.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_1.setBounds(661, 348, 126, 115);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Hangmen_ranking.class.getResource("/image/iconmonstr-cloud-1-120.png")));
		label_2.setBounds(72, 383, 126, 115);
		contentPane.add(label_2);
		
		// 순위 배경판넬
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(177, 155, 180, 66);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		// 컬럼명 순위
		JLabel lblNewLabel_1 = new JLabel("RANK");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 13, 156, 46);
		panel_1.add(lblNewLabel_1);
		
		// 이름 배경판넬
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.BLACK, 1));
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(350, 155, 188, 66);
		contentPane.add(panel_2);
		
		// 컬럼명 이름
		JLabel lblPlayer = new JLabel("PLAYER");
		lblPlayer.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setBounds(12, 10, 161, 46);
		panel_2.add(lblPlayer);
		
		// 점수 배경판넬
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(Color.BLACK, 1));
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(538, 155, 180, 66);
		contentPane.add(panel_3);
		
		// 컬럼명 점수
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(12, 10, 156, 46);
		panel_3.add(lblScore);
		
		
		
	}
}
