package com.apple;

import com.zoo.Zoo;
// 패키지가 다르니 호출해주기 위해 import를 이용해
// com.zoo안에 Zoo가 있다는 걸 알려줌

public class Apple {

	public static void main(String[] args) {
		System.out.println("빨간 사과");

		// 동물원의 호랑이를 호출하시오
		Zoo z = new Zoo();
		z.tiger();
		// z.giraffe();
		// z.elephant();
		// z.lion();

		// lion은 private이기 때문에 호출해 올 수 없다
		// private는 오로지 자신의 클래스에서만
	}

}
