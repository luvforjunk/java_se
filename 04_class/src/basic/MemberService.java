/* [����]
MemberService.java (�Է� �� ��� ��)

Ŭ���� ȸ������ ���α׷� �ۼ��Ϸ��� �Ѵ�.
����� ������� �������� ȸ���� �� 5������ �Ѵ�.
ȸ���� ������ �̸�, ����, �ڵ���, �ּҷ� �����Ѵ�.
ȸ�� ����, ���, ����, Ż�� ���α׷��� �ۼ��Ͻÿ�.

menu()
*************
   1. ����
   2. ���
   3. ����
   4. Ż��
   5. ������
*************
  ��ȣ : 

insertMember()
�̸� �Է� : 
�̸� �Է� :    
�ڵ��� �Է� : 
�ּ� �Է� : 
��� �Ϸ�..4�ڸ� ���ҽ��ϴ�   

list()
�̸�      ����      �ڵ���      �ּ�
�� 5���߿��� ��ϵ� ȸ���� �����ش�

updateMember()
�ڵ��� ��ȣ �Է� : 010-123-1234
ã���� �ϴ� ȸ���� �����ϴ�

-------------------------------
�ڵ��� ��ȣ �Է� : 010-123-1234

�̸�      ����      �ڵ���         �ּ�
ȫ�浿      25      010-123-1234      ����

�̸� �Է� : 
�̸� �Է� :    
�ڵ��� �Է� : 
�ּ� �Է� :

���� �Ϸ�

deleteMember()
�ڵ��� ��ȣ �Է� : 010-123-1234
ã���� �ϴ� ȸ���� �����ϴ�

-------------------------------
�ڵ��� ��ȣ �Է� : 010-123-1234

���� �Ϸ�
*/

package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberService {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	MemberDTO[] ar = new MemberDTO[5]; // ar�� �� Ŭ���� �ȿ� �ִ� ��� �ֵ��� �� �� �ִ�.

	public void menu() throws IOException { // ����
		int num;

		while (true) {
			System.out.println();
			System.out.println("********************");
			System.out.println("     1. ����");
			System.out.println("     2. ���");
			System.out.println("     3. ����");
			System.out.println("     4. Ż��");
			System.out.println("     5. ������");
			System.out.println("********************");
			System.out.print("     ��ȣ : ");
			num = Integer.parseInt(br.readLine());
			if (num == 5)
				break;

			if (num == 1)
				insertMember(); // �޴����� ��۹�� ���� ������ insert�� ������ ���ڸ��� ����
			else if (num == 2)
				list();
			else if (num == 3)
				updateMember();
			else if (num == 4)
				deleteMember();
		} // while
	}

	public void deleteMember() throws IOException {
		System.out.print("�ڵ��� ��ȣ �Է� : ");
		String phone = br.readLine();

		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				if (ar[i].getPhone().equals(phone))
					break;
			} // if
		} // for

		if (i == ar.length) {
			System.out.println("ã���� �ϴ� ȸ���� �����ϴ�");

		} else {
			ar[i] = null;
			System.out.println("Ż�� �Ϸ�...");
		}
	}

	public void updateMember() throws IOException { // ����
		System.out.print("�ڵ��� ��ȣ �Է� : ");
		String phone = br.readLine();

		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				if (ar[i].getPhone().equals(phone))
					break;
			} // if
		} // for

		if (i == ar.length) {
			System.out.println("ã���� �ϴ� ȸ���� �����ϴ�");
			return;
		}

		System.out
				.println(ar[i].getName() + "\t" + ar[i].getAge() + "\t" + ar[i].getPhone() + "\t" + ar[i].getAddress());

		System.out.print("�̸� �Է� : ");
		ar[i].setName(br.readLine());
		System.out.print("���� �Է� : ");
		ar[i].setAge(Integer.parseInt(br.readLine()));
		System.out.print("�ڵ��� �Է� : ");
		ar[i].setPhone(br.readLine());
		System.out.print("�ּ� �Է� : ");
		ar[i].setAddress(br.readLine());

		System.out.println();
		System.out.println("���� �Ϸ�...");
	}

	public void list() {
		System.out.println();
		System.out.println("�̸�\t����\t�ڵ���\t\t�ּ�");
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				System.out.println(
						ar[i].getName() + "\t" + ar[i].getAge() + "\t" + ar[i].getPhone() + "\t" + ar[i].getAddress());
			}
		}
	}

	public void insertMember() throws IOException {
		int i; //
		for (i = 0; i < ar.length; i++) { // MemberDTO�ּҰ��� �������� �ٰ��� �˷���� �ϱ� ������ ���ڸ� ã��
			if (ar[i] == null) // ������ ���� ���ƴٴϸ鼭 �ΰ��� ã��
				break; // ��ȿ� �ּҰ��� �־��� �ΰ��� ã������ ��.
		}

		if (i == ar.length) {
			System.out.println("���� �ʰ�..");
			return; // �޼ҵ带 �����
		}

		ar[i] = new MemberDTO(); // i���� �󸶿��� �������� �˱� ���� �ּҰ��� �ű⿡ ������ �ȴ�.

		System.out.print("�̸� �Է� : ");
		ar[i].setName(br.readLine());
		System.out.print("���� �Է� : ");
		ar[i].setAge(Integer.parseInt(br.readLine()));
		System.out.print("�ڵ��� �Է� : ");
		ar[i].setPhone(br.readLine());
		System.out.print("�ּ� �Է� : ");
		ar[i].setAddress(br.readLine());

		int count = 0;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] == null)
				count++;
		}
		System.out.println();
		System.out.println("��� �Ϸ�...");
		System.out.println(count + "�ڸ��� ���ҽ��ϴ�");
	}
}