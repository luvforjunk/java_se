package io;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TryNotepad extends JFrame implements ActionListener {
	private JTextArea area; // �۾� ���� ��
	private MenuPane menu; // Component�� menu�� Frame�� �ִ� ���� �ٿ��ֱ�
	private File file = null;

	public TryNotepad() {
		area = new JTextArea();
		area.setFont(new Font("���ü", Font.BOLD, 20)); // ��Ʈ �ٸ��� ���� 20����

		JScrollPane scroll = new JScrollPane(area); // area�� scroll �־��ֱ�
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		menu = new MenuPane();
		this.setJMenuBar(menu); // JFrame(this)= setJMenuBar, MenuBar���� menu�� �ְڴٴ� �ǹ�

		this.add("Center", scroll); // ���� add�� ���� �ʾƵ� setJMenuBar�� ���� ����⿡ menu�� �ٿ��ش�

		setBounds(900, 100, 500, 500);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		// ���⼭ this�� JOPtionPane�� �ƴ϶� JFrame�� �پ� �ִ� ��
		// �⺻������ JFrame�� ���� �� �⺻ Ư¡�̴�!!! �ƹ��� ���ϸ� hide�� �⺻���� ���´�
		// DISPOSE�� ���� ó��.
		// ��Ҹ� ������ �� â�� �״�� ����ְ� �ϱ� �������� ���°Ŵ�
		this.addWindowListener(new WindowAdapter() {
			// ���⼭ this�� �����ص� ������ Frame�� ���Ѵ�. �����θ� new WindowAdapter�� ��� �ִ�
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(TryNotepad.this, // ���⼭ ���ϴ� this�� �͸��̳ʸ� ���Ѵ�.
						"�����Ͻðڽ��ϱ�?", "�޸���", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if (result == JOptionPane.NO_OPTION) {
					saveDialog();
					filewrite();
					System.exit(0);
				}
			}
		});

		// �̺�Ʈ ó�� - �޴�
		menu.getNewM().addActionListener(this); // �����δ� ��(this)�� ���� �ִ�
		// �տ� this.newM.addAction~~~ �̷������� ���ָ� �� Ŭ���� �ȿ��� newM�� ã����� �ǹ��ε�,
		// ���� �İ� ã�ƺ��� �� Ŭ���� �ȿ��� newM�� ����
		// ���� getnewM()�� �ƴ� �׳� newM�̶�� ���� �Ǹ� newM�� private���� ���� �ֱ� ������ �ٸ� Ŭ�������� �� �� ����
		// ������ �ȵǴϱ� �� ��ƾ� �ұ�? ���� ������ �� �ֵ��� getter�� ������ �Ѵ�!
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu.getNewM()) {
			area.setText(""); // �ʱ�ȭ
		} else if (e.getSource() == menu.getOpenM()) {
			openDialog(); // ���� ���̾�α� -> ���� ����
			fileRead();// -> ������ ������ �о JFrame�� TextArea�� �Ѹ���

		} else if (e.getSource() == menu.getSaveM()) {

			JFileChooser chooser = new JFileChooser(); // ���ϴ� ���� ��ġ ����
			int result = chooser.showSaveDialog(this); // ���� ���̾�α�

			File file = null;
			if (result == JFileChooser.APPROVE_OPTION) { // save��ư ��������
				file = chooser.getSelectedFile(); // ������ ������ �����Ͷ�

				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}

		} else if (e.getSource() == menu.getExitM()) {

			// ���̾�α�
			int result = JOptionPane.showConfirmDialog(TryNotepad.this, // JFrame ������ ����ֱ�
					"�����Ͻðڽ��ϱ�?", // �޽��� ����
					"�޸���", // Ÿ��Ʋ
					JOptionPane.YES_NO_CANCEL_OPTION, // �� �ƴϿ� ��� �ɼ�
					JOptionPane.QUESTION_MESSAGE); // ? ����ǥ .... ! - Warning, i - information
			// ***yes�� no�� ���� int��(������)���� �ν��Ѵ�
			// YES_NO_CANCEL_OPTION�� �빮�ڷ� �Ǿ� �ִٴ� �� ����� �Ǿ� �־� ���ڷ� �ν��Ѵ�
			// ������ ��� ��ҵ� ������ ������ int������ �Ѿ�´�

			if (result == 0) { // YES_OPTION
				saveDialog();// ������ �����ϰ�~
				filewrite();
				
				System.exit(0); // ����
			} else if (result == JOptionPane.NO_OPTION) { // �̷��� ���� �� �� ���� ���ϴ� �� ����!
				System.exit(0);
			} else if (result == JOptionPane.CANCEL_OPTION) {
			}

		} else if (e.getSource() == menu.getCutM()) {
			area.cut();
		} else if (e.getSource() == menu.getCopyM()) {
			area.copy();
		} else if (e.getSource() == menu.getPasteM()) {
			area.paste();
		}
	} // actionPerformed(Actionevent e)


	private void filewrite() {
		if (file == null)
			return;
		String data = null; // getText�ϱ� String type����
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			area.getText(); // ���� ���� �����Ͷ�
		
			bw.write(data); // ���Ϸ� ����
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	private void saveDialog() {
		JFileChooser chooser = new JFileChooser(); // ���ϴ� ���� ��ġ ����
		int result = chooser.showSaveDialog(null); // ���� ���̾�α�

		File file = null;
		if (result == JFileChooser.APPROVE_OPTION) { // save��ư ��������
			file = chooser.getSelectedFile(); // ������ ������ �����Ͷ�
		}
		JOptionPane.showMessageDialog(this, file);
	}

	private void fileRead() {
		if (file == null)
			return;
		area.setText("");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			// ���⿡�� ������ ���� �ʰ� ��� ��ư�� ������ �� NullPointerException ������ ���
			// file�� Null�̶�� ��

			String line;
			while ((line = br.readLine()) != null) { // 1�پ� (Enter�� ĥ ������) ������ Enter�� ���� �ʴ´�. Enter������.
				// area.setText(line); - �о�� ���� setText area�� �־��ش�,
				// �ٵ�... setText�� ����� ������ �ؼ� ������ �����µ� �۵��� ������� �Ⱥ��̴� ��ó�� ���δ�
				area.append(line + "\n"); // readLing�� ���Ͱ��� �� ������
				// ���� ���ٷ� ���´�
				// ������ "\n"�� �־��ش�

			} // while
				// ������ �Ѳ����� �о�� �� ����
				// ���پ� �о�;� �ϴµ� �� ������ null������ ó���Ѵ�
				// �ѹ� �а� ������ �� �ƴϴϱ� null�� �ƴ� ���ȱ��� while���� ������

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// �ʵ忡 private File file = null; �־��ִ� ��� ���
	// void �޼ҵ忡 return���� �־��ִ� �͵� ���

	private void openDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) { // ���⸦ �����ߴٴ� �ųİ� ����� ��
			file = chooser.getSelectedFile();

		}
		JOptionPane.showMessageDialog(this, file);
		// file�� Ŭ@16�����ε� ���� ������ ������ ����� ���Դ����� �ñ��ѰŴϱ�
		// tostring���� �˾Ƽ� �ٲ������ ��
	}

	public static void main(String[] args) {
		new TryNotepad();
	}
}

// JFileChooser - ���� ����
// showOpenDialog - ���̾�α� ����
// showOpenDialog(Component parent) Component ��� �� ��� ���ųĴ� ���̴�
// showOpenDialog static�� �ƴϴ�. �׷� ���� Ŭ����(JFileChooser)�� ������ ��� �Ѵ�.
// JFileChooser chooser = new JFileChooser();

//showSaveDialog() - ���̾�α� ����
