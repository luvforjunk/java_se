package interface_;

public interface InterC extends InterA, InterB {
	// InterA�� InterB�κ��� ����� �޴´� (���� ��� ����)
	// �߻� �޼ҵ� �� 4��

}
/*
 * class A{} 
 * interface Inter A{}
 * 
 * 1. class B extends A {} // �տ��� Ŭ������ �ڿ��� Ŭ���� 
 * 2. class B implements InterA {} // implements ������ �ݵ�� inter�� �;��� 
 * 3. class B implements A {} // X 
 * 4. class B extends InterA {} // X 
 * 5. interface InterB extends A {} // X 
 * 6. interface InterB implements InterA {} 
 * // �տ��� inter�� �ڿ��� inter���� ������, 
 * // implements�� �ͼ� �ݵ�� �տ��� Ŭ������ ����� �Ѵ� 
 * // ����, X 
 * 7. interface InterB implements A {} // X 
 * 8. interface InterB extends InterA {} // O
 */