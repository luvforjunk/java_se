import java.text.DecimalFormat;
class PayTest {
	public static void main(String[] args) {
		char name = 'L';
		//String name = "L";

		int basePay = 2500000;
		int tax = (int)(basePay * 0.033);
		int salary = basePay - tax;

		//숫자 3자리마다 ,를 표시
		DecimalFormat df = new DecimalFormat ();

		System.out.println("***" + name + "의 월급 ***");
		System.out.println("기본급 : " + df.format(basePay) + "원");
		System.out.println("세금 : " + df.format(tax) + "원");
		System.out.println("월급 : " + df.format(salary) + "원");
	}
}