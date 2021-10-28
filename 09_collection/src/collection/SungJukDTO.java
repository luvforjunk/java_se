package collection;

import java.text.DecimalFormat;

public class SungJukDTO implements Comparable<SungJukDTO> {
	private String name;
	private int number, kor, eng, math, tot;
	private double avg;
	// �ܺο��� �����͸� �޴� �͸� ������ �Ǵϱ� ���� ����ؾ� �ϴ� tot, avg�� ���� �ʾƵ� ��

	public SungJukDTO(int number, String name, int kor, int eng, int math) { // ������
		this.name = name;
		this.number = number;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public SungJukDTO() {
	}

	public void calc() { // ���
		tot = kor + eng + math;
		avg = (double) tot / 3;
	}

	@Override

	public String toString() { // �ּҰ�(SungJukService - no.java 167)�� (no. java27) �� �޴� �۾�
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
