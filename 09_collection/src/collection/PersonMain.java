package collection;

import java.util.ArrayList;

public class PersonMain {
	// public void init() {
	public ArrayList<PersonDTO> init() { // 구현
		PersonDTO aa = new PersonDTO("홍길동", 25); // 지역 aa. 전역(X)
		PersonDTO bb = new PersonDTO("라이언", 30);
		PersonDTO cc = new PersonDTO("어피치", 28);

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);

		return list;
		// return aa, bb, cc;
		// java는 한개밖에 return 시킬 수 없으니
		// 묶어서 main으로 넘겨주자
		// PersonDTO값은 무거우니 그 주소값만 main으로 보내주는 것이다
	}// init()

	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		ArrayList<PersonDTO> list = pm.init();// 호출
		System.out.println("list = " + list); // [~~~]

		for (int i = 0; i < list.size(); i++) {
			System.out.println("이름 = " + list.get(i).getName() + "\t" + "나이 = " + list.get(i).getAge());
		}
		System.out.println();

		for (PersonDTO dto : list) { // 간단!!!
			System.out.println("이름 = " + dto.getName() + "\t나이 = " + dto.getAge());
		}
		System.out.println();
	}
}
