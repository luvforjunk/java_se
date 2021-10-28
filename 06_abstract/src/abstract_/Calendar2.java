package abstract_;

import java.util.Calendar;
import java.util.Scanner;

public class Calendar2 {
   Scanner scan = new Scanner(System.in);
   private int year, month, week, lastDay, dayOfWeek;
   
   //������ - �Է¹ޱ�
   public Calendar2(){
      System.out.print("�⵵ �Է� : ");
      year = scan.nextInt();
      System.out.print("�� �Է� : ");
      month = scan.nextInt();
      calc();
      display();
   }
   
   public void calc() {
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, year);
      cal.set(Calendar.MONTH, month);
      cal.set(year, month-1, 1);
      
      lastDay = cal.getActualMaximum(Calendar.DATE);
      dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
   }
   
   public void display() {
      System.out.println();
      System.out.println("��"+"\t"+"��"+"\t"+"ȭ"+"\t"+"��"+"\t"+"��"+"\t"+"��"+"\t"+"��");
      
      for(int i=1; i<=lastDay; i++) {
         if(i==1) {
            for(int j=1; j<dayOfWeek; j++)
               System.out.print("\t");
         }
         System.out.print(i+"\t");
         
         if(dayOfWeek%7==0)
         System.out.println();
         
         dayOfWeek++;
      }
      System.out.println("\n");
      System.out.println("�� �� ������ �� : "+lastDay);
   }
   
   //--------------------------------------------------
   public static void main(String[] args) {
      new Calendar2();
   } //main
}