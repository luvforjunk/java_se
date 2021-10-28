package inheritance;

import java.awt.Button;
import java.awt.Frame;

//Frame�� BorderLayout - ������ �̹� �������� ��(��������)
public class AwtMain extends Frame {
	// AwtMain�Ʒ��� �ڽ��� �����Ƿ� private����൵ �ȴ�
	private Button northBtn = null, southBtn, eastBtn, westBtn, centerBtn;
	// ��� Ŭ���� ��ü���� �ƹ��͵� ���� ���ϸ� �ΰ� ���´�
	// *���� �ߴ� ���� - NullPointerException - null���� ������ new�����ض�
	private int a = 0;

	public void init() {
		// ��ư ����
		northBtn = new Button("����");
		southBtn = new Button("����");
		eastBtn = new Button("����");
		westBtn = new Button("����");
		centerBtn = new Button("�߾�");
		//

		// ��ġ - ������ �������� ���� ���̴� �۾�
		add("North", northBtn);// ���ʿ��� northBtn ���ּ���
		add("South", southBtn);
		add("East", eastBtn);
		add("West", westBtn);
		add("Center", centerBtn);

		setBounds(900, 200, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		AwtMain am = new AwtMain(); // init�� static�� �ƴϹǷ� ������ ����,, Ŭ���� ���� -> ������ �θ���
		am.init();// -> initȣ��

		new AwtMain().init(); // �� �� ������ ��ģ ��
		// WindowTest���� â ���� ����� �ٸ��� �޼ҵ带 ���� ������ �ص� �ǰ�~~
	}

}

/*
 * Exception ����ó��
 * 
 * ������ - ���� IOException
 * 
 * ���� - ������ �ڵ� �߸� ArrayIndexOutOfBoundsException - �迭�� ���� �߸� �����ؼ�
 * NullPointerException - new�� �����༭
 */