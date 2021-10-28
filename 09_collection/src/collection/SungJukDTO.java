package collection;

import java.text.DecimalFormat;

public class SungJukDTO implements Comparable<SungJukDTO> {
	private String name;
	private int number, kor, eng, math, tot;
	private double avg;
	// 외부에서 데이터를 받는 것만 적으면 되니까 직접 계산해야 하는 tot, avg는 적지 않아도 됨

	public SungJukDTO(int number, String name, int kor, int eng, int math) { // 생성자
		this.name = name;
		this.number = number;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public SungJukDTO() {
	}

	public void calc() { // 계산
		tot = kor + eng + math;
		avg = (double) tot / 3;
	}

	@Override

	public String toString() { // 주소값(SungJukService - no.java 167)을 (no. java27) 로 받는 작업
		DecimalFormat df = new DecimalFormat("#.##");
		return number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + df.format(avg);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public int compareTo(SungJukDTO s) {
		return this.name.compareTo(s.name);
	}
}
