package safari;

import com.zoo.Zoo;
// �θ��� Zoo�� �ڽ��� safari�� �Ⱥ��δ�
// ������ ������������ new�ؼ� �θ� ���������� public�ۿ� �Ⱥ���

public class Safari extends Zoo {
// ��� ����� ���������

	public static void main(String[] args) {
		Zoo z = new Zoo(); // �θ� ����

		z.tiger();
		// z.giraffe();
		// z.elephant();
		// z.lion();
		
// ���� �ڽ�Ŭ����(sub)�� �����Ѵٸ�? 
		System.out.println("-------------");
		Safari s = new Safari(); // �ڽ��� ����
		s.tiger();
		s.giraffe();
		// s.elephant();
		// s.lion();
	}

}
