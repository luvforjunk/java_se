package collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SungJukDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; // select한 결과물은 항상 ResultSet에 보관된다
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	public SungJukDAO() { // 드라이버 로딩

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

	public void insertArticle(SungJukDTO dto) {
		String sql = "insert into sungjuk values(?, ?, ?, ?, ?, ?, ?)";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNumber());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMath());
			pstmt.setInt(6, dto.getTot());
			pstmt.setDouble(7, dto.getAvg());
			pstmt.executeUpdate();// 실행

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
	}// insertArticle(SungJukDTO dto)

	public List<SungJukDTO> printArticle() {

		List<SungJukDTO> list = new ArrayList<SungJukDTO>();
		String sql = "select * from sungjuk";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SungJukDTO dto = new SungJukDTO();

				dto.setNumber(rs.getInt("number"));
				// rs.getInt에서 number를 꺼내와 dto.setNumber에게 넘겨주기
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
				list.add(dto);
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
		return list;
	}

	public SungJukDTO searchArticle(int number) {
		
		SungJukDTO dto = null;
		String sql = "select * from sungjuk where number=?";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new SungJukDTO();
				dto.setNumber(rs.getInt("number"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
			}
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
		return dto;
	}

	public int deleteArticle(int number) {
		// int가 아닌 void로 해놓으면 return값이 없다는 얘기
		String sql = "delete sungjuk where number=?";
		getConnection();
		int su = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			su = pstmt.executeUpdate();
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
		return su;
	}

	public List<SungJukDTO> sortArticle(int num) {
		List<SungJukDTO> list = new ArrayList<SungJukDTO>();
		String sql = null;
		
		if (num == 1)
			sql = "select * from sungjuk order by name asc";
		else
			sql = "select * from sungjuk order by tot desc";

		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 실행

			while (rs.next()) {
				SungJukDTO dto = new SungJukDTO();
				dto.setNumber(rs.getInt("number"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; // try catch에서 error가 날 경우, list를 그냥 보낼 수 없으니
			// 더이상 진행하지 못하게 list를 초기화 시켜버려야 한다
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
			return list;
		}
	}
}