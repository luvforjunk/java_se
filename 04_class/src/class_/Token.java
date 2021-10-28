package class_;

import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		String str = "�п�, ��,,���ӹ�";

		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("��ū ���� = " + st.countTokens()); // 3�� - "�п�", "��", "���ӹ�"

		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		} // while
		System.out.println("--------------------");

		String[] ar = str.split(",");
		for (String data : ar) {
			System.out.println(data);
		}
	}
}

/*
 StringTokenizer 		String-split() 
 "�п�" 					"�п�" 
 "��" 					"��" 
 "���ӹ�" 				"" 
 						"���ӹ�"
 */

//�迭.length - ��ɾ�
//���ڿ�.length() - �޼ҵ�

//hasMoreTokens() - ���� ��ġ�� ��ū�� ������(T), ������(F)
//nextToken() - ��ū�� ������ ���� ��ġ�� �̵�