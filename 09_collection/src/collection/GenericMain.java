package collection;

class GenericTest<T> {
	private T a;

	public void setA(T a) {
		this.a = a;

	}

	public T getA() {
		return a;
	}
}
//----------------

public class GenericMain {

	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>();
		// String�̶�� �۾��� �� T�� ��Ī��
		// ������ ���ڿ��� ������� �� �ִ� ��
		aa.setA("ȫ�浿");
		System.out.println("�̸� = " + aa.getA());
		// aa.setA(250); -error : ���ڿ��� ���� �ߴµ�....

		GenericTest<Integer> bb = new GenericTest<Integer>();
		// �Ȱ��� Ŀ���ε� �ٸ� Ÿ������
		// intó�� �⺻���� �־��� �� ����
		// Generic�ȿ��� Ŭ������ �� �� �ִ�
		bb.setA(25);
		System.out.println("���� = " + bb.getA());

	}

}
