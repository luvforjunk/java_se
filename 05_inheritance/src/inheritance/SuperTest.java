package inheritance;

//부모보다 자식이 더 크다
//부모가 하나인걸 단일상속이라 한다
//interface는 자바의 다중 상속을 해결하기 위해 존재 - interface는 상속이 아님
//부모가 private을 걸어버리면 자식은 쓸 수 없다. 생성자 역시 마찬가지이다.
//클래스를 열 때 캡슐화라 해서 public을 쓸 수 없고 protected를 써서 부모 자신과 자식 클래스에게만 접근을 허가한다.
//작은 순 - private < protected < public 

public class SuperTest {
	protected double weight, height;
	// protected라 외부에서는 데이터를 가져올 수 없다
	// 따라서 setter을 통해 데이터를 받아오거나 생성자를 사용한다.

	public SuperTest() { //기본생성자 부르기 Ctrl + spacebar
		System.out.println("SuperTest 클래스 기본생성자");

	}

	// 2개의 매개변수(인수)를 갖는 생성자
	public SuperTest(double w, double h) { // 같은 더블형일지라도 개별 선언해줘야한다. double w,h (X)
		System.out.println("SuperTest 클래스 생성자");
		this.weight = w;
		this.height = h;
	}

	public void disp() {
		System.out.println("SuperTest 클래스 disp()");
		System.out.println("몸무게 =" + weight);
		System.out.println("키 =" + height);
	}

}
