package miniproject1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menu extends JFrame {
	private String menu[]; // �޴��̸�
	private int price[]; // ����
	private JButton bt[] = new JButton[6]; // �޴����� ��Ʈ
	private RoundedButton ok[] = new RoundedButton[6]; // �� �޴��� Ȯ�ι�ư
	private JTextField su[] = new JTextField[6]; // ����
	private RoundedButton minus[] = new RoundedButton[6]; // ���̳ʽ���ư
	private RoundedButton plus[] = new RoundedButton[6]; // �÷�����ư
	private JLabel l[] = new JLabel[6]; // �޴�, ���� ǥ�� ��

	private ImageIcon icon1, icon2, icon3, icon4, icon5, icon6;
	private RoundedButton back, order, home, reset, next;
	int total[] = new int[6]; // ���հ�
	int totalsu[] = new int[6]; // �Ѱ���
	int count = 0;
	private String show = ""; // ta�� ������ menu�̸�
	int totalprint;
	int totalsuprint;

	public Menu(String id, String pwd) {
		AmasvinDAO dao = AmasvinDAO.getInstance();
		String name = dao.loginMember(id, pwd);
		setTitle("�ݰ����ϴ�, " + name + "�� �Ƹ������Դϴ�");

		String menu[] = { "   ���ڿ�����", "ȭ��Ʈ������", "   ��Ʈ������", "   Ÿ�ν���ũ", "   ��н���ũ", "   �ڸ�������" };
		int price[] = { 5500, 5500, 5500, 5000, 5000, 5000 };

		JPanel p1 = new JPanel(new GridLayout(1, 3)); // �޴� ���� 3�� 1������ ����
		bt[0] = new JButton(menu[0]);// ��ư �̸� ����
		bt[1] = new JButton(menu[1]);
		bt[2] = new JButton(menu[2]);
		bt[0].setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		bt[1].setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		bt[2].setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		bt[0].setFocusPainted(false);
		icon1 = new ImageIcon("image/1.png");
		icon2 = new ImageIcon("image/2.png");
		icon3 = new ImageIcon("image/3.png");
		p1.add(bt[0]);
		p1.add(bt[1]);
		p1.add(bt[2]);
		bt[0].setIcon(icon1);
		bt[1].setIcon(icon2);
		bt[2].setIcon(icon3);

		JPanel p3 = new JPanel();
		minus[0] = new RoundedButton("-");
		su[0] = new JTextField(5);
		plus[0] = new RoundedButton("+");
		p3.add(minus[0]);
		p3.add(su[0]);
		p3.add(plus[0]);
		JPanel p2 = new JPanel(new GridLayout(3, 1)); // 2,3�г� 3�� 1��
		l[0] = new JLabel("                        " + price[0] + "��"); // ���ڿ����� : 5500��
		ok[0] = new RoundedButton("Ȯ��");
		p2.add(l[0]);
		p2.add(p3);
		p2.add(ok[0]);

		JPanel p4 = new JPanel();
		minus[1] = new RoundedButton("-");
		su[1] = new JTextField(5);
		plus[1] = new RoundedButton("+");
		p4.add(minus[1]);
		p4.add(su[1]);
		p4.add(plus[1]);
		JPanel p5 = new JPanel(new GridLayout(3, 1));
		l[1] = new JLabel("                        " + price[1] + "��\n");
		ok[1] = new RoundedButton("Ȯ��");
		p5.add(l[1]);
		p5.add(p4);
		p5.add(ok[1]);

		JPanel p6 = new JPanel();
		minus[2] = new RoundedButton("-");
		su[2] = new JTextField(5);
		plus[2] = new RoundedButton("+");
		p6.add(minus[2]);
		p6.add(su[2]);
		p6.add(plus[2]);
		JPanel p7 = new JPanel(new GridLayout(3, 1));
		l[2] = new JLabel("                        " + price[2] + "��");
		ok[2] = new RoundedButton("Ȯ��");
		p7.add(l[2]);
		p7.add(p6);
		p7.add(ok[2]);

		JPanel p8 = new JPanel(new GridLayout(1, 3)); // �� �޴��̸�,�ݾ�,+,-,����,Ȯ�� ��ư �� 3�� 1������ ��ġ��
		p8.add(p2);
		p8.add(p5);
		p8.add(p7);

		JPanel p9 = new JPanel(new GridLayout(2, 1)); // �޴��� ����, �ؿ� +,-,����,Ȯ�� ��ư ��ġ��
		p9.add(p1);
		p9.add(p8);

		JPanel p10 = new JPanel(new GridLayout(1, 3)); // 2��° �޴��� ���� ����
		bt[3] = new JButton(menu[3]);
		bt[4] = new JButton(menu[4]);
		bt[5] = new JButton(menu[5]);
		bt[3].setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		bt[4].setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		bt[5].setFont(new Font("�ȵ�����������", Font.BOLD, 16));

		icon4 = new ImageIcon("image/4.png");
		icon5 = new ImageIcon("image/5.png");
		icon6 = new ImageIcon("image/6.png");
		p10.add(bt[3]);
		p10.add(bt[4]);
		p10.add(bt[5]);
		bt[3].setIcon(icon4);
		bt[4].setIcon(icon5);
		bt[5].setIcon(icon6);

		JPanel p12 = new JPanel();
		minus[3] = new RoundedButton("-");
		su[3] = new JTextField(5);
		plus[3] = new RoundedButton("+");
		p12.add(minus[3]);
		p12.add(su[3]);
		p12.add(plus[3]);
		JPanel p11 = new JPanel(new GridLayout(3, 1));
		l[3] = new JLabel("                       " + price[3] + "��\n");
		ok[3] = new RoundedButton("Ȯ��");
		p11.add(l[3]);
		p11.add(p12);
		p11.add(ok[3]);

		JPanel p13 = new JPanel();
		minus[4] = new RoundedButton("-");
		su[4] = new JTextField(5);
		plus[4] = new RoundedButton("+");
		p13.add(minus[4]);
		p13.add(su[4]);
		p13.add(plus[4]);
		JPanel p14 = new JPanel(new GridLayout(3, 1));
		l[4] = new JLabel("                       " + price[4] + "��\n");
		ok[4] = new RoundedButton("Ȯ��");
		p14.add(l[4]);
		p14.add(p13);
		p14.add(ok[4]);

		JPanel p15 = new JPanel();
		minus[5] = new RoundedButton("-");
		su[5] = new JTextField(5);
		plus[5] = new RoundedButton("+");
		p15.add(minus[5]);
		p15.add(su[5]);
		p15.add(plus[5]);
		JPanel p16 = new JPanel(new GridLayout(3, 1));
		l[5] = new JLabel("                        " + price[5] + "��\n ");
		ok[5] = new RoundedButton("Ȯ��");
		p16.add(l[5]);
		p16.add(p15);
		p16.add(ok[5]);

		JPanel p17 = new JPanel(new GridLayout(1, 3));
		p17.add(p11);
		p17.add(p14);
		p17.add(p16);
		JPanel p18 = new JPanel(new GridLayout(2, 1));
		p18.add(p10);
		p18.add(p17);

		JPanel p19 = new JPanel(new GridLayout(2, 1)); // ������ ���� �޴��� 2�� �г� ��ġ��
		p19.add(p9);
		p19.add(p18);
		p19.setPreferredSize(new Dimension(500, 500)); // ������ �ֱ� ����500, ����500

		Container c = getContentPane();
		c.add(p19, "North");

		// ta : ���� 0��0�� �� ù�κп� ���̰� ��ũ�ѹ� ���ο� ����
		TextArea ta = new TextArea("      ��ǰ��          �ܰ�     ����         �հ�\n", 0, 0,
				TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setBackground(Color.white);
		ta.setFont(new Font("�ȵ�����������", Font.BOLD, 13));
		ta.setEditable(false); // ���� �Ұ���
		ta.setPreferredSize(new Dimension(500, 120)); // ������ ����
		c.add(ta, "Center");

		JPanel p20 = new JPanel(new GridLayout(1, 5)); // �� ������ ��ư �г�
		RoundedButton back = new RoundedButton("��");
		RoundedButton order = new RoundedButton("�ֹ�");
		RoundedButton home = new RoundedButton("Ȩ");
		RoundedButton reset = new RoundedButton("�ʱ�ȭ");
		RoundedButton next = new RoundedButton("����");
		p20.add(back);
		p20.add(order);
		p20.add(home);
		p20.add(reset);
		p20.add(next);
		p20.setPreferredSize(new Dimension(500, 30));
		c.add(p20, "South");

		back.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		order.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		home.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		reset.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		next.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		ta.setFont(new Font("�ȵ�����������", Font.BOLD, 16));

		for (int i = 0; i < 6; i++) {
			bt[i].setBackground(Color.WHITE);
			l[i].setFont(new Font("�ȵ�����������", Font.BOLD, 16));
			ok[i].setFont(new Font("�ȵ�����������", Font.BOLD, 13));
			su[i].setFont(new Font("�ȵ�����������", Font.BOLD, 13));
			minus[i].setFont(new Font("�ȵ�����������", Font.BOLD, 13));
			plus[i].setFont(new Font("�ȵ�����������", Font.BOLD, 13));
			ok[i].setEnabled(false); // ��ó�� �޴� Ŭ�� �� ������ ��ư ��Ȱ��ȭ
			minus[i].setEnabled(false);
			plus[i].setEnabled(false);
		}

		// setBounds(800, 100, 500, 650);
		setBounds(300, 100, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		// ����Ƽ ��ư �̺�Ʈ
		for (int i = 0; i < 6; i++) {
			int j = i;
			bt[i].addActionListener(new ActionListener() { // ����Ƽ ��ư
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false); // ��Ȱ��ȭ
					ok[j].setEnabled(true);
					count = 0;
				}
			});
			// "-" ��ư �̺�Ʈ
			minus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						su[j].setText(count + ""); // ���� �ؽ�Ʈ ������ ī��Ʈ�� �ֱ�
						ok[j].setEnabled(true);// Ȱ��ȭ
					} else {
						minus[j].setEnabled(false); // ��Ȱ��ȭ
					}
				}
			});

			// "+" ��ư �̺�Ʈ
			plus[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					su[j].setText(count + ""); // ���� �ؽ�Ʈ ������ ī��Ʈ�� �ֱ�
					ok[j].setEnabled(true);
					if (count > 0) {
						minus[j].setEnabled(true); // ��Ȱ��ȭ
					}
				}
			});

// Ȯ�� ��ư �̺�Ʈ
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					show = bt[j].getActionCommand(); // ��ư�� ��� �� ��ȯ
					total[j] = price[j] * count;
					totalsu[j] = count;
					ta.append(show + "       " + price[j] + "        " + count + "         " + total[j] + "��" + "\n");
					ok[j].setEnabled(false);
				}
			});
		}

		// �� �̺�Ʈ
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " ù �������Դϴ�.");
			}
		});

		// �ֹ� �̺�Ʈ
		order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < total.length; i++) {
					totalprint += total[i];
					totalsuprint += totalsu[i];
				}
				JOptionPane.showMessageDialog(null,
						ta.getText() + "\n" + "�� ���� ����: " + totalsuprint + "��" + "\n" + "�� �հ�: " + totalprint + "��");
				for (int i = 0; i < 6; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					su[i].setText("0");
					ta.setText("��ǰ��\t�ܰ�\t����\t�հ�\n\n");
				}
				dispose();
				new PayFrame(id, pwd, totalprint, totalsuprint);
				setVisible(false);
			}
		});
		// �ʱ�ȭ ��ư
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 6; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					su[i].setText("0");
					ta.setText("��ǰ��\t�ܰ�\t����\t�հ�\n\n");
				}
			}
		});

		// Ȩ��ư
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// dispose();
				new HomeFrame(id, pwd);
				setVisible(false);
			}
		});
		// ���� ��ư
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu2(id, pwd);
				setVisible(false);
			}
		});
	}
}