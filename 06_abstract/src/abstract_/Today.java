package abstract_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Today {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println("���� ��¥ : " + date); // ���� ��¥ : Fri Aug 06 14:23:00 KST 2021
		System.out.println();

		SimpleDateFormat sdf = new SimpleDateFormat("y�� MM�� dd�� E���� HH:mm:ss"); // ���� ���ϴ� ���� �Է�
		System.out.println("���� ��¥ : " + sdf.format(date)); // ���� ��¥ : 2021�� 08�� 06�� �ݿ��� 14:30:11
		System.out.println();

		// �Է�
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19940302070338"); // String -> Date ....parse���� �޼ҵ带 ���ؼ��� ����ȯ �����ϴܰ�
		System.out.println("�� ���� : " + birth); // �� ���� : Wed Mar 02 07:03:38 KST 1994
		System.out.println("�� ���� : " + sdf.format(birth)); // �� ���� : 1994�� 03�� 02�� ������ 07:03:38
		System.out.println();

		// �ý��� ��¥�� �ð�
		// Calendar cal = new Calendar(); //������ �ȵȴٴ� ������ �߸� ���� �߻� - ���������� new ���ϴ� �ڽ�Ŭ��������
		// Calendar cal = new GregorianCalendar(); // �ڽ� Ŭ���� �̿��Ͽ� ����
		Calendar cal = Calendar.getInstance();// �޼ҵ帣 �̿��Ͽ� ����

		// Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Canada/Pacific"));

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		int week = cal.get(Calendar.DAY_OF_WEEK); // �Ͽ����� 1, �������� 2,,,
		String dayOfWeek = null;
		switch (week) {
		case 1:
			dayOfWeek = "�Ͽ���";
			break;
		case 2:
			dayOfWeek = "������";
			break;
		case 3:
			dayOfWeek = "ȭ����";
			break;
		case 4:
			dayOfWeek = "������";
			break;
		case 5:
			dayOfWeek = "�����";
			break;
		case 6:
			dayOfWeek = "�ݿ���";
			break;
		case 7:
			dayOfWeek = "�����";
			break;

		} // switch

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		System.out.println("���� ��¥ : " + year + "�� " + month + "�� " + day + "�� " + dayOfWeek + " " + hour + "�� " + minute
				+ "�� " + second + "�� ");

	}

}
