package inheritance;

class AA { //부모 클래스
	public int a = 3;
	
	public void disp() {
		a += 5;
		System.out.println("AA : " + a + "");
	}
}

//--------------------------
class BB extends AA { //부모 참조하는 자식 클래스
	public int a = 8;
	
	public void disp () {
		this.a += 5; //this.a = this.a + 5
		System.out.println("BB : " + a + "");
	}
}

//---------------------------------
public class TestMain2 {

	public static void main(String[] args) {
		BB aa = new BB();
		//Override가 되면 자식꺼를 수행하기 때문에 class BB extends AA로 넘어오게 된다
		aa.disp(); // BB : 13 
		System.out.println("aa : " + aa.a); //aa : 13
		System.out.println();
		
		AA bb = new BB();
		bb.disp(); //BB : 13
		System.out.println("bb : " + bb.a); //bb : 3 (필드, 즉 멤버변수는 Override라는 개념이 없다)
		System.out.println();
		
		AA cc = new AA();
		cc.disp(); //AA : 8
		System.out.println("cc : " + cc.a); //cc : 8
		System.out.println();
		
		//자식 = (자식)부모 - Casting(형변환) / 부모가 자식에게 다운된다
		//클래스도 자료형이기 때문에 형변환이 가능하다
		BB dd = (BB)bb; 
		dd.disp(); //BB : 18
		System.out.println("dd : " + dd.a); //dd : 18
		System.out.println();
	}

}
