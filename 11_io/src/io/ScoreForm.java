package io;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScoreForm extends JFrame implements ActionListener {
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton inputBtn, printBtn, searchBtn, rankBtn, saveBtn, loadBtn;
	private DefaultTableModel model;
	private JTable table;
	private Score score; // inteface ���

	public ScoreForm() {
		// JLabel ����
		hakL = new JLabel("�й�");
		nameL = new JLabel("�̸�");
		korL = new JLabel("����");
		engL = new JLabel("����");
		mathL = new JLabel("����");

		// JTextField ����
		hakT = new JTextField("", 22); // ũ��(22)�� ���ָ� �ɱ׶���
		// TextField�� ũ�Ⱑ ���� ������ �����Ͱ� �� ������ �־�� �ϴϱ� ũ�⸦ ����ش�
		nameT = new JTextField("", 22);
		korT = new JTextField("", 22);
		engT = new JTextField("", 22);
		mathT = new JTextField("", 22);

		// JButton ����
		inputBtn = new JButton("�Է�");
		printBtn = new JButton("���");
		searchBtn = new JButton("�й��˻�");
		rankBtn = new JButton("����");
		saveBtn = new JButton("��������");
		loadBtn = new JButton("�����б�");

		// JTable�� Ÿ��Ʋ
		Vector<String> vector = new Vector<String>();
		vector.add("�й�");
		vector.add("�̸�");
		vector.add("����");
		vector.add("����");
		vector.add("����");
		vector.add("����");
		vector.add("���");

		model = new DefaultTableModel(vector, 0);
		table = new JTable(model);
		// ȭ�鿡 �ѷ��ִ� �� Table. �� �ȿ��� �����͸� �ִ� ���� �ϴ� ������ model�� �Ѵ�
		JScrollPane scroll = new JScrollPane(table);

		score = new ScoreImpl();

		// Panel ����
		// West - ����
		JPanel hakP = new JPanel(); // ���� �г� ����
		hakP.add(hakL); // ���� �󺧰�
		hakP.add(hakT); // ���� �ؽ�Ʈ�ʵ带 �־��ְ�
		JPanel nameP = new JPanel();
		nameP.add(nameL);
		nameP.add(nameT);
		JPanel korP = new JPanel();
		korP.add(korL);
		korP.add(korT);
		JPanel engP = new JPanel();
		engP.add(engL);
		engP.add(engT);
		JPanel mathP = new JPanel();
		mathP.add(mathL);
		mathP.add(mathT);

		JPanel p = new JPanel(new GridLayout(5, 1)); // ��ü �г� ���� �յ��ϰ� �г��� �� �־���(5��, 1��)
		p.add(hakP); // ���� �г�
		p.add(nameP); // �̸� �г�
		p.add(korP); // ���� �г�
		p.add(engP); // ���� �г�
		p.add(mathP); // ���� �г�

		JPanel p2 = new JPanel(new GridLayout(1, 6, 5, 5)); // �� �ٸ� �г�(p2)�� �Է�, ���, �й��˻�, ����, ��������, �����б� ��ư�� �־���
		p2.add(inputBtn);
		p2.add(printBtn);
		p2.add(searchBtn);
		p2.add(rankBtn);
		p2.add(saveBtn);
		p2.add(loadBtn);

		Container c = getContentPane(); // �г��� �־��� Container�� ����
		c.add("West", p); // ���ʿ� p��
		c.add("South", p2); // ���ʿ� p2��
		c.add("Center", scroll); // scroll�� �⺻ ���Ϳ� ��ġ

		setBounds(900, 100, 700, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// �̺�Ʈ
		event(); // event �Լ� ȣ��!
		// ������ �̺�Ʈ �ȿ� 6���� ��ư���� �̺�Ʈ���� �� ����������
		// ���ݺ��� �ξ� �� ���� �̺�Ʈ���� �ٷ� �� ������ event�Լ��� �������
		// event�޼ҵ带 ���� �� ȣ�� �ϴ� ������ ����� �� ���̴�~~~

	} // ScoreForm() - ������ ��!

	// �޼ҵ�� ���� ���� �� �ֿ�
	public void event() {
		inputBtn.addActionListener(this);
		printBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		loadBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ��ư���� �� �Ѿ���ϱ�~
		if (e.getSource() == inputBtn) { // �Ѿ���� ��ư�� inputBtn�̳�~
			input();

			// ���� �����͸� model���� �־�� �ϰ� �� model�� Impl���� �Ѹ����� �����͸� �����ؾ� �Ѵ�
			// �����͸� �����Ϸ��� list�� �ʿ��ϴ�. (list ��� DB�� ���⵵)

			// score.print(model);
			// ScoreImpl������ JTable�� �ִ��� ������ �𸣴�
			// model�� ��������Ѵ� �׷��� Table�� ���õ� ���� �� �� �ִ�
			// �����͸� �ְ� ���� ������ model�� �ϰ� �����ϱ�
			// score�� interface�� Score interface�� ���������

		} else if (e.getSource() == printBtn) { // printBtn�̳�~
			score.print(model);
			
		} else if (e.getSource() == searchBtn) { // searchBtn�̳�~
			score.search(model);
			
		} else if (e.getSource() == rankBtn) { // rankBtn�̳�~
			score.tot_desc();
			score.print(model);
			
		} else if (e.getSource() == saveBtn) { // saveBtn�̳�~
			score.save();
			
		} else if (e.getSource() == loadBtn) { // loadBtn�̳�~
			score.load();
			score.print(model); // ���� �ȿ� �ִ� �� �о����
			
		}

	} // actionPerformed(ActionEvent e)

	private void input() {
		// JTextField�� �Էµ� ������ ���
		String hak = hakT.getText(); // hak TextField�� hak ������ ��������
		// �׷��� �����Ͱ� ���Դ� �� ��� Ȯ���� �� ������?
		// = if(hak.equals("")) {
		if (hak.length() == 0) { // ���ڼ��� 0? �ƹ� ���ڵ� ������ �ʾҴٴ� ��
			JOptionPane.showMessageDialog(this, "�й��� �Է��ϼ���");
			return;
		}
		String name = nameT.getText();
		int kor = Integer.parseInt(korT.getText()); // TextField�� ������ �� ��� ���ڿ��̴�. ���ڿ� ���ڷ� �ٲ������
		int eng = Integer.parseInt(engT.getText()); //
		int math = Integer.parseInt(mathT.getText());

		// ���
		int tot = kor + eng + math;
		double avg = (double) tot / 3;

		ScoreDTO dto = new ScoreDTO(); // DTO�� ���� ScoreDTO�ȿ� �����͵��� �Ѱ����� ��ƾ� �����͸� ��� �ٴϱ� ���ϴ�
		dto.setHak(hak);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMath(math);
		dto.setTot(tot);
		dto.setAvg(avg);

		// ù��° ��� - ScoreDTO�� list�� ��Ƽ� JTable�� �Ѹ���...���Ͽ� ����
		score.intput(dto);
		// �ι�° ���- ScoreDTO�� ������ ScoreDAO.java���� DB�� insert�Ѵ�

		// �ʱ�ȭ - �Է��� �ϰ� �����ϰ� ���� �ٽ� �Է��� �� �ֵ��� �Է°��� �ʱ�ȭ������� �Ѵ�
		// �����ϰ��� ���� ������ ������ �� ������
		hakT.setText("");
		nameT.setText("");
		korT.setText("");
		engT.setText("");
		mathT.setText("");
	}
}

// �Է� ��ư�� ������ ���ÿ� ActionPerformed������ �Ѿ�ͼ� actionperformed���� inputBtn�Դϱ�?
// �ϰ� Ȯ���� �� input�޼ҵ�� ������

// �ڹٿ��� null�� �ϳ��� ����� �ν��Ѵ�
// �������
// String a = null;		String b = "";
// a + "apple"			b = "apple"
// "nullapple"				"apple"
// -> �����̳� ���꿡�� null�� ��������� �ȵȴ�. null�� ��ü�� �������� ����

// �ڹٰ� �����ϴ� �޼ҵ�� throws�� �ȵȴ�

