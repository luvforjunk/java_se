package miniproject1;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;


public class EmailCheck {
//	private String user_email;
//	private int num;
//	
public EmailCheck(String user_email, int num) {
//	this.num = num;
//	this.user_email =user_email;
    String user = "csj187108@gmail.com"; // ���̹��� ��� ���̹� ����, gmail��� gmail ����
    String password = "!@qaz187108";   // �н�����
 
    // SMTP ���� ������ �����Ѵ�.
    Properties prop = new Properties();
  
    prop.put("mail.smtp.host", "smtp.gmail.com"); 
    prop.put("mail.smtp.port", 465); 
    prop.put("mail.smtp.auth", "true"); 
    prop.put("mail.smtp.ssl.enable","true"); 
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    prop.put("mail.smtp.starttls.required", "true");
    prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

    Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
        }
    });

    try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));

        //�����ڸ����ּ�
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(user_email)); 

        // Subject
        message.setSubject("�Ƹ����� ���̷� ���� ȸ�������� ���� ������ȣ �߼�"); //���� ������ �Է�

        // Text
        message.setText("�Ʒ��� ������ȣ�� ȸ������â�� ������ȣ���� �Է����ּ���"+"\n"+"������ȣ : "+num);    //���� ������ �Է�

        // send the message
        Transport.send(message); ////����
        System.out.println("message sent successfully...");
    } catch (AddressException e) {
        e.printStackTrace();
    } catch (MessagingException e) {
        e.printStackTrace();
    }
}


}
/*
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


                       public static  String FROM =  "znzl9dnjwnj@naver.com";
                       public static   String FROMNAME = "Crazy Acade ���� ������ȣ����";
                       public static  String TO = "email";
   public static final  String SMTP_USERNAME = "���̵�"
   public static final  String SMTP_PASSWORD = "���"
    
    static final String HOST = "smtp.naver.com";
    static final int PORT = 587;
                           static final String SUBJECT = "���� ����";

            
    
    public EmailCheck(GameJoin gameJoin, String num) {
       try {
          TO = gameJoin.emailcheckT.getText().trim();
          Properties props = System.getProperties();
          props.put("mail.transport.protocol", "smtp");
          props.put("mail.smtp.port", PORT); 
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.smtp.auth", "true");
          Session session = Session.getDefaultInstance(props);
         
          MimeMessage msg = new MimeMessage(session);
          msg.setFrom(new InternetAddress(FROM, FROMNAME));
          //�޴»�� ���� 
          msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
          msg.setSubject(SUBJECT);
          msg.setContent(String.join(
                  System.getProperty("line.separator"),
                  "<h1>���� ���� ��й�ȣ</h1>",
                  "<p>"+
                  num +                 "</p>"
                  ), "text/html;charset=euc-kr");
          
          Transport transport = session.getTransport();
          try {
             System.out.println("Sending...");
             
             transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
             transport.sendMessage(msg, msg.getAllRecipients());
             System.out.println("Email sent!");
          } catch (Exception ex) {
             ex.printStackTrace();
          }finally {
             transport.close();
          }
       }catch(Exception e) {
          e.printStackTrace();
       }
    }
}*/