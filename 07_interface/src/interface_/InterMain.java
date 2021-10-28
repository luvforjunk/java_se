package interface_;

public abstract class InterMain implements InterA, InterB {
	// InterMain은 상속 받은 것처럼 보일 뿐 상속받은 것이 아니다
	public void aa() {} // override(재구현)

	public void bb() {} // override(재구현)
	
	public void cc() {}
	
	public void dd() {}

	public static void main(String[] args) {

	}

}

// -error 
// 1. 재구현
// 2. 추상클래스

// 자바 클래스는 다중상속이 안된다
// 자바 인터페이스는 다중상속이 된다
