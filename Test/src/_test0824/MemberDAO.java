package _test0824;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private static MemberDAO instance;

	public static MemberDAO getInstance() {
		synchronized (MemberDAO.class) { // MemberDAO.class��� �̸��� ���� �ֵ��� ���´ٸ�
			if (instance == null) { // static�̱� ������ null���� �� �ѹ���
				instance = new MemberDAO(); // null�� ������ memberDAO�� ������
			}
		}
		System.out.println("instance = " + instance);
		return instance;
	}

	public MemberDAO() { // ����̹� �ε�

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

	public boolean isCheckId(String id) {
		boolean check = false;
		String sql = "select * from member where id=?";
		
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sql);
			rs = pstmt.executeQuery();
			
			// = check = rs.next()
			if(rs.next()) check = true; // rs�� ���� �ֽ��ϱ�?
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	}finally {
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
		return check;
	}


	public void writeMember(MemberDTO dto) {
		String sql = "insert into Member values(?,?,?,?)";
		getConnection(); // ����

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getEmail());
			pstmt.executeUpdate(); // ����

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
	}// writeMember

	public MemberDTO loginMember(String id) {

		MemberDTO dto = null;
		String sql = "select * from member where id=? and pwd=?";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			if (rs.nextame(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
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
		System.out.println(dto);
		return dto;

	} // loginMember()

	public List<MemberDTO> listMember() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from Member order by name";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("Name"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
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

}
