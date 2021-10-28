package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {

	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");
		int size = (int) file.length(); // 파일 크기 - 타입의 크기 맞지 않으니 int로 변환

		byte[] b = new byte[size]; // 배열 생성

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		bis.read(b, 0, size); // byte를 쥐고 있는 b, 0번부터 읽어라, 배열의 사이즈만큼 읽어라

		// 배열을 돌리기 위해 for문을 쓰지만
		// 간단하게 해주자~~ byte형태로 들어온 배열을 문자열로 변환해서 찍어라
		System.out.println(new String(b)); // byte[] -> String 변환
		bis.close(); // 습관적으로 써줘라 꼭지 틀어서 물을 내보냈으면 다시 잠궈야 하니까
	}
}

// ByteStream을 한글자씩 말고 통으로 읽어오려면....?
// 한꺼번에 읽어서 배열로 보관
// 몇 글자씩 갖고 있는지 몰라 그럼 배열을 잡을 수가 없잖아?
// 그럼 파일의 크기를 알아야겠지
// 근데 중요한건 내가 알고 있는 건 파일이 아닌 파일의 이름만 알고 있다 그럼 파일의 크기를 모르는거지
// 파일로 생성해주자! File file = new File("data.txt");
