package interface_;

public interface InterC extends InterA, InterB {
	// InterA와 InterB로부터 상속을 받는다 (다중 상속 가능)
	// 추상 메소드 총 4개

}
/*
 * class A{} 
 * interface Inter A{}
 * 
 * 1. class B extends A {} // 앞에가 클래스면 뒤에도 클래스 
 * 2. class B implements InterA {} // implements 다음엔 반드시 inter가 와야함 
 * 3. class B implements A {} // X 
 * 4. class B extends InterA {} // X 
 * 5. interface InterB extends A {} // X 
 * 6. interface InterB implements InterA {} 
 * // 앞에가 inter면 뒤에도 inter여야 하지만, 
 * // implements가 와서 반드시 앞에가 클래스가 와줘야 한다 
 * // 따라서, X 
 * 7. interface InterB implements A {} // X 
 * 8. interface InterB extends InterA {} // O
 */