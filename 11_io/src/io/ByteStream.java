package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
		int data;

		while ((data = bis.read()) != -1) { // -1이 아닐 때까지 while문을 돌려라
			System.out.print((char) data); // 형변환
		} // while
		bis.close();
	}
}
// 바이트 단위는 파일 안에 있는 내용을 한글자씩 읽어오는 것
// 더이상 읽을 문자가 없으면 null이 아닌 -1을 가져온다