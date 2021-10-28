/*
���� �޷�
- �⵵, ���� �Է��Ͽ� �޷��� ����Ͻÿ�
- �ſ� �����ϴ� ������ ���Ͻÿ� - �޼ҵ�
- �ſ� ������ ��(30, 28, 29, 31)�� ���Ͻÿ� - �޼ҵ�
- Ŭ���� : CalendarTest
  �ʵ�  : year, month, week, lastDay
  ������ : �Է�
  �޼ҵ� : calc()
         display()

[������]
�⵵ �Է� : 2002
�� �Է� : 10

��   ��   ȭ   ��   ��   ��   ��
      1   2   3   4   5
6   7   8   9   10   11   12
13   14   15   16   17   18   19
20   21   22   23   24   25   26
27   28   29   30   31
 */

package abstract_;

import java.util.Calendar;
import java.util.Scanner;

class CalendarTest {
	private int year, month, week, lastDay; // �����ϴ� ������ �˱� ���� week�� �����

	public CalendarTest() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ �Է� : ");
		this.year = scan.nextInt();

		System.out.print("�� �Է� : ");
		this.month = scan.nextInt();
	}

	public void calc() {
		Calendar cal = Calendar.getInstance();

		// ������ �ý��� ��¥�� �ð� - 2021 08 11(���ó�¥)
		// ������ �����ϱ� -> 2002 10 11(�Ͽ� ���� ��� ������ �ý����� '��' �״��)
//			cal.set(Calendar.YEAR, year); // ��
//			cal.set(cal.MONTH, month-1); // ��
//			cal.set(cal.DAY_OF_MONTH, 1); // ��

		cal.set(year, month - 1, 1); // �� �� ������ ��ģ ��

		week = cal.get(cal.DAY_OF_WEEK); // ������ �����´�.
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH); // 30, 31, 28, 29

	}

	public void display() {
		System.out.print("��\t��\tȭ\t��\t��\t��\t��\t\n");

		for (int i = 1; i < week; i++) {
			System.out.print("\t"); // week���� ���� ������ tab�� ������
		}

		for (int i = 1; i <= lastDay; i++) {
			System.out.print(i + "\t");

			if (week % 7 == 0)
				System.out.println(); // 7�� ����� �Ǹ� �Ʒ��� ����߷���
			week++;

		}
	}
}

// ---------------------------------------
public class CalendarMain {

	public static void main(String[] args) {
		CalendarTest ct = new CalendarTest();
		ct.calc();
		ct.display();
	}

}
