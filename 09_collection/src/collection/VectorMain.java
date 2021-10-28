package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(); // �⺻�뷮 10��, 10���� ����
		System.out.println("���� ũ�� = " + v.size()); // 0 - �׸񰳼�
		System.out.println("���� �뷮 = " + v.capacity()); // 10 - ����ũ��
		System.out.println();

		System.out.println("----�׸� �߰�----");
		for (int i = 1; i <= 10; i++) {
			v.add(i + "");
		}

		v.add("5"); // collection�� �����̱� ������ �ߺ��� ����Ѵ�, ���� O
		// = v.element("5");
		System.out.println("���� ũ�� = " + v.size()); // 10 -> 11
		System.out.println("���� �뷮 = " + v.capacity()); // 10 -> 20
		System.out.println();

		for (int i = 0; i < v.size(); i++) {
			System.out.print(v.get(i) + " "); // 1 2 3 4 5 6 7 8 9 10 5
		}
		System.out.println();

		System.out.println("----�׸� ����----");
		v.remove("5"); // �տ� �ִ� "5"�� ����
		v.removeElementAt(9); // �ڿ� �ִ� "5"�� ����***
		// ex) "orange".charAt(2) ---> a

		Iterator<String> it = v.iterator(); // ����
		while (it.hasNext()) {
			System.out.print(it.next() + " "); // 1 2 3 4 6 7 8 9 10
		}
		System.out.println();

		Vector<String> v2 = new Vector<String>(5); // �⺻�뷮 5��, 2���� ����
	}

}

// ����� ������ �ߴ� ������ generic�� �ɾ��ֶ�� �ǹ�
// <String>�� �޾��ش�
