class CompTest3 {
	public static void main(String[] args){
		int num = 30;

		//num�� ����ִ� �����Ͱ� ¦���̳�?
		//num�� ����ִ� �����Ͱ� 2�� ���?
		//num�� ����ִ� �����Ͱ� 2�� �������� �� �������� 0�̳�?

		String result = num % 2 == 0 ? "¦���̴�" : "Ȧ���̴�";

		System.out.println(num + "��(��)" + result);
	}
}
