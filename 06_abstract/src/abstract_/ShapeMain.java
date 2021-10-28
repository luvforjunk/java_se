package abstract_;

import java.util.Scanner;

abstract class ShapeTest {
	protected double area;
	protected Scanner scan = new Scanner(System.in);

	public ShapeTest() {
		System.out.println("ShapeTest �⺻ ������");
	}

	// public void calcArea() {
	// area = base*height/2.0;
	// }
	// �޸� Ȯ���� ���� �Ʒ��� ���� �߻�޼ҵ�� �ٲ��ִ� ��
	public abstract void calcArea();

	public abstract void dispArea();

}

//-----------------------------------
class SamTest extends ShapeTest {
	protected int base, height;

	// �����ڸ� ���� �����͸� �޾�
	public SamTest() {
		System.out.println("SamTest �⺻������");
		System.out.print("�غ� : ");
		base = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = base * height / 2.0;
	}

	@Override
	public void dispArea() {
		System.out.println("�ﰢ�� ���� = " + area);
	}
}

//-----------------------------------
class SaTest extends ShapeTest {
	private int width, height;

	public SaTest() {
		System.out.println("SaTest �⺻������");
		System.out.print("���� : ");
		width = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = width * height;
	}

	@Override
	public void dispArea() {
		System.out.println("�簢���� ���� = " + area);
	}
}

//-----------------------------------

class SadariTest extends ShapeTest {
	private int top, bottom, height;

	public SadariTest() {
		System.out.println("SadariTest �⺻������");
		System.out.print("���� : ");
		top = scan.nextInt();
		System.out.print("�غ� : ");
		bottom = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = (top + bottom) * height / 2.0;
	}

	@Override
	public void dispArea() {
		System.out.println("��ٸ��� ���� = " + area);
	}
}

//-----------------------------------
public class ShapeMain {

	public static void main(String[] args) {

		/*
		 * SamTest sam = new SamTest(); //1:1����, ���յ� 100% sam.calcArea();
		 * sam.dispArea(); System.out.println();
		 * 
		 * SaTest sa = new SaTest(); sa.calcArea(); sa.dispArea(); System.out.println();
		 * 
		 * SadariTest sadari = new SadariTest(); sadari.calcArea(); sadari.dispArea();
		 * System.out.println();
		 */

		// ���յ� ���߱�
		ShapeTest shape; // �������� ���Ҹ� �ϰڴ� - �θ� ������ ����
		shape = new SamTest(); // �θ� �ڽ� Ŭ������ �����մϴ�~~ / ������
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SaTest(); // �θ� = �ڽ�, ������
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SadariTest(); // �θ� = �ڽ�, ������
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		// �������� ������ ����� �Ǿ���ϰ� override�����Ǿ� �Ѵ�

		// ������ - String int � Ÿ���� �͵� object�� ���� �� �� �ִ� ��ó��
		// Object [] ar = {new MemberDTO(), new SalaryDTO(), new FruitTest()}
	}
}