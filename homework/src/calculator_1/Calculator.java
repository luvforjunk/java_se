
package calculator_1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Calculator extends Frame {
	private Label dispL, inputL;
	private Button[] button; // 라벨 18개

	public Calculator() {
		super("돈 많은 백수의 계산기");

		Panel w = new Panel();   // 전체
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel p5 = new Panel();
		Panel p6 = new Panel();
		Panel p7 = new Panel();
		
		//버튼만들기
		String [] buttonName = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "=", "+", "cal", "^"};
		button = new Button[18];
		for(int i =0; i < 18; i++) {
			button[i] = new Button(buttonName[i]);
		}
		//라벨만들기
		dispL = new Label();
		dispL.setBackground(new Color(220, 225, 125));
		inputL = new Label("0",Label.RIGHT);
		inputL.setBackground(new Color(139,158,204));
		
		//패널
		w.setLayout(new GridLayout(7,1,5,5));
		p1.setLayout(new GridLayout(1,1,5,5));
		p1.add(dispL);
		p2.setLayout(new GridLayout(1,1,5,5));
		p2.add(inputL);
		p3.setLayout(new GridLayout(1,2));
		p3.add(button[16]);
		p3.add(button[17]);
		p4.setLayout(new GridLayout(1,4));
		for(int i=0;i<4;i++) {
			p4.add(button[i]);
		}
		p5.setLayout(new GridLayout(1,4));
		for(int i=4;i<8;i++) {
			p5.add(button[i]);
		}
		p6.setLayout(new GridLayout(1,4));
		for(int i=8;i<12;i++) {
			p6.add(button[i]);
		}
		p7.setLayout(new GridLayout(1,4));
		for(int i=12;i<16;i++) {
			p7.add(button[i]);
		}
		
		w.add(p1);
		w.add(p2);
		w.add(p3);
		w.add(p4);
		w.add(p5);
		w.add(p6);
		w.add(p7);
		add("Center", w);
		
		setBounds(900,180,300,500);
		setBackground(new Color(105,132,224));
		setVisible(true);
	}
	public static void main(String[] args){
		Calculator c = new Calculator();

	}

}
