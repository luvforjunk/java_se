package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {

	public static void main(String[] args) {
		// ���ڿ��� ���� ���� �ּҹۿ� ����
		String[] ar = { "orange", "apple", "banana", "pear", "peach", "applemango" };

		System.out.print("���� �� = ");
		for (String str : ar) {
			System.out.print(str + " ");
		}
		System.out.println();

		Arrays.sort(ar); // String Ÿ���� -1, 0, 1 ���� ����

		System.out.print("���� �� = ");
		for (String str : ar) {
			System.out.print(str + "  ");
		}
		System.out.println("\n");

		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("���̾�", 30);
		PersonDTO cc = new PersonDTO("����ġ", 28);

		// ������ ��ü�� sort�����ְԲ� List�Ѱ��� �����ֱ�
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);

		System.out.println("���� ��");
		System.out.println(list);
		System.out.println();

		Collections.sort(list);
		System.out.println("���̷� ��������(��������) : ");
		System.out.println(list);
		System.out.println();

		System.out.println("�̸����� ��������");
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() {
			@Override
			public int compare(PersonDTO dto1, PersonDTO dto2) {

				// ��������
				// return dto1.getName().compareTo(dto2.getName());

				// ��������
				return dto1.getName().compareTo(dto2.getName());
				// = return dto1.getName().compareTo(dto2.getName()) * -1;
			}
		};
		// Comparable�� Comparator�� �������̽�.
		// Comparable�� �⺻ ���ı����� �����ϴµ� ���

		Collections.sort(list, com);
		System.out.println(list);
		System.out.println();
	}
}
