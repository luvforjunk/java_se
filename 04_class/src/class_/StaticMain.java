package class_;

public class StaticMain {
	private int a; // 클래스 바로 밑에 있는 아이들을 필드라고 한다. new를 시켜줘야 하는 인스턴스변수
	private static int b; // 필드, static이 붙는 걸 클래스변수라고 한다.

	static {
		System.out.println("초기화 영역");
		b = 3;
	}

	public StaticMain() {
		System.out.println("기본 생성자");
		this.a = 3;
	}

	public void calc() {
		this.a++;
		b++;
	}

	public void disp() {
		System.out.println("a=" + this.a + "\t b=" + StaticMain.b);
	}

	public static void output() {
		System.out.println("static method...");
		// static 메소드에는 this값이 존재하지 않는다.
		// System.out.println("a=" + this.a + "\t b=" + StaticMain.b); - error
		// ex)void main에는 this가 없다.
	}

	public static void main(String[] args) {
		StaticMain st = new StaticMain();
		st.calc();
		st.disp();
		System.out.println();

		StaticMain st2 = new StaticMain();
		st2.calc();
		st2.disp();
		System.out.println();

		StaticMain st3 = new StaticMain();
		st3.calc();
		st3.disp();
		System.out.println();

		// static 메소드 호출
		StaticMain.output();// 클래스명.메소드()
		output();
		st.output();// 객체.메소드
	}

}// class StaticMain
