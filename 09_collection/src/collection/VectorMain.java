package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(); // 기본용량 10개, 10개씩 증가
		System.out.println("벡터 크기 = " + v.size()); // 0 - 항목개수
		System.out.println("벡터 용량 = " + v.capacity()); // 10 - 벡터크기
		System.out.println();

		System.out.println("----항목 추가----");
		for (int i = 1; i <= 10; i++) {
			v.add(i + "");
		}

		v.add("5"); // collection의 일종이기 때문에 중복을 허용한다, 순서 O
		// = v.element("5");
		System.out.println("벡터 크기 = " + v.size()); // 10 -> 11
		System.out.println("벡터 용량 = " + v.capacity()); // 10 -> 20
		System.out.println();

		for (int i = 0; i < v.size(); i++) {
			System.out.print(v.get(i) + " "); // 1 2 3 4 5 6 7 8 9 10 5
		}
		System.out.println();

		System.out.println("----항목 삭제----");
		v.remove("5"); // 앞에 있는 "5"를 삭제
		v.removeElementAt(9); // 뒤에 있는 "5"를 삭제***
		// ex) "orange".charAt(2) ---> a

		Iterator<String> it = v.iterator(); // 생성
		while (it.hasNext()) {
			System.out.print(it.next() + " "); // 1 2 3 4 6 7 8 9 10
		}
		System.out.println();

		Vector<String> v2 = new Vector<String>(5); // 기본용량 5개, 2개씩 증가
	}

}

// 노란색 밑줄이 뜨는 이유는 generic을 걸어주라는 의미
// <String>을 달아준다
