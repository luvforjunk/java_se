/* [숙제]
MemberService.java (입력 및 출력 등)

클럽의 회원관리 프로그램 작성하려고 한다.
여기는 폐쇄적인 모임으로 회원은 총 5명으로 한다.
회원의 정보는 이름, 나이, 핸드폰, 주소로 설정한다.
회원 가입, 출력, 수정, 탈퇴 프로그램을 작성하시오.

menu()
*************
   1. 가입
   2. 출력
   3. 수정
   4. 탈퇴
   5. 끝내기
*************
  번호 : 

insertMember()
이름 입력 : 
이름 입력 :    
핸드폰 입력 : 
주소 입력 : 
등록 완료..4자리 남았습니다   

list()
이름      나이      핸드폰      주소
총 5명중에서 등록된 회원만 보여준다

updateMember()
핸드폰 번호 입력 : 010-123-1234
찾고자 하는 회원이 없습니다

-------------------------------
핸드폰 번호 입력 : 010-123-1234

이름      나이      핸드폰         주소
홍길동      25      010-123-1234      서울

이름 입력 : 
이름 입력 :    
핸드폰 입력 : 
주소 입력 :

수정 완료

deleteMember()
핸드폰 번호 입력 : 010-123-1234
찾고자 하는 회원이 없습니다

-------------------------------
핸드폰 번호 입력 : 010-123-1234

삭제 완료
*/

package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberService {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	MemberDTO[] ar = new MemberDTO[5]; // ar은 이 클래스 안에 있는 모든 애들이 쓸 수 있다.

	public void menu() throws IOException { // 구현
		int num;

		while (true) {
			System.out.println();
			System.out.println("********************");
			System.out.println("     1. 가입");
			System.out.println("     2. 출력");
			System.out.println("     3. 수정");
			System.out.println("     4. 탈퇴");
			System.out.println("     5. 끝내기");
			System.out.println("********************");
			System.out.print("     번호 : ");
			num = Integer.parseInt(br.readLine());
			if (num == 5)
				break;

			if (num == 1)
				insertMember(); // 메뉴에서 뱅글뱅글 돌기 때문에 insert가 끝나면 제자리로 복귀
			else if (num == 2)
				list();
			else if (num == 3)
				updateMember();
			else if (num == 4)
				deleteMember();
		} // while
	}

	public void deleteMember() throws IOException {
		System.out.print("핸드폰 번호 입력 : ");
		String phone = br.readLine();

		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				if (ar[i].getPhone().equals(phone))
					break;
			} // if
		} // for

		if (i == ar.length) {
			System.out.println("찾고자 하는 회원이 없습니다");

		} else {
			ar[i] = null;
			System.out.println("탈퇴 완료...");
		}
	}

	public void updateMember() throws IOException { // 수정
		System.out.print("핸드폰 번호 입력 : ");
		String phone = br.readLine();

		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				if (ar[i].getPhone().equals(phone))
					break;
			} // if
		} // for

		if (i == ar.length) {
			System.out.println("찾고자 하는 회원이 없습니다");
			return;
		}

		System.out
				.println(ar[i].getName() + "\t" + ar[i].getAge() + "\t" + ar[i].getPhone() + "\t" + ar[i].getAddress());

		System.out.print("이름 입력 : ");
		ar[i].setName(br.readLine());
		System.out.print("나이 입력 : ");
		ar[i].setAge(Integer.parseInt(br.readLine()));
		System.out.print("핸드폰 입력 : ");
		ar[i].setPhone(br.readLine());
		System.out.print("주소 입력 : ");
		ar[i].setAddress(br.readLine());

		System.out.println();
		System.out.println("수정 완료...");
	}

	public void list() {
		System.out.println();
		System.out.println("이름\t나이\t핸드폰\t\t주소");
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				System.out.println(
						ar[i].getName() + "\t" + ar[i].getAge() + "\t" + ar[i].getPhone() + "\t" + ar[i].getAddress());
			}
		}
	}

	public void insertMember() throws IOException {
		int i; //
		for (i = 0; i < ar.length; i++) { // MemberDTO주소값을 누구한테 줄건지 알려줘야 하기 때문에 빈자리 찾기
			if (ar[i] == null) // 각각의 방을 돌아다니면서 널값을 찾아
				break; // 방안에 주소값을 넣어줄 널값을 찾았으면 끝.
		}

		if (i == ar.length) {
			System.out.println("정원 초과..");
			return; // 메소드를 벗어나라
		}

		ar[i] = new MemberDTO(); // i방이 얼마에서 빠졌는지 알기 위해 주소값을 거기에 넣으면 된다.

		System.out.print("이름 입력 : ");
		ar[i].setName(br.readLine());
		System.out.print("나이 입력 : ");
		ar[i].setAge(Integer.parseInt(br.readLine()));
		System.out.print("핸드폰 입력 : ");
		ar[i].setPhone(br.readLine());
		System.out.print("주소 입력 : ");
		ar[i].setAddress(br.readLine());

		int count = 0;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] == null)
				count++;
		}
		System.out.println();
		System.out.println("등록 완료...");
		System.out.println(count + "자리가 남았습니다");
	}
}