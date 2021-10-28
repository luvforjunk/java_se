package miniproject1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	private Image img, img2;
	private JLabel idL, pwdL;
	private JTextField idT;
	private JPasswordField pwdT;
	private RoundedButton loginBtn, writeBtn, idpwdsearchBtn;
	private WriteFrame writepanel;
	int stamp;

	public LoginFrame() {
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

		img = Toolkit.getDefaultToolkit().getImage("Image/�Ƹ�����ΰ�.png");
		img2 = Toolkit.getDefaultToolkit().getImage("Image/�Ƹ�����ĳ����.png");

		idL = new JLabel("���̵�");
		idL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		pwdL = new JLabel("��й�ȣ");
		pwdL.setFont(new Font("�ȵ�����������", Font.BOLD, 16));

		idT = new JTextField();
		pwdT = new JPasswordField();

		loginBtn = new RoundedButton("�α���");
		loginBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		loginBtn.setBackground(new Color(255, 255, 204));
		writeBtn = new RoundedButton("ȸ������");
		writeBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 15));
		writeBtn.setBackground(new Color(255, 255, 204));
		idpwdsearchBtn = new RoundedButton("���̵�/��й�ȣ ã��");
		idpwdsearchBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 13));
		idpwdsearchBtn.setBackground(new Color(255, 255, 204));

		background.add(idL);
		background.add(idT);
		background.add(pwdL);
		background.add(pwdT);

		background.add(loginBtn);
		background.add(writeBtn);
		background.add(idpwdsearchBtn);
		background.setLayout(null);

		idL.setBounds(175, 300, 80, 40);
		idT.setBounds(230, 300, 170, 40);

		pwdL.setBounds(165, 350, 80, 40);
		pwdT.setBounds(230, 350, 170, 40);

		loginBtn.setBounds(420, 300, 100, 90);
		writeBtn.setBounds(180, 420, 150, 30);
		idpwdsearchBtn.setBounds(350, 420, 150, 30);
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);

		setTitle("�Ƹ����� ���̷� ���� ���α׷�");
		setBounds(300, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// �̺�Ʈ
		writeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new WriteFrame();
				setVisible(false);
			}
		});

		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idT.getText();
				String pwd = pwdT.getText();

				// DB
				AmasvinDAO dao = AmasvinDAO.getInstance(); // �̱������� �ٲ�
				String name = dao.loginMember(id, pwd);

				if (name == null) {
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�");
				} else {

					JOptionPane.showMessageDialog(null, name + "�� �α���");
					dispose();
					new HomeFrame(id, pwd);
					setVisible(false);
				}
			}
		});

		idpwdsearchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SearchFrame();
				setVisible(false);
			}

		});
	}

	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(img2, 20, 400, 680, 350, this);
	}

}