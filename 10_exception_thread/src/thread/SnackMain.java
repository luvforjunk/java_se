package thread;

class SnackTest extends Thread {
	private String str;

	public SnackTest(String str) {
		super();
		this.str = str;
	}

	public void run() { // thread가 아니기 때문에 콜백메소드가 아님
		for (int i = 1; i <= 5; i++) {
			System.out.println(str + "\t" + "i = " + i + Thread.currentThread());
			// * currentThread : 현재 실행 중인(지금 먹고 있는) 스레드가 무엇이냐
		} // for
	}
}

//-----------------------------
public class SnackMain {

	public static void main(String[] args) {
		SnackTest aa = new SnackTest("새우깡"); // Thread 생성
		SnackTest bb = new SnackTest("포카칩"); // Thread 생성
		SnackTest cc = new SnackTest("홈런볼"); // Thread 생성

		// 스레드에 이름 부여
		aa.setName("새우깡");
		bb.setName("포카칩");
		cc.setName("홈런볼");

		// 우선순위 - 1 ~ 10 (default : 5)
		//aa.setPriority(10);
		// = aa.setPriority(Thread.MAX_PRIORITY);
		//bb.setPriority(1);
		// = bb.setPriority(Thread.MIN_PRIORITY);
		//cc.setPriority(5);
		// = cc.setPriority(Thread.NORM_PRIORITY);

		aa.start(); // 스레드 시작 -> 스레드 실행(run())
		try {
			aa.join(); // 스레드 죽이기
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		bb.start(); // 스레드 시작 -> 스레드 실행(run())
		cc.start(); // 스레드 시작 -> 스레드 실행(run())
		
		//aa가 끝날때까지 bb와 cc는 block상태
	}
}
