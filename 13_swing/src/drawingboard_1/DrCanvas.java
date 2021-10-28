package drawingboard_1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrCanvas extends Canvas {
	private MsPaint msPaint;
	
	public DrCanvas(MsPaint msPaint) {
		this.msPaint = msPaint;
		this.setBackground(new Color(255,200,255));
	}
	
	@Override
	public void paint(Graphics g) {//�ݹ�޼ҵ�
		// list�� ����ִ� ShapeDTO�� (������ �׷ȴ� ������) �ϳ��� ������ �ٽ� �׸���
		
		//---------------
		//���� �׷����� ����
		//��ǥ
		int x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
		int y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		int x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		int y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		int z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		int z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());
		
		//��
		switch(msPaint.getCombo().getSelectedIndex()) {
		case 0 : this.setForeground(Color.RED); break;
		case 1 : this.setForeground(Color.GREEN); break;
		case 2 : this.setForeground(Color.BLUE); break;
		case 3 : this.setForeground(Color.CYAN); break;
		case 4 : this.setForeground(Color.MAGENTA); break;
		}
		
		//����
		if(msPaint.getFill().isSelected()) {//ä���� ����
			if(msPaint.getLine().isSelected())
				g.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected())
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRect().isSelected())
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRoundRect().isSelected())
				g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			
		}else {//�� ����
			if(msPaint.getLine().isSelected())
				g.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected())
				g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRect().isSelected())
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRoundRect().isSelected())
				g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
		}
	}
}