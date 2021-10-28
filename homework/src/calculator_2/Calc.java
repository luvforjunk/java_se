package calculator_2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

public class Calc extends Frame implements WindowListener, ActionListener{
   private Label dispL, inputL; 
   private Button[] btn;
   private String[] button_value= {"←","C",
                               "7","8","9","/",
                               "4","5","6","*",
                               "1","2","3","-",
                               ".","0","=","+"};

   private StringBuffer dispBuffer = new StringBuffer();
   private StringBuffer inputBuffer = new StringBuffer();
   
   private double result;
   private char op;
   private DecimalFormat df = new DecimalFormat("#,###.#######");
         
   public void init() {
      dispL = new Label("");
      inputL = new Label("0", Label.RIGHT);
      
      btn = new Button[18]; 
      for(int i= 0; i<btn.length; i++) {
         btn[i] = new Button(button_value[i]);
      }
      
      setLayout(null);
      setLayout(new GridLayout(7,1,5,5));

      dispL.setBounds(5, 50, 287, 50);
      inputL.setBounds(5, 105, 287, 50);
      dispL.setBackground(new Color(141,184,197));
      inputL.setBackground(new Color(141,184,197));
      add(dispL);
      add(inputL);
    
      Panel p = new Panel();
      p.setLayout(new GridLayout(1,2,5,5));
      for(int i = 0; i<2; i++) {
         p.add(btn[i]);
      }
      add(p);
      
      Panel p2 = new Panel();
      p2.setLayout(new GridLayout(1,4,5,5));
      for(int i = 2; i<6; i++) {
         p2.add(btn[i]);
      }
      add(p2);
      
      Panel p3 = new Panel();
      p3.setLayout(new GridLayout(1,4,5,5));
      for(int i = 6; i<10; i++) {
         p3.add(btn[i]);
      }
      add(p3);
      
      Panel p4 = new Panel();
      p4.setLayout(new GridLayout(1,4,5,5));
      for(int i = 10; i<14; i++) {
         p4.add(btn[i]);
      }
      add(p4);
      
      Panel p5 = new Panel();
      p5.setLayout(new GridLayout(1,4,5,5));
      for(int i = 14; i<18; i++) {
         p5.add(btn[i]);
      }
      add(p5);
      
      setTitle("계산기");
      setBounds(900,200,300,400);
      setVisible(true);
         
      //이벤트 
      this.addWindowListener(this);
      
      for(int i = 0; i<btn.length; i++) {
         btn[i].addActionListener(this);
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      //숫자
      if(e.getActionCommand() == "1"||
         e.getActionCommand() == "2"||
         e.getActionCommand() == "3"||
         e.getActionCommand() == "4"||
         e.getActionCommand() == "5"||
         e.getActionCommand() == "6"||
         e.getActionCommand() == "7"||
         e.getActionCommand() == "8"||
         e.getActionCommand() == "9"||
         e.getActionCommand() == "0") {
         
         if(inputBuffer.length()==1 && inputBuffer.toString().equals("0")) {
            inputBuffer.delete(0, 1);
         }
         
         inputBuffer.append(e.getActionCommand());//메모리
         inputL.setText(inputBuffer+"");
         inputL.setText(inputBuffer.toString()); 
      
      }else if(e.getActionCommand() == "C") {
         inputBuffer.delete(0, inputBuffer.length());
         
         inputL.setText("0");
      
      }else if(e.getActionCommand() == ".") {
         if(inputBuffer.indexOf(".") == -1) {
            inputBuffer.append(".");
         }
         inputL.setText(inputBuffer+"");
         
      }else if(e.getActionCommand() == "←") {
         inputBuffer.delete(inputBuffer.length()-1, inputBuffer.length());
         if(inputBuffer.length() == 0)
            inputBuffer.append("0");
         
         inputL.setText(inputBuffer+"");
      }
      
      
   }
   
   @Override
   public void windowOpened(WindowEvent e) {}
   @Override
   public void windowClosing(WindowEvent e) {
      System.exit(0);
   }
   @Override
   public void windowClosed(WindowEvent e) {}
   @Override
   public void windowIconified(WindowEvent e) {}
   @Override
   public void windowDeiconified(WindowEvent e) {}
   @Override
   public void windowActivated(WindowEvent e) {}
   @Override
   public void windowDeactivated(WindowEvent e) {}
   
   public static void main(String[] args) {
      new Calc().init();
   }
}