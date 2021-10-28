package constructor;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SalaryDTO {
	private int empId;
	private String name;
	private String position;
	private int basePay;
	private int benefit;
	private double taxRate;
	private int tax;
	private int salary;

	private DecimalFormat df = new DecimalFormat(); //세자리 수마다 , 찍기
	//private은 써도 되고 안써도 되고

	public SalaryDTO() { 
		//선택! - SalaryDTO에서 받을건지, SalaryService에서 받아서 전달한건지
		Scanner scan = new Scanner(System.in);

		System.out.print("사원번호 입력 : ");
		empId = scan.nextInt();
		System.out.print("사원명 입력 : ");
		name = scan.next();
		System.out.print("직급 입력 : ");
		position = scan.next();
		System.out.print("기본급 입력 : ");
		basePay = scan.nextInt();
		System.out.print("수당 입력 : ");
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
		int total = basePay + benefit; //합계 = 기본급 + 수당

		if (total <= 2000000) //세율 계산
			taxRate = 0.01;
		else if (total <= 4000000)
			taxRate = 0.02;
		else
			taxRate = 0.03;

		tax = (int) (total * taxRate); //세금계산
		salary = total - tax; //월급계산
	}
//getter
	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public String getBasePay() {
		return df.format(basePay); //format을 걸 경우 문자로 바뀌기 때문에 String으로 반드시 바꿔줘야 한다.
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