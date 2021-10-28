package miniproject1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class InfoFrame extends JFrame {
	private JLabel pwdL;
	private JPasswordField pwdT;
	private RoundedButton correctBtn, deleteBtn, exitBtn;
	private Image img2;

	public InfoFrame(String id, String pwd) {
		JScrollPane scrollPane;
		ImageIcon icon;

		icon = new ImageIcon("Image/�Ƹ�������.jpg");

		// ��� Panel ������ �������������� ����
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);

				setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
				super.paintComponent(g);
			}
		};

		img2 = Toolkit.getDefaultToolkit().getImage("Image/�Ƹ�����ĳ����.png");

		AmasvinDAO dao = AmasvinDAO.getInstance();
		String name = dao.loginMember(id, pwd);
		setTitle("�ݰ����ϴ�, " + name + "�� �Ƹ������Դϴ�");

		setLayout(null);

		pwdL = new JLabel("ȸ������ ����/Ż�� ���Ͻø� ��й�ȣ�� �Է��ϼ���");
		pwdL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));

		pwdT = new JPasswordField();

		correctBtn = new RoundedButton("ȸ������ ����");
		correctBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));

		deleteBtn = new RoundedButton("ȸ�� Ż��");
		deleteBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));

		exitBtn = new RoundedButton("�ݱ�");
		exitBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));

		pwdL.setBounds(170, 300, 350, 30);
		pwdT.setBounds(200, 350, 300, 30);
		correctBtn.setBounds(170, 400, 100, 50);
		deleteBtn.setBounds(290, 400, 100, 50);
		exitBtn.setBounds(410, 400, 100, 50);
//      
//       Container c = getContentPane();
//        c.setBackground(new Color(195,219,242));
//      
//        c.add(pwdL);
//        c.add(pwdT);
//        c.add(correctBtn);
//        c.add(deleteBtn);
//        c.add(exitBtn);

		background.add(pwdL);
		background.add(pwdT);
		background.add(correctBtn);
		background.add(deleteBtn);
		background.add(exitBtn);
		background.setLayout(null);

		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);

		setBounds(300, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		correctBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// DB
				AmasvinDAO dao = AmasvinDAO.getInstance(); // �̱������� �ٲ�
				String pwd = pwdT.getText();
				String pwdc = dao.pwdCheck(pwd);

				if (pwdT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ۼ����ּ���");
					return;
				} else if (pwdc == null) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�");
				} else {
					dispose();
					new CorrectFrame(id, pwd);
					setVisible(false);
				}
			}
		});

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// DB
				AmasvinDAO dao = AmasvinDAO.getInstance(); // �̱������� �ٲ�
				String pwd = pwdT.getText();
				String pwdc = dao.pwdCheck(pwd);

				if (pwdT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ۼ����ּ���");
					return;
				} else if (pwdc == null) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�");
				} else {
					dispose();
					new DeleteFrame(id, pwd);
					setVisible(false);
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

	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(img2, 20, 400, 680, 350, this);
	}
}