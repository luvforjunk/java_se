//new class ��ü�� �����ϸ� �̸��� �ִ� ���� �ƴ� �ּҰ� ��� �ִ� ��

package inheritance2;

class Test extends Object {
	@Override
	public String toString() {
		// Overriding ���ְ� �Ǹ� �켱���� �ڽ�Ŭ������ �������� �ȴ�
		// Object, public String toString() (�θ�)
		// Test, public String toString() (�ڽ�)
		return getClass() + "@���ٺ�"; // �ּҰ��� @���ٺη� �ٲ��ְڴ�
		// Ŭ���� �̸��� ���� ���� ������ getClass() �Է�. getClass�� Object��
	}
}

//-----------
class Sample extends Object {

}

//-----------
public class ObjectMain {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("��ü t = " + t); // ��ü t = class inheritance2.Test@���ٺ�
		System.out.println("��ü t = " + t.toString()); // Ŭ@16����,,,toString�� ���� �ִ� �ּҸ� @���۷����� ������ ���ִ� ��
		// toString�� object�� ���� �ִµ� Sample�� Object���� ����� �޾ұ� ������ �ڵ����� toString�� �ҷ����� �־�
		// ���� �Ʒ��� ����� ����
		System.out.println();

		Sample s = new Sample();
		System.out.println("��ü s = " + s.toString()); // Ŭ@16����, ��ü s = inheritance2.Sample@1175e2db
		System.out.println("��ü s = " + s.hashCode()); // 10����, ��ü s = 292938459
		System.out.println();

		String str = "apple";
		System.out.println("��ü str = " + str.toString()); // ���ڿ�, ��ü str = apple
		// �Ϲ����� ��ü�� ������ toString�� �ҷ��� �ּҰ��� ����������
		// String Ŭ������ �������� Overriding�ϸ� �θ� ���� �����ϰ� �ڽ� ���� ó���ϹǷ� ���ڿ��� ���´�
		System.out.println("��ü str = " + str.hashCode()); // 10����-���ڿ��� �� ǥ�������� ���Ѵ�
		System.out.println();

		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println("aa==bb : " + (aa == bb)); // �ּ� - F
		System.out.println("aa.equals(bb) : " + (aa.equals(bb))); // ���ڿ� �� - T
		System.out.println();

		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd : " + (cc == dd)); // �ּ� - F
		System.out.println("cc.equals(dd) : " + (cc.equals(dd))); // �ּ� - F
		// equals�� ���ڿ� ����� ���� �ƴ϶� Object�� ���� �ּҰ��� ���ϴ� ��
		System.out.println();

		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : " + (ee == ff));// �ּ� - F
		System.out.println("ee.equals(ff) : " + (ee.equals(ff))); // ���ڿ� - T
	}

}