package miniproject1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SearchFrame extends JFrame{
	private RoundedButton idsearchBtn, pwdsearchBtn, cancelBtn;
	private Image img2;

	public SearchFrame() {
		 JScrollPane scrollPane;
	       ImageIcon icon;
	   
	          icon = new ImageIcon("Image/�Ƹ�������.jpg");
	       
	           //��� Panel ������ �������������� ����      
	           JPanel background = new JPanel() {
	               public void paintComponent(Graphics g) {
	             
	                  g.drawImage(icon.getImage(),0,0, this.getWidth(), this.getHeight(),null);
	                 
	                   setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	                   super.paintComponent(g);
	               }
	           };

		//setLayout(null);
	    img2 = Toolkit.getDefaultToolkit().getImage("Image/�Ƹ�����ĳ����.png");
	           
		idsearchBtn = new RoundedButton("���̵� ã��");
		pwdsearchBtn = new RoundedButton("��й�ȣ ã��");
		cancelBtn = new RoundedButton("���");
		idsearchBtn.setBounds(180, 350, 100, 50);
		idsearchBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		pwdsearchBtn.setBounds(297, 350, 100, 50);
		pwdsearchBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
		cancelBtn.setBounds(410, 350, 100, 50);
		cancelBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
	     background.add(idsearchBtn);
	     background.add(pwdsearchBtn);
	     background.add(cancelBtn);
	     background.setLayout(null);
	     
	     scrollPane = new JScrollPane(background);
	      setContentPane(scrollPane);

	      
	    setTitle("�Ƹ����� ���̷� ���� ���α׷�");
	    setBounds(300, 100, 700, 700);
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    idsearchBtn.addActionListener(new ActionListener() {
	        
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            new IdSearchFrame();
	            setVisible(false);
	         }
	      });
	    
	    pwdsearchBtn.addActionListener(new ActionListener() {
	        
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            new PwdSearchFrame();
	            setVisible(false);
	         }
	      });
	    
	    cancelBtn.addActionListener(new ActionListener() {
	        
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            new LoginFrame();
	            setVisible(false);
	         }
	      });
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(img2, 20, 400, 680, 350, this);
}
}
