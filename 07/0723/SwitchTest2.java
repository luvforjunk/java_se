import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SwitchTest2 {
   public static void main(String[ ] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.print("a�� �Է� : ");
      int a = Integer.parseInt(br.readLine());
      System.out.print("b�� �Է� : ");
      int b = Integer.parseInt(br.readLine());
      System.out.print("������(+,-,*,/) : ");
      int op = br.read()); //int op = System.in.read(); �� �ٲ��ְų�.
      //String op = br.readLine(); ��� �ᵵ ��.
	//int op = Integer.parseInt(br.readLine()); ��� �ᵵ ��.

      switch(op){
	case '+' : System.out.println(a + " + " + b + " = " + (a+b)); break;
         case '-' : System.out.println(a + " - " + b + " = " + (a-b)); break;
         case '*' : System.out.println(a + " * " + b + " = " + (a*b)); break;
         case '/' : System.out.println(a + " / " + b + " = " + ((double)a/b)); break;

        /*
         case "+" : System.out.println(a + " + " + b + " = " + (a+b)); break;
         case "-" : System.out.println(a + " - " + b + " = " + (a-b)); break;
         case "*" : System.out.println(a + " * " + b + " = " + (a*b)); break;
         case "/" : System.out.println(a + " / " + b + " = " + ((double)a/b)); break;
         default : System.out.println("������ error");
*/

      }//switch
   }
}
