import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IfTest3 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.print("첫번째 입력 : ");
      int a = Integer.parseInt(br.readLine());
      System.out.print("두번째 입력 : ");
      int b = Integer.parseInt(br.readLine());
      System.out.print("세번째 입력 : ");
      int c = Integer.parseInt(br.readLine());

      if(a<b && a<c) { //만약에 a가 가장 작다면
         if(b<c) System.out.println(a+ ", " +b+ ", " +c); //a가 제일 작다면 그다음 작은 건 b냐
         else System.out.println(a+ ", " +c+ ", " +b); //아니다, c가 그다음으로 작은거다.

      }else if(b<c){ //만약에 b가 제일 작다면
         if(a<c) System.out.println(b+", "+a+", "+c);
         else System.out.println(b+", "+c+", "+a);

      }else{ //만약에 c가 제일 작다면
         if(a<b) System.out.println(c+", "+a+", "+b);
         else System.out.println(c+", "+b+", "+a);
      }
   }
}
