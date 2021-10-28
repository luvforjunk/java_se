class Test{
	//class 바로 밑에 잡는 건 모두 필드
	int a, b; //필드, 초기화 -> Static이 앞에 없으므로 new 설정 해줘야

	public void sum(){
		//int a=100; a
		System.out.println(a+ "+" +b+ "=" +(a+b));
	}
	public void mul(){
		System.out.println(a+ "*" +b+ "=" +(a*b));
	}
}

//class는 메뉴판이라고 생각하면 됨. 음식인 new는 얼마든지 만들 수 있음.

//------------------
class MethodTest4{
	public static void main(String[] args) {
		Test t = new Test();

		System.out.println("a =" +t.a + "\t b=" + t.b); 
		//heap이라는 메모리 안에 Test가 잡히고 그 안에 a, b라는 변수가 잡힘.
		//t(객체주소)가 가르키는 곳에 a를 찍어라. 
		System.out.println();
		
		t.a = 50;
		t.b = 60;
		t.sum(); //호출
		t.mul();

		Test t2 = new Test();
		t2.a = 70;
		t2.b = 80;
		t2.sum();
		t2.mul();
	}
} 
