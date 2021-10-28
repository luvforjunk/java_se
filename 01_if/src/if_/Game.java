package if_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Game {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat();
		int com, user;
		int money = 1000;
		int batting;

		// 난수
		com = (int) (Math.random() * 3) + 1;

		System.out.print("가위(1), 바위(2), 보(3) 중 번호를 입력 : ");
		user = System.in.read() - 48; // 문자로 취급하고 있다,'0'(48)
		System.in.read();
		System.in.read();
		System.out.print("배팅 금액 입력 : ");
		batting = Integer.parseInt(br.readLine());//문자열이 들어오니까 parseInt
		
		//근데, 여기서 NumberFormatException이라는 error가 뜬다? 그럼 100% parseInt문제.
		//아무 글자도 못 들어오고 그냥 통과한 건 flush처리를 안해줬기때문.
		//System.in.read();을 써주자.

		System.out.println("결과를 보려면 아무키나 누르세요......");
		System.in.read();
		System.in.read();

		if (com == 1) {// 컴:가위
			if (user == 1) {
				System.out.println("컴퓨터 : 가위, 나 : 가위");
				System.out.println("비겼습니다");
			} else if (user == 2) {
				System.out.println("컴퓨터 : 가위, 나 : 바위");
				System.out.println("이겼습니다");
				money += batting; // money = money+batting
			} else if (user == 3) {
				System.out.println("컴퓨터 : 가위, 나 : 보자기");
				System.out.println("졌습니다..ㅠㅠ");
				money -= batting; // money = money-batting
			}

		} else if (com == 2) {// 컴:바위
			if (user == 1) {
				System.out.println("컴퓨터 : 바위, 나 : 가위");
				System.out.println("졌습니다..ㅠㅠ");
				money -= batting; // money = money-batting
			} else if (user == 2) {
				System.out.println("컴퓨터 : 바위, 나 : 바위");
				System.out.println("비겼습니다");
			} else if (user == 3) {
				System.out.println("컴퓨터 : 바위, 나 : 보자기");
				System.out.println("이겼습니다");
				money += batting; // money = money+batting
			}

		} else if (com == 3) {// 컴:보자기
			if (user == 1) {
				System.out.println("컴퓨터 : 보자기, 나 : 가위");
				System.out.println("이겼습니다");
				money += batting; // money = money+batting
			} else if (user == 2) {
				System.out.println("컴퓨터 : 보자기, 나 : 바위");
				System.out.println("졌습니다..ㅠㅠ");
				money -= batting; // money = money-batting
			} else if (user == 3) {
				System.out.println("컴퓨터 : 보자기, 나 : 보자기");
				System.out.println("비겼습니다");
			}
		} // if

		System.out.println("현재 금액은 " + df.format(money) + "원 입니다.");
	}
}