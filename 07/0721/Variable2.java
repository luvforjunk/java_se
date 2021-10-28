class Variable2 {
	int a; //필드, 초기화, 인스턴스 변수
	static int b; //필드, 초기화, 클래스 변수

	public static void main(String[ ] args) {
		int a=10; //지역변수, 쓰레기값
		System.out.println("지역변수 a =" +a);

		Variable2 v = new Variable2(); //생성
		System.out.println("필드 a =" + v.a);
		System.out.println("필드 b =" + Variable2.b);
	}
}
