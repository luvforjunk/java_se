package inheritance;

import java.util.Scanner;

class ShapeTest {
	protected double area;
	protected Scanner scan = new Scanner(System.in);

	public ShapeTest() {
		System.out.println("ShapeTest 기본 생성자");
	}

	public void calcArea() {
		System.out.println("도형을 계산합니다");
	}

	public void dispArea() {
		System.out.println("도형을 출력합니다");
	}

}

//-----------------------------------
class SamTest extends ShapeTest {
	protected int base, height;

	// 생성자를 통해 데이터를 받아
	public SamTest() {
		System.out.println("SamTest 기본생성자");
		System.out.print("밑변 : ");
		base = scan.nextInt();
		System.out.print("높이 : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = base * height / 2.0;
	}

	@Override
	public void dispArea() {
		System.out.println("삼각형 넓이 = " + area);
	}
}

//-----------------------------------
class SaTest extends ShapeTest{
	private int width, height;
	
	public SaTest() {
	System.out.println("SaTest 기본생성자");
	System.out.print("가로 : ");
	width = scan.nextInt();
	System.out.print("세로 : ");
	height = scan.nextInt();
	}

	@Override 
	public void calcArea() {
		area = width * height;
	}
	@Override 
	public void dispArea() {
		System.out.println("사각형의 넓이 = " + area);
	}
}

//-----------------------------------

class SadariTest extends ShapeTest {
	private int top, bottom, height;
	
	public SadariTest() {
	System.out.println("SadariTest 기본생성자");
	System.out.print("윗변 : ");
	top = scan.nextInt();
	System.out.print("밑변 : ");
	bottom = scan.nextInt();
	System.out.print("높이 : ");
	height = scan.nextInt();
	}
	
	@Override 
	public void calcArea() {
		area = (top + bottom) * height / 2.0;
	}
	@Override 
	public void dispArea() {
		System.out.println("사다리꼴 넓이 = " + area);
	}
}

//-----------------------------------
public class ShapeMain {

	public static void main(String[] args) {
		
		/*
	      SamTest sam = new SamTest(); //1:1관계, 결합도 100%
	      sam.calcArea();
	      sam.dispArea();
	      System.out.println();
	      
	      SaTest sa = new SaTest();
	      sa.calcArea();
	      sa.dispArea();
	      System.out.println();
	            
	      SadariTest sadari = new SadariTest();
	      sadari.calcArea();
	      sadari.dispArea();
	      System.out.println();
	    */
	      
	      
	      //결합도 낮추기
	      ShapeTest shape; // 리모컨의 역할만 하겠다 - 부모가 리모컨 역할
	      shape = new SamTest(); // 부모가 자식 클래스를 참조합니다~~ / 다형성
	      shape.calcArea();
	      shape.dispArea();
	      System.out.println();
	      
	      shape = new SaTest(); //부모 = 자식, 다형성
	      shape.calcArea();
	      shape.dispArea();
	      System.out.println();
	      
	      shape = new SadariTest(); //부모 = 자식, 다형성
	      shape.calcArea();
	      shape.dispArea();
	      System.out.println();
	      
	      //다형성을 쓰려면 상속이 되어야하고 override까지되야 한다
	      
	      //다형성 - String int 어떤 타입이 와도 object가 오면 쓸 수 있는 것처럼
	      //Object [] ar = {new MemberDTO(), new SalaryDTO(), new FruitTest()}
	   			}
		}