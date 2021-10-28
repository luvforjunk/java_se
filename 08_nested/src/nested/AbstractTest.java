package nested;

// POJO - Original class(상속도 뭣도 없는 깔끔한)
public abstract class AbstractTest { // 추상클래스
	String name; // 필드

	public String getName() { // 생성자
		return name;
	}

	public abstract void setName(String name); // 추상메소드
// interface는 추상밖에 안들어가기 때문에 abstract 키워드를 쓸 필요 없음

}

//반드시 추상메소드를 Override 꼭 해줘야 한다
