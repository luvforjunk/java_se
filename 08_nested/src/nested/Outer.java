package nested;

public class Outer { // - 클래스1
	private String name; // 필드
	// 외부데이터를 가져오고 내보내려면 setter와 getter를 쓰는데
	// 중첩을 시키면 setter와 getter 필요 없음

	public void output() { // 메소드
		// System.out.println("이름 = " + name + "\t 나이 = " + age); - 접근 불가
		System.out.println("이름 = " + this.name + "\t 나이 = " + new Inner().age); // - 접근 가능
	}

	class Inner { // 멤버이너 - 클래스2
		private int age; // 필드

		public void disp() { // 메소드
			System.out.println("이름 = " + Outer.this.name + "\t 나이 = " + this.age);
			// static일 경우 클래스명으로 바로 접근되지만 얘는 static이 아니므로
			// Outer.this.name에서 this는 생략 불가
		}
	} // Class Inner

	public static void main(String[] args) {
		Outer ou = new Outer(); // Outer new
		ou.name = "홍길동";
		ou.output();

//		Inner라고 직접 쓰면 안된다
//		Outer안에 있는 Inner라고 알려주기 위해
//		new Inner라고도 하면 안된다
		Outer.Inner in = ou.new Inner(); // Outer의 Inner new
		in.age = 25;
		in.disp();

		Outer.Inner in2 = ou.new Inner(); // Outer안에 Inner가 둘~
		in2.age = 30;
		in2.disp();

		Outer.Inner in3 = new Outer().new Inner(); // 난 저기 안에 들어가기 싫은뒈?
		// 이럴 땐 Outer를 따로 만들어 줘야 됨
		// in3.name = "코난"; - error : 같은 클래스에선 먹힐지 몰라도 여기선 안됨
		in3.age = 35;
		in3.disp();
	}
} // Outer

// Inner는 상속받은 것처럼 다 갖다 쓰지만
// Outer는 접근을 못한다. 하지만 뉴~해서 객체를 생성하면 가능하다