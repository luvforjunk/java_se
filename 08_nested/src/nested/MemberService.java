package nested;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MemberService {
	Scanner scan = new Scanner(System.in);
	private List<MemberDTO> list;

	public MemberService() {
		list = new ArrayList<MemberDTO>();
	}

	public void menu() {
		int num;
		while (true) {
			System.out.println();
			System.out.println("***************");
			System.out.println("   1. 회원가입");
			System.out.println("   2. 로그인");
			System.out.println("   3. 회원리스트");
			System.out.println("   4. 끝");
			System.out.println("***************");
			System.out.print("번호 : ");
			num = scan.nextInt();

			if (num == 4)
				break;
			if (num == 1)
				writeMember();
			else if (num == 2)
				loginMember();
			else if (num == 3)
				listMember();
			else
				System.out.println("1~6중에 선택하세요");

		} // while
	} // menu()

	private void listMember() {
		System.out.println();

		// DB
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.listMember();

		System.out.println("이름\t아이디\t비밀번호\t이메일");
		for (MemberDTO dto : list) {
			System.out.println(dto);
		}
	} // listMember()

	private void loginMember() {
		String id;
		int pwd;

		System.out.println();
		System.out.print("아이디 입력 : ");
		id = scan.next();
		System.out.print("비밀 번호 입력 : ");
		pwd = scan.nextInt();

		// DB
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.loginMember(id);
		System.out.println("loginMember = "+dto);

		if (dto != null) {
			System.out.println(id + "님 로그인");
		} else {
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다");
		}

	} // loginMember()

	private void writeMember() { // -----------writeMember()

		System.out.println();
		System.out.print("이름 입력 : ");
		String name = scan.next();
		
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.loginMember(id);

		if (dto == null) {
			System.out.println(id + " 사용 가능한 아이디입니다");
		} else {
			System.out.println(id + " 이미 사용 중인 아이디입니다");
			return;
		}
		
		
		System.out.print("패스워드 입력 : ");
		int pwd = scan.nextInt();
		System.out.print("이메일 입력 : ");
		String email = scan.next();

		// 데이터를 생성자 또는 setter 저장
		dto = new MemberDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);

		// DB
		dao = new MemberDAO();
		dao.writeMember(dto);

		System.out.println("회원가입을 축하합니다");
		
	} // writeMember()

}
