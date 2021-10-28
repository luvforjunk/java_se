package nested;

public class Outer { // - Ŭ����1
	private String name; // �ʵ�
	// �ܺε����͸� �������� ���������� setter�� getter�� ���µ�
	// ��ø�� ��Ű�� setter�� getter �ʿ� ����

	public void output() { // �޼ҵ�
		// System.out.println("�̸� = " + name + "\t ���� = " + age); - ���� �Ұ�
		System.out.println("�̸� = " + this.name + "\t ���� = " + new Inner().age); // - ���� ����
	}

	class Inner { // ����̳� - Ŭ����2
		private int age; // �ʵ�

		public void disp() { // �޼ҵ�
			System.out.println("�̸� = " + Outer.this.name + "\t ���� = " + this.age);
			// static�� ��� Ŭ���������� �ٷ� ���ٵ����� ��� static�� �ƴϹǷ�
			// Outer.this.name���� this�� ���� �Ұ�
		}
	} // Class Inner

	public static void main(String[] args) {
		Outer ou = new Outer(); // Outer new
		ou.name = "ȫ�浿";
		ou.output();

//		Inner��� ���� ���� �ȵȴ�
//		Outer�ȿ� �ִ� Inner��� �˷��ֱ� ����
//		new Inner��� �ϸ� �ȵȴ�
		Outer.Inner in = ou.new Inner(); // Outer�� Inner new
		in.age = 25;
		in.disp();

		Outer.Inner in2 = ou.new Inner(); // Outer�ȿ� Inner�� ��~
		in2.age = 30;
		in2.disp();

		Outer.Inner in3 = new Outer().new Inner(); // �� ���� �ȿ� ���� ������?
		// �̷� �� Outer�� ���� ����� ��� ��
		// in3.name = "�ڳ�"; - error : ���� Ŭ�������� ������ ���� ���⼱ �ȵ�
		in3.age = 35;
		in3.disp();
	}
} // Outer

// Inner�� ��ӹ��� ��ó�� �� ���� ������
// Outer�� ������ ���Ѵ�. ������ ��~�ؼ� ��ü�� �����ϸ� �����ϴ�