package inheritance;

class AAA {
}

class BBB extends AAA {
} // AAA클래스를 물려받은 BBB
//----------------------

public class InstanceOf {

	public static void main(String[] args) {
		AAA aa = new AAA();
		BBB bb = new BBB();
		AAA aa2 = new BBB();

		AAA aa3 = aa;
		if (aa instanceof AAA)
			System.out.println("1. TRUE"); // aa를 AAA에 보낼 수 있느냐
		else
			System.out.println("1. FALSE");
		// aa의 주소값을 aa3에게 넘겨주겠다. 같은 클래스 타입이니까 aa3는 aa의 주소값을 쉽게 받을 수 있고, 주소값을 받은 aa3는
		// AAA를 가리키게 된다.
		// aa를 오른쪽 AAA로 넘길 수 있다 = aa의 참조값을 따라갔더니 메모리에 AAA클래스가 잡혀있다

		AAA aa4 = bb;
		if (bb instanceof AAA)
			System.out.println("1. TRUE"); // aa를 AAA에 보낼 수 있느냐
		else
			System.out.println("1. FALSE");

		BBB bb2 = (BBB) aa2;
		// aa2는 AAA도 BBB도 갖고 있으니 언제든지 캐스팅이 가능함
		// DownCasting해줘야
		if (aa2 instanceof BBB)
			System.out.println("1. TRUE");
		else
			System.out.println("1. FALSE");

		// BBB bb3 = (BBB)aa; - error
		// aa는 AAA안에 혼자 살아서 BBB에 캐스팅할 수 없다
		if (aa instanceof BBB)
			System.out.println("1. TRUE");
		else
			System.out.println("1. FALSE");

		// *aa도 AAA를 가리키고 aa2도 AAA를 가리키는 건 맞지만
		// aa와 달리 aa2는 AAA와 BBB 모두 공유 가능하다
	}

}
