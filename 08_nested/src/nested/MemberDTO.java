package nested;

import java.text.DecimalFormat;

public class MemberDTO implements Comparable<MemberDTO> {
	public String name, id, email;
	int pwd;

	public MemberDTO(String name, String id, int pwd, String email) { // ������
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
	}

	public MemberDTO() {
	} // �⺻ ������
	
	@Override
	public String toString() {
		return name + "\t" + id + "\t" + pwd + "\t" + email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(MemberDTO m) {
		return this.id.compareTo(m.id);
	}
}