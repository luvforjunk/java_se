/*
x=320, y=258�� ��, ��, ��, ���� ���Ͻÿ�

[������]
x     y      sum   sub    mul    div
320   258    xxx
236   125
539   327 
 */
package basic;

public class ComputeMain {

	public static void main(String[] args) {
		Compute aa = new Compute(); // ����***
		aa.setX(320); //private���� ��Ƴ��� ������ class Compute�� �ƴϰ��� ������ �� ����, aa.x =320;�̶�� �� �� ����.

		aa.setY(258);

		aa.calc();

		System.out.println("X\tY\tSum\tSub\tMul\tDiv");
		System.out.println(aa.getX() + "\t" + aa.getY() + "\t" + aa.getSum() + "\t" + aa.getSub() + "\t" + aa.getMul()
				+ "\t" + String.format("%.2f", aa.getDiv()));
	}

}












