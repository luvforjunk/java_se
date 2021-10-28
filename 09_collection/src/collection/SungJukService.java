package collection;

import java.util.*;

public class SungJukService {

	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list; // 부모를 List로 설정해놓고 생성자는 ArrayList

	public SungJukService() {
		list = new ArrayList<SungJukDTO>();
	}

	public void menu() {
		int num;

		while (true) {
			System.out.println("*****************");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("5. 정렬");
			System.out.println("6. 끝");
			System.out.println("*****************");
			System.out.print("      번호 : ");
			num = scan.nextInt();

			if (num == 6)
				break;
			if (num == 1)
				insertArticle();
			else if (num == 2)
				printArticle();
			else if (num == 3)
				searchArticle();
			else if (num == 4)
				deleteArticle();
			else if (num == 5)
				sortArticle();
			else
				System.out.println("1~6중에 선택하세요");
		} // while
	} // menu

	public void sortArticle() { // -------------------sortArticle( )
		int num;

		while (true) {
			System.out.println("1. 이름으로 오름차순");
			System.out.println("2. 총점으로 내림차순");
			System.out.println("3. 이전메뉴");
			System.out.print("번호 입력 : ");
			num = scan.nextInt();
			if (num == 3)
				break;

			// 이름으로 오름차순
			if (num == 1) {
//          // interface라 뉴가 안되니 익명 설정해주기
//         Comparator<SungJukDTO> com = new Comparator<SungJukDTO>( ) {
//              @Override
//             public int compare(SungJukDTO dto1, SungJukDTO dto2) {
//            return dto1.getName( ).compareTo(dto2.getName( ));
//           //문자열과 문자열의 크기 비교가 불가하므로 compareTo가 그 역할을 대신한다
//                                 }
//                         };
//                 Collections.sort(list, com); // 객체 전체를 움직여주는 역할을 함. 총점만 바뀌는 것이 아님.
//                          printArticle();

				Collections.sort(list);
				printArticle();

				// DTO에서 이미 CompareTo 다 잡아놨으니 위 Comparator는 없어도 됨.
				// Comparable은 클래스에다 implements해서 자체적으로 기준점을 잡아주고,
				// Comparator은 직접 기준점을 잡는다
				// 총점으로 내림차순

			} else if (num == 2) {
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
					
					@Override
					public int compare(SungJukDTO dto1, SungJukDTO dto2) {
						// 조건연산자 : 조건 ? 참 : 거짓;
						// return dto1.getTot( ) > dto2.getTot( ) ? 1 : -1; - 오름차순
						return dto1.getTot() > dto2.getTot() ? -1 : 1;
					}
				};

				Collections.sort(list, com);
				printArticle();
			}
		} // while
	} // sortArticle( )

	public void deleteArticle() {// -------------------deleteArticle( )***
		System.out.println();
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();
		int sw = 0; // 변수 설정

//                for(int i =0; i<list.size(); i++) {
//                         if(list.get(i).getName().equals(name)) {
//                                 list.remove(list.get(i));
//                                 sw =1;
//                         }
//                }
//                list size가 계속 움직이면서 번호가 같이 움직여버려 에러가 남

		Iterator<SungJukDTO> it = list.iterator(); // 생성 - 반복해서 가져올 객체가 SungJukDTO
		while (it.hasNext()) { // it값이 있습니까? 항목이 있으면 T, 없으면 F (hasnext는 데이터가 있다 없다만 판단)
			SungJukDTO dto = it.next();
			// 항목을 꺼내서 dto에게 전달, 다음으로 이동(next는 항목을 꺼내고 전달한 뒤 다음으로 이동하는 것 까지)
			if (dto.getName().equals(name)) {
				it.remove(); // it가 가리키는 현재 위치를 지우는 것이 아닌 dto에 보관한 내용 삭제
				sw = 1;
			} // if
		} // while

		if (sw == 0) // 변수에 변화가 없으면
			System.out.println("찾고자 하는 이름이 없습니다");
		else // 변수 변화가 있으면
			System.out.println("데이터를 삭제하였습니다");
	} // deleteArticle( )

	public void searchArticle() { // -------------------searchArticle( )
		System.out.println();
		System.out.print("검색 할 이름 입력 : ");
		String Name = scan.next();
		int sw = 0; // 1번 - 변수를 잡는다(for문으로 전 데이터 돌기)

		for (SungJukDTO dto : list) {
			if (Name.equals(dto.getName())) { // 검색한 이름과 같은 이름을 찾으면
				if (sw == 0) // 0부터 시작해서 처음엔 0, 그 다음에 1 이렇게 찍히고
					// 0일때는 딱 한번밖에 안나오니 이름도 한번밖에 안찍힘
					System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(dto); // 2번 - 데이터를 찍고
				sw = 1; // 3번 - 뭔가를 찍고 나니 변수가 0에서 1로
//                         }else {                                                      
//                                 System.out.println("찾고자 하는 이름이 없습니다");
//                         }
//                         break;

// *** 여기서 else를 찍을 경우 딱 한번만 돈다
// 내가 찾는 데이터가 다른 곳에 분명히 있는데 break로 빠져나오니까 그 다음 껄 못해..ㅠ
// 변수를 하나 잡고, 데이터를 돌린 뒤 변수가 바뀜. for문을 돌았는데도 변수가 처음 그대로의 값이라면 그제서야 탁!
			}
		} // for
		if (sw == 0) // 4번 - for문 밖으로 나와서... 아직도 sw가 0인지 물어봐
			System.out.println("찾고자 하는 이름이 없습니다"); // 5번 - 그러고나서 찍어주면 됨
	}
	
	public void printArticle() { // -------------------printArticle()
		System.out.println();
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");

		for (SungJukDTO dto : list) { // list에 있는 SungJukDTO를 dto에 꺼내주자
			System.out.println(dto);
		}
	} // printArticle( )

	public void insertArticle() { // -------------------insertArticle()
		System.out.println();
		System.out.print("번호 입력 : ");
		int number = scan.nextInt();
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("국어 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		int math = scan.nextInt();
		
		// 한사람분의 DTO 받기~~
		SungJukDTO dto = new SungJukDTO(number, name, kor, eng, math);
		dto.calc(); // 총점, 평균 계산
		list.add(dto); // dto의 주소값만 list에 넣는 것
		// System.out.println(list); // 클@16진수 ...[~,~,~]
		System.out.println("등록 완료");
	} // inserArticle( )
}