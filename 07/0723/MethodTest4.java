class Test{
	//class �ٷ� �ؿ� ��� �� ��� �ʵ�
	int a, b; //�ʵ�, �ʱ�ȭ -> Static�� �տ� �����Ƿ� new ���� �����

	public void sum(){
		//int a=100; a
		System.out.println(a+ "+" +b+ "=" +(a+b));
	}
	public void mul(){
		System.out.println(a+ "*" +b+ "=" +(a*b));
	}
}

//class�� �޴����̶�� �����ϸ� ��. ������ new�� �󸶵��� ���� �� ����.

//------------------
class MethodTest4{
	public static void main(String[] args) {
		Test t = new Test();

		System.out.println("a =" +t.a + "\t b=" + t.b); 
		//heap�̶�� �޸� �ȿ� Test�� ������ �� �ȿ� a, b��� ������ ����.
		//t(��ü�ּ�)�� ����Ű�� ���� a�� ����. 
		System.out.println();
		
		t.a = 50;
		t.b = 60;
		t.sum(); //ȣ��
		t.mul();

		Test t2 = new Test();
		t2.a = 70;
		t2.b = 80;
		t2.sum();
		t2.mul();
	}
} 
