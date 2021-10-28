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

		System.out.print("이름 : ");
		name = scan.next();
		System.out.print("직급 : ");
		position = scan.next();
		System.out.print("기본급 : ");
		basePay = scan.nextInt();
		System.out.print("수당 : ");
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

//계산
	public void calc() {
		int total = basePay + benefit; // 합계 = 기본급 + 수당

		if (total <= 2000000) // 세율 계산
			taxRate = 0.01;
		else if (total <= 4000000)
			taxRate = 0.02;
		else
			taxRate = 0.03;

		tax = (int) (total * taxRate); // 세금계산
		salary = total - tax; // 월급계산
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