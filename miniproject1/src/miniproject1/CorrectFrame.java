package miniproject1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CorrectFrame extends JFrame {
	private JLabel nameL, idL, pwdL, pwdcheckL, emailL, phoneL;
	private JTextField nameT, idT, pwdT, pwdcheckT, emailT, phoneT;
	private RoundedButton cancelBtn, pwdcheckBtn, writeBtn, resetBtn;
	boolean idok, pwdok, emailok = false;

	public CorrectFrame(String id, String pwd) {
		AmasvinDAO dao = AmasvinDAO.getInstance();
		String name = dao.loginMember(id, pwd);
		setTitle("�ݰ����ϴ�, " + name + "�� �Ƹ������Դϴ�");

		JFrame jf = new JFrame();
		setLayout(null);

		// Label
		JPanel p = new JPanel();
		p.setLayout(null);

		nameL = new JLabel("�̸�");
		nameL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		nameL.setBounds(133, 50, 70, 50);
		p.add(nameL);

		idL = new JLabel("���̵�");
		idL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		idL.setBounds(115, 120, 70, 50);
		p.add(idL);

		pwdL = new JLabel("��й�ȣ");
		pwdL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		pwdL.setBounds(98, 190, 70, 50);
		p.add(pwdL);

		pwdcheckL = new JLabel("��й�ȣ ���Է�");
		pwdcheckL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		pwdcheckL.setBounds(48, 260, 130, 50);
		p.add(pwdcheckL);

		emailL = new JLabel("�̸���");
		emailL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		emailL.setBounds(113, 330, 100, 50);
		p.add(emailL);

		phoneL = new JLabel("�޴��� ��ȣ");
		phoneL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		phoneL.setBounds(90, 400, 100, 50);
		p.add(phoneL);

		// TextField
		nameT = new JTextField();
		nameT.setBounds(200, 50, 250, 50);
		p.add(nameT);

		idT = new JTextField();
		idT.setBounds(200, 120, 250, 50);
		p.add(idT);

		pwdT = new JTextField();
		pwdT.setBounds(200, 190, 250, 50);
		p.add(pwdT);

		pwdcheckT = new JTextField();
		pwdcheckT.setBounds(200, 260, 250, 50);
		p.add(pwdcheckT);

		emailT = new JTextField();
		emailT.setBounds(200, 330, 250, 50);
		p.add(emailT);

		phoneT = new JTextField();
		phoneT.setBounds(200, 400, 250, 50);
		p.add(phoneT);

		// Button
		writeBtn = new RoundedButton("����");
		writeBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		resetBtn = new RoundedButton("�ٽ� �ۼ�");
		resetBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		pwdcheckBtn = new RoundedButton("��ġ Ȯ��");
		pwdcheckBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		cancelBtn = new RoundedButton("���");
		cancelBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		pwdcheckBtn.setBounds(470, 260, 130, 50);
		pwdcheckBtn.setBackground(new Color(255, 255, 204));
		p.add(pwdcheckBtn);
		writeBtn.setBounds(120, 530, 130, 60);
		resetBtn.setBounds(280, 530, 130, 60);
		cancelBtn.setBounds(440, 530, 130, 60);

		JPanel p2 = new JPanel();
		p2.setBackground(new Color(197, 238, 245));
		p2.add(writeBtn);
		writeBtn.setBackground(new Color(255, 255, 204));

		p2.add(resetBtn);
		resetBtn.setBackground(new Color(255, 255, 204));

		p2.add(cancelBtn);
		resetBtn.setBackground(new Color(255, 255, 204));

		Container c = getContentPane();
		c.setBackground(new Color(197, 238, 245));
		c.add("North", p);
		c.add("South", p2);

		c.add(nameL);
		c.add(nameT);
		c.add(idL);
		c.add(idT);
		c.add(pwdL);
		c.add(pwdT);
		c.add(pwdcheckL);
		c.add(pwdcheckT);
		c.add(pwdcheckBtn);
		c.add(emailL);
		c.add(emailT);
		c.add(phoneL);
		c.add(phoneT);
		c.add(writeBtn);
		c.add(resetBtn);
		c.add(cancelBtn);

		setBounds(400, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		writeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (nameT.getText().isEmpty() || idT.getText().isEmpty() || pwdT.getText().isEmpty()
						|| emailT.getText().isEmpty() || phoneT.getText().isEmpty() || pwdcheckT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "��� �ۼ����ּ���");
					return;
				} else if (pwdok == false) {
					JOptionPane.showMessageDialog(null, "��й�ȣ Ȯ�� �ϼ���");
					return;
				} else {
					String name = nameT.getText();
					String id = idT.getText();
					String pwd = pwdT.getText();
					String email = emailT.getText();
					String phone = phoneT.getText();

					// DB
					AmasvinDAO dao = AmasvinDAO.getInstance();
					dao.UpdateMember(name, pwd, email, phone, id);

					JOptionPane.showMessageDialog(null, "���� �Ǿ����ϴ�");

					dispose();
					new HomeFrame(id, pwd);
					setVisible(false);
				}
			}
		});

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HomeFrame(id, pwd);
				setVisible(false);
			}
		});

		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nameT.setText("");
				idT.setText("");
				pwdT.setText("");
				emailT.setText("");
				phoneT.setText("");
				pwdcheckT.setText("");
			}
		});

		pwdcheckBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pwdT.getText().equals(pwdcheckT.getText())) {
					pwdok = true;

					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ�մϴ�");
				} else {
					pwdok = false;
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�." + "\n" + "�ٽ� �Է��ϼ���.");
					pwdcheckT.setText("");
					// writeBtn.setEnabled(false);
				}
			}
		});

	}
}