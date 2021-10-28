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
	
//난수	

	System.out.print("가위(1), 바위(2), 보(3) 중 번호를 입력 : ");
    int a = (int)(Math.random()*3)+1;
    System.out.print("배팅 금액 입력 : ");
    int b = Integer.parseInt(br.readLine());
	System.out.print();

	if(user가 2고, com이 1이면) System.out.println(money + b, "이겼습니다")

	System.out.println("컴퓨터 :" + a + ", " + "나 :" + );
	System.out.println(
	System.out.println("현재 금액은" + df.format() + "원 입니다.");
   }
}
