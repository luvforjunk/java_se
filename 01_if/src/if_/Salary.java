/*
[����]
���� ��� ���α׷�
�̸�, ����, �⺻��, ������ �Է��Ͽ� �޿�, ����, ������ ����Ͻÿ�
������ �޿��� 4,000,000 ���� �̻��̸� 3% �ƴϸ� 2%�� �Ѵ� (���ǿ����� - ���� ? �� : ����)

�޿� = �⺻�� + ����
���� = �޿� * ����
���� = �޿� - ����

������ calcTax() �޼ҵ� ���Ͽ� �����´� (return)
������ calcSalary()  �޼ҵ� ���Ͽ� �����´� (return)
 */

package if_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Salary {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat();
		// DecimalFormat df = new DecimalFormat("#,###");
		Salary s = new Salary();

		System.out.print("�̸� �Է� : ");
		String name = br.readLine();
		System.out.print("��å �Է� : ");
		String position = br.readLine();
		System.out.print("�⺻�� �Է� : ");
		int basePay = Integer.parseInt(br.readLine()); //String�� int������, Integer.parseInt(
		System.out.print("���� �Է� : ");
		int extraPay = Integer.parseInt(br.readLine());

		int totalPay = basePay + extraPay;
		double taxRate = totalPay >= 4000000 ? 0.03 : 0.02;

		// int tax = (int)(totalPay*taxRate); //int�� double�� ���� ���� double�� ǥ�õǴ� �� ���� ���� �տ� (int)�� ���̴� ����.
		int tax = s.calcTax(totalPay, taxRate);// ȣ��

		// int pay = totalPay - tax;
		int pay = s.calcSalary(totalPay, tax);

		System.out.println("\t *** " + name + " ���� ���� ***");
		System.out.println("���� : " + position);

		// System.out.println("�⺻��\t����\t�޿�\t����\t����\t����");
		System.out.printf("%12s %12s %12s %8s %12s %12s\n", "�⺻��", "����", "�޿�", "����", "����", "����");

		/*
		 * System.out.println(df.format(basePay) + "\t" + df.format(extraPay) + "\t" +
		 * df.format(totalPay) + "\t" + (int)(taxRate*100) + "% \t" + df.format(tax) +
		 * "\t" + df.format(pay));
		 */
		System.out.printf("%13s %13s %13s %7d%% %13s %13s\n", df.format(basePay), df.format(extraPay),
				df.format(totalPay), (int) (taxRate * 100), df.format(tax), df.format(pay));
	}// main

	public int calcTax(int totalPay, double taxRate) {
		return (int) (totalPay * taxRate);
	}

	public int calcSalary(int totalPay, int tax) {
		return totalPay - tax;
	}
}