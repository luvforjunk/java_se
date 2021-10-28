package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class JTableModel extends AbstractTableModel { // AbstractTableModel�� �߻�Ŭ����
//	Object[][] data = {{"Nari","����ġ",new Integer(1234), "����ģ��"},
//					   {"One","������",new Integer(1111),"������"},
//			  		   {"tow","������",new Integer(2222),"�Ϳ�����"},
//					   {"three","�ƶ�ġ",new Integer(3333),"���Ƹ� ģ��"}};

	// new Integer(1234)

	// JDK 9���ʹ� Wrapper Class�� �����ڰ� ������� AutoBoxing
	// �⺻���� �ᵵ Object�� ��üŸ������ ����. �ڵ����� Integer�Ǿ ���ٴ� �ǹ�
	Object[][] data = { { "Nari", "����ġ", 1234, "����ģ��" }, { "One", "������", 1111, "������" }, { "two", "������", 2222, "�Ϳ�����" },
			{ "three", "�ƶ�ġ", 3333, "���Ƹ� ģ��" } };
	// �ڵ����� new Integer������ �ϴ� AutoBoxingó���� ���ش�
	// JDK 9���ʹ� Wrapper Class�� �����ڰ� ������� AutoBoxing

	String[] name = { "���̵�", "�̸�", "��й�ȣ", "����" }; // �ʵ�� - Column

	// �߻�޼ҵ带 Override�ؼ� ���
	@Override
	public int getRowCount() { // ���� ����
		return data.length;
	}

	@Override
	public int getColumnCount() { // ���� ����
		return name.length;
	}

	@Override
	public Object getValueAt(int r, int c) { // ���� ��ġ, ���� ��ġ.
		return data[r][c];
	}

	@Override
	public void setValueAt(Object ob, int r, int c) { // ���� �־��ִ� ��
		// ���� ��ġ, ���� ��ġ
		data[r][c] = ob; // ������ r�� c���� ob���� �־��
	}

	@Override // �߻�޼ҵ� �ƴ�
	public String getColumnName(int c) {// �ʵ��(����) - {"���̵�","�̸�","��й�ȣ","����"}
		return name[c];
	}

	@Override
	public boolean isCellEditable(int r, int c) {// ����Ŭ���ϸ� ���� �����ϰԲ�
		// return true; - ���� �����϶�
		// ���� ? �� : ����;
		return c == 0 ? false : true;
		// ���� 0��° Column�� ���̵� ������Ű�� �Ͱ� �������� �����ص� ������� �ϰ� �;��
	}
}

//------------------
public class JTableEx extends JFrame {
	JTable table; // �����ִ� ����
	JTableModel model; // ���� �ְ� ���� ����

	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model); // ���ϰ� �����սô�
		JScrollPane scroll = new JScrollPane(table);

		add(scroll);

		this.setBounds(900, 100, 300, 300);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTableEx();

	}

}
