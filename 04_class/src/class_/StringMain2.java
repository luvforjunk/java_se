/*
ġȯ�ϴ� ���α׷��� �ۼ��Ͻÿ� - indexOf(), replace()
String Ŭ������ �޼ҵ带 �̿��Ͻÿ�
��ҹ��� ������� ������ ����Ͻÿ�

[������]
���ڿ� �Է� : aabba
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddbba
1�� ġȯ
----------------
���ڿ� �Է� : aAbbA
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddbba
1�� ġȯ
----------------
���ڿ� �Է� : aabbaa
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddbbdd
2�� ġȯ
----------------
���ڿ� �Է� : AAccaabbaaaaatt
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddccddbbddddatt
4�� ġȯ
----------------
���ڿ� �Է� : aabb
���� ���ڿ� �Է� : aaaaa
�ٲ� ���ڿ� �Է� : ddddd
�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�
ġȯ �� �� �����ϴ�
 */

package class_;

import java.util.Scanner;

public class StringMain2 {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int index = 0;
      int count = 0;
      
      System.out.print("���ڿ� �Է� : ");
      String str = scan.next().toLowerCase();
      
      System.out.print("���� ���ڿ� �Է� : ");
      String target = scan.next().toLowerCase();

      System.out.print("�ٲ� ���ڿ� �Է� : ");
      String replacing = scan.next();
      
      if(str.length() < target.length())
         System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�");
      else {
         
         while( (index = str.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
         }//while
         
         System.out.println(str.replace(target, replacing));
         System.out.println(count+"�� ġȯ");
      }
   }
}