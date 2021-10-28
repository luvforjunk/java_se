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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class WriteFrame extends JFrame {
	private JLabel nameL, idL, pwdL, pwdcheckL, emailL, emailcheckL, phoneL;
	private JTextField nameT, idT, emailT, emailcheckT, phoneT;
	private JPasswordField pwdT, pwdcheckT;
	private RoundedButton checkBtn, pwdcheckBtn, emailcheckBtn, okBtn, writeBtn, resetBtn, loginBtn;
	static int num = (int) ((Math.random() * 8999) + 1000);
	boolean idok, pwdok, emailok = false;

	// static int count=0;
	public WriteFrame() {
		JFrame jf = new JFrame();
		setLayout(null);

		// Label
		JPanel p = new JPanel();
		p.setLayout(null);

		nameL = new JLabel("�̸�");
		nameL.setBounds(133, 50, 70, 50);
		p.add(nameL);

		idL = new JLabel("���̵�");
		idL.setBounds(115, 120, 70, 50);
		p.add(idL);

		pwdL = new JLabel("��й�ȣ");
		pwdL.setBounds(98, 190, 70, 50);
		p.add(pwdL);

		pwdcheckL = new JLabel("��й�ȣ ���Է�");
		pwdcheckL.setBounds(48, 260, 130, 50);
		p.add(pwdcheckL);

		emailL = new JLabel("�̸���");
		emailL.setBounds(113, 330, 100, 50);
		p.add(emailL);

		emailcheckL = new JLabel("������ȣ �Է�");
		emailcheckL.setBounds(70, 400, 100, 50);
		p.add(emailcheckL);

		phoneL = new JLabel("�޴��� ��ȣ");
		phoneL.setBounds(90, 470, 100, 50);
		p.add(phoneL);

		// TextField
		nameT = new JTextField();
		nameT.setBounds(200, 50, 250, 50);
		p.add(nameT);

		idT = new JTextField();
		idT.setBounds(200, 120, 250, 50);
		p.add(idT);

		pwdT = new JPasswordField();
		pwdT.setBounds(200, 190, 250, 50);
		p.add(pwdT);

		pwdcheckT = new JPasswordField();
		pwdcheckT.setBounds(200, 260, 250, 50);
		p.add(pwdcheckT);

		emailT = new JTextField();
		emailT.setBounds(200, 330, 250, 50);
		p.add(emailT);

		emailcheckT = new JTextField();
		emailcheckT.setBounds(200, 400, 250, 50);
		p.add(emailcheckT);

		phoneT = new JTextField();
		phoneT.setBounds(200, 470, 250, 50);
		p.add(phoneT);

		// Font
		Font labelF = new Font("�ȵ�����������", Font.BOLD, 18);
		Font textF = new Font("�ȵ�����������", Font.PLAIN, 18);
		Font ButtonF = new Font("�ȵ�����������", Font.BOLD, 17);

		nameL.setFont(labelF);
		nameT.setFont(textF);
		idL.setFont(labelF);
		idT.setFont(textF);
		pwdL.setFont(labelF);
		// pwdT.setFont(textF);
		pwdcheckL.setFont(labelF);
		// pwdcheckT.setFont(textF);
		emailL.setFont(labelF);
		emailT.setFont(textF);
		emailcheckL.setFont(labelF);
		emailcheckT.setFont(textF);
		phoneL.setFont(labelF);
		phoneT.setFont(textF);

		// Button
		writeBtn = new RoundedButton("���");
		resetBtn = new RoundedButton("�ٽ� �ۼ�");
		checkBtn = new RoundedButton("�ߺ�üũ");
		loginBtn = new RoundedButton("�α���â");

		checkBtn.setBounds(480, 120, 125, 50);
		checkBtn.setBackground(new Color(255, 255, 204));
		p.add(checkBtn);
		pwdcheckBtn = new RoundedButton("��ġ Ȯ��");
		pwdcheckBtn.setBounds(480, 260, 125, 50);
		pwdcheckBtn.setBackground(new Color(255, 255, 204));
		p.add(pwdcheckBtn);
		emailcheckBtn = new RoundedButton("������ȣ �߼�");
		emailcheckBtn.setBounds(480, 330, 125, 50);
		emailcheckBtn.setBackground(new Color(255, 255, 204));
		p.add(emailcheckBtn);
		okBtn = new RoundedButton("Ȯ��");
		okBtn.setBounds(480, 400, 125, 50);
		okBtn.setBackground(new Color(255, 255, 204));
		p.add(okBtn);

		writeBtn.setFont(ButtonF);
		resetBtn.setFont(ButtonF);
		checkBtn.setFont(ButtonF);
		pwdcheckBtn.setFont(ButtonF);
		emailcheckBtn.setFont(ButtonF);
		okBtn.setFont(ButtonF);
		loginBtn.setFont(ButtonF);

		writeBtn.setBounds(80, 560, 150, 60);
		resetBtn.setBounds(270, 560, 150, 60);
		loginBtn.setBounds(460, 560, 150, 60);

		JPanel p2 = new JPanel();
		p2.setBackground(new Color(195, 219, 242));
		p2.add(writeBtn);
		writeBtn.setBackground(new Color(255, 255, 204));

		p2.add(resetBtn);
		resetBtn.setBackground(new Color(255, 255, 204));
		loginBtn.setBackground(new Color(255, 255, 204));

		Container c = getContentPane();

		c.setBackground(new Color(197, 238, 245));
		c.add("North", p);
		c.add("South", p2);

		c.add(nameL);
		c.add(nameT);
		c.add(idL);
		c.add(idT);
		c.add(checkBtn);
		c.add(pwdL);
		c.add(pwdT);
		c.add(pwdcheckL);
		c.add(pwdcheckT);
		c.add(pwdcheckBtn);
		c.add(emailL);
		c.add(emailT);
		c.add(emailcheckBtn);
		c.add(emailcheckL);
		c.add(emailcheckT);
		c.add(okBtn);
		c.add(phoneL);
		c.add(phoneT);
		c.add(writeBtn);
		c.add(resetBtn);
		c.add(loginBtn);

		setTitle("�Ƹ����� ���̷� ���� ���α׷�");
		setBounds(300, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		writeBtn.addActionListener(new ActionListener() { // ---> db�� �� not null�߰��ʿ�!!�Ѱ�???
			@Override
			public void actionPerformed(ActionEvent e) {

				if (nameT.getText().isEmpty() || idT.getText().isEmpty() || pwdT.getText().isEmpty()
						|| emailT.getText().isEmpty() || phoneT.getText().isEmpty() || emailcheckT.getText().isEmpty()
						|| pwdcheckT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "��� �ۼ����ּ���");
					return;
				} else if (idok == false) {
					JOptionPane.showMessageDialog(null, "���̵� �ߺ� Ȯ�� �ϼ���");
					return;
				} else if (pwdok == false) {
					JOptionPane.showMessageDialog(null, "��й�ȣ Ȯ�� �ϼ���");
					return;
				} else if (emailok == false) {
					JOptionPane.showMessageDialog(null, "�̸��� �����ϼ���");
					return;
				} else
					JOptionPane.showMessageDialog(null, "ȸ������ �Ǿ����ϴ�");

				// ������
				String name = nameT.getText();
				String id = idT.getText();
				String pwd = pwdT.getText();
				String email = emailT.getText();
				String phone = phoneT.getText();

				AmasvinDTO dto = new AmasvinDTO();
				dto.setName(name);
				dto.setId(id);
				dto.setPwd(pwd);
				dto.setEmail(email);
				dto.setPhone(phone);

				// DB
				AmasvinDAO dao = new AmasvinDAO();
				int su = dao.insertMember(dto);
				dispose();
				new LoginFrame();
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
				emailcheckT.setText("");
				pwdcheckT.setText("");
			}
		});

		checkBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (idT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "���̵� �Է� ���ּ���");
					return;
				} else {
					AmasvinDAO dao = AmasvinDAO.getInstance(); // ��� new �� �� ������ �̱����ʿ�
					String id = idT.getText();
					String idc = dao.idcheck(id);
					if (idc == null) {
						idok = true;
						JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�");
					} else {
						idok = false;
						JOptionPane.showMessageDialog(null, "�̹� ��� ���� ���̵��Դϴ�");
						idT.setText("");

					}
				}
			}
		});

		emailcheckBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (emailT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�̸����� �Է� ���ּ���");
					return;
				}

				String user_email = emailT.getText();

				EmailCheck ec = new EmailCheck(user_email, num);

				JOptionPane.showMessageDialog(null, "������ȣ�� �߼۵Ǿ����ϴ�" + num);
			}
		});

		pwdcheckBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pwdcheckT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է� ���ּ���");
					return;
				} else {
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
			}
		});

		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (emailcheckT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ȣ�� �Է����ּ���");
				} else {
					if (num == Integer.parseInt(emailcheckT.getText())) {
						emailok = true;

						JOptionPane.showMessageDialog(null, "�̸��� ���� ����");

					} else {
						emailok = false;
						JOptionPane.showMessageDialog(null, "������ȣ�� ��ġ���� �ʽ��ϴ�." + "\n" + "�ٽ� �Է��ϼ���.");
						emailcheckT.setText("");
						// writeBtn.setEnabled(false);
					}
				}
			}
		});
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame();
				setVisible(false);

			}
		});
	}
}