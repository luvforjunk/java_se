class Money {
   public static void main(String[] args) {
      int money = 5679;
   
      int thousand = money / 1000;
      int hundred = money % 1000 / 100;
      int ten = money % 1000 % 100 / 10;
      int one = money % 1000 % 100 % 10;

      System.out.println("�ݾ� : " + money + "��");
      System.out.println("õ�� : " + thousand + "��");
      System.out.println("��� : " + hundred + "��");
      System.out.println("�ʿ� : " + ten + "��");
      System.out.println("�Ͽ� : " + one + "��");

   }
}
