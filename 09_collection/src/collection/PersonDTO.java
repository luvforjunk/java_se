package collection;

// 데이터 - 1인분
public class PersonDTO implements Comparable<PersonDTO> { // PersonDTO기준으로 비교
	// Comparable이 interface니까 Override해주기
	private String name;
	private int age;

	public PersonDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 오름차순
	@Override
	public int compareTo(PersonDTO dto) {
//		if (this.age < dto.age)
//			return -1;
//		else if (this.age == dto.age)
//			return 0;
//		else
//			return 1;

		// 내림차순
		if (this.age < dto.age)
			return 1;
		else if (this.age == dto.age)
			return 0;
		else
			return -1;
	}
	@Override
	public String toString() {
		return "(" + name + "\t" + age + ")"; // 클@16진수를 변경해준 것
		// 왜? 보기 편하라고
	}
}
