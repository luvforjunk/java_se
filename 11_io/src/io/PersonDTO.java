package io;

import java.io.Serializable;

public class PersonDTO implements Serializable {
	// Serializable은 interface인데 추상메소드가 1도 없다
	// 그래서 딱 한번만 써주면 된다
	private String name;
	private int age;
	private double height;

// private이라 외부에서 접근을 못하니 setter, getter 잡아주기
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}

// Serializable은 항목들을 묶어준 형태로 갖고 있는 것 
//Serializable만 넣어주면 된당