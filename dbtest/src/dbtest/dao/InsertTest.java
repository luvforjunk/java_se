package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // insert, delete, oracle ������ ����ϴ� ���̵� ����
// �� ���� interface. ���� implement�ϴ� �� �ٺ����� ��.
// ��� implement���ִ� Ŭ���� ���� ������... �޼ҵ带 ��� ���ۿ�?
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {
	private Connection conn; // null�� ���� ����. ��� �� ���������
	private PreparedStatement pstmt;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	public InsertTest() {
		try {
			// driver loading
			// Class.forName("Ǯ����, ��Ű����.���ϸ�"); ���ϸ��� �ָ� Class���� �������ְڴ�
			Class.forName(driver); // �̸� ��ü�� Class. �� ���� �ִ� class���� �ٸ� ��. ��Ÿ���ϻ�.
			System.out.println("����̹� �ε� ����");

		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // try���� catch���� �߻��ϴ� ���� ������ ���
		}
	}

	public void getConnection() {
		try {
			// DriverManager.getConnection("URL", "USERNAME", "PASSWORD");
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			// "c##java", "bit");
			conn = DriverManager.getConnection(url, username, password); // �޼ҵ� �̿��Ͽ� ����
			System.out.println("���� ����");

		} catch (SQLException e) {// SQLException�� ������ �� �𸥴�
			e.printStackTrace(); // �װ� ȭ�鿡 ���� ����
		}
	}

	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���� �Է� : ");
		int age = scan.nextInt();
		System.out.print("Ű �Է� : ");
		double height = scan.nextDouble();

		try { // Exception �ɾ��ֱ�
			this.getConnection(); // ���� - ����(connection)�� �� sql���� ó��

			// developer�� �ͼ� ������ ������ �� ���������� (-> delete dbtest;)
			// �̶� delete�� lock�� �ɷ��־� commit�� ������ ������ �ٸ� �������� ���� �ƴ��� �𸥴�
			// ��� �������ٴ� �� ���Ž����ֱ� ���� commit; �Է�
			String sql = "insert into dbtest values(?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			// connection�� ����ִ� prepareStatement ����
			// implement�� �� ����, implement�� ��� ���ִ� �͵� ������ �޼ҵ� ��Ƽ� �������� ��
			// ?�� ������ ����
			pstmt.setString(1, name); // Oracle�� java�� �޸� index���� 1���� ����.
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);

			// ���� - ���� ����
			int su = pstmt.executeUpdate(); // db���� insert into�� �Է��ϸ� �׻� ������ ���Ͻ�����
			System.out.println(su + "���� ���� ����������ϴ�");

			// insert into dbtest values()
			// ����Ŭ �����ϻ� �ڹ��ڵ尡 �ƴϴ� ���̵�(PreparedStatement)�� ���󰡾�
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ������ �ְ� ���� ������!! ���������� �������!!
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

	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.insertArticle();
	}
}