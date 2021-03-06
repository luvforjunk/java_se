/*
[문제]
월급 계산 프로그램
이름, 직급, 기본급, 수당을 입력하여 급여, 세금, 월급을 계산하시오
세율은 급여가 4,000,000 만원 이상이면 3% 아니면 2%로 한다 (조건연산자 - 조건 ? 참 : 거짓)

급여 = 기본급 + 수당
세금 = 급여 * 세율
월급 = 급여 - 세금

세금은 calcTax() 메소드 구하여 가져온다 (return)
월급은 calcSalary()  메소드 구하여 가져온다 (return)
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

		System.out.print("이름 입력 : ");
		String name = br.readLine();
		System.out.print("직책 입력 : ");
		String position = br.readLine();
		System.out.print("기본급 입력 : ");
		int basePay = Integer.parseInt(br.readLine()); //String을 int형으로, Integer.parseInt(
		System.out.print("수당 입력 : ");
		int extraPay = Integer.parseInt(br.readLine());

		int totalPay = basePay + extraPay;
		double taxRate = totalPay >= 4000000 ? 0.03 : 0.02;

		// int tax = (int)(totalPay*taxRate); //int와 double의 곱한 값이 double로 표시되는 걸 막기 위해 앞에 (int)를 붙이는 거임.
		int tax = s.calcTax(totalPay, taxRate);// 호출

		// int pay = totalPay - tax;
		int pay = s.calcSalary(totalPay, tax);

		System.out.println("\t *** " + name + " 월급 명세서 ***");
		System.out.println("직급 : " + position);

		// System.out.println("기본급\t수당\t급여\t세율\t세금\t월급");
		System.out.printf("%12s %12s %12s %8s %12s %12s\n", "기본급", "수당", "급여", "세율", "세금", "월급");

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