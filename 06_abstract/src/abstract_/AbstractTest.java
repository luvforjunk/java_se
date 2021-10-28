package abstract_;

//POJO형식 (Plain Old  Java Object)
public abstract class AbstractTest {
	String name;

	public String getName() {
		return name;
	}

	// public void setName(String name){
	// this.name = name;
	// 위 두문장을 추상메소드로 만들기 위해선 구현부를 만들어 놓지 않고 세미콜론을 찍는다
	public abstract void setName(String name); // 추상메소드
	// 추상메소드를 만드려면 클래스 역시 추상클래스여야 한다
	// 추상클래스는 절대 뉴를 쓸 수 없다
	// 1. 자식클래스를 이용한다
	// 2. 메소드를 이용한다
	// 3. 익명 이너클래스를 이용한다
}