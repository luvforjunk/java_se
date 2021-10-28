package collection;

 

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

 

public class SungJukServiceDB {
         Scanner scan = new Scanner(System.in);
         private List<SungJukDTO> list;

         public SungJukServiceDB( ) {
                  list = new ArrayList<SungJukDTO>( ); // 부모 = 자식
         }

         public void menu( ) {
                  int num;
                  while (true) {
                           System.out.println();
                           System.out.println("****************");
                           System.out.println("   1. 입력");
                           System.out.println("   2. 출력");
                           System.out.println("   3. 검색");
                           System.out.println("   4. 삭제");
                           System.out.println("   5. 정렬");
                           System.out.println("   6. 끝");
                           System.out.println("****************");
                           System.out.print(" 번호 : ");
                           num = scan.nextInt();

                           if (num == 6)
                                   break;
                           if (num == 1)
                                   insertArticle();
                           else if (num == 2)
                                   printArticle();
                           else if (num == 3)
                                   searchArticle(); // 번호 검색
                           else if (num == 4)
                                   deleteArticle(); // 번호 검색 후 삭제
                           else if (num == 5)
                                   sortArticle();
                           else
                                   System.out.println("1~6중에 선택하세요");

                  } // while

         }// menu()

 

         private void sortArticle( ) {
                  System.out.println();
                  int num;
                  SungJukDAO dao = new SungJukDAO( );

                  while (true) {
                           System.out.println( );
                           System.out.println("*********************");
                           System.out.println("1. 이름으로 오름차순");
                           System.out.println("2. 총점으로 내림차순");
                           System.out.println("3. 이전메뉴");
                           System.out.println("*********************");
                           System.out.print("번호 입력 : ");
                           num = scan.nextInt( );
                           if (num == 3)
                                   break;

 

//                if (num == 1) {
//                         List<SungJukDTO> list = dao.sortName();
//                } else if (num == 2) {
//                         List<SungJukDTO> list = dao.sortTot();
//                }

                
// 한번에 해결하고 싶은데 어떤 번호가 눌렸는지 모르니 num을 가져가라                         

                           List<SungJukDTO> list = dao.sortArticle(num);

                           System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
                           for (SungJukDTO dto : list) {
                                   System.out.println(dto);
                           }
                  } // while
         }// sortArticle

         private void deleteArticle( ) { // 삭제를 할 때는 번호로 삭제하는 것이 낫다

                  System.out.println( );
                  System.out.print("삭제 할 번호 입력 : ");
                  int number = scan.nextInt( );

                  // DB
                  SungJukDAO dao = new SungJukDAO( );
                  int su = dao.deleteArticle(number);

                  if (su == 0)
                           System.out.println("찾고자 하는 번호가 없습니다.");
                  else
                           System.out.println("삭제완료");
         } // deleteArticle

         private void searchArticle( ) {
        	 
                  System.out.println( );
                  System.out.print("검색 할 번호 입력 : ");
                  int number = scan.nextInt( );

                  // DB
                  SungJukDAO dao = new SungJukDAO( );
                  SungJukDTO dto = dao.searchArticle(number);
                  // 가져올 줄이 여러 줄이면 list에 담아오는데, 여기선 한줄만 가져오면 되니 dto에 담아오는 거

                  if (dto == null) {
                           System.out.println("찾고자 하는 번호가 없습니다");
                  } else {
                           System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
                           System.out.println(dto);
                  }
         } // searchArticle                                                                             

         private void printArticle( ) {
                  System.out.println( );

                  // DB
                  SungJukDAO dao = new SungJukDAO( );
                  List<SungJukDTO> list = dao.printArticle( );

                  System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
                  for (SungJukDTO dto : list) {
                           System.out.println(dto);
                  }
         } // printArticle()

         private void insertArticle( ) {

                  // 데이터
                  System.out.println( );
                  System.out.print("번호 입력 : ");
                  int number = scan.nextInt( );
                  System.out.print("이름 입력 : ");
                  String name = scan.next( );
                  System.out.print("국어 입력 : ");
                  int kor = scan.nextInt( );
                  System.out.print("영어 입력 : ");
                  int eng = scan.nextInt();
                  System.out.print("수학 입력 : ");
                  int math = scan.nextInt( );

                  // 데이터를 생성자 또는 setter 저장
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

                  System.out.println("등록 완료");
         }// insertArticle()
}