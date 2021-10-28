package interface_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Frame�� BorderLayout(��������)
//�������Ͽ��� 1���� Component�� �ø��� �ִ�
class WindowTest extends Frame implements ActionListener, MouseListener {
	private Button newBtn, exitBtn;
	private TextArea area;

	public void init() {
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");
		area = new TextArea(); // �۾� ���� ���

		Panel p = new Panel();// FlowLayout (�߾�-���� ��ġ)
		// Panel�� �ѹ� ���� ������ ������ �ʵ忡 �Ƚ���
		p.add(newBtn);
		p.add(exitBtn);

		this.add("North", p);
		this.add("Center", area);

		this.setBounds(900, 100, 300, 400);
		setVisible(true);

		// �̺�Ʈ
		this.addWindowListener(new WindowExit()); // �� â���� �����츮���ʰ� �߻��ϴµ� �� �����δ� WindowExit�� ������ �ִٴ� �ǹ�
		this.addMouseListener(this); // ������ �ȿ��� �������� ���콺�� ������ ���ؼ��� 
		newBtn.addActionListener(this); // newBtn�� ������ JVM�� ���� actionPerformed�� �Ѿ�´�. �����δ� this��
		exitBtn.addActionListener(this);
	}// init()

	
	// call back(�ݹ�)
	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newBtn) { // ���� �θ� �ְ� newBtn�Դϱ�?
			area.setText(" ");
			area.setText(" ");// �ʱ�ȭ

		} else if (e.getActionCommand() == "����") { // actionPerformed ��ſ� getActionCommand�� �ᵵ �ȴ�
													// ��ſ� ""�� �ݵ�� ���� �Ѵ�
													// e.getSource�� ��ü, e.getActionCommand�� Ÿ��Ʋ
			System.exit(0);// ���α׷� ���� ����
		}
	}

	// MouseListener Override
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("���콺 Ŭ��!!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("���콺 IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("���콺 OUT");
	}
}

//------------
public class WindowMain {

	public static void main(String[] args) {
		new WindowTest().init();
	}

}

// Component (����)
// ex) Button, Panel, TextField/TextArea
// Container - �ܵ����� �� �� �ִ� ��
// ex) Frame, JFrame, Dialog