package collection;

import java.util.ArrayList;

public class PersonMain {
	// public void init() {
	public ArrayList<PersonDTO> init() { // ����
		PersonDTO aa = new PersonDTO("ȫ�浿", 25); // ���� aa. ����(X)
		PersonDTO bb = new PersonDTO("���̾�", 30);
		PersonDTO cc = new PersonDTO("����ġ", 28);

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);

		return list;
		// return aa, bb, cc;
		// java�� �Ѱ��ۿ� return ��ų �� ������
		// ��� main���� �Ѱ�����
		// PersonDTO���� ���ſ�� �� �ּҰ��� main���� �����ִ� ���̴�
	}// init()

	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		ArrayList<PersonDTO> list = pm.init();// ȣ��
		System.out.println("list = " + list); // [~~~]

		for (int i = 0; i < list.size(); i++) {
			System.out.println("�̸� = " + list.get(i).getName() + "\t" + "���� = " + list.get(i).getAge());
		}
		System.out.println();

		for (PersonDTO dto : list) { // ����!!!
			System.out.println("�̸� = " + dto.getName() + "\t���� = " + dto.getAge());
		}
		System.out.println();
	}
}
