import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.io.InputStreamReader;
import java.io.IOException;

class Game {
   public static void main(String[ ] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      	int com, user;
     	int money = 1000;

	DecimalFormat df = new DecimalFormat ();
	
//����	

	System.out.print("����(1), ����(2), ��(3) �� ��ȣ�� �Է� : ");
    int a = (int)(Math.random()*3)+1;
    System.out.print("���� �ݾ� �Է� : ");
    int b = Integer.parseInt(br.readLine());
	System.out.print();

	if(user�� 2��, com�� 1�̸�) System.out.println(money + b, "�̰���ϴ�")

	System.out.println("��ǻ�� :" + a + ", " + "�� :" + );
	System.out.println(
	System.out.println("���� �ݾ���" + df.format() + "�� �Դϴ�.");
   }
}
