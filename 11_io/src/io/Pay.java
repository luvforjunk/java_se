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
		
		// �θ� ������ ���� �� �⺻ ��Ÿ�� ����
		JFrame frame = new JFrame("�ֹ� ���� ���α׷�");
		setJFrameStyle(frame);
		
		// �ڽ� ���̾ƿ� [���� �ֹ� ����] ����
		JLabel foodL = new JLabel("����Ʈ");
		foodL.setBounds(0, 0, 100, 50);
		setJLabelStyle(foodL);
		
		String foodArray[] = {"ī���", "���̽��Ƹ޸�ī��", "���̽��ٴҶ��", "���̽�Ƽ"};
		JComboBox<String> foodCombo = new JComboBox<String>(foodArray);
		foodCombo.setBounds(100, 0, 300, 50); 
		setJComboBoxStyle(foodCombo);
		
		JButton food_add_btn = new JButton("�����߰�");			
		food_add_btn.setBounds(400, 0, 100, 50); 
		setJButtonStyle(food_add_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��
		
		
		// [���� �ֹ� ����] ����
		JLabel drinkL = new JLabel("����");
		drinkL.setBounds(0, 55, 100, 50); 
		setJLabelStyle(drinkL);
				
		String drinkArray [] = {"ī���", "���̽��Ƹ޸�ī��", "���̽��ٴҶ��", "���̽�Ƽ"};
		JComboBox<String> drink_combo = new JComboBox<String>(drinkArray);
		drink_combo.setBounds(100, 55, 300, 50); 
		setJComboBoxStyle(drink_combo);
			
		JButton drink_add_btn = new JButton("�����߰�");			
		drink_add_btn.setBounds(400, 55, 100, 50);
		setJButtonStyle(drink_add_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��
		
		
		// �ڽ� ���̾ƿ� [���̺�] ����
		String titleArray[] = {"�ֹ�����", "����"};
		DefaultTableModel model = new DefaultTableModel(titleArray, 0);
		JTable table = new JTable(model);		
		JScrollPane scrollPane = new JScrollPane(table);	
		scrollPane.getViewport().setBackground(Color.WHITE); //JScrollPane�� ���� ����
		scrollPane.setBounds(0, 110, 500, 285);				
		ArrayList pay_list = new ArrayList(); //���� �ݾ� ���� ����Ʈ ����
		
		
		// �ڽ� ���̾ƿ� [���� �� ���� ��ư] ����
		JButton pay_btn = new JButton("����");
		setJButtonStyle(pay_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��
		
		JButton del_btn = new JButton("����");			
		setJButtonStyle(del_btn); // �⺻ ��ư ��Ÿ�� ���� �޼ҵ� ȣ��
		
		JPanel btn_flow_panel = new JPanel();
		btn_flow_panel.setLayout(new FlowLayout()); // ��� �߽� ��ġ ���̾ƿ� (������â ũ�⸦ ����� �ڵ� �ٹٲ� �ǽ�)
		btn_flow_panel.add(pay_btn);
		btn_flow_panel.add(del_btn);
		btn_flow_panel.setBackground(Color.WHITE);
		btn_flow_panel.setBounds(0, 400, 500, 100); 
		
		
		// �ڽ� ���̾ƿ� [��ư] Ŭ�� �̺�Ʈ ���� �ǽ�		
		ActionListener action = new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals("�����߰�")) { // ���� �߰� ��ư Ŭ���̺�Ʈ ó��
					// �Էµ� �� ���̺� �߰��ϱ�
					String info[] = new String[2]; //�� �࿡ ������ ������ ����
					info[0] = foodCombo.getSelectedItem().toString(); //�޺��ڽ� ���� �����´�
					info[1] = "5000";									
					model.addRow(info); //���̺� �𵨿� ������ ���� �ǽ�
					pay_list.add(foodCombo.getSelectedItem().toString()+" : "+"5000"); //���� �ݾ� ����Ʈ�� �߰�
				}
				else if (e.getActionCommand().equals("�����߰�")) { // ���� �߰� ��ư Ŭ���̺�Ʈ ó��
					// �Էµ� �� ���̺� �߰��ϱ�
					String info[] = new String[2]; //���� (row) �� ������ ������ ����
					info[0] = drink_combo.getSelectedItem().toString(); //�޺��ڽ� ���� �����´�
					info[1] = "3000";									
					model.addRow(info); //���̺� �𵨿� ������ ���� �ǽ�					
					pay_list.add(drink_combo.getSelectedItem().toString()+" : "+"3000"); //���� �ݾ� ����Ʈ�� �߰�
				}
				else if(e.getActionCommand().equals("����")) { // ���� ��ư Ŭ���̺�Ʈ ó��
					/** [���� �˸�â]*/ 
					int qut_data = JOptionPane.showConfirmDialog(frame, "�ֹ��� �����Ͻðڽ��ϱ�?","�ֹ�����", 
							JOptionPane.YES_NO_CANCEL_OPTION);
					if(qut_data == 0) { //[��] ��ư
						System.out.println(pay_list.toString());
						JOptionPane.showMessageDialog(frame, "�����Ǿ����ϴ�."+"\n"+"[�ֹ�����]\n"+pay_list.toString());
					}
					else if(qut_data == 1) { //[�ƴϿ�] ��ư
						
					}
					else if(qut_data == 2){ //[���] ��ư
						
					}

				}
				else if(e.getActionCommand().equals("����")) { // ���� ��ư Ŭ���̺�Ʈ ó��
					//������ ��(row)�� ��ȣ �˾Ƴ���
					int rowIndex = table.getSelectedRow();
					
					//���� ���ϰ� ���� ��� ���ϰ� -1
					if(rowIndex == -1) {
						return;	
					}
					model.removeRow(rowIndex); //�ش� ���̺� �� ����
					pay_list.remove(rowIndex); //���� �ݾ� ����Ʈ������ ���� �ǽ�
				}
			}
		};
		food_add_btn.addActionListener(action);
		drink_add_btn.addActionListener(action);
		pay_btn.addActionListener(action);
		del_btn.addActionListener(action);		
				
		
		// �θ� �����ӿ��ٰ� �ڽ� ������Ʈ �߰�		
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
	
	// JFrame �θ� �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJFrameStyle(JFrame frame) {
		// ������ ũ�� ���� (����, ����) �� ���� ����
		frame.setSize(500, 500);
		frame.setBackground(Color.BLACK);		 
		// �������� ȭ�� ����� ��ġ
		frame.setLocationRelativeTo(null);		 
		// �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		// ������ â ũ�� ���� �ǽ�
		frame.setResizable(false);		 
		// ���̾ƿ� ����
		frame.getContentPane().setLayout(null);
	}	
	
	// JLabel �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJLabelStyle(JLabel txt) {						
		txt.setBackground(Color.GRAY);
		txt.setForeground(Color.WHITE); 
		txt.setFont(new Font("���� ���", 0, 15)); 
		txt.setHorizontalAlignment(JLabel.CENTER); // �ؽ�Ʈ ���� ǥ�� ����
	}
	
	// JComboBox �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJComboBoxStyle(JComboBox combo) {							
		combo.setBackground(Color.LIGHT_GRAY);
		combo.setForeground(Color.WHITE); 
		combo.setFont(new Font("���� ���", 0, 15)); 
	}
	
	// JButton �⺻ ��Ÿ�� ���� �޼ҵ�
	public static void setJButtonStyle(JButton btn) {
		btn.setBackground(Color.DARK_GRAY); 
		btn.setForeground(Color.WHITE); 
		btn.setFont(new Font("���� ���", 0, 15));
		btn.setHorizontalAlignment(JLabel.CENTER);
	}		

} //Pay
