package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {

	public static void main(String[] args) {
		// 문자열은 값이 없고 주소밖에 없다
		String[] ar = { "orange", "apple", "banana", "pear", "peach", "applemango" };

		System.out.print("정렬 전 = ");
		for (String str : ar) {
			System.out.print(str + " ");
		}
		System.out.println();

		Arrays.sort(ar); // String 타입은 -1, 0, 1 값이 나옴

		System.out.print("정렬 후 = ");
		for (String str : ar) {
			System.out.print(str + "  ");
		}
		System.out.println("\n");

		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("라이언", 30);
		PersonDTO cc = new PersonDTO("어피치", 28);

		// 각각의 객체를 sort시켜주게끔 List한곳에 묶어주기
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);

		System.out.println("정렬 전");
		System.out.println(list);
		System.out.println();

		Collections.sort(list);
		System.out.println("나이로 오름차순(내림차순) : ");
		System.out.println(list);
		System.out.println();

		System.out.println("이름으로 오름차순");
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() {
			@Override
			public int compare(PersonDTO dto1, PersonDTO dto2) {

				// 오름차순
				// return dto1.getName().compareTo(dto2.getName());

				// 내림차순
				return dto1.getName().compareTo(dto2.getName());
				// = return dto1.getName().compareTo(dto2.getName()) * -1;
			}
		};
		// Comparable과 Comparator은 인터페이스.
		// Comparable은 기본 정렬기준을 구현하는데 사용

		Collections.sort(list, com);
		System.out.println(list);
		System.out.println();
	}
}
