package io;

import java.io.Serializable;

public class PersonDTO implements Serializable {
	// Serializable�� interface�ε� �߻�޼ҵ尡 1�� ����
	// �׷��� �� �ѹ��� ���ָ� �ȴ�
	private String name;
	private int age;
	private double height;

// private�̶� �ܺο��� ������ ���ϴ� setter, getter ����ֱ�
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

// Serializable�� �׸���� ������ ���·� ���� �ִ� �� 
//Serializable�� �־��ָ� �ȴ�