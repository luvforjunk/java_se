package interface_;

public abstract class InterMain implements InterA, InterB {
	// InterMain�� ��� ���� ��ó�� ���� �� ��ӹ��� ���� �ƴϴ�
	public void aa() {} // override(�籸��)

	public void bb() {} // override(�籸��)
	
	public void cc() {}
	
	public void dd() {}

	public static void main(String[] args) {

	}

}

// -error 
// 1. �籸��
// 2. �߻�Ŭ����

// �ڹ� Ŭ������ ���߻���� �ȵȴ�
// �ڹ� �������̽��� ���߻���� �ȴ�
