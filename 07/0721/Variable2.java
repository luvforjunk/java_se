class Variable2 {
	int a; //�ʵ�, �ʱ�ȭ, �ν��Ͻ� ����
	static int b; //�ʵ�, �ʱ�ȭ, Ŭ���� ����

	public static void main(String[ ] args) {
		int a=10; //��������, �����Ⱚ
		System.out.println("�������� a =" +a);

		Variable2 v = new Variable2(); //����
		System.out.println("�ʵ� a =" + v.a);
		System.out.println("�ʵ� b =" + Variable2.b);
	}
}
