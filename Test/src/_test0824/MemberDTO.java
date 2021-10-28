package _test0824;

public class MemberDTO implements Comparable<MemberDTO> {
	public String name, id, pwd, email;

	public MemberDTO(String name, String id, String pwd, String email) { // 持失切
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
	}

	public MemberDTO() {
	} // 奄沙 持失切
	
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
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
