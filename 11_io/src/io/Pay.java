package io;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Pay {		
	
	public static void main(String[] args) {
		
		// 부모 프레임 생성 및 기본 스타일 지정
		JFrame frame = new JFrame("주문 관리 프로그램");
		setJFrameStyle(frame);
		
		// 자식 레이아웃 [음식 주문 내역] 생성
		JLabel foodL = new JLabel("디저트");
		foodL.setBounds(0, 0, 100, 50);
		setJLabelStyle(foodL);
		
		String foodArray[] = {"카페라떼", "아이스아메리카노", "아이스바닐라라떼", "아이스티"};
		JComboBox<String> foodCombo = new JComboBox<String>(foodArray);
		foodCombo.setBounds(100, 0, 300, 50); 
		setJComboBoxStyle(foodCombo);
		
		JButton food_add_btn = new JButton("음식추가");			
		food_add_btn.setBounds(400, 0, 100, 50); 
		setJButtonStyle(food_add_btn); // 기본 버튼 스타일 지정 메소드 호출
		
		
		// [음료 주문 내역] 생성
		JLabel drinkL = new JLabel("음료");
		drinkL.setBounds(0, 55, 100, 50); 
		setJLabelStyle(drinkL);
				
		String drinkArray [] = {"카페라떼", "아이스아메리카노", "아이스바닐라라떼", "아이스티"};
		JComboBox<String> drink_combo = new JComboBox<String>(drinkArray);
		drink_combo.setBounds(100, 55, 300, 50); 
		setJComboBoxStyle(drink_combo);
			
		JButton drink_add_btn = new JButton("음료추가");			
		drink_add_btn.setBounds(400, 55, 100, 50);
		setJButtonStyle(drink_add_btn); // 기본 버튼 스타일 지정 메소드 호출
		
		
		// 자식 레이아웃 [테이블] 생성
		String titleArray[] = {"주문내역", "가격"};
		DefaultTableModel model = new DefaultTableModel(titleArray, 0);
		JTable table = new JTable(model);		
		JScrollPane scrollPane = new JScrollPane(table);	
		scrollPane.getViewport().setBackground(Color.WHITE); //JScrollPane에 배경색 지정
		scrollPane.setBounds(0, 110, 500, 285);				
		ArrayList pay_list = new ArrayList(); //결제 금액 관련 리스트 선언
		
		
		// 자식 레이아웃 [결제 및 삭제 버튼] 생성
		JButton pay_btn = new JButton("결제");
		setJButtonStyle(pay_btn); // 기본 버튼 스타일 지정 메소드 호출
		
		JButton del_btn = new JButton("삭제");			
		setJButtonStyle(del_btn); // 기본 버튼 스타일 지정 메소드 호출
		
		JPanel btn_flow_panel = new JPanel();
		btn_flow_panel.setLayout(new FlowLayout()); // 가운데 중심 배치 레이아웃 (윈도우창 크기를 벗어나면 자동 줄바꿈 실시)
		btn_flow_panel.add(pay_btn);
		btn_flow_panel.add(del_btn);
		btn_flow_panel.setBackground(Color.WHITE);
		btn_flow_panel.setBounds(0, 400, 500, 100); 
		
		
		// 자식 레이아웃 [버튼] 클릭 이벤트 정의 실시		
		ActionListener action = new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals("음식추가")) { // 음식 추가 버튼 클릭이벤트 처리
					// 입력된 값 테이블에 추가하기
					String info[] = new String[2]; //한 행에 저장할 데이터 모음
					info[0] = foodCombo.getSelectedItem().toString(); //콤보박스 값을 가져온다
					info[1] = "5000";									
					model.addRow(info); //테이블 모델에 데이터 삽입 실시
					pay_list.add(foodCombo.getSelectedItem().toString()+" : "+"5000"); //결제 금액 리스트에 추가
				}
				else if (e.getActionCommand().equals("음료추가")) { // 음식 추가 버튼 클릭이벤트 처리
					// 입력된 값 테이블에 추가하기
					String info[] = new String[2]; //한행 (row) 에 저장할 데이터 모음
					info[0] = drink_combo.getSelectedItem().toString(); //콤보박스 값을 가져온다
					info[1] = "3000";									
					model.addRow(info); //테이블 모델에 데이터 삽입 실시					
					pay_list.add(drink_combo.getSelectedItem().toString()+" : "+"3000"); //결제 금액 리스트에 추가
				}
				else if(e.getActionCommand().equals("결제")) { // 결제 버튼 클릭이벤트 처리
					/** [질문 알림창]*/ 
					int qut_data = JOptionPane.showConfirmDialog(frame, "주문을 결제하시겠습니까?","주문내역", 
							JOptionPane.YES_NO_CANCEL_OPTION);
					if(qut_data == 0) { //[예] 버튼
						System.out.println(pay_list.toString());
						JOptionPane.showMessageDialog(frame, "결제되었습니다."+"\n"+"[주문내역]\n"+pay_list.toString());
					}
					else if(qut_data == 1) { //[아니오] 버튼
						
					}
					else if(qut_data == 2){ //[취소] 버튼
						
					}

				}
				else if(e.getActionCommand().equals("삭제")) { // 삭제 버튼 클릭이벤트 처리
					//선택한 줄(row)의 번호 알아내기
					int rowIndex = table.getSelectedRow();
					
					//선택 안하고 누를 경우 리턴값 -1
					if(rowIndex == -1) {
						return;	
					}
					model.removeRow(rowIndex); //해당 테이블 행 삭제
					pay_list.remove(rowIndex); //결제 금액 리스트에서도 삭제 실시
				}
			}
		};
		food_add_btn.addActionListener(action);
		drink_add_btn.addActionListener(action);
		pay_btn.addActionListener(action);
		del_btn.addActionListener(action);		
				
		
		// 부모 프레임에다가 자식 컴포넌트 추가		
		frame.getContentPane().add(foodL);
		frame.getContentPane().add(foodCombo);
		frame.getContentPane().add(food_add_btn);
		
		frame.getContentPane().add(drinkL);
		frame.getContentPane().add(drink_combo);
		frame.getContentPane().add(drink_add_btn);
		
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.getContentPane().add(btn_flow_panel);
		
		
		frame.setVisible(true);
		
	} // void main
	
	// JFrame 부모 기본 스타일 지정 메소드
	public static void setJFrameStyle(JFrame frame) {
		// 프레임 크기 설정 (가로, 세로) 및 배경색 지정
		frame.setSize(500, 500);
		frame.setBackground(Color.BLACK);		 
		// 프레임을 화면 가운데에 배치
		frame.setLocationRelativeTo(null);		 
		// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		// 프레임 창 크기 고정 실시
		frame.setResizable(false);		 
		// 레이아웃 설정
		frame.getContentPane().setLayout(null);
	}	
	
	// JLabel 기본 스타일 지정 메소드
	public static void setJLabelStyle(JLabel txt) {						
		txt.setBackground(Color.GRAY);
		txt.setForeground(Color.WHITE); 
		txt.setFont(new Font("맑은 고딕", 0, 15)); 
		txt.setHorizontalAlignment(JLabel.CENTER); // 텍스트 센터 표시 설정
	}
	
	// JComboBox 기본 스타일 지정 메소드
	public static void setJComboBoxStyle(JComboBox combo) {							
		combo.setBackground(Color.LIGHT_GRAY);
		combo.setForeground(Color.WHITE); 
		combo.setFont(new Font("맑은 고딕", 0, 15)); 
	}
	
	// JButton 기본 스타일 지정 메소드
	public static void setJButtonStyle(JButton btn) {
		btn.setBackground(Color.DARK_GRAY); 
		btn.setForeground(Color.WHITE); 
		btn.setFont(new Font("맑은 고딕", 0, 15));
		btn.setHorizontalAlignment(JLabel.CENTER);
	}		

} //Pay
