package abstract_;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {

	public static void main(String[] args) {
		// 3자리마다 ,를 찍고 소수 이하 3째자리까지
		// NumberFormat nf = new NumberFormat(); -error : 추상이라 메모리에 생성할 수 없으니 자식 클래스 이용
		NumberFormat nf = new DecimalFormat();
		System.out.println(nf.format(12345678.456789)); // 12,345,678.457
		System.out.println(nf.format(12345678)); // 12,345,678
		System.out.println();

		// 유효 숫자가 아닌 것은 표현하지 않는다
		NumberFormat nf2 = new DecimalFormat("#,###.##원"); // Oracle은 9,999로 표현
		System.out.println(nf2.format(12345678.456789)); // 12,345,678.46원
		System.out.println(nf2.format(12345678)); // 12,345,678원
		System.out.println();

		// 강제로 0을 표시
		NumberFormat nf3 = new DecimalFormat("#,###.00원");
		System.out.println(nf3.format(12345678.456789)); // 12,345,678.46원
		System.out.println(nf3.format(12345678)); // 12,345,678.00원
		System.out.println();

		// 추상 클래스를 메소드를 이용하여 생성
		// 3자리마다 ,를 찍고 소수 이하 3째자리까지
		// NumberFormat nf4 = NumberFormat.getInstance();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		System.out.println(nf4.format(12345678.456789)); // ?12,345,678
		System.out.println(nf4.format(12345678)); // ?12,345,678
		System.out.println();

		NumberFormat nf5 = NumberFormat.getInstance();
		nf5.setMaximumFractionDigits(2);// 현재 갖고 있는 걸 소수이하 2째자리까지
		nf5.setMinimumFractionDigits(2);// 강제로 0을 표시
		System.out.println(nf5.format(12345678.456789)); // 12,345,678.46
		System.out.println(nf5.format(12345678)); // 12,345,678.00
		System.out.println();

		NumberFormat nf6 = NumberFormat.getCurrencyInstance(Locale.US);
		nf6.setMaximumFractionDigits(2);// 현재 갖고 있는 걸 소수이하 2째자리까지
		nf6.setMinimumFractionDigits(2);// 강제로 0을 표시
		System.out.println(nf6.format(12345678.456789)); // $12,345,678.46
		System.out.println(nf6.format(12345678)); // $12,345,678.00
		System.out.println();
	}

}
