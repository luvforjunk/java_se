class MethodTest2 {
	//int a - �ʵ�, class �Ҽ��̸� error �Ȱɸ�
	public static void main(String[] args) {
		//int a - ��������, main �Լ� �Ҽ�
		
		MethodTest2 mt = new MethodTest2(); //����

		System.out.println("�� =" + mt.sum(320,258)); //ȣ��
		System.out.println("�� =" + mt.sub(320,258)); //62
		System.out.println("�� =" + mt.mul(320,258)); // 82560
		System.out.println("�� =" + mt.div(320,258)); //1.24~~
	
	}

	public int sum(int a,int b){ //����, �̷��� �߰�ȣ ���� ������ �� �Լ��� �����̶�� �Ѵ�. int a�� sum �Լ� �Ҽ�. �μ� �Ű������� �ΰ� �̻� �� �� ����. ���� ������ int a, int b��� ����Ѵ�.
		return a+b;
	}
	public int sub(int a,int b){
		return a-b;
	}
	public int mul(int a,int b){
		return a*b;
	}
	public double div(int a, int b){
	//public int div(double a,double b){ //Ʋ�� �� �ƴ����� �ڱ⸦ ��Ű�� �� �� ������.
		return (double)a/b;
	}
}
