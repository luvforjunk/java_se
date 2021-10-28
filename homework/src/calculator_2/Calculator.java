/*
[���� ����]
Panel + GridLayout
setLayout(null)

private Button[] btn;
- �迭�� ũ��� 18���� ��� for���� ����Ͽ� �����Ѵ�.

private Label dispL
	      inputL 
-inputL�� 0�� �����ʿ� ǥ���Ѵ�.
-Label�� �������� ������.
*/
package calculator_2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;

public class Calculator extends Frame implements ActionListener, WindowListener {

	private Label dispL, inputL; // �ʵ�
	private Button[] btn; // ��(��ư) 18��
	private DecimalFormat df = new DecimalFormat("#,###.#######");
	StringBuffer sb = new StringBuffer();
	private String disp; // �߰� �����
	private int op; // ������
	public double result; // �� ó����
	public double number;
	boolean opClick = false;

	public Calculator() { // ������ ȣ��
		super("�� ���� ����� ����"); // �θ� ������ ȣ��

		Panel w = new Panel(); // ��ü

		Panel p1 = new Panel(); // �� 7��
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel p5 = new Panel();
		Panel p6 = new Panel();
		Panel p7 = new Panel();

		// ��ư�����
		// ��ư ������ String�迭 �ȿ� �־��ְ�, �� ��ư�� ���ο� �迭 Ŭ������ �� �ϳ��ϳ��� ����ִ� for���� �����
		String[] btnName = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "=", "+", "��", "C" };
		btn = new Button[18];
		for (int i = 0; i < 18; i++) {
			btn[i] = new Button(btnName[i]);
		}
		// �󺧸����
		dispL = new Label("0", Label.RIGHT);
		dispL.setBackground(new Color(220, 225, 125));
		inputL = new Label("0", Label.RIGHT);
		inputL.setBackground(new Color(128, 153, 204));

		// �г�
		// ���� ��ư���� �׸��� ���̾ƿ� Ŭ���� ȣ���� ���� �ϳ��� �г��� 1��, 4ĭ ¥���� ���� �� ��ư 4���� �־��ش�.
		// ������ 7���� �г��� ���� ��ü �г� ���� 7��, 1ĭ�� �׸��� ���̾ƿ����� �����
		w.setLayout(new GridLayout(7, 1, 5, 5));
		p1.setLayout(new GridLayout(1, 1, 5, 5));
		p1.add(dispL);
		p2.setLayout(new GridLayout(1, 1, 5, 5));
		p2.add(inputL);
		p3.setLayout(new GridLayout(1, 2));
		p3.add(btn[16]);
		p3.add(btn[17]);
		p4.setLayout(new GridLayout(1, 4));
		for (int i = 0; i < 4; i++) {
			p4.add(btn[i]);
		}
		p5.setLayout(new GridLayout(1, 4));
		for (int i = 4; i < 8; i++) {
			p5.add(btn[i]);
		}
		p6.setLayout(new GridLayout(1, 4));
		for (int i = 8; i < 12; i++) {
			p6.add(btn[i]);
		}
		p7.setLayout(new GridLayout(1, 4));
		for (int i = 12; i < 16; i++) {
			p7.add(btn[i]);
		}

		w.add(p1); // ��ü �ǳڿ� �� �־��ֱ�
		w.add(p2);
		w.add(p3);
		w.add(p4);
		w.add(p5);
		w.add(p6);
		w.add(p7);
		add("Center", w);

		setBounds(900, 180, 300, 500); // â�� ũ��
		setBackground(new Color(105, 132, 224)); // â�� ����
		setVisible(true); // â ����

		// �̺�Ʈ

		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(this);
		}
		this.addWindowListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// ����� �ѹ� ����� ��, �� ���� �ٽ� �����
		if (op == 61) {
			sb.delete(0, sb.length());
			sb.append(result);
			disp = "";
			op = 0;
			dispL.setText(disp);

		}
		if (e.getActionCommand() == "1") {
			sb.append(1);
		} else if (e.getActionCommand() == "2") {
			sb.append(2);
		} else if (e.getActionCommand() == "3") {
			sb.append(3);
		} else if (e.getActionCommand() == "4") {
			sb.append(4);
		} else if (e.getActionCommand() == "5") {
			sb.append(5);
		} else if (e.getActionCommand() == "6") {
			sb.append(6);
		} else if (e.getActionCommand() == "7") {
			sb.append(7);
		} else if (e.getActionCommand() == "8") {
			sb.append(8);
		} else if (e.getActionCommand() == "9") {
			sb.append(9);
		} else if (e.getActionCommand() == "0") {
			sb.append(0);
		} else if (e.getActionCommand() == "C") {
			sb.delete(0, sb.length());
			dispL.setText("0");
			disp = "";
			result = 0;
			op = 0;
		} else if (e.getActionCommand() == "��") {
			if (sb.length() > 0)
				sb = sb.delete(sb.length() - 1, sb.length());
			else
				sb.delete(0, sb.length());
		} else if (e.getActionCommand() == ".") {
			if (sb.indexOf(".") == -1) {
				if (inputL.getText().equals("0")) {
					sb.append("0.");
				} else {
					sb.append(".");
				}
			}
		} else {
			// ������ ��ư�� Ŭ���ϴ� ��� ���(+,-,*,/)
			opClick = true;
			// disp���� ���� null���� �ƴ��� Ȯ��
			if (disp != null)
				disp += sb.toString();
			else
				disp = sb.toString();
			// op�ȿ� �������� ���� �ִ��� Ȯ��;
			if (op == 0) {
				result = Double.parseDouble(sb.toString());
				// �����ڸ� 10������ ��ȯ
				op = e.getActionCommand().hashCode();
				disp += e.getActionCommand();
				dispL.setText(disp);
			} else {
				disp += e.getActionCommand();
				if (op == 43) { // "+"
					result += Double.parseDouble(sb.toString());
					dispL.setText(disp);
				} else if (op == 45) { // "-"
					result -= Double.parseDouble(sb.toString());
					dispL.setText(disp);
				} else if (op == 42) { // "*"
					result *= Double.parseDouble(sb.toString());
					dispL.setText(disp);
				} else if (op == 47) { // "/"
					result /= Double.parseDouble(sb.toString());
					dispL.setText(disp);
				}
				op = e.getActionCommand().hashCode();
			}
			sb.delete(0, sb.length());
		}

		// StringBuffer�� ���� �ӽ÷� ���� temp ���� ����
		String temp; // ������ ������ ��ƹ�����
		String temp2; // �Ǽ��� ������ ��ƹ�����
		
		// StringBuffer �ȿ� ���� �����ϴ��� ���θ� üũ
		if (sb.length() > 0) {
			// StrinBuffer�� �Ҽ����� �ִ� ���
			if (sb.indexOf(".") != -1) {
				if (sb.indexOf(".") == sb.length() - 1) {
					// StringBuffer�� �Էµ� �� �� ���� �Ҽ����� ���
					temp = sb.substring(0, sb.indexOf("."));
					temp = df.format(Integer.parseInt(temp));
					temp += ".";
					inputL.setText(temp);
				} else {
					// �Ҽ����� �������� �����κ��� temp��, �Ҽ��κ��� temp2�� ���� �� ��ħ
					temp = sb.substring(0, sb.indexOf("."));
					temp2 = sb.substring(sb.indexOf(".") + 1, sb.length());
					temp = df.format(Integer.parseInt(temp));
					temp += ".";
					temp += temp2;
					inputL.setText(temp);
				}
			} else {
				temp = sb.toString();
				temp = df.format(Integer.parseInt((temp)));
				inputL.setText(temp);
			}
		} else
			inputL.setText("0");
		// �����ڰ� Ŭ�� ��, inputL�� ����� result���� ���̰� ����/ "="��ư�� Ŭ���Ͽ��� �� ���� ����� ǥ��
		if (opClick == true || op == 61) {
			inputL.setText(Double.toString(result));
			opClick = false;
		}
	}

	// WindowListener Override - â �ݱ�
	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
