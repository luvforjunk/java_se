/*
x=320, y=258로 합, 차, 곱, 몫을 구하시오

[실행결과]
x     y      sum   sub    mul    div
320   258    xxx
236   125
539   327 
 */
package basic;

public class ComputeMain {

	public static void main(String[] args) {
		Compute aa = new Compute(); // 생성***
		aa.setX(320); //private으로 잡아놨기 때문에 class Compute가 아니고서야 접근할 수 없어, aa.x =320;이라고 쓸 수 없다.

		aa.setY(258);

		aa.calc();

		System.out.println("X\tY\tSum\tSub\tMul\tDiv");
		System.out.println(aa.getX() + "\t" + aa.getY() + "\t" + aa.getSum() + "\t" + aa.getSub() + "\t" + aa.getMul()
				+ "\t" + String.format("%.2f", aa.getDiv()));
	}

}












