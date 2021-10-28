package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReadMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));

		PersonDTO dto = (PersonDTO) ois.readObject();
		// 자식 = (자식)부모. DTO 로 담겨 있는데 꺼내오는 건 Object를 꺼내오자고 하니
		// Casting을 안걸어줘서 에러가 뜨는데,

		System.out.println("이름 = " + dto.getName());
		System.out.println("나이 = " + dto.getAge());
		System.out.println("키 = " + dto.getHeight());
		ois.close();
	}
}
