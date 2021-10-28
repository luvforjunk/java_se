package swing;

enum Shape {// 상수만 모아놓은 것 = enum
	LINE, CIRCLE, RECT, ROUNDRECT, PEN
}

//--------------------------------------
// 도형 딱 1개
public class ShapeDTO {
//	public static final int LINE = 0; // 이렇게 잡아주기도 하지만 개수가 많을 땐
//	public static final int CIRCLE = 1; // 위에 있는 상수 집합체인 enum으로 잡아준다
//	public static final int RECT = 2; 
//	public static final int ROUNDRECT = 3;
//	public static final int PEN = 4;

	private int x1, y1, x2, y2, z1, z2;
	private boolean fill;
//	private int shape; // 0이면 선, 1이면 원, 2이면 사각형, 3이면 둥근사각형
	// 자바에서 상수화시키려면 ? - static final
	private Shape shape;
	private int color; //

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getZ1() {
		return z1;
	}

	public void setZ1(int z1) {
		this.z1 = z1;
	}

	public int getZ2() {
		return z2;
	}

	public void setZ2(int z2) {
		this.z2 = z2;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return shape + ""; // 단순 주소값을 shape으로 변경해 확인 편하도록
	}
}
