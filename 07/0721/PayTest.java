import java.text.DecimalFormat;
class PayTest {
	public static void main(String[] args) {
		char name = 'L';
		//String name = "L";

		int basePay = 2500000;
		int tax = (int)(basePay * 0.033);
		int salary = basePay - tax;

		//���� 3�ڸ����� ,�� ǥ��
		DecimalFormat df = new DecimalFormat ();

		System.out.println("***" + name + "�� ���� ***");
		System.out.println("�⺻�� : " + df.format(basePay) + "��");
		System.out.println("���� : " + df.format(tax) + "��");
		System.out.println("���� : " + df.format(salary) + "��");
	}
}