class MethodTest {
	public static void main(String[] args){
		//System.out.println("args[0] =" + args[0]);
		//System.out.println("args[1] =" + args[1]);

		//ȣ��
		MethodTest.output();

		MethodTest mt = new MethodTest();
		mt.disp(); //��� �Լ��� �θ޶�ó�� ���ƿ´�.
	}
	public void disp(){ //����
		System.out.println("non-static method");
	}
	public static void output(){ //����
		System.out.println("static method");
	}
}
