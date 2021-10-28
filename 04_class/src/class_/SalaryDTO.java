package class_;

import java.util.Scanner;

public class SalaryDTO {
	private String name;
	private String position;
	private int basePay;
	private int benefit;
	private double taxRate;
	private int tax;
	private int salary;

	public SalaryDTO() {
		Scanner scan = new Scanner(System.in);

		System.out.print("�̸� : ");
		name = scan.next();
		System.out.print("���� : ");
		position = scan.next();
		System.out.print("�⺻�� : ");
		basePay = scan.nextInt();
		System.out.print("���� : ");
		benefit = scan.nextInt();
	}

//setter
	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}

	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}

//���
	public void calc() {
		int total = basePay + benefit; // �հ� = �⺻�� + ����

		if (total <= 2000000) // ���� ���
			taxRate = 0.01;
		else if (total <= 4000000)
			taxRate = 0.02;
		else
			taxRate = 0.03;

		tax = (int) (total * taxRate); // ���ݰ��
		salary = total - tax; // ���ް��
	}
//getter

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public int getBasePay() {
		return basePay;
	}

	public int getBenefit() {
		return benefit;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public int getTax() {
		return tax;
	}

	public int getSalary() {
		return salary;
	}
}