package basic;

class Person {
	private String name; // private : �ܺο��� ������ ���ϰ� �����ִ� ��
	private int age; // �ڽ��� Ŭ���� �ȿ����� ���� ���

	public void setName(String n) { // ����
		name = n;
	}

	public void setAge(int a) {
		age = a;
	}

	public void setData(String n, int a) { // �Լ��� �̸��� �Ȱ��� ���� �� Overload��� �Ѵ�.
		name = n;
		age = a;
	}

	// ���� ������ �޼ҵ带 ��� Ŀ�Ǹ� ���� �������� �޼ҵ带 �ϳ� �����.
	// ���� ������ �޼ҵ带 setter(�����͸� �޴�), �����͸� �������� �޼ҵ带 getter��� �Ѵ�.
	public void setData() {
	} // �Լ��� �̸��� �Ȱ��� ���� �� Overload��� �Ѵ�. �޼ҵ���� ������ �μ����� Ʋ���ų� �μ��� ������ Ʋ���ų�
		// ���� �ִ� ���� �ֵ��̶�� �ν�.

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;

	}
}

//--------------��ü�������α׷�
public class PersonMain {

	public static void main(String[] args) {
		Person p; // ��ü
		p = new Person(); // ���� �޸𸮰� ��ġ�� �ִ� �ּ�
		System.out.println("��ü p =" + p); // �ּҸ� �����´�. ��ü p =basic.Person@7de26db8
		// 16���� ���۷����� �����´�.
		System.out.println("��ü p =" + p.toString());
		p.setName("ȫ�浿"); // <- p.name = "ȫ�浿";
		// p�� ��� �ִ� name���� ȫ�浿�̶�� �̸��� �ش�.
		p.setAge(25); // <- p.age = 25;
		System.out.println("�̸�=" + p.getName() + "\t ����=" + p.getAge());

		// new��� �����ڸ� �̿��ؼ� �����ϸ� �޸� heap�� �Ҵ�ȴ�
		// heap ������ �Ҵ�� ���� �̸��� ����. �׻� �ּҸ� ����Ѵ�.

		Person p2 = new Person();
		System.out.println("��ü p2 =" + p2);
		p2.setName("�ڳ�");// ȣ��
		p2.setAge(13);
		System.out.println("�̸�=" + p2.getName() + "\t ����=" + p2.getAge());

		Person p3 = new Person();
		p3.setData("���̾�", 35);
		System.out.println("�̸�=" + p3.getName() + "\t ����=" + p3.getAge());

		Person p4 = new Person();
		p4.setData(); // ���ϴ� �����͸� �־�� �� �� ���� ó���ǰ� �Ϸ��� �޼ҵ带 ��������
		System.out.println("�̸�=" + p4.getName() + "\t ����=" + p4.getAge());
		System.out.println();
	}
}

//�Լ�()�ȿ� ���� �� parameter �Ű����� Ȥ�� argument �μ���� �Ѵ�
