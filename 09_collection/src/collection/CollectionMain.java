package collection;

import java.util.ArrayList; // �迭�� ��� - index�� ����
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {

	// @SuppressWarnings("all")
	@SuppressWarnings({ "rawtypes", "unchecked" }) // - 1.�Ҵ� ������ �ȿ�� �ϴ� ���
	public static void main(String[] args) {
		Collection coll = new ArrayList(); // Array�� Collection�� ���� �������̵� ���ְ� ����
		//ArrayList list = new ArrayList(); �߻�Ŭ������ �ƴϴ� �� ó���� �� ����

		coll.add("ȣ����");
		coll.add("����");
		coll.add("ȣ����"); // �ߺ� ���, ����
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");

		Iterator it = coll.iterator(); // ����
		while (it.hasNext()) { // ���� ��ġ�� �׸��� ������ True
			System.out.println(it.next()); // �����ְ� ����! �����ְ� ����!
		} // while
	}
}

// �迭�� Ȯ���ϰ� �����Ͱ� ������ ��
// �׷��� ���� ��쿣 Collection
// ��ü�� ����ִ� ����� ������ �ϸ鼭 ������ ũ�� ��ȯ�� �����ϴ�
