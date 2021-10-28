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
			System.out.println("   1. ȸ������");
			System.out.println("   2. �α���");
			System.out.println("   3. ȸ������Ʈ");
			System.out.println("   4. ��");
			System.out.println("***************");
			System.out.print("��ȣ : ");
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
				System.out.println("1~6�߿� �����ϼ���");

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
		System.out.print("���̵� �Է� : ");
		String id = scan.next();
		System.out.print("��� ��ȣ �Է� : ");
		String pwd = scan.next();

		// DB
		MemberDAO dao = MemberDAO.getInstance(); //�̱���
		MemberDTO dto = dao.loginMember(id, pwd);
		System.out.println("loginMember = "+dto);

		if (dto != null) {
			System.out.println(id + "�� �α���");
		} else {
			System.out.println("���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�");
		}

	} // loginMember()

	private void writeMember() { // -----------writeMember()

		System.out.println();
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���̵� �Է� : ");
		String id = scan.next();
		
		//DB
		MemberDAO dao = MemberDAO.getInstance(); //�̱��� 
		boolean exist = dao.ischeckId(id); // id�� �ִ��� ������ Ȯ�� 
		// is ���λ縦 ���̸� 100���� boolean������ ���´�
		if(check) {
			System.out.println(id + " �̹� ��� ���� ���̵��Դϴ�");
			return; // ������. ó������ ���ư���
		} else {
			System.out.println(id + " ��� ������ ���̵��Դϴ�");
		}	
			
		System.out.print("�н����� �Է� : ");
		int pwd = scan.nextInt();
		System.out.print("�̸��� �Է� : ");
		String email = scan.next();
		
		// DB
		MemberDTO dto = new MemberDTO();
		

		// �����͸� ������ �Ǵ� setter ����
		dto = new MemberDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);

		// DB
		dao = new MemberDAO();
		dao.writeMember(dto);

		System.out.println("ȸ�������� �����մϴ�");
		
	} // writeMember()

}
