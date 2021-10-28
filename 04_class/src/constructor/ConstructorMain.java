package constructor;

class ConstructorTest{
   String name=null;
   int age=0;
   
   //생성자 Overload
   public ConstructorTest() {
      System.out.println("default 생성자"); 
      System.out.println("this = " + this);
   }
   public ConstructorTest(String name) { //똑같은 클래스와 외부로부터 데이터를 받은
      this();
      this.name = name; //이름 전달
      System.out.println("this = " + this);
   }
   public ConstructorTest(int age) {
      this("코난"); //Overload된 다른 생성자 호출
      this.age = age;
      System.out.println("this = " + this);
   }
   
}
//------------
public class ConstructorMain {

   public static void main(String[] args) {
      ConstructorTest aa = new ConstructorTest(); //생성자
      System.out.println("aa = " + aa);
      System.out.println("이름 = " + aa.name + "\t 나이 = " + aa.age);
      System.out.println();
      
      ConstructorTest bb = new ConstructorTest("홍길동");
      System.out.println("bb = " + bb);
      System.out.println("이름 = " + bb.name + "\t 나이 = " + bb.age);
      System.out.println();
      
      ConstructorTest cc = new ConstructorTest(25);
      System.out.println("cc = " + cc);
      System.out.println("이름 = " + cc.name + "\t 나이 = " + cc.age);
      System.out.println();
   }

}