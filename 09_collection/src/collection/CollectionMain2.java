package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionMain2 {

	public static void main(String[] args) {
		// Collection<String> coll = new ArrayList<String>(); // 2. 사탕 사주기 - 자연스럽게 울음
		// 멈추게 하는
		ArrayList<String> list = new ArrayList<String>();
		list.add("호랑이");
		list.add("사자");
		list.add("호랑이"); // 중복 허용, 순서
		// list.add(25);
		// list.add(43.8);
		list.add("기린");
		list.add("코끼리");

		Iterator it = list.iterator(); // 생성
		while (it.hasNext()) {
			System.out.println(it.next());
		} // while
		System.out.println("------------------");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		} // for
		System.out.println("------------------"); // 제일 자주 쓰이는
		for (String data : list) {
			System.out.println(data);
		} // for
	}

}