/*
 1~10까지의 합을 구하시오.
 
 [결과]
 i	sum	mul
 1	1	1(1*1)	  
 2	3	2(1*2)
 3	6	6(2*3)
 4	10	24(2*3*4)
 5	15	120(2*3*4*5)
 6	21
 7	28
 8	36
 9	45
 10	55
 */

package for_;

public class ForTest4 {

	public static void main(String[] args) {
		int sum = 0;
		int mul = 1;

		for (int i = 1; i <= 10; i++) {
			sum += i;// sum = sum + i;
			mul *= i;
			System.out.println(i + "\t" + sum + "\t" + mul);
		} // for

	}

}