package class_;

import java.io.IOException;
import java.util.Scanner;

public class SalaryService {
	private SalaryDTO[] ar;
	private Scanner scan = new Scanner(System.in);

	public SalaryService(SalaryDTO[] ar) {
		this.ar = ar;
	}

	public void menu() throws IOException { // 구현
		int num;

		while (true) {
			System.out.println();
			System.out.println("     1. 등록");
			System.out.println("     2. 출력");
			System.out.println("     3. 수정");
			System.out.println("     4. 검색");
			System.out.println("     5. 종료");
			System.out.println("---------");
			System.out.print("     번호 : ");
			num = scan.nextInt();
			if (num == 5)
				break;

			if (num == 1)
				insertEmp();
			else if (num == 2)
				display();
			else if (num == 3)
				updateEmp();
			else if (num == 4)
				searchEmp();
		} // while
	}

	private void searchEmp() {
		System.out.println();
		System.out.println("-- <검색> --");
		System.out.print("검색할 이름? : ");
		String name = scan.next();

		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				if(ar[i].getName().equals(name)) {
					break;
				}
			} // if
		} // for
		System.out.println(ar[i].getName() + "\t" + ar[i].getPosition() + "\t" + ar[i].getBasePay() + "\t"
				+ ar[i].getBenefit() + "\t" + ar[i].getTaxRate() + "\t" + (ar[i].getSalary()));
	}

	public void updateEmp() {
		System.out.println();
		System.out.println("-- <수정> --");
		System.out.print("수정할 이름? : ");
		String name = scan.next();

		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				if(ar[i].getName().equals(name)) {
					break;
				}
			} // if
		} // for

		System.out.println(ar[i].getName() + "\t" + ar[i].getPosition() + "\t" + ar[i].getBasePay() + "\t"
				+ ar[i].getBenefit() + "\t" + ar[i].getTaxRate() + "\t" + (ar[i].getSalary()));

		System.out.println();
		System.out.print("직급 : ");
		ar[i].setPosition(scan.next());
		System.out.print("기본급 : ");
		ar[i].setBasePay(scan.nextInt());
		System.out.print("수당 : ");
		ar[i].setBenefit(scan.nextInt());

		ar[i].calc();

	}

	public void display() {
		System.out.println();
		System.out.println("-- <출력> --");
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				System.out.println(ar[i].getName() + "\t" + ar[i].getPosition() + "\t" + ar[i].getBasePay() + "\t"
						+ ar[i].getBenefit() + "\t" + ar[i].getTaxRate() + "\t" + (ar[i].getSalary()));
			}
		}
	}

	public void insertEmp() {
		System.out.println();
		System.out.println("-- <등록> --");
		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] == null)
				break;
		}

		ar[i] = new SalaryDTO();
		ar[i].calc();

		System.out.println();
		System.out.println("등록 완료");
	}

}