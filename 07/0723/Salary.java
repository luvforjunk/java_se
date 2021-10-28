import java.text.DecimalFormat;

class Salary{
	public static void main(String[] args) {
     
	Salary sl = new Salary();

		String name = args[0];
    int a = Integer.parseInt(args[1]); 
    int b = Integer.parseInt(args[2]);
	int Pay = a + b;

	double result = Pay >= 4000000 ? 0.03 : 0.02;

	int cT = sl.calcTax(Pay, result);
	int sT = sl.calcSalary(Pay, cT);

		DecimalFormat df = new DecimalFormat ();

	System.out.println("\t***" + name + "월급 명세서 ***");
		System.out.println("직급 :" + a);
		System.out.println("기본급\t수당\t급여\t세율\t세금\t월급");
		System.out.println(df.format(a) + df.format(b) + df.format(Pay) + result + cT + sT);
	}

public int calcTax(int Pay, int result);{
	return Pay*result;
}
public int calcSalary(int Pay, int cT);{
	return Pay-cT;
	}
}

