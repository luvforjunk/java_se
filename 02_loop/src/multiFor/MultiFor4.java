/*
[����] MultiFor4.java
2�� ~9�ܱ��� 3���� ��� ����Ͻÿ�
��, 3�� for ����ϼ��� (if)

[������]

2*1=2   3*1=3   4*1=4   

5*1=5   6*1=6   7*1=7   

8*1=8   9*1=9
 */

package multiFor;

public class MultiFor4 {

	public static void main(String[] args) {
		int dan, i;

		for (int x = 2; x <= 8; x += 3) {// 3�� w=1, w=2, w=3 -> w=2, w=5, w=8
			for (i = 1; i <= 9; i++) {
				for (dan = x; dan <= x + 2; dan++) {
					if (dan != 10)// 10�� �ƴ� �͵鸸 ������
						System.out.print(dan + "*" + i + "=" + dan * i + "\t");
				} // for dan
				System.out.println();
			} // for i
			System.out.println();
		} // for w
	}
}