package inheritance;

class AA { //�θ� Ŭ����
	public int a = 3;
	
	public void disp() {
		a += 5;
		System.out.println("AA : " + a + "");
	}
}

//--------------------------
class BB extends AA { //�θ� �����ϴ� �ڽ� Ŭ����
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
		//Override�� �Ǹ� �ڽĲ��� �����ϱ� ������ class BB extends AA�� �Ѿ���� �ȴ�
		aa.disp(); // BB : 13 
		System.out.println("aa : " + aa.a); //aa : 13
		System.out.println();
		
		AA bb = new BB();
		bb.disp(); //BB : 13
		System.out.println("bb : " + bb.a); //bb : 3 (�ʵ�, �� ��������� Override��� ������ ����)
		System.out.println();
		
		AA cc = new AA();
		cc.disp(); //AA : 8
		System.out.println("cc : " + cc.a); //cc : 8
		System.out.println();
		
		//�ڽ� = (�ڽ�)�θ� - Casting(����ȯ) / �θ� �ڽĿ��� �ٿ�ȴ�
		//Ŭ������ �ڷ����̱� ������ ����ȯ�� �����ϴ�
		BB dd = (BB)bb; 
		dd.disp(); //BB : 18
		System.out.println("dd : " + dd.a); //dd : 18
		System.out.println();
	}

}
