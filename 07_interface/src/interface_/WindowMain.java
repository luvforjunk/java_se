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

//Frame은 BorderLayout(동서남북)
//동서남북에는 1개의 Component만 올릴수 있다
class WindowTest extends Frame implements ActionListener, MouseListener {
	private Button newBtn, exitBtn;
	private TextArea area;

	public void init() {
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");
		area = new TextArea(); // 글씨 쓰는 기능

		Panel p = new Panel();// FlowLayout (중앙-순서 배치)
		// Panel은 한번 쓰고 버리기 때문에 필드에 안써줌
		p.add(newBtn);
		p.add(exitBtn);

		this.add("North", p);
		this.add("Center", area);

		this.setBounds(900, 100, 300, 400);
		setVisible(true);

		// 이벤트
		this.addWindowListener(new WindowExit()); // 내 창에서 윈도우리스너가 발생하는데 그 구현부는 WindowExit가 가지고 있다는 의미
		this.addMouseListener(this); // 윈도우 안에서 벌어지는 마우스의 행위에 대해서만 
		newBtn.addActionListener(this); // newBtn을 누르면 JVM에 의해 actionPerformed로 넘어온다. 구현부는 this가
		exitBtn.addActionListener(this);
	}// init()

	
	// call back(콜백)
	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newBtn) { // 나를 부른 애가 newBtn입니까?
			area.setText(" ");
			area.setText(" ");// 초기화

		} else if (e.getActionCommand() == "종료") { // actionPerformed 대신에 getActionCommand를 써도 된다
													// 대신에 ""은 반드시 들어가야 한다
													// e.getSource는 객체, e.getActionCommand는 타이틀
			System.exit(0);// 프로그램 강제 종료
		}
	}

	// MouseListener Override
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭!!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스 IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("마우스 OUT");
	}
}

//------------
public class WindowMain {

	public static void main(String[] args) {
		new WindowTest().init();
	}

}

// Component (도구)
// ex) Button, Panel, TextField/TextArea
// Container - 단독으로 올 수 있는 것
// ex) Frame, JFrame, Dialog