package constructor;

class ConstructorTest{
   String name=null;
   int age=0;
   
   //������ Overload
   public ConstructorTest() {
      System.out.println("default ������"); 
      System.out.println("this = " + this);
   }
   public ConstructorTest(String name) { //�Ȱ��� Ŭ������ �ܺηκ��� �����͸� ����
      this();
      this.name = name; //�̸� ����
      System.out.println("this = " + this);
   }
   public ConstructorTest(int age) {
      this("�ڳ�"); //Overload�� �ٸ� ������ ȣ��
      this.age = age;
      System.out.println("this = " + this);
   }
   
}
//------------
public class ConstructorMain {

   public static void main(String[] args) {
      ConstructorTest aa = new ConstructorTest(); //������
      System.out.println("aa = " + aa);
      System.out.println("�̸� = " + aa.name + "\t ���� = " + aa.age);
      System.out.println();
      
      ConstructorTest bb = new ConstructorTest("ȫ�浿");
      System.out.println("bb = " + bb);
      System.out.println("�̸� = " + bb.name + "\t ���� = " + bb.age);
      System.out.println();
      
      ConstructorTest cc = new ConstructorTest(25);
      System.out.println("cc = " + cc);
      System.out.println("�̸� = " + cc.name + "\t ���� = " + cc.age);
      System.out.println();
   }

}