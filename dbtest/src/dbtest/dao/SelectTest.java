/*
 * 1개의 행을 만들었습니다 -- insert
 * x개의 행을 수정하였습니다 -- update
 * x개의 행을 삭제하였습니다 -- delete
 * 
 * 반드시 이 세개는 commit해줘야 한다
 * 
 * transaction sql명령어들을 한꺼번에 뭉쳐놓은 것
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
	private ResultSet rs; // select를 하면 모든 결과물을 담는 resultSet이 들어와야 함

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	public SelectTest() { // 생성자
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
			String sql = "select * from dbtest"; // sql 잡아줬으니
			getConnection(); // 접속

			pstmt = conn.prepareStatement(sql); // 생성

			// 매핑할 게 없으니 바로 실행
			rs = pstmt.executeQuery(); // 다른 것들은 executeUpdate이지만 select만 rs

			while (rs.next()) { // rs가 몇개 있는지 모르니
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getDouble("height") + "\t"
						+ rs.getString("logtime"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 안 넣으면 메모리가 쌓여버림
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
