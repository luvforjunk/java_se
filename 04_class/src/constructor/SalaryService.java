package constructor;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SalaryService {
	private SalaryDTO[] ar; //this.ar
	private Scanner scan = new Scanner(System.in);
	private DecimalFormat df = new DecimalFormat();

	public SalaryService(SalaryDTO[] ar) {
		//SalaryMain으로부터 주소 받기
		this.ar = ar;
		//주소를 받아놓고 생성자{}가 끝나면 죽어버리는 걸 막기 위해 this.ar에게 ar을 전달해 보관한다. 
	}

	public void menu() { // 구현
		int num;

		while (true) {
			System.out.println();
			System.out.println("********************");
			System.out.println("     1. 사원 등록");
			System.out.println("     2. 전체 출력");
			System.out.println("     3. 사원 정보 수정");
			System.out.println("     4. 퇴사");
			System.out.println("     5. 끝내기");
			System.out.println("********************");
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
				deleteEmp();
		} // while
	}

	private void deleteEmp() {
		System.out.print("사원번호 입력 : ");
		int empId = scan.nextInt();

		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] != null) {
				if (ar[i].getEmpId() == empId) {
					break;
				}
			} // if
		} // for

		if (i == ar.length) {
			System.out.println("찾고자 하는 사원이 없습니다");
			return;
		}

		ar[i] = null; //삭제를 할 수 없기 때문에 주소를 널값으로 잡으면서 연을 끊어버림  

		System.out.println();
		System.out.println("삭제 완료...");

	}

	public void updateEmp() {
		System.out.print("사원번호 입력 : ");
		int empId = scan.nextInt();

		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] != null) { //널이 아닌 것 중
				if (ar[i].getEmpId() == empId) { //empId와 같은 것만 찾아
					break; // 나가라
				}
			} // if
		} // for

		if (i == ar.length) { //ar.length까지 다 돌았는데 발견한 것이 없으면~~
			System.out.println("찾고자 하는 사원이 없습니다");
			return;
		}

		System.out.println(ar[i].getEmpId() + "\t" + ar[i].getName() + "\t" + ar[i].getPosition() + "\t"
				+ ar[i].getBasePay() + "\t" + df.format(ar[i].getBenefit()) + "\t" + (int) (ar[i].getTaxRate() * 100)
				+ "%\t" + df.format(ar[i].getTax()) + "\t" + df.format(ar[i].getSalary()));

		System.out.println();
		System.out.print("수정할 사원명 입력 : ");
		ar[i].setName(scan.next());
		/*String name = scan.next(); //이름을 받고
		ar{i].setName(name); //현재 위치해 있는 배열에다 이름을 넣는
		위 두 구문을 합친 것이 ar[i].setName(scan.next());
		*/
		System.out.print("직급 입력 : ");
		ar[i].setPosition(scan.next());
		System.out.print("기본급 입력 : ");
		ar[i].setBasePay(scan.nextInt());
		System.out.print("수당 입력 : ");
		ar[i].setBenefit(scan.nextInt());

		ar[i].calc(); //다시 한번 계산, 계산을 해야 수정이 될테니

		System.out.println();
		System.out.println("수정 완료...");
	}

	public void display() {
		System.out.println();
		System.out.println("사원번호\t이름\t직급\t기본급\t\t수당\t세율\t세금\t월급");
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != null) { //다섯개의 방 중 널값이 아닌 애들만
				System.out.println(ar[i].getEmpId() + "\t" + ar[i].getName() + "\t" + ar[i].getPosition() + "\t"
						+ ar[i].getBasePay() + "\t" + df.format(ar[i].getBenefit()) + "\t"
						+ (int) (ar[i].getTaxRate() * 100) + "%\t" + df.format(ar[i].getTax()) + "\t"
						+ df.format(ar[i].getSalary()));
			} // if
		} // for
	}

	public void insertEmp() {
		int i;
		for (i = 0; i < ar.length; i++) {
			if (ar[i] == null)
				break;
		}

		if (i == ar.length) {
			System.out.println("정원 초과..");
			return; // 메소드를 벗어나라
		}

		ar[i] = new SalaryDTO(); //생성자가 DTO에 입력한 데이터를 긁어옴
		ar[i].calc(); //모든 계산이 다 처리가 됨

		System.out.println();
		System.out.println("등록 완료...");
	}

}