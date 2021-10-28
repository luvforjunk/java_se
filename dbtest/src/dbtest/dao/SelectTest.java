/*
 * 1���� ���� ��������ϴ� -- insert
 * x���� ���� �����Ͽ����ϴ� -- update
 * x���� ���� �����Ͽ����ϴ� -- delete
 * 
 * �ݵ�� �� ������ commit����� �Ѵ�
 * 
 * transaction sql��ɾ���� �Ѳ����� ���ĳ��� ��
 */

package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; // select�� �ϸ� ��� ������� ��� resultSet�� ���;� ��

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	public SelectTest() { // ������
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {

		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectArticle() {

		try {
			String sql = "select * from dbtest"; // sql ���������
			getConnection(); // ����

			pstmt = conn.prepareStatement(sql); // ����

			// ������ �� ������ �ٷ� ����
			rs = pstmt.executeQuery(); // �ٸ� �͵��� executeUpdate������ select�� rs

			while (rs.next()) { // rs�� � �ִ��� �𸣴�
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getDouble("height") + "\t"
						+ rs.getString("logtime"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // �� ������ �޸𸮰� �׿�����
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
	}

	public static void main(String[] args) {
		SelectTest st = new SelectTest();
	      st.selectArticle();

	}
}
