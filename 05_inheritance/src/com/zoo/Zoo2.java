package com.zoo; // 같은 패키지에 있으면 다 접근이 가능함

// private은 제외
public class Zoo2 {

	public static void main(String[] args) {
		Zoo z = new Zoo();
		z.tiger();
		z.giraffe();
		z.elephant();
		// z.lion();

	}

}
