package collection;

import java.util.LinkedList;
import static java.lang.System.out;

public class QueueMain {

	public static void main(String[] args) {
		String[] item = { "소나타", "렉스톤", "제규어" };
		LinkedList<String> q = new LinkedList<String>();

		for (String n : item) // 중괄호를 안쳤다는 건 반복되는 건 그 다음 문장까지
			q.offer(n); // 요소 추가

		out.println("q의 크기 : " + q.size() + "\n");

		String data = "";

		while ((data = q.poll()) != null) { // 소나타는 널값이 아니다?
			out.println(data + " 삭제!"); // 널값이 아니라는 조건이 맞으니 내려와서 소나타 찍고
			out.println("q의 크기 : " + q.size() + "\n"); // 사이즈는 두개 남았다
		}

	}

}
