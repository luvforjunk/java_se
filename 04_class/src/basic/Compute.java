/*
클래스  : Compute
필드   : x, y, sum, sub, mul, div
setter : setX, setY
계산   : calc() - 합, 차, 곱, 몫
getter : getX, getY, getSum, getSub, getMul, getDiv
 */

package basic;

public class Compute {
	private int x, y, sum, sub, mul;
	private double div; // 클래스가 수행할 일을 필드로 잡아준다.
	// Compute클래스 안에 x, y, sum, sub, mul, div가 있는 것.

	public void setX(int x) { // 데이터가 들어갈 setX가 필요함.
		this.x = x; // this는 클래스꺼
	}

	public void setY(int y) {
		this.y = y;
	}

	public void calc() { // 데이터를 받을 것도, return도 할 필요 없음. 계산만 해주면 되니까.
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
