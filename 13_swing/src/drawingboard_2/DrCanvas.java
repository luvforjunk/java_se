package drawingboard_2;

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
	public void paint(Graphics g) { 
		int x1, y1, x2, y2, z1, z2;

		for (ShapeDTO dto : msPaint.getList()) { 

			// 좌표
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();

			// 색
			switch (dto.getColor()) {
			case 0:g.setColor(Color.RED);break;
			case 1:g.setColor(Color.GREEN);break;
			case 2:g.setColor(Color.BLUE);break;
			case 3:g.setColor(Color.CYAN);break;
			case 4:g.setColor(Color.MAGENTA);break;
			}

			// 도형
			if (dto.isFill()) { // 채워진 도형
				if (dto.getShape() == Shape.LINE)
					g.drawLine(x1, y1, x2, y2);
				else if (dto.getShape() == Shape.CIRCLE)
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				else if (dto.getShape() == Shape.RECT)
					g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1)); 
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

		// 좌표
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());

		// 색깔
		switch (msPaint.getCombo().getSelectedIndex()) {
		case 0:g.setColor(Color.RED);break;
		case 1:g.setColor(Color.GREEN);break;
		case 2:g.setColor(Color.BLUE);break;
		case 3:g.setColor(Color.CYAN);break;
		case 4:g.setColor(Color.MAGENTA);break;
		}

		// 도형
		// 채워진 도형
		if (msPaint.getFill().isSelected()) {
			if (msPaint.getLine().isSelected()) 
				g.drawLine(x1, y1, x2, y2); 
			else if (msPaint.getCircle().isSelected()) 
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
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
