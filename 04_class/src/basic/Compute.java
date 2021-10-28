/*
Ŭ����  : Compute
�ʵ�   : x, y, sum, sub, mul, div
setter : setX, setY
���   : calc() - ��, ��, ��, ��
getter : getX, getY, getSum, getSub, getMul, getDiv
 */

package basic;

public class Compute {
	private int x, y, sum, sub, mul;
	private double div; // Ŭ������ ������ ���� �ʵ�� ����ش�.
	// ComputeŬ���� �ȿ� x, y, sum, sub, mul, div�� �ִ� ��.

	public void setX(int x) { // �����Ͱ� �� setX�� �ʿ���.
		this.x = x; // this�� Ŭ������
	}

	public void setY(int y) {
		this.y = y;
	}

	public void calc() { // �����͸� ���� �͵�, return�� �� �ʿ� ����. ��길 ���ָ� �Ǵϱ�.
		sum = x + y;
		sub = x - y;
		mul = x * y;
		div = (double) x / y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSum() {
		return sum;
	}

	public int getSub() {
		return sub;
	}

	public int getMul() {
		return mul;
	}

	public double getDiv() {
		return div;
	}
}
