package collection;

import java.util.LinkedList;
import static java.lang.System.out;

public class QueueMain {

	public static void main(String[] args) {
		String[] item = { "�ҳ�Ÿ", "������", "���Ծ�" };
		LinkedList<String> q = new LinkedList<String>();

		for (String n : item) // �߰�ȣ�� ���ƴٴ� �� �ݺ��Ǵ� �� �� ���� �������
			q.offer(n); // ��� �߰�

		out.println("q�� ũ�� : " + q.size() + "\n");

		String data = "";

		while ((data = q.poll()) != null) { // �ҳ�Ÿ�� �ΰ��� �ƴϴ�?
			out.println(data + " ����!"); // �ΰ��� �ƴ϶�� ������ ������ �����ͼ� �ҳ�Ÿ ���
			out.println("q�� ũ�� : " + q.size() + "\n"); // ������� �ΰ� ���Ҵ�
		}

	}

}
