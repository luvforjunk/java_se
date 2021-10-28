package class_;

import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		String str = "학원, 집,,게임방";

		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("토큰 개수 = " + st.countTokens()); // 3개 - "학원", "집", "게임방"

		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		} // while
		System.out.println("--------------------");

		String[] ar = str.split(",");
		for (String data : ar) {
			System.out.println(data);
		}
	}
}

/*
 StringTokenizer 		String-split() 
 "학원" 					"학원" 
 "집" 					"집" 
 "게임방" 				"" 
 						"게임방"
 */

//배열.length - 명령어
//문자열.length() - 메소드

//hasMoreTokens() - 현재 위치에 토큰이 있으면(T), 없으면(F)
//nextToken() - 토큰을 꺼내고 다음 위치로 이동