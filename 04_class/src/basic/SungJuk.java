/*
- 필드
- 메소드
setData(이름, 국어, 영어, 수학)
CalcTot()
CalcAvg()
CalcGrade()
getter

3명의 총점, 평균, 학점을 구하시오
단, 평균의 소수이하 2째자리까지 출력하시오

평균이 90 이상이면 A
평균이 80 이상이면 B
평균이 70 이상이면 C
평균이 60 이상이면 D
그외는 F

[실행결과]

홍길동	90	96	100	286	95.33	A
라이언	100	90	75	265	88.33	B
어피치	75	80	48	203	67.67	D

*/

package basic;

public class SungJuk {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	private char grade;

	public void setData(String n, int k, int e, int m) { // 구현
		name = n;
		kor = k;
		eng = e;
		math = m;
	}

	public void calcTot() {
		tot = kor + eng + math;
	}

	public void calcAvg() {
		avg = (double) tot / 3;
	}

	public void calcGrade() {
		if (avg >= 90)
			grade = 'A';
		else if (avg >= 80)
			grade = 'B';
		else if (avg >= 70)
			grade = 'C';
		else if (avg >= 60)
			grade = 'D';
		else
			grade = 'F';
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTot() {
		return tot;
	}

	public String getAvg() { //리턴하는 타입이 String타입이므로 double이 아닌 String으로
		return String.format("%.2f", avg);
	}

	public char getGrade() {
		return grade;
	}
}