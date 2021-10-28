package interface_;

public interface InterA {
	public static final String NAME = "홍길동"; // 오로지 상수만 들어갈 수 있음
	// public static final 생략 가능
	int AGE = 25;

	public abstract void aa(); // 추상메소드

	public void bb(); // 키워드를 빼버려도 괜찮다
}

// Interface 저장 시 java파일, class파일 모두 저장 됨
