package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrCanvas extends Canvas {
	private MsPaint msPaint;

	public DrCanvas(MsPaint msPaint) {
		this.msPaint = msPaint;
		this.setBackground(new Color(255, 200, 255));
	}

	@Override
	public void paint(Graphics g) { // 콜백메소드
		// 내가 부르는 것이 아닌 자바 가상 머신에 의해 불려지는 것
		// Paint를 부르는 시점은 언제일까? Frame창이 만드는 setTitle, setVisible
		int x1, y1, x2, y2, z1, z2;

		// list에 담겨있는 ShapeDTO를 하나씩 꺼내서 다시 그리기
		for (ShapeDTO dto : msPaint.getList()) { // list는 DrCanvas에 없다
			// list는 msPaint가 갖고 있다.
			// 그리고 private List<ShapeDTO> list; private으로 잡아놨기 때문에 클래스에서 사용할 수 없으므로
			// get으로 꺼내와야 한다

			// dto안에 있는 좌표를 꺼내와야 한다(그래야 다시 그릴 수 있다)
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();

			// 색을 꺼내와야 한다
			switch (dto.getColor()) {
			case 0:g.setColor(Color.RED);break;
			case 1:g.setColor(Color.GREEN);break;
			case 2:g.setColor(Color.BLUE);break;
			case 3:g.setColor(Color.CYAN);break;
			case 4:g.setColor(Color.MAGENTA);break;
			}

			// 도형을 꺼내와야 한다
			if (dto.isFill()) { // 채워진 도형
				if (dto.getShape() == Shape.LINE)
					g.drawLine(x1, y1, x2, y2);
				else if (dto.getShape() == Shape.CIRCLE)
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				else if (dto.getShape() == Shape.RECT)
					g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1)); 
				// x좌표, y좌표, 너비, 높이
				else if (dto.getShape() == Shape.ROUNDRECT)
					g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); 

			} else { // 빈 도형
				if (dto.getShape() == Shape.LINE)
					g.drawLine(x1, y1, x2, y2);
				else if (dto.getShape() == Shape.CIRCLE)
					g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				else if (dto.getShape() == Shape.RECT)
					g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				else if (dto.getShape() == Shape.ROUNDRECT)
					g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
			}
		}

		// paint 메소드가 그림을 그리려면 좌표를 얻어와야 한다
		// 좌표는 반드시 int형으로 가져와야 한다
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim()); // trim은 좌우 공백을 없애주는 것
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());

		// 색깔
		// = switch((String)msPaint.getCombo().getSelectedItem()) {
		switch (msPaint.getCombo().getSelectedIndex()) {
		case 0:g.setColor(Color.RED);break;
		case 1:g.setColor(Color.GREEN);break;
		case 2:g.setColor(Color.BLUE);break;
		case 3:g.setColor(Color.CYAN);break;
		case 4:g.setColor(Color.MAGENTA);break;
		}

		// 도형
		// 채워진 도형
		if (msPaint.getFill().isSelected()) {// 앞에가 접두사가 is가 붙으면 참, 거짓 boolean형이 리턴된다
			if (msPaint.getLine().isSelected()) // 선이 선택됐어?
				g.drawLine(x1, y1, x2, y2); // 선은 좌표만 그려주면 된다
			else if (msPaint.getCircle().isSelected()) 
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				// x좌표, y좌표, 너비, 높이;
			else if (msPaint.getRect().isSelected())
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1)); 
			else if (msPaint.getRoundRect().isSelected())
				g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); 

			// 빈 도형
		} else {
			if (msPaint.getLine().isSelected())
				g.drawLine(x1, y1, x2, y2);
			else if (msPaint.getCircle().isSelected())
				g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			else if (msPaint.getRect().isSelected())
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			else if (msPaint.getRoundRect().isSelected())
				g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
		}
	}
}

// NumberFormatException 이란???

// 창의 크기를 조절하면서 repaint됨
// 이벤트를 발생하자 msPaint에서
