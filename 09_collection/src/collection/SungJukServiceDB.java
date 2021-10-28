package collection;

 

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

 

public class SungJukServiceDB {
         Scanner scan = new Scanner(System.in);
         private List<SungJukDTO> list;

         public SungJukServiceDB( ) {
                  list = new ArrayList<SungJukDTO>( ); // �θ� = �ڽ�
         }

         public void menu( ) {
                  int num;
                  while (true) {
                           System.out.println();
                           System.out.println("****************");
                           System.out.println("   1. �Է�");
                           System.out.println("   2. ���");
                           System.out.println("   3. �˻�");
                           System.out.println("   4. ����");
                           System.out.println("   5. ����");
                           System.out.println("   6. ��");
                           System.out.println("****************");
                           System.out.print(" ��ȣ : ");
                           num = scan.nextInt();

                           if (num == 6)
                                   break;
                           if (num == 1)
                                   insertArticle();
                           else if (num == 2)
                                   printArticle();
                           else if (num == 3)
                                   searchArticle(); // ��ȣ �˻�
                           else if (num == 4)
                                   deleteArticle(); // ��ȣ �˻� �� ����
                           else if (num == 5)
                                   sortArticle();
                           else
                                   System.out.println("1~6�߿� �����ϼ���");

                  } // while

         }// menu()

 

         private void sortArticle( ) {
                  System.out.println();
                  int num;
                  SungJukDAO dao = new SungJukDAO( );

                  while (true) {
                           System.out.println( );
                           System.out.println("*********************");
                           System.out.println("1. �̸����� ��������");
                           System.out.println("2. �������� ��������");
                           System.out.println("3. �����޴�");
                           System.out.println("*********************");
                           System.out.print("��ȣ �Է� : ");
                           num = scan.nextInt( );
                           if (num == 3)
                                   break;

 

//                if (num == 1) {
//                         List<SungJukDTO> list = dao.sortName();
//                } else if (num == 2) {
//                         List<SungJukDTO> list = dao.sortTot();
//                }

                
// �ѹ��� �ذ��ϰ� ������ � ��ȣ�� ���ȴ��� �𸣴� num�� ��������                         

                           List<SungJukDTO> list = dao.sortArticle(num);

                           System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
                           for (SungJukDTO dto : list) {
                                   System.out.println(dto);
                           }
                  } // while
         }// sortArticle

         private void deleteArticle( ) { // ������ �� ���� ��ȣ�� �����ϴ� ���� ����

                  System.out.println( );
                  System.out.print("���� �� ��ȣ �Է� : ");
                  int number = scan.nextInt( );

                  // DB
                  SungJukDAO dao = new SungJukDAO( );
                  int su = dao.deleteArticle(number);

                  if (su == 0)
                           System.out.println("ã���� �ϴ� ��ȣ�� �����ϴ�.");
                  else
                           System.out.println("�����Ϸ�");
         } // deleteArticle

         private void searchArticle( ) {
        	 
                  System.out.println( );
                  System.out.print("�˻� �� ��ȣ �Է� : ");
                  int number = scan.nextInt( );

                  // DB
                  SungJukDAO dao = new SungJukDAO( );
                  SungJukDTO dto = dao.searchArticle(number);
                  // ������ ���� ���� ���̸� list�� ��ƿ��µ�, ���⼱ ���ٸ� �������� �Ǵ� dto�� ��ƿ��� ��

                  if (dto == null) {
                           System.out.println("ã���� �ϴ� ��ȣ�� �����ϴ�");
                  } else {
                           System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
                           System.out.println(dto);
                  }
         } // searchArticle                                                                             

         private void printArticle( ) {
                  System.out.println( );

                  // DB
                  SungJukDAO dao = new SungJukDAO( );
                  List<SungJukDTO> list = dao.printArticle( );

                  System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
                  for (SungJukDTO dto : list) {
                           System.out.println(dto);
                  }
         } // printArticle()

         private void insertArticle( ) {

                  // ������
                  System.out.println( );
                  System.out.print("��ȣ �Է� : ");
                  int number = scan.nextInt( );
                  System.out.print("�̸� �Է� : ");
                  String name = scan.next( );
                  System.out.print("���� �Է� : ");
                  int kor = scan.nextInt( );
                  System.out.print("���� �Է� : ");
                  int eng = scan.nextInt();
                  System.out.print("���� �Է� : ");
                  int math = scan.nextInt( );

                  // �����͸� ������ �Ǵ� setter ����
                  SungJukDTO dto = new SungJukDTO();
                  dto.setNumber(number);
                  dto.setName(name);
                  dto.setKor(kor);
                  dto.setEng(eng);
                  dto.setMath(math);

                  dto.calc( );

                  // DB
                  SungJukDAO dao = new SungJukDAO( );
                  dao.insertArticle(dto);

                  System.out.println("��� �Ϸ�");
         }// insertArticle()
}