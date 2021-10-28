package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	public static void main(String[] args) throws FileNotFoundException, IOException { // 부모인 IOException만 써줘도 됨
		// 데이터를 파일에 집어넣는 방법
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		dos.writeUTF("홍길동"); // 한글처리를 UTF파일 형식으로 내보낼거다~
		dos.writeInt(25); // 나이니까 정수형
		dos.writeFloat(185.3f);
		// dos.writeFloat(185.3); 라고 썼을 때 error가 뜨는 이유는 Double형인데 Float로 받아서이다
		// Double로 바꾸지 않고 Float형으로 가려면 뒤에 f를 써주면 된당! 간단쓰~~
		dos.close();

		// 파일 안에서 데이터를 꺼내오는 방법
		DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
		System.out.println("이름 = " + dis.readUTF());
		System.out.println("나이 = " + dis.readInt());
		System.out.println("키 = " + dis.readFloat());
		dis.close();
	}
}

// BufferedOutputStream은 단점이 메소드가 몇개 안된다. 정수형 혹은 byte.
// 따라서 문자열 혹은 실수형 나가기가 너무 불편하니까 DataOutputStream을 써준다
// File로 나가려고 쓰는 것이 FileOutputStream

