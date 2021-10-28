package inheritance;

//�θ𺸴� �ڽ��� �� ũ��
//�θ� �ϳ��ΰ� ���ϻ���̶� �Ѵ�
//interface�� �ڹ��� ���� ����� �ذ��ϱ� ���� ���� - interface�� ����� �ƴ�
//�θ� private�� �ɾ������ �ڽ��� �� �� ����. ������ ���� ���������̴�.
//Ŭ������ �� �� ĸ��ȭ�� �ؼ� public�� �� �� ���� protected�� �Ἥ �θ� �ڽŰ� �ڽ� Ŭ�������Ը� ������ �㰡�Ѵ�.
//���� �� - private < protected < public 

public class SuperTest {
	protected double weight, height;
	// protected�� �ܺο����� �����͸� ������ �� ����
	// ���� setter�� ���� �����͸� �޾ƿ��ų� �����ڸ� ����Ѵ�.

	public SuperTest() { //�⺻������ �θ��� Ctrl + spacebar
		System.out.println("SuperTest Ŭ���� �⺻������");

	}

	// 2���� �Ű�����(�μ�)�� ���� ������
	public SuperTest(double w, double h) { // ���� ������������ ���� ����������Ѵ�. double w,h (X)
		System.out.println("SuperTest Ŭ���� ������");
		this.weight = w;
		this.height = h;
	}

	public void disp() {
		System.out.println("SuperTest Ŭ���� disp()");
		System.out.println("������ =" + weight);
		System.out.println("Ű =" + height);
	}

}
