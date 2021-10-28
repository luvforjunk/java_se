package _test0824;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberDTO> list = dao.listMember();

		for (MemberDTO dto : list) {
			System.out.println(dto);
		}
	} // listMember()

	private void loginMember() {
		System.out.println();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀 번호 입력 : ");
		String pwd = scan.next();

		// DB
		MemberDAO dao = MemberDAO.getInstance(); //싱글톤
		MemberDTO dto = dao.loginMember(id, pwd);
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
		
		//DB
		MemberDAO dao = MemberDAO.getInstance(); //싱글톤 
		boolean exist = dao.ischeckId(id); // id가 있는지 없는지 확인 
		// is 접두사를 붙이면 100프로 boolean형으로 나온다
		if(check) {
			System.out.println(id + " 이미 사용 중인 아이디입니다");
			return; // 나가라. 처음으로 돌아가라
		} else {
			System.out.println(id + " 사용 가능한 아이디입니다");
		}	
			
		System.out.print("패스워드 입력 : ");
		int pwd = scan.nextInt();
		System.out.print("이메일 입력 : ");
		String email = scan.next();
		
		// DB
		MemberDTO dto = new MemberDTO();
		

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
