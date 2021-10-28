/*
- �ʵ�
- �޼ҵ�
setData(�̸�, ����, ����, ����)
CalcTot()
CalcAvg()
CalcGrade()
getter

3���� ����, ���, ������ ���Ͻÿ�
��, ����� �Ҽ����� 2°�ڸ����� ����Ͻÿ�

����� 90 �̻��̸� A
����� 80 �̻��̸� B
����� 70 �̻��̸� C
����� 60 �̻��̸� D
�׿ܴ� F

[������]

ȫ�浿	90	96	100	286	95.33	A
���̾�	100	90	75	265	88.33	B
����ġ	75	80	48	203	67.67	D

*/

package basic;

public class SungJuk {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	private char grade;

	public void setData(String n, int k, int e, int m) { // ����
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

	public String getAvg() { //�����ϴ� Ÿ���� StringŸ���̹Ƿ� double�� �ƴ� String����
		return String.format("%.2f", avg);
	}

	public char getGrade() {
		return grade;
	}
}