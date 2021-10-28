package swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx2 extends JFrame implements ActionListener {
	private List<PersonDTO> list;
	private DefaultTableModel model; // AbstractTableModel�� ���൵ �������� Default�� �� ���� ����
	private JTable table;
	private JButton addBtn, delBtn;

	public JTableEx2() {
		list = new ArrayList<PersonDTO>();
		// PersonDTO�� ����ְ� �Ǹ�~~
		list.add(new PersonDTO("hong", "ȫ�浿", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "�ڳ�", "333", "010-777-7777")); // �� �ٴ� vector�� ���������

		// Ÿ��Ʋ
		Vector<String> vector = new Vector<String>();
		vector.addElement("���̵�");
		vector.addElement("�̸�"); // addElement�� add �Ѵ� ����
		vector.add("��й�ȣ");
		vector.add("�ڵ���");

		// model ����
		model = new DefaultTableModel(vector, 0) {
// vectorŸ��Ʋ�� ������ ����, ���̺� �� �� ���� �̸� �ϳ� ������ּ��� - 1
// ����� ������ ������ - 0
// �� �ϳ��� �籸���ϰ� �ʹ��ϸ� �͸��� ���ָ� �ȴ�
// DefaultTableModel�� �߻�Ŭ������ �ƴѵ� �͸��� �ᵵ �ɱ�? - YES

			@Override
			public boolean isCellEditable(int row, int column) {
				// ���� ? �� : ����;
				return column == 0 ? false : true; // 0��° �ุ ������ �ȵǰ� �������� �� ��
			}
		};
		table = new JTable(model); // Table�� model�� �־��
		JScrollPane scroll = new JScrollPane(table); // table�� scroll�� �־��

		// ��ư
		addBtn = new JButton("�߰�");
		delBtn = new JButton("����");

		// �гο� ��ư �߰����ֱ�
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(addBtn);
		p.add(delBtn);

		// ������
		for (PersonDTO dto : list) { // list�ϳ��� vector�ϳ��� �������� �Ѵ�
			Vector<String> v = new Vector<String>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getPhone());

			model.addRow(v); // Vector�� �𵨿��� �ٿ���
		}

		Container c = this.getContentPane();
		c.add(scroll);
		c.add("South", p);
		// Panel�� ����� �ٴ� ������ �ֱ� ������ ������ ����������

		setBounds(900, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// �̺�Ʈ
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
	} // JTableEx2()

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBtn) { // �߰�
			insert();

		} else if (e.getSource() == delBtn) { // ����
			delete();
		}
	}

	private void delete() {
		boolean value = false;

		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		int i;

		for (i = 0; i < model.getRowCount(); i++) {
			if (name.equals(model.getValueAt(i, 0))) {
				JOptionPane.showInputDialog(this, "���� �̸��Դϴ�");
				value = true;
				break;
			}
		}
		if (value == false) {
			Vector<String> v = new Vector<String>();
			v.add(name);

			for (i = 0; i < model.getRowCount(); i++) {
				if (name.equals(model.getValueAt(i, 1))) { // �̸��� ���� ����� ����
					model.removeRow(i);
					i = -1;
				}
			}
		}
	}

	private void insert() {
		boolean value = false;
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		if (!id.equals("")) {
			for (int i = 0; i < model.getRowCount(); i++) {
				if (id.equals(model.getValueAt(i, 0))) {
					JOptionPane.showMessageDialog(this, "��� ���� ���̵��Դϴ�");
					value = true;
					break;
				}
			}
			if (value == false) {
				String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
				String pwd = JOptionPane.showInputDialog(this, "��й�ȣ�� �Է��ϼ���");
				String number = JOptionPane.showInputDialog(this, "��ȭ��ȣ�� �Է��ϼ���");
				// Vector�� �� �߰��ϱ�
				Vector<String> v = new Vector<String>();
				v.add(id);
				v.add(name);
				v.add(pwd);
				v.add(number);

				JOptionPane.showMessageDialog(this, "��� �Ϸ�");
				model.addRow(v);
			}
		}
	}

	public static void main(String[] args) {
		new JTableEx2();
	}

}

// �߻� Ŭ������ �ݵ�� �߻� �޼ҵ带 �ʼ������� ������Ѵ�
// ������ default�� �Ϲ� Ŭ������ �������̷� ����

// Component�� ������ ���� ����, ����
//Button/JButton, TextField/JTextField

//���������� ���� ���ϴ� Container������ Frame/JFrame(���� �����̳�), Dialog
// �� ��ɵ��� ��� ���� Container ����
// Frame�� Frame���� �� �ö󰣴� ���� ���� ���������
// JMenuBar�� contentPane�� ���� �ٸ� Container�̴�
