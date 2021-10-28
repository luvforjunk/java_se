package com.zoo;

public class Zoo {
	public void tiger() {
		System.out.println("무서운 호랑이");
	}

	protected void giraffe() {
		System.out.println("목이 긴 기린");
	}

	void elephant() {
		System.out.println("뚱뚱한 코끼리");
	}

	private void lion() {
		System.out.println("멋진 사자");
	}
}
// main이 없으면 class를 실행할 수 없다는 의미
// elephant 앞에 아무것도 안써있는 건 default를 의미