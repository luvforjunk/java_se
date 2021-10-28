/* A회사는 작년에 개업을 해서 직원이 5명이다.
직원들의 월급을 계산하는 프로그램을 작성하시오
필드 : empId(사원번호), name(이름), position(직급), basePay(기본급), benefit(수당), 
        taxRate(세율), tax(세금), salary(월급)
메소드 : 생성자 - 입력
       calcSalary() - 계산
       getter        
        
[조건]
1. 금액은 3자리마다 , 를 표시
2. 세율은 합계가 200만원 이하 : 1%(0.01), 
             400만원 이하 : 2%(0.02), 
             400만원 초과 : 3%(0.03)으로 설정한다.
3. 세금 = (기본급 + 수당) * 세율;
4. 월급 = 기본급 + 수당 - 세금;
        
[실행결과]

menu()
    ************************
          1. 사원 등록
          2. 전체 출력
          3. 사원 정보 수정
          4. 퇴사
          5. 종료
    ************************
       번호 : 
       
insertEmp() - Scanner 사용
사원번호 입력 :
사원명 입력 :
직급 입력 :
기본급 입력 :
수당 입력 : 

등록 완료

display() 
사원번호     이름   직급      기본급   수당      세율      세금      월급

updateEmp()
사원번호 입력 : 
사원번호가 없습니다
-----------------------

사원번호 입력 : 

사원번호     이름   직급      기본급   수당      세율      세금      월급

직급 입력 :
기본급 입력 :
수당 입력 : 

수정 완료

deleteEmp()
사원번호 입력 : 
사원번호가 없습니다
-----------------------

사원번호 입력 : 
삭제 완료
*/

package constructor;

public class SalaryMain {

	public static void main(String[] args) {
		SalaryDTO[] ar = new SalaryDTO[5];
		SalaryService service = new SalaryService(ar); 
		// 생성을 혼자만 가면 안되고 setter나 생성자를 통해 ar을 던져줘야 한다.
		// 왜? main 안에 SalaryDTO [] ar = new SalaryDTO[5]; 을 잡아놓은 걸 SalaryService는 모르기때문에
		// ar(생성자)를 통해 Service에 주소를 전달
		//여기서 ar은 SalaryDTO의 배열주소.
		service.menu(); // menu함수 호출
		System.out.println("프로그램을 종료합니다");
	}

}
