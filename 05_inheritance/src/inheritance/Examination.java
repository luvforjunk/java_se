package inheritance;

import java.util.Scanner;

public class Examination {
	public static final String JUNG = "11111"; // 정답, 상수화
	// final - 절대 이값을 바꾸지 마라
	// static은 클래스에 직접 접근하게 해주는 것. final이랑 같이 많이 쓰인다
	// 상수화 시킬 때는 private보다는 public을 자주 씀

	private String name = null;
	private String dap;
	private char[] ox = null; // 배열로 - 문자로 잡았다는 거
	// 문자열로 잡을 수도 문자로 잡을 수 있는데, 문자열로 잡으면 그냥 String으로 잡고 문자로 잡으면 배열로 잡아야
	private int score;

	public Examination() { // 생성자
		Scanner scan = new Scanner(System.in);

		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.print("답 입력 : ");
		dap = scan.next();

		ox = new char[5]; // char로 방을 5개 잡겠다
	}

	public void compare() {
		for (int i = 0; i < ox.length; i++) {
			if (JUNG.charAt(i) == dap.charAt(i)) {
				ox[i] = 'O'; // 맞으면
				score += 20;
			} else {
				ox[i] = 'X';
			}
		} // for
	}

	public String getName() {
		return name;
	}

	public char[] getOx() {
		return ox;
	}

	public int getScore() {
		return score;
	}
}