/*
 * [����]
Project  : student
Package : student.dao
Class    : Student.java

# ���̺� �ۼ�
create table student(
name  varchar2(15)  not  null, -- �̸�
value   varchar2(15), -- �й� or ���� or �μ�
code   number   -- 1�̸� �л�, 2�̸� ����, 3�̸� ������
);

menu()
****************
   ����
****************
  1. �Է�
  2. �˻�
  3. ����
  4. ����
****************
  ��ȣ���� : 4
���α׷� �����մϴ�


1. �Է�
insertArticle()
****************
   1. �л�
   2. ����
   3. ������
   4. �����޴�
****************
   ��ȣ���� : 

1�� �л��� ���
�̸��Է� : 
�й��Է� : 

2�� ������ ���
�̸��Է� : 
�����Է� : 

3�� �������� ���
�̸��Է� : 
�μ��Է� : 

2. �˻�
selectArticle()
****************
   1. �̸� �˻� (1�� ���ڰ� ���Ե� �̸��� ��� �˻�)
   2. ��ü �˻�
   3. �����޴�
****************
   ��ȣ���� : 1

1�� ���
�˻��� �̸� �Է� : ��
�̸�=����   �й�=2015
�̸�=�̱���   ����=JAVA

3. ����
deleteArticle()
������ ���ϴ� �̸� �Է� : (��Ȯ�ϰ� 3���� ���ڰ� ��� �Էµ� ����)
 * code���� ��ȣ(1,2,3,,)�� insert ������
 * 
 * ���̺� �Է��� �𺧷��۷�
 * ������ �Է��� �ڹٷ� 
 */

package student.dao;

import java.sql.*;

import student.dao.Student;
import java.util.*;

public class Student {
	// �ʵ�

	int num;
	String name, value;
	int code;

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;

	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;

	}

}

class MenuAdmin {

	private Connection conn = null;
	private PreparedStatement pstmt;

	Student st;
	Scanner scan = new Scanner(System.in);
	int num;
	String name, value;
	int code;

	public MenuAdmin() {
	}

	public void insertArticle() { // -----------------insert
		st = new Student();

		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("1. �л�");
			System.out.println("2. ����");
			System.out.println("3. ������");
			System.out.println("4. �����޴�");
			System.out.println("****************");
			System.out.println("  ��ȣ���� : ");
			num = scan.nextInt();
			try {
				Connection conn = getConnection();

				if (num == 4)
					break;

				if (num == 1) {
					System.out.println("�̸��Է� : ");
					String name = scan.next();
					System.out.println("�й��Է� : ");
					String value = scan.next();
					code = 1;

				} else if (num == 2) {
					System.out.println("�̸��Է� : ");
					String name = scan.nextLine();
					System.out.println("�����Է� : ");
					String value = scan.next();
					code = 2;

				} else if (num == 3) {
					System.out.println("�̸��Է� : ");
					String name = scan.next();
					System.out.println("�μ��Է� : ");
					String value = scan.next();
					code = 3;
				}

				String sql = "insert into student values(?, ?, ?, sysdate)";
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, code);
				pstmt.executeUpdate();

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
		}
	}

	public void selectArticle() { // ------------------select

		try {
			Connection conn = getConnection();

			String sql = "select * from student";
			getConnection(); // ����

			PreparedStatement pstmt = conn.prepareStatement(sql); // ����

			ResultSet rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("name") + "\t" + rs.getInt("studentnumber") + "\t"
						+ rs.getString("major") + "\t" + rs.getString("depart"));
			}
			while (true) {
				System.out.println();
				System.out.println("****************");
				System.out.println("1. �̸��˻�");
				System.out.println("2. ��ü�˻�");
				System.out.println("3. �����޴�");
				System.out.println("****************");
				System.out.println("  ��ȣ���� : ");
				num = scan.nextInt();

				if (num == 3)
					return;
				if (num == 1) {
					System.out.println("�˻��� �̸� �Է� : ");
					scan.nextLine();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteArticle() { // -------------delete

		selectArticle();
		String name;

		try {
			Connection conn = getConnection();
			String sql = "delete from student where name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate("delete from student where name=?");

			// ����
			int su = pstmt.executeUpdate();
			System.out.println(su + "���� ���� �����Ǿ����ϴ�");

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void menu() {

		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("1. �Է�");
			System.out.println("2. �˻�");
			System.out.println("3. ����");
			System.out.println("4. ����");
			System.out.println("****************");
			System.out.println("  ��ȣ���� : ");
			num = scan.nextInt();

			if (num == 4)
				break;
		}
	}

	public static Connection getConnection() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "c##java";
		String password = "bit";
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;

	} // while

}

class StudentMenu {
	Scanner scan = new Scanner(System.in);
	MenuAdmin ma = new MenuAdmin();
	int num;

	public StudentMenu() {
		try {
			Connection conn = ma.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
			ma.menu();
		}
		num = scan.nextInt();

		if (num == 1) {
			ma.insertArticle();
		} else if (num == 2) {
			ma.selectArticle();
		} else if (num == 3) {
			ma.deleteArticle();
		} else if (num == 4) {
			break;
		}
	}
}

public class StudentMysql {
	public static void main(String[] args) {
		new StudentMenu();

	}
}