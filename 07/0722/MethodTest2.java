class MethodTest2 {
	//int a - 필드, class 소속이며 error 안걸림
	public static void main(String[] args) {
		//int a - 지역변수, main 함수 소속
		
		MethodTest2 mt = new MethodTest2(); //생성

		System.out.println("합 =" + mt.sum(320,258)); //호출
		System.out.println("차 =" + mt.sub(320,258)); //62
		System.out.println("곱 =" + mt.mul(320,258)); // 82560
		System.out.println("몫 =" + mt.div(320,258)); //1.24~~
	
	}

	public int sum(int a,int b){ //구현, 이렇게 중괄호 문이 열리는 걸 함수의 구현이라고 한다. int a는 sum 함수 소속. 인수 매개변수는 두개 이상 쓸 수 없다. 개별 단위로 int a, int b라고 써야한다.
		return a+b;
	}
	public int sub(int a,int b){
		return a-b;
	}
	public int mul(int a,int b){
		return a*b;
	}
	public double div(int a, int b){
	//public int div(double a,double b){ //틀린 건 아니지만 자기를 지키는 걸 더 좋아함.
		return (double)a/b;
	}
}
