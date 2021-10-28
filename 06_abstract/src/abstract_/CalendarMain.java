/*
만년 달력
- 년도, 월을 입력하여 달력을 출력하시오
- 매월 시작하는 요일을 구하시오 - 메소드
- 매월 끝나는 일(30, 28, 29, 31)을 구하시오 - 메소드
- 클래스 : CalendarTest
  필드  : year, month, week, lastDay
  생성자 : 입력
  메소드 : calc()
         display()

[실행결과]
년도 입력 : 2002
월 입력 : 10

일   월   화   수   목   금   토
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
	private int year, month, week, lastDay; // 시작하는 요일을 알기 위해 week를 잡아줌

	public CalendarTest() {
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		this.year = scan.nextInt();

		System.out.print("월 입력 : ");
		this.month = scan.nextInt();
	}

	public void calc() {
		Calendar cal = Calendar.getInstance();

		// 기준은 시스템 날짜와 시간 - 2021 08 11(오늘날짜)
		// 기준을 변경하기 -> 2002 10 11(일에 대한 언급 없으니 시스템의 '일' 그대로)
//			cal.set(Calendar.YEAR, year); // 년
//			cal.set(cal.MONTH, month-1); // 월
//			cal.set(cal.DAY_OF_MONTH, 1); // 일

		cal.set(year, month - 1, 1); // 위 세 문장을 합친 것

		week = cal.get(cal.DAY_OF_WEEK); // 요일을 가져온다.
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH); // 30, 31, 28, 29

	}

	public void display() {
		System.out.print("일\t월\t화\t수\t목\t금\t토\t\n");

		for (int i = 1; i < week; i++) {
			System.out.print("\t"); // week보다 작을 때까지 tab을 띄어줘라
		}

		for (int i = 1; i <= lastDay; i++) {
			System.out.print(i + "\t");

			if (week % 7 == 0)
				System.out.println(); // 7의 배수가 되면 아래로 떨어뜨려라
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
