package abstract_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Today {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println("오늘 날짜 : " + date); // 오늘 날짜 : Fri Aug 06 14:23:00 KST 2021
		System.out.println();

		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 HH:mm:ss"); // 내가 원하는 패턴 입력
		System.out.println("오늘 날짜 : " + sdf.format(date)); // 오늘 날짜 : 2021년 08월 06일 금요일 14:30:11
		System.out.println();

		// 입력
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19940302070338"); // String -> Date ....parse같은 메소드를 통해서도 형변환 가능하단거
		System.out.println("내 생일 : " + birth); // 내 생일 : Wed Mar 02 07:03:38 KST 1994
		System.out.println("내 생일 : " + sdf.format(birth)); // 내 생일 : 1994년 03월 02일 수요일 07:03:38
		System.out.println();

		// 시스템 날짜와 시간
		// Calendar cal = new Calendar(); //생성이 안된다는 에러가 뜨면 백퍼 추상 - 직접적으로 new 못하니 자식클래스생성
		// Calendar cal = new GregorianCalendar(); // 자식 클래스 이용하여 생성
		Calendar cal = Calendar.getInstance();// 메소드르 이용하여 생성

		// Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Canada/Pacific"));

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		int week = cal.get(Calendar.DAY_OF_WEEK); // 일요일은 1, 월요일은 2,,,
		String dayOfWeek = null;
		switch (week) {
		case 1:
			dayOfWeek = "일요일";
			break;
		case 2:
			dayOfWeek = "월요일";
			break;
		case 3:
			dayOfWeek = "화요일";
			break;
		case 4:
			dayOfWeek = "수요일";
			break;
		case 5:
			dayOfWeek = "목요일";
			break;
		case 6:
			dayOfWeek = "금요일";
			break;
		case 7:
			dayOfWeek = "토요일";
			break;

		} // switch

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		System.out.println("오늘 날짜 : " + year + "년 " + month + "월 " + day + "일 " + dayOfWeek + " " + hour + "시 " + minute
				+ "분 " + second + "초 ");

	}

}
