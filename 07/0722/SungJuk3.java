class SungJuk3 {
   public static void main(String[] args) {

      String name;
     
      int kor = Integer.parseInt(args[1]);
      int eng = Integer.parseInt(args[2]);
      int math = Integer.parseInt(args[3]);

      //SungJuk total = new SungJuk();
      //int tot = total();
      //double ave = average();

	  System.out.println("***" + args[0] + " ����ǥ ***");
      System.out.println("����\t����\t����\t����\t���");
      System.out.println(args[1] + "\t" + args[2] + "\t" + args[3]);
   }
   public int total(int kor, int eng, int math){
      return kor + eng + math;
   }
}