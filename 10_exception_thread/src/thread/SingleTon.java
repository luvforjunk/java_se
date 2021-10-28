package thread;

public class SingleTon {
	private int num = 3;
	private static SingleTon instance = null; // �ʱ�ȭ �� �ѹ�

	public static SingleTon getInstance() { // �ڷ��� : SingleTon
		if (instance == null) { // instance�� null�� ���� �� �ѹ�
			synchronized(SingleTon.class) { // �Ѳ����� ���� ���� �ϳ���
			instance = new SingleTon(); // ó�� �� �ѹ��� �����ϰ� �� �������� ���Ѵ�
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa); // Ŭ@16����.
		System.out.println("num = " + aa.num); // 4
		System.out.println();

		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = " + bb); // Ŭ@16����
		System.out.println("num = " + bb.num);
		System.out.println();

		System.out.println("--- �̱��� ---"); // �޸𸮿� �� �ѹ��� ��ڴ�. �ּҰ� ���� ����

		SingleTon cc = SingleTon.getInstance();
		cc.num++;
		System.out.println("cc = " + cc); // Ŭ@16����
		System.out.println("num = " + cc.num); // 4
		System.out.println();

		SingleTon dd = SingleTon.getInstance();
		dd.num++;
		System.out.println("dd = " + dd); // Ŭ@16����
		System.out.println("num = " + dd.num); // 5
		System.out.println();
	}
}

// SingleTon cc = new SingleTon();.....(x)
// SingleTon cc = SingleTon.getInstance() - �޼ҵ� �̿�. static�̴ϱ� Ŭ���������� ���̷�Ʈ�ϰ� ��

// new�� �����ָ� heap�޸𸮸� �����ϰ�, ������ �޸𸮿� new�Ѹ�ŭ �����
