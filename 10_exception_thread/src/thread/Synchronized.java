package thread;

public class Synchronized extends Thread {
	private static int count;
	
	public Synchronized() {
		System.out.println("this = " + this);
		// aa,bb,cc�� �ּҰ��� �� �ٸ���. this�� �� �ٸ�
	}

	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // ������ ����
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();

		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");

		aa.start(); // ������ ����
		bb.start(); // ������ ����
		cc.start(); // ������ ����
	}

	@Override
	// public synchronized void run() { --- ����ȭ X
	public void run() {

		// Synchronized (this) { - ����ȭ X, �ּҰ��� �� �ٸ��� ����
		synchronized (Synchronized.class) { // ������ Ŭ���� ����
			for (int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + " : count=" + count);
				// ��� - aa : count=10 / cc : count=10....����ȭ�� �ȵǾ� �ֱ� ������ ���� ����
				// �׷� �޼ҵ忡 synchronized �־��ָ� �ɱ�??
				// public synchronized void run() { �� ����ȭ ó���� ���� �ʾҴ�
				// ATM�� ATMTest�ϳ��� ����� ������ �Ƶ��� ���� �� �� �ִ� �ݸ�
				// Synchronized�� ���� ���ε��� ������� ����ȭ���� �ʾҴ� ��!!!
				// �׷��� aa, bb, cc ��� �������� ���� �ִ� �� ������ �ϴµ�
				// �� ���� Ŭ���� ������ ��� �����ϴ� Ŭ���� ���Ϸ� ����ش�

			}
		}
	}
}
