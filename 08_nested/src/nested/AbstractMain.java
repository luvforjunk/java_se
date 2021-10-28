package nested;

public class AbstractMain {

	public static void main(String[] args) {
		// AbstractTest at = new AbstractTest(); - error
		// 추상 클래스는 직접적인 new가 가능하지 않다
		// 자식클래스를 이용하여 생성하면 됨 or 메소드 이용

		AbstractTest at = new AbstractTest() { // 익명 Inner Class
			@Override
			public void setName(String name) { // 구현
				// 메소드의 구현부를 차지할 수 있는 건 클래스 뿐

			}
		}; // 익명 Inner Class
		InterA in = new InterA() { // 익명 Inner Class를 뉴 시켜준
			@Override
			public void aa() {
			}

			@Override
			public void bb() {
			}
		}; // 위에다 implements를 해줄거 여기다 해준거
		AbstractExam ae = new AbstractExam() {
			// Override 해도 되고 안해도 되고~
		};
	}
}

//AbstractMain.java
//AbstractMain.class
//AbstractMain$1.class