/*
1��б��� ���Ϻ� �հ�� ���� �հ踦 ���Ͻÿ�
(��ü�迭 ���)

Ŭ���� : FruitTest
�ʵ�  : pum, jan, feb, mar, tot
       sumJan, sumFeb, sumMar
       
�޼ҵ� : ������
       calcTot()
       display()
       output() - ���� ���  

[������]
---------------------------------
PUM      JAN   FEB   MAR      TOT
---------------------------------
���    100    80    75        255
����     30    25    10        xxx
����     25    30    90        xxx
---------------------------------
        xxx   xxx   xxx
 
 */

package class_;

public class FruitTest {
	private String pum;
	private int jan, feb, mar, tot;
	private static int sumJan, sumFeb, sumMar;

	public FruitTest() {
	}

	public FruitTest(String pum, int jan, int feb, int mar) {
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}

	public void setData(String pum, int jan, int feb, int mar) {
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}

	public void calcTot() {
		tot = jan + feb + mar;

		sumJan += jan;
		sumFeb += feb;
		sumMar += mar;
	}

	public void display() {
		System.out.println(pum + "\t" + jan + "\t" + feb + "\t" + mar + "\t" + tot);
	}

	public static void output() {
		System.out.println("\t" + sumJan + "\t" + sumFeb + "\t" + sumMar);
	}
}

/*
 * 1. private �ʵ尪 pum, jan, feb, mar, tot, sumJan, sumFeb, sumMar �Է� 2.
 */
