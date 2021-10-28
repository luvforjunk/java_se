package thread;

class JoinTest implements Runnable {
// interface를 가졌다는 건 스레드가 되고 싶은 거지 스레드를 생성한 게 아니다
// ex) 청진기 가지고 있다해서 의사인 게 아닌 것처럼
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("i = " + i);
		}
	}
}

//-------------------------------------
public class JoinMain {

	public static void main(String[] args) {
		JoinTest jt = new JoinTest(); // 스레드 생성한 거? ...아니야!
		Thread t = new Thread(jt); // jt(JoinTest)를 스레드로 생성

		System.out.println("스레드 시작");
		t.start(); // 스레드 시작 - 스레드 실행(run())
		try {
			t.join(); // 스레드가 끝날 때까지는 마무리를 못함(절차식)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("스레드 종료"); // 스레드가 끝나고 나서야 입력됨
	}
	// 메인이 끝나도 스레드는 종료되지 않는다
	// 메인이 종료되어도 백그라운드에서 스레드는 돌아간다.
	// ex) 이영자씨가 뱃살을 흔드는 걸 멈춰도 뱃살은 출렁인다
}

