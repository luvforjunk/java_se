package thread;

class SnackTest extends Thread {
	private String str;

	public SnackTest(String str) {
		super();
		this.str = str;
	}

	public void run() { // thread�� �ƴϱ� ������ �ݹ�޼ҵ尡 �ƴ�
		for (int i = 1; i <= 5; i++) {
			System.out.println(str + "\t" + "i = " + i + Thread.currentThread());
			// * currentThread : ���� ���� ����(���� �԰� �ִ�) �����尡 �����̳�
		} // for
	}
}

//-----------------------------
public class SnackMain {

	public static void main(String[] args) {
		SnackTest aa = new SnackTest("�����"); // Thread ����
		SnackTest bb = new SnackTest("��īĨ"); // Thread ����
		SnackTest cc = new SnackTest("Ȩ����"); // Thread ����

		// �����忡 �̸� �ο�
		aa.setName("�����");
		bb.setName("��īĨ");
		cc.setName("Ȩ����");

		// �켱���� - 1 ~ 10 (default : 5)
		//aa.setPriority(10);
		// = aa.setPriority(Thread.MAX_PRIORITY);
		//bb.setPriority(1);
		// = bb.setPriority(Thread.MIN_PRIORITY);
		//cc.setPriority(5);
		// = cc.setPriority(Thread.NORM_PRIORITY);

		aa.start(); // ������ ���� -> ������ ����(run())
		try {
			aa.join(); // ������ ���̱�
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		bb.start(); // ������ ���� -> ������ ����(run())
		cc.start(); // ������ ���� -> ������ ����(run())
		
		//aa�� ���������� bb�� cc�� block����
	}
}
