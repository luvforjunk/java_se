package dbtest;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class HomePanel extends Panel{
	public HomePanel() {
		// s.setBackground(Color.RED);
	}
	
	@Override
	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("°«¿¬°æ.jpg");
		g.drawImage(img, this.getWidth(), this.getHeight(), this);
		
	}
	
	
	public static void main(String[] args) {
		new HomePanel();
	}

}
