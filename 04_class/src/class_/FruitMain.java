package class_;

public class FruitMain {

	public static void main(String[] args) {
		FruitTest [] ar = new FruitTest[3];
		for(int i =0; i < ar.length; i++) {
			ar[i] = new FruitTest();
		}
		ar[0].setData("���", 100, 80, 75);
		ar[1].setData("����", 30, 25, 10);
		ar[2].setData("����", 25, 30, 90);
		
		/*2�����
		 FruitTest[] ar = {new FruitTest("���", 100, 80, 75),
		 				   new FruitTest("����", 30, 25, 10),
		 				   new FruitTest("����", 25, 30, 90)};
		 ---------------------------------------------------
		 3�����
		 FruitTest [] ar = new FruitTest[] {new FruitTest("���", 100, 80, 75),
		 				   					new FruitTest("����", 30, 25, 10)
		 				   					new FruitTest("����", 25, 30, 90)};
		 */
		
		System.out.println("---------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("---------------------------------");
		
		for(FruitTest data : ar) {
	         data.calcTot();
	         data.display();
	      }
	      
	      System.out.println("------------------------------------");
	      FruitTest.output();
	   
	}
}