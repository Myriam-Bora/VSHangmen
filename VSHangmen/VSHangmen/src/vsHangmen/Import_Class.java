package vsHangmen;

import java.awt.EventQueue;
import java.util.ArrayList;

public class Import_Class {
	
	// 랭킹 1~5등 이름 점수 초기값
	static String rank1name = "아무개";
	static String rank2name = "저무개";
	static String rank3name = "3등한 아무개";
	static String rank4name = "누구게";
	static String rank5name = "5등함";
	static int jumsu1 = 200;
	static int jumsu2 = 150;
	static int jumsu3 = 90;
	static int jumsu4 = 80;
	static int jumsu5 = 60;
	// 플레이어 이름 기본값
	static String player1name = "\uC544\uBB34\uAC1C";
	static String player2name = "\uC800\uBB34\uAC1C";
	// 문제 목록
	static String [] questionwords = {"computer","kitchen","subway","smoke","moniter","keyboard","mouse"
			,"picture","question","random"};
	// 중복피하기 위한 지금까지 나온 문제 목록
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
