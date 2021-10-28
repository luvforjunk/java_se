package miniproject1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PayFrame extends JFrame {
	private JLabel nameL, cardL, cardnumL, phoneL, emailL, totalL, couponL2, couponL3, couponL4, couponL5;
	private JLabel usernameL, userphoneL, useremailL;
	private RoundedButton okBtn, exitBtn, usecoupon;
	private JComboBox<String> combo;

	public PayFrame(String id, String pwd, int totalprint, int totalsuprint) {
		AmasvinDAO dao = AmasvinDAO.getInstance(); // �̱������� �ٲ�
		String name = dao.loginMember(id, pwd);
		String email = dao.UserEmail(id, pwd);
		String phone = dao.UserPhone(id, pwd);

		nameL = new JLabel("     ������ ����");
		cardL = new JLabel("     ī��縦 �������ּ���");
		cardnumL = new JLabel("     ī�� ��ȣ�� �Է����ּ���");
		phoneL = new JLabel("     ����ó");
		emailL = new JLabel("     �̸���");
		totalL = new JLabel("     �� �����ݾ�");

		couponL2 = new JLabel("���� 1�� ���� ���� ");
		couponL3 = new JLabel("��");
		int cnum = dao.couponnum(id, pwd);
		couponL4 = new JLabel(String.valueOf(cnum));
		couponL5 = new JLabel("�� ����");
		usecoupon = new RoundedButton("����ϱ�");

		JPanel p1 = new JPanel(new GridLayout(1, 2));
		JPanel p2 = new JPanel(new GridLayout(1, 2));
		JPanel p3 = new JPanel(new GridLayout(1, 2));
		JPanel p4 = new JPanel(new GridLayout(1, 2));
		JPanel p5 = new JPanel(new GridLayout(1, 2));
		JPanel p6 = new JPanel(new GridLayout(1, 2));
		p1.setBackground(new Color(255, 255, 255));
		p2.setBackground(new Color(255, 255, 255));
		p3.setBackground(new Color(255, 255, 255));
		p4.setBackground(new Color(255, 255, 255));
		p5.setBackground(new Color(255, 255, 255));
		p6.setBackground(new Color(255, 255, 255));
		p1.add(nameL);
		p2.add(cardL);
		p3.add(cardnumL);
		p4.add(phoneL);
		p5.add(emailL);
		p6.add(totalL);

		String[] card = { "����", "��", "����", "�Ե�", "�츮", "�ϳ�", "�ϳ�(��)��ȯ", "����", "���" };
		JPanel cardnumcoupon = new JPanel(new GridLayout(2, 1));
		cardnumcoupon.setBackground(new Color(255, 255, 255));
		JLabel hyphen1 = new JLabel("-");
		JLabel hyphen2 = new JLabel("-");
		JLabel hyphen3 = new JLabel("-");
		JTextField cn1 = new JTextField(4);
		JTextField cn2 = new JTextField(4);
		JTextField cn3 = new JTextField(4);
		JTextField cn4 = new JTextField(4);
		JPanel c1 = new JPanel();
		c1.setBackground(new Color(255, 255, 255));
		JPanel c2 = new JPanel();
		c2.setBackground(new Color(255, 255, 255));
		c1.add(cn1);
		c1.add(hyphen1);
		c1.add(cn2);
		c1.add(hyphen2);
		c1.add(cn3);
		c1.add(hyphen3);
		c1.add(cn4);

		c2.add(couponL2);
		c2.add(couponL3);
		c2.add(couponL4);
		c2.add(couponL5);
		c2.add(usecoupon);
		cardnumcoupon.add(c1);
		cardnumcoupon.add(c2);

		combo = new JComboBox<String>(card);
		usernameL = new JLabel(name);
		useremailL = new JLabel(email);
		userphoneL = new JLabel(phone);
		String total = "5000��";
		JLabel l = new JLabel(String.valueOf(totalprint) + "��");
		p1.add(usernameL);
		p2.add(combo);
		p3.add(cardnumcoupon);
		p4.add(userphoneL);
		p5.add(useremailL);
		p6.add(l);
		JPanel p7 = new JPanel(new GridLayout(6, 1));
		p7.setBackground(new Color(255, 255, 255));
		p7.add(p1);
		p7.add(p2);
		p7.add(p3);
		p7.add(p4);
		p7.add(p5);
		p7.add(p6);

		Container c = getContentPane();

		c.setBackground(new Color(255, 255, 255));
		c.add(p7, "Center");

		JPanel btn = new JPanel();
		btn.setBackground(new Color(255, 255, 255));
		okBtn = new RoundedButton("������û");
		exitBtn = new RoundedButton("�ݱ�");
		btn.add(okBtn);
		btn.add(exitBtn);

		c.add(btn, "South");

		nameL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		cardL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		cardnumL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		phoneL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		emailL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		totalL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		couponL2.setFont(new Font("�ȵ�����������", Font.BOLD, 12));
		couponL3.setFont(new Font("�ȵ�����������", Font.BOLD, 12));
		couponL4.setFont(new Font("�ȵ�����������", Font.BOLD, 12));
		couponL5.setFont(new Font("�ȵ�����������", Font.BOLD, 12));
		// usernameL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		// userphoneL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		// useremailL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		// cardnumT.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		okBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		exitBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		usecoupon.setFont(new Font("�ȵ�����������", Font.BOLD, 12));

		setVisible(true);
		setBounds(400, 200, 500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (cn1.getText().isEmpty() || cn2.getText().isEmpty() || cn3.getText().isEmpty()
						|| cn4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ī���ȣ�� �Է����ּ���");
					return;
				} else {
					JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�. �����մϴ�");
					AmasvinDAO dao = AmasvinDAO.getInstance();
					for (int i = 1; i <= totalsuprint; i++) {
						dao.addstamp(id, pwd);
					}
					dispose();

					try {
						new HomeTimer(id, pwd);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					setVisible(false);
				}
			}
		});

		usecoupon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cnum != 0) {
					JOptionPane.showMessageDialog(null, "���� ������� ���� �Ϸ�Ǿ����ϴ�." + "\n" + "�����մϴ�.");
					AmasvinDAO dao = AmasvinDAO.getInstance();
					dao.resetcoupon(id, pwd);
					dispose();
					new HomeFrame(id, pwd);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�");
					return;
				}

			}
		});
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				new HomeFrame(id, pwd);
				setVisible(false);

			}
		});

	}

}