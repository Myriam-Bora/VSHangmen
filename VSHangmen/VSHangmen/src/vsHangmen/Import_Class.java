package vsHangmen;

import java.awt.EventQueue;
import java.util.ArrayList;

public class Import_Class {
	
	// ��ŷ 1~5�� �̸� ���� �ʱⰪ
	static String rank1name = "�ƹ���";
	static String rank2name = "������";
	static String rank3name = "3���� �ƹ���";
	static String rank4name = "������";
	static String rank5name = "5����";
	static int jumsu1 = 200;
	static int jumsu2 = 150;
	static int jumsu3 = 90;
	static int jumsu4 = 80;
	static int jumsu5 = 60;
	// �÷��̾� �̸� �⺻��
	static String player1name = "\uC544\uBB34\uAC1C";
	static String player2name = "\uC800\uBB34\uAC1C";
	// ���� ���
	static String [] questionwords = {"computer","kitchen","subway","smoke","moniter","keyboard","mouse"
			,"picture","question","random"};
	// �ߺ����ϱ� ���� ���ݱ��� ���� ���� ���
	static ArrayList<String> reviewwords = new ArrayList<String>();

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

}
