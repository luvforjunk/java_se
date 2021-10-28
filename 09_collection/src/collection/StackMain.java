package collection;

import java.util.Stack;
import static java.lang.System.out;

public class StackMain { // 들어간 순서의 반대로

	public static void main(String[] args) {
		String[] groupA = { "우즈베키스탄", "쿠웨이트", "사우디", "대한민국" };
		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < groupA.length; i++)
			stack.push(groupA[i]);

		while (!stack.isEmpty()) // 현재 스텍이 비어있습니까? 아니요 - False. 그거에 반대(!) -> true
			out.println(stack.pop()); // 조건이 맞으니까 꺼내라
	}

}
