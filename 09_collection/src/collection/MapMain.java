package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(); // <Key, Value>
		map.put("book101", "�鼳����");
		map.put("book201", "�ξ����");
		map.put("book102", "�鼳����"); // Value �ߺ����
		map.put("book301", "�ǿ���");
		map.put("book101", "��������"); // Key �ߺ����

		// �� ��������
		System.out.println(map.get("book102")); // �鼳����
		System.out.println(map.get("book103")); // null
		System.out.println(map.get("book101")); // ��������
		
		//map�� �׻� Ű�� �����Ѵ�. Ű���� �־��ָ� ������� �����ش�
	}
}
