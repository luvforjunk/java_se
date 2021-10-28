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

	public Student2() { // 드라이버 로딩 - 딱 한번!
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() { // 접속
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
// 메뉴함수 생성
	public void menu() { 
		int num = 0;
		while (true) {
			System.out.println();
			System.out.println("***************");
			System.out.println("   관리");
			System.out.println("***************");
			System.out.println("   1. 입력");
			System.out.println("   2. 검색");
			System.out.println("   3. 삭제");
			System.out.println("   4. 종료");
			System.out.println("***************");
			System.out.print("번호 선택 : ");
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
		System.out.print("삭제 할 이름 입력 : ");
		String name = scan.next();
		// DB
		String sql = "delete student where name=?"; // **delete는 =
		this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이 삭제되었습니다");
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
			System.out.println("1. 이름검색");
			System.out.println("2. 전체검색");
			System.out.println("3. 이전메뉴");
			System.out.println("*************");
			System.out.print("번호 선택 : ");
			num = scan.nextInt();

			if (num == 3)
				break;
			if (num == 1) {
				System.out.print("검색할 이름 입력 : ");
				name = scan.next();
			}
			// DB
			String sql = null;
			if (num == 1) {
				sql = "select * from student where name like ?"; // 이름검색
			} else if (num == 2) {
				sql = "select * from student"; // 전체검색
			}
			this.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				if (num == 1)
					pstmt.setString(1, "%" + name + "%"); // ? 매핑
				rs = pstmt.executeQuery();// 실행
				// insert update delete는 항상 개수가 떨어지지만 
				// select는 결과물이 들어온다
				while (rs.next()) {
					System.out.print("이름 = " + rs.getString("name") + "\t\t");
					if (rs.getInt("code") == 1) // 코드값이 1번이면
						System.out.println("학번 = " + rs.getString("value")); // 학번을 꺼내와라 
					else if (rs.getInt("code") == 2)
						System.out.println("과목 = " + rs.getString("value"));
					else if (rs.getInt("code") == 3)
						System.out.println("부서 = " + rs.getString("value"));
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
		String name; // 아래를 보면 이름은 if문에 상관없이 무조건 데이터 읽어들이지만
		String value = null; // Value랑 code는 모르니 초기화시켜줘야. 
		int code = 0; // String value = null; int code =0; -> 초기화

		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("   1. 학생");
			System.out.println("   2. 교수");
			System.out.println("   3. 관리자");
			System.out.println("   4. 이전메뉴");
			System.out.println("****************");
			System.out.print("번호 선택 : ");
			num = scan.nextInt();
			if (num == 4)
				break;
			// 데이터 입력
			System.out.print("이름 입력 : "); // 이름은 공통적으로 다 들어가고
			name = scan.next();
			if (num == 1) {
				System.out.print("학번 입력 : ");
				value = scan.next();
				code = 1;
			} else if (num == 2) {
				System.out.print("과목 입력 : ");
				value = scan.next();
				code = 2;
			} else if (num == 3) {
				System.out.print("부서 입력 : ");
				value = scan.next();
				code = 3;
			}
			// DB
			String sql = "insert into student values(?, ?, ?)";
			
			this.getConnection();// 오라클 접속
			try {
				pstmt = conn.prepareStatement(sql); // sql 처리해주는 가이드 생성
				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, code);
				int su = pstmt.executeUpdate();// 실행
				System.out.println(su + "개의 행이 만들어졌습니다");
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

	public static void main(String[] args) { // 프로그램 시작
		Student sd = new Student(); // 메모리에 Student 클래스 잡아주고, 생성자까지 콜해주면 드라이버 로딩 끝
		sd.menu();
		System.out.println("프로그램을 종료합니다.");
	}
}

/*SQL 테이블 만들기
create table student (name varchar2(15), 
		value varchar2(15),
		code number);
		
select * from student where name like '%이%'; - 이름검색	
		
select * from student; - 전체검색

Oracle
- Server 한글 1자 = 2byte
- Express 한글 1자 = 3byte

홍길동 -> 9
*/