/*
������ ���� ���α׷�

[������]
**************
1. ����      
2. ����      
3. ����Ʈ      
4. ����
**************
�޴� : 8
1~4���� �Է��ϼ���.

(4���� �Է��� ���) ���α׷��� �����մϴ�.

1���� ���
��ġ �Է� : 3
3��ġ�� ���� / �̹� �����Ǿ��ֽ��ϴ�

2���� ���
��ġ �Է� : 4
4��ġ�� ���� / �����Ǿ� ���� �ʽ��ϴ�

3���� ���
1��ġ : false
2��ġ : false
3��ġ : false
4��ġ : false
5��ġ : false
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num; 
		boolean[] ar = new boolean[5];
		//int�� 0, boolean���� �ʱⰪ���� false�� ���´�.
		int index; //��ġ�� �� ���� �־����.

		while(true) {
			System.out.println("**************");
			System.out.println("1. ���� ");
			System.out.println("2. ���� ");
			System.out.println("3. ����Ʈ");
			System.out.println("4. ����");
			System.out.println("**************");
			System.out.print("�޴� : ");
			num = Integer.parseInt(br.readLine());
			if (num == 4) break;

			if (num == 1) {
				System.out.print("��ġ �Է� :");
				index = Integer.parseInt(br.readLine());
				
				//if(ar[index-1] == true) ar[index-1]��ü�� boolean��, true/false�� �ٷ�� ������ ���� �ڿ� �Ƚ��൵ ��.
				if(ar[index-1])//ar[index]��� ������� ��ǻ��� �ν�. ����� �� �� �ְ�.
					System.out.println("�̹� �����Ǿ� �ֽ��ϴ�.");
				else {
					System.out.println(index + "��ġ�� ����");
					ar[index-1] = true;
				}
			}
			else if (num == 2) {
				System.out.print("��ġ �Է� :");
				index = Integer.parseInt(br.readLine());
				
				if(ar[index-1]) {
					System.out.println(index +"��ġ�� ����");
					ar[index-1] = false;
				}else {
					System.out.println("�����Ǿ� ���� �ʽ��ϴ�.");
				}
			}
			else if (num == 3) {
				for(int i=0; i<ar.length; i++) {
					System.out.println((i+1) + "��ġ" + ar[i]);
				}//for
			}else System.out.println("1~4���� �Է��ϼ���.");

		} // while
		System.out.println("���α׷��� �����մϴ�.");
	}
}
