package collection;

import java.util.ArrayList; // 배열로 취급 - index값 형성
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {

	// @SuppressWarnings("all")
	@SuppressWarnings({ "rawtypes", "unchecked" }) // - 1.팬다 억지로 안울게 하는 방법
	public static void main(String[] args) {
		Collection coll = new ArrayList(); // Array는 Collection의 값을 오버라이딩 해주고 있음
		//ArrayList list = new ArrayList(); 추상클래스가 아니니 다 처리할 수 있음

		coll.add("호랑이");
		coll.add("사자");
		coll.add("호랑이"); // 중복 허용, 순서
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");

		Iterator it = coll.iterator(); // 생성
		while (it.hasNext()) { // 현재 위치에 항목이 있으면 True
			System.out.println(it.next()); // 꺼내주고 다음! 꺼내주고 다음!
		} // while
	}
}

// 배열은 확실하게 데이터가 잡혔을 때
// 그렇지 않은 경우엔 Collection
// 객체를 담아주는 저장소 역할을 하면서 언제든 크기 변환이 가능하다
