package exception;

public class MakeException extends Exception { // �����ڰ� ���� Exception Ŭ�����̴�
	private String errorMessage;

	public MakeException() {

	}

	public MakeException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		// return errorMessage; - error�޽����� ����ִ���
		return getClass() + ":" + errorMessage; // - Ŭ���������� ����ִ���
	}
}
// �⺻�����ڿ� �����޽����� �Բ� ����� ���� ����ó���� �⺻