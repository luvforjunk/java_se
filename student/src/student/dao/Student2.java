package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student2 {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	Scanner scan = new Scanner(System.in);

	public Student2() { // ����̹� �ε� - �� �ѹ�!
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() { // ����
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
// �޴��Լ� ����
	public void menu() { 
		int num = 0;
		while (true) {
			System.out.println();
			System.out.println("***************");
			System.out.println("   ����");
			System.out.println("***************");
			System.out.println("   1. �Է�");
			System.out.println("   2. �˻�");
			System.out.println("   3. ����");
			System.out.println("   4. ����");
			System.out.println("***************");
			System.out.print("��ȣ ���� : ");
			num = scan.nextInt();
			if (num == 4)
				break;
			if (num == 1)
				insertArticle();
			else if (num == 2)
				selectArticle();
			else if (num == 3)
				deleteArticle();
		} // while
	}// menu()

	private void deleteArticle() { //------------deleteArticle()
		System.out.print("���� �� �̸� �Է� : ");
		String name = scan.next();
		// DB
		String sql = "delete student where name=?"; // **delete�� =
		this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + "���� ���� �����Ǿ����ϴ�");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}// deleteArticle()

	private void selectArticle() { //------------selectArticle()
		int num;
		String name = null;

		while (true) {
			System.out.println();
			System.out.println("*************");
			System.out.println("1. �̸��˻�");
			System.out.println("2. ��ü�˻�");
			System.out.println("3. �����޴�");
			System.out.println("*************");
			System.out.print("��ȣ ���� : ");
			num = scan.nextInt();

			if (num == 3)
				break;
			if (num == 1) {
				System.out.print("�˻��� �̸� �Է� : ");
				name = scan.next();
			}
			// DB
			String sql = null;
			if (num == 1) {
				sql = "select * from student where name like ?"; // �̸��˻�
			} else if (num == 2) {
				sql = "select * from student"; // ��ü�˻�
			}
			this.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				if (num == 1)
					pstmt.setString(1, "%" + name + "%"); // ? ����
				rs = pstmt.executeQuery();// ����
				// insert update delete�� �׻� ������ ���������� 
				// select�� ������� ���´�
				while (rs.next()) {
					System.out.print("�̸� = " + rs.getString("name") + "\t\t");
					if (rs.getInt("code") == 1) // �ڵ尪�� 1���̸�
						System.out.println("�й� = " + rs.getString("value")); // �й��� �����Ͷ� 
					else if (rs.getInt("code") == 2)
						System.out.println("���� = " + rs.getString("value"));
					else if (rs.getInt("code") == 3)
						System.out.println("�μ� = " + rs.getString("value"));
				} // while
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // while
	}// selectArticle()
	
	public void insertArticle() { //------------insertArticle()
		int num;
		String name; // �Ʒ��� ���� �̸��� if���� ������� ������ ������ �о��������
		String value = null; // Value�� code�� �𸣴� �ʱ�ȭ�������. 
		int code = 0; // String value = null; int code =0; -> �ʱ�ȭ

		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("   1. �л�");
			System.out.println("   2. ����");
			System.out.println("   3. ������");
			System.out.println("   4. �����޴�");
			System.out.println("****************");
			System.out.print("��ȣ ���� : ");
			num = scan.nextInt();
			if (num == 4)
				break;
			// ������ �Է�
			System.out.print("�̸� �Է� : "); // �̸��� ���������� �� ����
			name = scan.next();
			if (num == 1) {
				System.out.print("�й� �Է� : ");
				value = scan.next();
				code = 1;
			} else if (num == 2) {
				System.out.print("���� �Է� : ");
				value = scan.next();
				code = 2;
			} else if (num == 3) {
				System.out.print("�μ� �Է� : ");
				value = scan.next();
				code = 3;
			}
			// DB
			String sql = "insert into student values(?, ?, ?)";
			
			this.getConnection();// ����Ŭ ����
			try {
				pstmt = conn.prepareStatement(sql); // sql ó�����ִ� ���̵� ����
				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, code);
				int su = pstmt.executeUpdate();// ����
				System.out.println(su + "���� ���� ����������ϴ�");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // while
	}// insertArticle()

	public static void main(String[] args) { // ���α׷� ����
		Student sd = new Student(); // �޸𸮿� Student Ŭ���� ����ְ�, �����ڱ��� �����ָ� ����̹� �ε� ��
		sd.menu();
		System.out.println("���α׷��� �����մϴ�.");
	}
}

/*SQL ���̺� �����
create table student (name varchar2(15), 
		value varchar2(15),
		code number);
		
select * from student where name like '%��%'; - �̸��˻�	
		
select * from student; - ��ü�˻�

Oracle
- Server �ѱ� 1�� = 2byte
- Express �ѱ� 1�� = 3byte

ȫ�浿 -> 9
*/