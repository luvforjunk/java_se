package nested;

public class AbstractMain {

	public static void main(String[] args) {
		// AbstractTest at = new AbstractTest(); - error
		// �߻� Ŭ������ �������� new�� �������� �ʴ�
		// �ڽ�Ŭ������ �̿��Ͽ� �����ϸ� �� or �޼ҵ� �̿�

		AbstractTest at = new AbstractTest() { // �͸� Inner Class
			@Override
			public void setName(String name) { // ����
				// �޼ҵ��� �����θ� ������ �� �ִ� �� Ŭ���� ��

			}
		}; // �͸� Inner Class
		InterA in = new InterA() { // �͸� Inner Class�� �� ������
			@Override
			public void aa() {
			}

			@Override
			public void bb() {
			}
		}; // ������ implements�� ���ٰ� ����� ���ذ�
		AbstractExam ae = new AbstractExam() {
			// Override �ص� �ǰ� ���ص� �ǰ�~
		};
	}
}

//AbstractMain.java
//AbstractMain.class
//AbstractMain$1.class