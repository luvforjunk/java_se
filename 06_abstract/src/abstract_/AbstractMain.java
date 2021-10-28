package abstract_;

public class AbstractMain extends AbstractTest {
	// 추상클래스로 만들기 위해 자식 클래스를 데려왔으면
	// 반드시 자식클래스를 구현(Override)시켜줘야 한다
	@Override
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		// AbstractTest at = new AbstractTest(); //추상클래스라
		AbstractTest at = new AbstractMain(); // 부모 = 자식
		at.setName("홍길동");
		System.out.println(at.getName());

	}

}