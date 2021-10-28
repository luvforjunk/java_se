package collection;

class GenericTest2<T> {
	private T a;

	public GenericTest2(T a) { // ������ - new�� �� �ѹ� �Ҹ�. ���� ������ ��
		this.a = a;
	}

	public void setA(T a) { // setter - �� ó���� ��� �� ��
		this.a = a;

	}

	public T getA() {
		return a;
	}
}
//--------------------------------

public class GenericMain2 {

	public static void main(String[] args) {
		// GenericTest<?> aa = new GenericTest<String>();
		// Generic�� �ɾ����� �� �ȿ� �� �ִ� �� Object
		// aa.setA("ȫ�浿"); - error : ?�� ����ϸ� �ݵ�� �����ڸ� ���ؼ��� ���޵ȴ�
		GenericTest2<?> aa = new GenericTest2<String>("ȫ�浿");
		String name = (String) aa.getA();
		System.out.println("�̸� = " + name);

		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (Integer) bb.getA(); // AutoUnBoxing - Casting
		System.out.println("���� = " + age);
	}

}

// �⺻�� -> ��ü�� : AutoBoxing (��üȭ)
// ��ü�� -> �⺻�� : AutoUnBoxing