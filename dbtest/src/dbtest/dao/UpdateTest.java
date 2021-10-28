/* 
 * 수정할 이름 입력 : 홍
 * x개의 행을 수정하였습니다
 * 홍이 들어간 이름을 찾아서 나이를 1살 증가, 키 1 감소
 * 
 * InsertTest와 비교했을 때 sql문과 ?에 값을 매핑하는 것이 달라질뿐

 */

package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	private Connection conn;
	private PreparedStatement pstmt;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	public UpdateTest() {
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

	public void updateArticle() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("수정할 이름 입력 : ");
			String name = scan.next();

			// ---------------------
			// 오라클 문장
			String sql = "update dbtest set age = age+1, height = height+1 where name like ?";

			// 접속
			this.getConnection(); // 얘는 Exception이 안일어남
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%"); // %와 ?는 같이 못 씀

			// 실행 - 개수 리턴
			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행을 수정하였습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 안 넣으면 메모리가 쌓여버림
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
		UpdateTest ut = new UpdateTest();
		ut.updateArticle();
	}
}
