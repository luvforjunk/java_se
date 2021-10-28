package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriteMain {

	public static void main(String[] args) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		// 하나씩 보내지 않고 객체 생성
		PersonDTO dto = new PersonDTO();
		dto.setName("홍길동");
		dto.setAge(25);
		dto.setHeight(185.3);

		oos.writeObject(dto); // dataStream과 달리 write가 딱 한번 들어감
		oos.close();

	}

}

// PersonDTO가 serializable이 걸려 있지 않다고 NotSerializableException 오류가 뜸
// 홍길동은 String타입으로 객체인데 
// String class는 자체적으로 Serializable Comparable<String>을 갖고 있다
// 문자열은 이름은 그냥 간거
