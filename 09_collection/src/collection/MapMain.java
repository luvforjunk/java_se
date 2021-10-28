package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(); // <Key, Value>
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "백설공주"); // Value 중복허용
		map.put("book301", "피오나");
		map.put("book101", "엄지공주"); // Key 중복허용

		// 값 꺼내오기
		System.out.println(map.get("book102")); // 백설공주
		System.out.println(map.get("book103")); // null
		System.out.println(map.get("book101")); // 엄지공주
		
		//map은 항상 키로 관리한다. 키값만 넣어주면 결과값을 꺼내준다
	}
}
