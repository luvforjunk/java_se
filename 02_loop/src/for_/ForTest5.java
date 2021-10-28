/*
 시작값 입력 : 5
 끝값 입력 : 20
 5~20까지의 합 = xx
 */

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start, end; // 값이 고정된 것이 아니기 때문에 변수명을 입력한거.
		int sum = 0;
		int count = 0;

		System.out.print("시작값 입력 : ");
		start = Integer.parseInt(br.readLine());
		System.out.print("끝값 입력 : ");
		end = Integer.parseInt(br.readLine());

		for (int i = start; i <= end; i++) {
			sum += i;
			System.out.print(i + "  ");
			count++; // 개수 1 2 3 4 5 6 7 ...
			if (count % 5 == 0)
				System.out.println();

		} // for

		System.out.println();
		System.out.println(start + " ~ " + end + "까지의 합 = " + sum);
	}
}
