package inheritance;

import java.awt.Button;
import java.awt.Frame;

//Frame은 BorderLayout - 구역을 이미 나눠놓은 것(동서남북)
public class AwtMain extends Frame {
	// AwtMain아래로 자식이 없으므로 private잡아줘도 된다
	private Button northBtn = null, southBtn, eastBtn, westBtn, centerBtn;
	// 모든 클래스 객체형은 아무것도 생성 안하면 널값 나온다
	// *자주 뜨는 오류 - NullPointerException - null값만 떴으니 new생성해라
	private int a = 0;

	public void init() {
		// 버튼 생성
		northBtn = new Button("북쪽");
		southBtn = new Button("남쪽");
		eastBtn = new Button("동쪽");
		westBtn = new Button("서쪽");
		centerBtn = new Button("중앙");
		//

		// 배치 - 구역을 나눠놓고 갖다 붙이는 작업
		add("North", northBtn);// 북쪽에다 northBtn 놔주세요
		add("South", southBtn);
		add("East", eastBtn);
		add("West", westBtn);
		add("Center", centerBtn);

		setBounds(900, 200, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		AwtMain am = new AwtMain(); // init는 static이 아니므로 생성자 생성,, 클래스 생성 -> 생성자 부르기
		am.init();// -> init호출

		new AwtMain().init(); // 위 두 구문을 합친 것
		// WindowTest에서 창 띄우는 방법과 다르게 메소드를 잡은 다음에 해도 되고~~
	}

}

/*
 * Exception 예외처리
 * 
 * 컴파일 - 보험 IOException
 * 
 * 실행 - 개발자 코드 잘못 ArrayIndexOutOfBoundsException - 배열의 방을 잘못 설정해서
 * NullPointerException - new를 안해줘서
 */