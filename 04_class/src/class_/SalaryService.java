package class_;

import java.io.IOException;
import java.util.Scanner;

public class SalaryService {
	private SalaryDTO[] ar;
	private Scanner scan = new Scanner(System.in);

	public SalaryService(SalaryDTO[] ar) {
		this.ar = ar;
	}

	public void menu() throws IOException { // ����
		int num;

		while (true) {
			System.out.println();
			System.out.println("     1. ���");
			System.out.println("     2. ���");
			System.out.println("     3. ����");
			System.out.println("     4. �˻�");
			System.out.println("     5. ����");
			System.out.println("---------");
			System.out.print("     ��ȣ : ");
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
		System.out.println("-- <�˻�> --");
		System.out.print("�˻��� �̸�? : ");
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
		System.out.println("-- <����> --");
		System.out.print("������ �̸�? : ");
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
		System.out.print("���� : ");
		ar[i].setPosition(scan.next());
		System.out.print("�⺻�� : ");
		ar[i].setBasePay(scan.nextInt());
		System.out.print("���� : ");
		ar[i].setBenefit(scan.nextInt());

		ar[i].calc();

	}

	public void display() {
		System.out.println();
		System.out.println("-- <���> --");
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				System.out.println(ar[i].getName() + "\t" + ar[i].getPosition() + "\t" + ar[i].getBasePay() + "\t"
						+ ar[i].getBenefit() + "\t" + ar[i].getTaxRate() + "\t" + (ar[i].getSalary()));
			}
		}
	}

	public void insertEmp() {
		System.out.println();
		System.out.println("-- <���> --");
		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] == null)
				break;
		}

		ar[i] = new SalaryDTO();
		ar[i].calc();

		System.out.println();
		System.out.println("��� �Ϸ�");
	}

}