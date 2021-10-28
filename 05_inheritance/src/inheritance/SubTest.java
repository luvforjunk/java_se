package inheritance;

public class SubTest extends SuperTest { // SuperTest���� ��ӹޱ�
	// �켱 �������� SubTest. SubTest���� ���� ���� ������ SuperTest��.
	private String name;
	private int age;

	public SubTest(String name, int age, double w, double h) { //������
		System.out.println("SubTest Ŭ���� ������");
		this.name = name; 
		this.age = age; //���͵� ����
		super.weight = w; // this.weight = w; �θ� �͵� ����
		super.height = h; // this.height = h;
	}

	public void output() {
		System.out.println("SubTest Ŭ������ output()");
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);
	}

	public static void main(String[] args) {
		SubTest aa = new SubTest("ȫ�浿", 25, 72.3, 185.3); //�޸� ����
		//�θ�ű��� ���� ��ƹ�����.
		aa.output(); //�ҷ�����
		System.out.println("-----------------");
		aa.disp(); // �켱 SubTest Ŭ�������� ã�� ������ SuperTest���� ã�´�.
		System.out.println("-----------------");

		SuperTest bb = new SubTest("�ڳ�", 13, 25.6, 158.7);
		//�θ�� �ڽ� Ŭ������ ������ �� �ִ�.
		// bb��� Ŭ������ �������� SuperTest�� ��ڴ�
		// bb.output(); - error ���� �� �θ�
		
		bb.disp(); //�θ� �� �ִ� �� ���.
	}
}

/*
 -error 
 1. �θ� Ŭ������ �⺻ �����ڸ� ������! 
 �⺻ ������ �ڵ� ȣ�� - Ŭ���� �ȿ� �����ڰ� 1�� ���� ����
 
 �ڽ� Ŭ������ ����� �ڽ� Ŭ���� ���ΰ� �θ� �Ѳ����� �޸𸮿� �����Ѵ�.
 new �ڽ� Ŭ���� + ������(2�� ȣ��, �θ�� �⺻ �����ڸ� ȣ���Ѵ�)
 �ڽ� Ŭ������ ���� ���� �͸� �޸𸮿� ������ �ʴ´� �θ𲨵� ���� ������.
 */