package miniproject1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class IdSearchFrame extends JFrame{
	private JLabel nameL, emailL, emailcheckL;
	private JTextField nameT, emailT, emailcheckT;
	private RoundedButton sendBtn, checkBtn, okBtn, cancelBtn;
	static int num = (int)((Math.random()*8999)+1000);
	boolean idok, emailok = false;
	private Image img2;
	
	public IdSearchFrame() {
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

	       
		nameL = new JLabel("�̸�");
		emailL = new JLabel("�̸��� �Է�");
		emailcheckL = new JLabel("������ȣ �Է�");
		
		nameT = new JTextField();
		emailT = new JTextField();
		emailcheckT = new JTextField();
		
		sendBtn = new RoundedButton("�߼�");
		checkBtn = new RoundedButton("����");
		okBtn = new RoundedButton("Ȯ��");
		cancelBtn = new RoundedButton("���");
		
		nameL.setFont(new Font("�ȵ�����������", Font.BOLD, 17));
		emailL.setFont(new Font("�ȵ�����������", Font.BOLD, 17));
		emailcheckL.setFont(new Font("�ȵ�����������", Font.BOLD, 17));
		nameT.setFont(new Font("�ȵ�����������", Font.BOLD, 17));
		emailT.setFont(new Font("�ȵ�����������", Font.BOLD, 17));
		emailcheckT.setFont(new Font("�ȵ�����������", Font.BOLD, 17));
	
		
		nameL.setBounds(210, 290, 80, 40);
	    nameT.setBounds(260, 290, 170, 40);

	    emailL.setBounds(160, 350, 80, 40);
	    emailT.setBounds(260, 350, 170, 40);
	    
	    emailcheckL.setBounds(150, 410, 120, 40);
	    emailcheckT.setBounds(260, 410, 170, 40);
	    
	    sendBtn.setBounds(450, 350, 70, 40);
	    checkBtn.setBounds(450, 410, 70, 40);
	    okBtn.setBounds(270, 460, 70, 40);
	    cancelBtn.setBounds(355, 460, 70, 40);
	     
	    sendBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
	    checkBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
	    okBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16)); 
	    cancelBtn.setFont(new Font("�ȵ�����������", Font.BOLD, 16));
	    background.add(nameL);
	      background.add(nameT);
	      background.add(emailL);
	      background.add(emailT);
	      background.add(emailcheckL);
	      background.add(emailcheckT);
	      
	      background.add(sendBtn);
	      background.add(checkBtn);
	      background.add(okBtn);
	      background.add(cancelBtn);
	     background.setLayout(null);
	     
	     scrollPane = new JScrollPane(background);
	      setContentPane(scrollPane);
	      
	      setTitle("�Ƹ����� ���̷� ���� ���α׷�");
	      setBounds(300, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// �̺�Ʈ
	      okBtn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 if (nameT.getText().isEmpty() || emailT.getText().isEmpty() 
	        				|| emailcheckT.getText().isEmpty()) {
	        			JOptionPane.showMessageDialog(null, "��� �ۼ����ּ���");
	        			return;
	        				} else if(emailok == false) {
	        			JOptionPane.showMessageDialog(null, "�̸��� �����ϼ���");
	        			return;
	        		}else {
	        			String name = nameT.getText();
	        			String email = emailT.getText();
	             
	        			// DB
	        			AmasvinDAO dao = AmasvinDAO.getInstance(); //�̱������� �ٲ�
	        			String idc = dao.idSearchMember(name, email);

	        			if (idc == null) {
	        				JOptionPane.showMessageDialog(null, "��Ȯ�� ������ �Է��ϼ���"); 
	        			} else {
	        				JOptionPane.showMessageDialog(null, name + "�� ���̵�� "+ idc + "�Դϴ�");
	        				 dispose();
	       		          new LoginFrame();
	       		          setVisible(false);
	        			}
	        		}
	         	}
	      });
	      
	   // �̺�Ʈ
	      cancelBtn.addActionListener(new ActionListener() {
	      
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            new LoginFrame();
	            setVisible(false);
	         }
	      });
	      
	      sendBtn.addActionListener(new ActionListener() {
		      
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 String user_email = emailT.getText();
		             
		             EmailCheck ec = new EmailCheck(user_email,num);
		            
		             JOptionPane.showMessageDialog(null, "������ȣ�� �߼۵Ǿ����ϴ�"+num);
		         }
		      });
	      
	      checkBtn.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) { 
	           if(num == Integer.parseInt(emailcheckT.getText())) {
	        	   emailok=true;
	              JOptionPane.showMessageDialog(null, "�̸��� ���� ����");
	           }else {
	        	  emailok=false;
	              JOptionPane.showMessageDialog(null, "������ȣ�� ��ġ���� �ʽ��ϴ�."+"\n"+ "�ٽ� �Է��ϼ���.");
	              emailcheckT.setText("");
	              //writeBtn.setEnabled(false);
	           }           
	          }
	       });    
	}

}
