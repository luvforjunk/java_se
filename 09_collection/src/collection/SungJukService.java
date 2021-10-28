package collection;

import java.util.*;

public class SungJukService {

	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list; // �θ� List�� �����س��� �����ڴ� ArrayList

	public SungJukService() {
		list = new ArrayList<SungJukDTO>();
	}

	public void menu() {
		int num;

		while (true) {
			System.out.println("*****************");
			System.out.println("1. �Է�");
			System.out.println("2. ���");
			System.out.println("3. �˻�");
			System.out.println("4. ����");
			System.out.println("5. ����");
			System.out.println("6. ��");
			System.out.println("*****************");
			System.out.print("      ��ȣ : ");
			num = scan.nextInt();

			if (num == 6)
				break;
			if (num == 1)
				insertArticle();
			else if (num == 2)
				printArticle();
			else if (num == 3)
				searchArticle();
			else if (num == 4)
				deleteArticle();
			else if (num == 5)
				sortArticle();
			else
				System.out.println("1~6�߿� �����ϼ���");
		} // while
	} // menu

	public void sortArticle() { // -------------------sortArticle( )
		int num;

		while (true) {
			System.out.println("1. �̸����� ��������");
			System.out.println("2. �������� ��������");
			System.out.println("3. �����޴�");
			System.out.print("��ȣ �Է� : ");
			num = scan.nextInt();
			if (num == 3)
				break;

			// �̸����� ��������
			if (num == 1) {
//          // interface�� ���� �ȵǴ� �͸� �������ֱ�
//         Comparator<SungJukDTO> com = new Comparator<SungJukDTO>( ) {
//              @Override
//             public int compare(SungJukDTO dto1, SungJukDTO dto2) {
//            return dto1.getName( ).compareTo(dto2.getName( ));
//           //���ڿ��� ���ڿ��� ũ�� �񱳰� �Ұ��ϹǷ� compareTo�� �� ������ ����Ѵ�
//                                 }
//                         };
//                 Collections.sort(list, com); // ��ü ��ü�� �������ִ� ������ ��. ������ �ٲ�� ���� �ƴ�.
//                          printArticle();

				Collections.sort(list);
				printArticle();

				// DTO���� �̹� CompareTo �� ��Ƴ����� �� Comparator�� ��� ��.
				// Comparable�� Ŭ�������� implements�ؼ� ��ü������ �������� ����ְ�,
				// Comparator�� ���� �������� ��´�
				// �������� ��������

			} else if (num == 2) {
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
					
					@Override
					public int compare(SungJukDTO dto1, SungJukDTO dto2) {
						// ���ǿ����� : ���� ? �� : ����;
						// return dto1.getTot( ) > dto2.getTot( ) ? 1 : -1; - ��������
						return dto1.getTot() > dto2.getTot() ? -1 : 1;
					}
				};

				Collections.sort(list, com);
				printArticle();
			}
		} // while
	} // sortArticle( )

	public void deleteArticle() {// -------------------deleteArticle( )***
		System.out.println();
		System.out.print("������ �̸� �Է� : ");
		String name = scan.next();
		int sw = 0; // ���� ����

//                for(int i =0; i<list.size(); i++) {
//                         if(list.get(i).getName().equals(name)) {
//                                 list.remove(list.get(i));
//                                 sw =1;
//                         }
//                }
//                list size�� ��� �����̸鼭 ��ȣ�� ���� ���������� ������ ��

		Iterator<SungJukDTO> it = list.iterator(); // ���� - �ݺ��ؼ� ������ ��ü�� SungJukDTO
		while (it.hasNext()) { // it���� �ֽ��ϱ�? �׸��� ������ T, ������ F (hasnext�� �����Ͱ� �ִ� ���ٸ� �Ǵ�)
			SungJukDTO dto = it.next();
			// �׸��� ������ dto���� ����, �������� �̵�(next�� �׸��� ������ ������ �� �������� �̵��ϴ� �� ����)
			if (dto.getName().equals(name)) {
				it.remove(); // it�� ����Ű�� ���� ��ġ�� ����� ���� �ƴ� dto�� ������ ���� ����
				sw = 1;
			} // if
		} // while

		if (sw == 0) // ������ ��ȭ�� ������
			System.out.println("ã���� �ϴ� �̸��� �����ϴ�");
		else // ���� ��ȭ�� ������
			System.out.println("�����͸� �����Ͽ����ϴ�");
	} // deleteArticle( )

	public void searchArticle() { // -------------------searchArticle( )
		System.out.println();
		System.out.print("�˻� �� �̸� �Է� : ");
		String Name = scan.next();
		int sw = 0; // 1�� - ������ ��´�(for������ �� ������ ����)

		for (SungJukDTO dto : list) {
			if (Name.equals(dto.getName())) { // �˻��� �̸��� ���� �̸��� ã����
				if (sw == 0) // 0���� �����ؼ� ó���� 0, �� ������ 1 �̷��� ������
					// 0�϶��� �� �ѹ��ۿ� �ȳ����� �̸��� �ѹ��ۿ� ������
					System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
				System.out.println(dto); // 2�� - �����͸� ���
				sw = 1; // 3�� - ������ ��� ���� ������ 0���� 1��
//                         }else {                                                      
//                                 System.out.println("ã���� �ϴ� �̸��� �����ϴ�");
//                         }
//                         break;

// *** ���⼭ else�� ���� ��� �� �ѹ��� ����
// ���� ã�� �����Ͱ� �ٸ� ���� �и��� �ִµ� break�� ���������ϱ� �� ���� �� ����..��
// ������ �ϳ� ���, �����͸� ���� �� ������ �ٲ�. for���� ���Ҵµ��� ������ ó�� �״���� ���̶�� �������� Ź!
			}
		} // for
		if (sw == 0) // 4�� - for�� ������ ���ͼ�... ������ sw�� 0���� �����
			System.out.println("ã���� �ϴ� �̸��� �����ϴ�"); // 5�� - �׷����� ����ָ� ��
	}
	
	public void printArticle() { // -------------------printArticle()
		System.out.println();
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");

		for (SungJukDTO dto : list) { // list�� �ִ� SungJukDTO�� dto�� ��������
			System.out.println(dto);
		}
	} // printArticle( )

	public void insertArticle() { // -------------------insertArticle()
		System.out.println();
		System.out.print("��ȣ �Է� : ");
		int number = scan.nextInt();
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���� �Է� : ");
		int kor = scan.nextInt();
		System.out.print("���� �Է� : ");
		int eng = scan.nextInt();
		System.out.print("���� �Է� : ");
		int math = scan.nextInt();
		
		// �ѻ������ DTO �ޱ�~~
		SungJukDTO dto = new SungJukDTO(number, name, kor, eng, math);
		dto.calc(); // ����, ��� ���
		list.add(dto); // dto�� �ּҰ��� list�� �ִ� ��
		// System.out.println(list); // Ŭ@16���� ...[~,~,~]
		System.out.println("��� �Ϸ�");
	} // inserArticle( )
}