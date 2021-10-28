package constructor;

public class PointMain {
	private int x, y;

	public PointMain() { // �⺻������
		x = y = 10;
		// �����ڿ��� ���� void�� ���� �ȵȴ�. Ŭ������� �Ȱ��� ���ְ� �⺻ �������̹Ƿ� ()�� ���ش�.
	}

	public PointMain(int x, int y) { // �ܺηκ��� x�� y�� �޴´�. setter�� ���� ����
		this.x = x; // this.x���� ����
		this.y = y; // this.y���� ����

		// �����ڿ� setter�� ���� ������ ������ �����ڴ� new�� �� �ڵ�ȣ���� �Ѵ�.(1���� ó��)
		// setter�� �޼ҵ���� ������� ����ָ� �ǰ�, ����ȣ���� �ϵ� ���ϴ� �������� ������� �ҷ��� �� �� �ִ�.(����)
		// �ʱⰪ�� ���� ���� ������, ���� ������ ���� setter.
	}

	public PointMain(PointMain aa, PointMain bb) { // ��ü��(Ŭ������)
		this.x = aa.x + bb.x;
		this.y = aa.y * bb.y;
	}

	public void calcPlus() {
		x += 10;
	}

	public void calcPlus(int x, int y) { // 3�� -8 �μ��� �޴� �޼ҵ�
		this.x += x;
		this.y += y;
	}

	public static void main(String[] args) {
		PointMain aa = new PointMain();
		System.out.println("x=" + aa.x + "\t y=" + aa.y);

		System.out.println("\n x�� ���� +10 �����ϴ� �޼ҵ带 �ۼ��Ͻÿ� - calcPlus()");
		aa.calcPlus();
		System.out.println("x=" + aa.x + "\t y=" + aa.y);
		System.out.println();

		PointMain bb = new PointMain(100, 200);
		System.out.println("x=" + bb.x + "\t y=" + bb.y);

		System.out.println("\n 3, -8 �μ��� �޾Ƽ� x�� ����, y�� �����ϴ� �޼ҵ带 �ۼ��Ͻÿ�- calcPlus()");
		bb.calcPlus(3, -8); // �μ� �ޱ�
		System.out.println("x=" + bb.x + "\t y=" + bb.y);
		System.out.println();

		System.out.println("\n x�� aa�� x���� bb�� x�� ���� ���ϰ� y������ ���ϱ�");
		PointMain cc = new PointMain(aa, bb); // new�ϸ鼭 �ҷ������Ƿ� ������
		System.out.println("x=" + cc.x + "\t y=" + cc.y);
		System.out.println();

	}

}// class PointMain