package basic;

import java.io.IOException;

public class MemberMain {

   public static void main(String[] args) throws IOException {
      MemberService service = new MemberService();
      service.menu();//호출
      System.out.println("프로그램을 종료합니다");
   }

}