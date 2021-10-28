package safari;

import com.zoo.Zoo;
// 부모인 Zoo는 자식인 safari가 안보인다
// 참조는 가능할지언정 new해서 부모를 생성했으면 public밖에 안보임

public class Safari extends Zoo {
// 상속 관계로 묶어버리기

	public static void main(String[] args) {
		Zoo z = new Zoo(); // 부모를 생성

		z.tiger();
		// z.giraffe();
		// z.elephant();
		// z.lion();
		
// 만약 자식클래스(sub)로 생성한다면? 
		System.out.println("-------------");
		Safari s = new Safari(); // 자식을 생성
		s.tiger();
		s.giraffe();
		// s.elephant();
		// s.lion();
	}

}
