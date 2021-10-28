/*
[계산기 과제]
Panel + GridLayout
setLayout(null)

private Button[] btn;
- 배열의 크기는 18개로 잡고 for문을 사용하여 생성한다.

private Label dispL
	      inputL 
-inputL에 0은 오른쪽에 표시한다.
-Label에 바탕색을 입힌다.
*/
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

import javax.swing.JTextField;

public class Calculator extends Frame implements ActionListener, WindowListener {

	private Label dispL, inputL; // 필드
	private Button[] btn; // 라벨(버튼) 18개
	private DecimalFormat df = new DecimalFormat("#,###.#######");
	StringBuffer sb = new StringBuffer();
	private String disp; // 중간 결과값
	private int op; // 연산자
	public double result; // 맨 처음값
	public double number;
	boolean opClick = false;

	public Calculator() { // 생성자 호출
		super("돈 많은 백수의 계산기"); // 부모 생성자 호출

		Panel w = new Panel(); // 전체

		Panel p1 = new Panel(); // 총 7줄
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel p5 = new Panel();
		Panel p6 = new Panel();
		Panel p7 = new Panel();

		// 버튼만들기
		// 버튼 값들을 String배열 안에 넣어주고, 이 버튼을 새로운 배열 클래스의 값 하나하나에 담아주는 for문을 만든다
		String[] btnName = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "=", "+", "←", "C" };
		btn = new Button[18];
		for (int i = 0; i < 18; i++) {
			btn[i] = new Button(btnName[i]);
		}
		// 라벨만들기
		dispL = new Label("0", Label.RIGHT);
		dispL.setBackground(new Color(220, 225, 125));
		inputL = new Label("0", Label.RIGHT);
		inputL.setBackground(new Color(128, 153, 204));

		// 패널
		// 만든 버튼들을 그리드 레이아웃 클래스 호출을 통해 하나의 패널을 1줄, 4칸 짜리로 만든 후 버튼 4개씩 넣어준다.
		// 마지막 7개의 패널을 담을 전체 패널 역시 7줄, 1칸의 그리드 레이아웃으로 잡아줌
		w.setLayout(new GridLayout(7, 1, 5, 5));
		p1.setLayout(new GridLayout(1, 1, 5, 5));
		p1.add(dispL);
		p2.setLayout(new GridLayout(1, 1, 5, 5));
		p2.add(inputL);
		p3.setLayout(new GridLayout(1, 2));
		p3.add(btn[16]);
		p3.add(btn[17]);
		p4.setLayout(new GridLayout(1, 4));
		for (int i = 0; i < 4; i++) {
			p4.add(btn[i]);
		}
		p5.setLayout(new GridLayout(1, 4));
		for (int i = 4; i < 8; i++) {
			p5.add(btn[i]);
		}
		p6.setLayout(new GridLayout(1, 4));
		for (int i = 8; i < 12; i++) {
			p6.add(btn[i]);
		}
		p7.setLayout(new GridLayout(1, 4));
		for (int i = 12; i < 16; i++) {
			p7.add(btn[i]);
		}

		w.add(p1); // 전체 판넬에 값 넣어주기
		w.add(p2);
		w.add(p3);
		w.add(p4);
		w.add(p5);
		w.add(p6);
		w.add(p7);
		add("Center", w);

		setBounds(900, 180, 300, 500); // 창의 크기
		setBackground(new Color(105, 132, 224)); // 창의 색깔
		setVisible(true); // 창 열기

		// 이벤트

		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(this);
		}
		this.addWindowListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// 계산이 한번 종료된 후, 그 값에 다시 계산을
		if (op == 61) {
			sb.delete(0, sb.length());
			sb.append(result);
			disp = "";
			op = 0;
			dispL.setText(disp);

		}
		if (e.getActionCommand() == "1") {
			sb.append(1);
		} else if (e.getActionCommand() == "2") {
			sb.append(2);
		} else if (e.getActionCommand() == "3") {
			sb.append(3);
		} else if (e.getActionCommand() == "4") {
			sb.append(4);
		} else if (e.getActionCommand() == "5") {
			sb.append(5);
		} else if (e.getActionCommand() == "6") {
			sb.append(6);
		} else if (e.getActionCommand() == "7") {
			sb.append(7);
		} else if (e.getActionCommand() == "8") {
			sb.append(8);
		} else if (e.getActionCommand() == "9") {
			sb.append(9);
		} else if (e.getActionCommand() == "0") {
			sb.append(0);
		} else if (e.getActionCommand() == "C") {
			sb.delete(0, sb.length());
			dispL.setText("0");
			disp = "";
			result = 0;
			op = 0;
		} else if (e.getActionCommand() == "←") {
			if (sb.length() > 0)
				sb = sb.delete(sb.length() - 1, sb.length());
			else
				sb.delete(0, sb.length());
		} else if (e.getActionCommand() == ".") {
			if (sb.indexOf(".") == -1) {
				if (inputL.getText().equals("0")) {
					sb.append("0.");
				} else {
					sb.append(".");
				}
			}
		} else {
			// 연산자 버튼을 클릭하는 모든 경우(+,-,*,/)
			opClick = true;
			// disp안의 값이 null인지 아닌지 확인
			if (disp != null)
				disp += sb.toString();
			else
				disp = sb.toString();
			// op안에 연산자의 값이 있는지 확인;
			if (op == 0) {
				result = Double.parseDouble(sb.toString());
				// 연산자를 10진수로 변환
				op = e.getActionCommand().hashCode();
				disp += e.getActionCommand();
				dispL.setText(disp);
			} else {
				disp += e.getActionCommand();
				if (op == 43) { // "+"
					result += Double.parseDouble(sb.toString());
					dispL.setText(disp);
				} else if (op == 45) { // "-"
					result -= Double.parseDouble(sb.toString());
					dispL.setText(disp);
				} else if (op == 42) { // "*"
					result *= Double.parseDouble(sb.toString());
					dispL.setText(disp);
				} else if (op == 47) { // "/"
					result /= Double.parseDouble(sb.toString());
					dispL.setText(disp);
				}
				op = e.getActionCommand().hashCode();
			}
			sb.delete(0, sb.length());
		}

		// StringBuffer의 값을 임시로 담을 temp 변수 생성
		String temp; // 정수를 변수에 담아버리기
		String temp2; // 실수를 변수에 담아버리기
		
		// StringBuffer 안에 값이 존재하는지 여부를 체크
		if (sb.length() > 0) {
			// StrinBuffer에 소수점이 있는 경우
			if (sb.indexOf(".") != -1) {
				if (sb.indexOf(".") == sb.length() - 1) {
					// StringBuffer에 입력된 맨 끝 값이 소수점일 경우
					temp = sb.substring(0, sb.indexOf("."));
					temp = df.format(Integer.parseInt(temp));
					temp += ".";
					inputL.setText(temp);
				} else {
					// 소수점을 기준으로 정수부분은 temp에, 소수부분은 temp2에 저장 후 합침
					temp = sb.substring(0, sb.indexOf("."));
					temp2 = sb.substring(sb.indexOf(".") + 1, sb.length());
					temp = df.format(Integer.parseInt(temp));
					temp += ".";
					temp += temp2;
					inputL.setText(temp);
				}
			} else {
				temp = sb.toString();
				temp = df.format(Integer.parseInt((temp)));
				inputL.setText(temp);
			}
		} else
			inputL.setText("0");
		// 연산자가 클릭 시, inputL에 계산한 result값이 보이게 설정/ "="버튼을 클릭하였을 시 최종 결과값 표시
		if (opClick == true || op == 61) {
			inputL.setText(Double.toString(result));
			opClick = false;
		}
	}

	// WindowListener Override - 창 닫기
	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
