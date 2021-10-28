package exception;

public class MakeException extends Exception { // 개발자가 만든 Exception 클래스이다
	private String errorMessage;

	public MakeException() {

	}

	public MakeException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		// return errorMessage; - error메시지만 띄어주던가
		return getClass() + ":" + errorMessage; // - 클래스명까지 띄어주던가
	}
}
// 기본생성자와 에러메시지가 함께 만드는 것이 예외처리의 기본
