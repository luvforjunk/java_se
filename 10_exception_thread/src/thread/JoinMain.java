package thread;

class JoinTest implements Runnable {
// interface�� �����ٴ� �� �����尡 �ǰ� ���� ���� �����带 ������ �� �ƴϴ�
// ex) û���� ������ �ִ��ؼ� �ǻ��� �� �ƴ� ��ó��
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
		JoinTest jt = new JoinTest(); // ������ ������ ��? ...�ƴϾ�!
		Thread t = new Thread(jt); // jt(JoinTest)�� ������� ����

		System.out.println("������ ����");
		t.start(); // ������ ���� - ������ ����(run())
		try {
			t.join(); // �����尡 ���� �������� �������� ����(������)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������ ����"); // �����尡 ������ ������ �Էµ�
	}
	// ������ ������ ������� ������� �ʴ´�
	// ������ ����Ǿ ��׶��忡�� ������� ���ư���.
	// ex) �̿��ھ��� ����� ���� �� ���絵 ����� �ⷷ�δ�
}

