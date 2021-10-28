package swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

//JFrame�� BorderLayout(��������)
public class JListEx extends JFrame {

	public JListEx() {
		super("JList Test"); // �θ� ������ ȣ��

		setLayout(new FlowLayout());
		// List�� ���ڵ��� �پ ������ �� setLayout�� FlowLayout���� ��Ƴ��� ����.
		// ���� ���� �ִ� �� �߾��� �������� ������� �ٿ��ְ� �ȴ�.

		String[] listData = { "Hong", "Gil", "Dong", "JAVA", "JSP" };
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1);

		// JList �ٱ��� �����ִ� �۾� - ����(�θ�)
		// �ȿ� �ִ� �����͸� �ִ� ���� �ϴ� �۾��� DefaultListModel - �Ŵ���(�ڽ�)
		// �����Ͱ� ������ �׸��� ���ڿ��̰� (model)�� �Ŵ���
		// model�� ���õ� JList�� �ۼ��ؼ� �ִ� ��

		// Model�� ���� �ϰų�~~~
		// DefaultListModel<String> model = new DefaultListModel<String>();
		// JList<String> list2 = new JList<String>(model);

		// =
		// List�� ���� ��� Model�� �ڵ������ �ϰų�~~~
		JList<String> list2 = new JList<String>(new DefaultListModel<String>());
		DefaultListModel<String> model = (DefaultListModel<String>) list2.getModel(); // �׻� �θ�� �ڽĿ��� ���缭 �����Ѵ�
		// �θ��� ListModel�� �ڽ��� DefaultListModel�� �ٲ㼭 Casting�� ������ ������� �Ѵ�

		model.addElement("���");
		model.addElement("��");
		model.addElement("����");
		model.addElement("�ٳ���");
		list2.setSelectedIndex(1);
		// Index 1���� ���������� "��"�� ����

		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("�౸");
		vListData.add("�߱�");
		vListData.add("��");
		vListData.add("�豸");
		vListData.add("�״Ͻ�");
		vListData.add("����");
		vListData.add("����");
		vListData.add("�±ǵ�");
		vListData.add("����");

		class Student { // �и��� �����ڶ�� �޼ҵ� �ȿ� Ŭ������ �����ؼ� ����?
			// �����̳� ���? �ѹ� ���ڴ�
			String id;
			String name;
			String department;

			// �����ڸ� ����!
			// ��Ŭ�� - Source - Generator Constructor using field
			public Student(String id, String name, String department) {
				super();
				this.id = id;
				this.name = name;
				this.department = department;
			}

			@Override
			public String toString() { // �ּҰ� �ƴ� �̸����� ������ �ϱ� ���ؼ�
				return name; // �̸��� ȭ�鿡 ������ ���ھ�
			}
		}

		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		// ���ڿ��� �ƴ� student��� Ŭ���� ��ü���� ��ڴ�
		DefaultListModel<Student> model2 = (DefaultListModel<Student>) list4.getModel();
		// getmodel�� ������� casting �ɾ�����
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �ϳ��� �����ϰ� �;��
		model2.addElement(new Student("100", "ȫ�浿", "�����"));
		model2.addElement(new Student("200", "�տ���", "�����"));
		model2.addElement(new Student("300", "�����", "����"));
		model2.addElement(new Student("400", "���Ȱ�", "�濵��"));
		list4.setSelectedIndex(1);

		add(list1);
		add(list2);
		add(scroll);
		// add(list3); ��� �ϸ� scroll�� ������ ������ �ʴ´�
		// ��? list�� scroll�� ���ٺٿ��� ������(JScrollPane scroll = new JScrollPane(list3);)
		// Frame�� ���� ���� list�� �ƴ� scroll�� �ٿ��� �Ѵ�.
		add(list4);

		setBounds(900, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JListEx();
	}
}
