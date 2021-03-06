package swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MsPaint extends JFrame implements ActionListener {
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen; 
	private JComboBox<String> combo;
	private JButton draw;
	private DrCanvas can;
	private List<ShapeDTO> list;

	public MsPaint() {

		// JLabel
		x1L = new JLabel("x1");
		y1L = new JLabel("y1");
		x2L = new JLabel("x2");
		y2L = new JLabel("y2");
		z1L = new JLabel("z1");
		z2L = new JLabel("z2");

		// JTextField
		x1T = new JTextField("0", 4);
		y1T = new JTextField("0", 4);
		x2T = new JTextField("0", 4);
		y2T = new JTextField("0", 4);
		z1T = new JTextField("50", 4);
		z2T = new JTextField("50", 4);

		fill = new JCheckBox("채우기");

		line = new JRadioButton("선");
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형", true); // true를 쓰면 사각형을 항상 기본으로 선택되어 있다
		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("연필");

		ButtonGroup group = new ButtonGroup();
		// RadioButtun은 항상 그룹으로 묶어서 해줘야 한다. 한번에 하나씩만 선택해야 하기 때문에
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);

		String[] color = { "빨강", "초록", "파랑", "하늘", "보라" };
		combo = new JComboBox<String>(color);

		draw = new JButton("그리기");

		can = new DrCanvas(this); // DrCanvas를 썼으니 패널 들어가야겠네?

		list = new ArrayList<ShapeDTO>();

		JPanel northP = new JPanel(); // FlowLayout(순서배치)
		northP.add(x1L);
		northP.add(x1T);
		northP.add(y1L);
		northP.add(y1T);
		northP.add(x2L);
		northP.add(x2T);
		northP.add(y2L);
		northP.add(y2T);
		northP.add(z1L);
		northP.add(z1T);
		northP.add(z2L);
		northP.add(z2T);
		northP.add(fill);

		JPanel southP = new JPanel();
		southP.add(line);
		southP.add(circle);
		southP.add(rect);
		southP.add(roundRect);
		southP.add(pen);
		southP.add(combo);
		southP.add(draw);

		Container c = this.getContentPane();
		c.add("North", northP);
		c.add("Center", can);
		c.add("South", southP);

		setTitle("미니 그림판");
		setVisible(true);
		setBounds(900, 100, 700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 이벤트
		draw.addActionListener(this); // 그리기 버튼을 눌렀을 때 그림이 바뀔 수 있도록

		can.addMouseListener(new MouseAdapter() { // can에 마우스를 꾹 누르고 있을 때 x1, y1의 좌표가 변경되도록
			@Override
			public void mousePressed(MouseEvent e) {
				x1T.setText(e.getX() + "");
				// e.getX()는 int값인데 setText으로 가져오라 했으니
				y1T.setText(e.getY() + "");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// 눌렀다 뗐을 때 그곳이 시작점이 되지 않도록 하기 위해
				int x1 = Integer.parseInt(x1T.getText()); 
				int y1 = Integer.parseInt(y1T.getText());
				if (x1 == e.getX() && y1 == e.getY())
					return;

				ShapeDTO dto = new ShapeDTO(); // 딱 한개의 도형을 저장하려고

				// 좌표
				dto.setX1(Integer.parseInt(x1T.getText())); // x1좌표 문자열인 x1T.getText()를 int로
				dto.setY1(Integer.parseInt(y1T.getText())); 
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));

				// 채우기
				dto.setFill(fill.isSelected()); 
				// fill.isSelected()는 False를 가져올거임. 왜? 내가 선택을 안했기 때문에 

				// 도형
				// 내가 어떤 도형을 선택한지 모르기 때문에 일일이 물어본다
				if (line.isSelected()) // Line이 선택됐다면
					dto.setShape(Shape.LINE); // 선을 가져와라(dto의 setShape에게 Shape.Line을 넣어준다)
				else if (circle.isSelected())
					dto.setShape(Shape.CIRCLE);
				else if (rect.isSelected())
					dto.setShape(Shape.RECT);
				else if (roundRect.isSelected())
					dto.setShape(Shape.ROUNDRECT);

				// 색
				dto.setColor(combo.getSelectedIndex());

				list.add(dto);
				
				System.out.println(list); // 단순 주소값 확인차 써준거
			} // mouseReleased(MouseEvent e)
		});

		can.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x2T.setText(e.getX() + "");
				y2T.setText(e.getY() + "");

				can.repaint();
			}
		});

	} // MsPaint()

	@Override
	public void actionPerformed(ActionEvent e) {
		can.repaint(); // paint를 다시 부르자. 이때 paint는 Canvas가 갖고 있으므로
		// z1의 숫자가 클수록 둥근 정도가 더 커진다
	}

	public JTextField getX1T() {
		return x1T;
	}
	public JTextField getY1T() {
		return y1T;
	}
	public JTextField getX2T() {
		return x2T;
	}
	public JTextField getY2T() {
		return y2T;
	}
	public JTextField getZ1T() {
		return z1T;
	}
	public JTextField getZ2T() {
		return z2T;
	}
	public JComboBox<String> getCombo() {
		return combo;
	}
	public JCheckBox getFill() {
		return fill;
	}
	public JRadioButton getLine() {
		return line;
	}
	public JRadioButton getCircle() {
		return circle;
	}
	public JRadioButton getRect() {
		return rect;
	}
	public JRadioButton getRoundRect() {
		return roundRect;
	}
	public JRadioButton getPen() {
		return pen;
	}
	public List<ShapeDTO> getList() { // 다른 클래스에서 사용할 수 있게!!!!!!
		return list;
	}
	
	public static void main(String[] args) {
		new MsPaint();
	}
}