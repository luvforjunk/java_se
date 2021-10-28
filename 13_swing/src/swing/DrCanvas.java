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
	public void paint(Graphics g) { // �ݹ�޼ҵ�
		// ���� �θ��� ���� �ƴ� �ڹ� ���� �ӽſ� ���� �ҷ����� ��
		// Paint�� �θ��� ������ �����ϱ�? Frameâ�� ����� setTitle, setVisible
		int x1, y1, x2, y2, z1, z2;

		// list�� ����ִ� ShapeDTO�� �ϳ��� ������ �ٽ� �׸���
		for (ShapeDTO dto : msPaint.getList()) { // list�� DrCanvas�� ����
			// list�� msPaint�� ���� �ִ�.
			// �׸��� private List<ShapeDTO> list; private���� ��Ƴ��� ������ Ŭ�������� ����� �� �����Ƿ�
			// get���� �����;� �Ѵ�

			// dto�ȿ� �ִ� ��ǥ�� �����;� �Ѵ�(�׷��� �ٽ� �׸� �� �ִ�)
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();

			// ���� �����;� �Ѵ�
			switch (dto.getColor()) {
			case 0:g.setColor(Color.RED);break;
			case 1:g.setColor(Color.GREEN);break;
			case 2:g.setColor(Color.BLUE);break;
			case 3:g.setColor(Color.CYAN);break;
			case 4:g.setColor(Color.MAGENTA);break;
			}

			// ������ �����;� �Ѵ�
			if (dto.isFill()) { // ä���� ����
				if (dto.getShape() == Shape.LINE)
					g.drawLine(x1, y1, x2, y2);
				else if (dto.getShape() == Shape.CIRCLE)
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				else if (dto.getShape() == Shape.RECT)
					g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1)); 
				// x��ǥ, y��ǥ, �ʺ�, ����
				else if (dto.getShape() == Shape.ROUNDRECT)
					g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); 

			} else { // �� ����
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

		// paint �޼ҵ尡 �׸��� �׸����� ��ǥ�� ���;� �Ѵ�
		// ��ǥ�� �ݵ�� int������ �����;� �Ѵ�
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim()); // trim�� �¿� ������ �����ִ� ��
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());

		// ����
		// = switch((String)msPaint.getCombo().getSelectedItem()) {
		switch (msPaint.getCombo().getSelectedIndex()) {
		case 0:g.setColor(Color.RED);break;
		case 1:g.setColor(Color.GREEN);break;
		case 2:g.setColor(Color.BLUE);break;
		case 3:g.setColor(Color.CYAN);break;
		case 4:g.setColor(Color.MAGENTA);break;
		}

		// ����
		// ä���� ����
		if (msPaint.getFill().isSelected()) {// �տ��� ���λ簡 is�� ������ ��, ���� boolean���� ���ϵȴ�
			if (msPaint.getLine().isSelected()) // ���� ���õƾ�?
				g.drawLine(x1, y1, x2, y2); // ���� ��ǥ�� �׷��ָ� �ȴ�
			else if (msPaint.getCircle().isSelected()) 
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				// x��ǥ, y��ǥ, �ʺ�, ����;
			else if (msPaint.getRect().isSelected())
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1)); 
			else if (msPaint.getRoundRect().isSelected())
				g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); 

			// �� ����
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

// NumberFormatException �̶�???

// â�� ũ�⸦ �����ϸ鼭 repaint��
// �̺�Ʈ�� �߻����� msPaint����
