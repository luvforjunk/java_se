package thread;

public class Synchronized extends Thread {
	private static int count;
	
	public Synchronized() {
		System.out.println("this = " + this);
		// aa,bb,cc의 주소값이 다 다르다. this가 다 다름
	}

	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // 스레드 생성
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();

		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");

		aa.start(); // 스레드 시작
		bb.start(); // 스레드 시작
		cc.start(); // 스레드 시작
	}

	@Override
	// public synchronized void run() { --- 동기화 X
	public void run() {

		// Synchronized (this) { - 동기화 X, 주소값이 다 다르기 때문
		synchronized (Synchronized.class) { // 공통의 클래스 파일
			for (int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + " : count=" + count);
				// 결과 - aa : count=10 / cc : count=10....동기화가 안되어 있기 때문에 동시 접근
				// 그럼 메소드에 synchronized 넣어주면 될까??
				// public synchronized void run() { 는 동기화 처리가 되지 않았다
				// ATM은 ATMTest하나만 만들어 엄마와 아들이 같이 쓸 수 있는 반면
				// Synchronized는 각자 따로따로 만들어져 동기화되지 않았던 것!!!
				// 그렇담 aa, bb, cc 모두 공통으로 갖고 있는 걸 잡아줘야 하는데
				// 이 셋의 클래스 파일이 모두 동일하니 클래스 파일로 잡아준다

			}
		}
	}
}
