package abstract_;

//POJO���� (Plain Old  Java Object)
public abstract class AbstractTest {
	String name;

	public String getName() {
		return name;
	}

	// public void setName(String name){
	// this.name = name;
	// �� �ι����� �߻�޼ҵ�� ����� ���ؼ� �����θ� ����� ���� �ʰ� �����ݷ��� ��´�
	public abstract void setName(String name); // �߻�޼ҵ�
	// �߻�޼ҵ带 ������� Ŭ���� ���� �߻�Ŭ�������� �Ѵ�
	// �߻�Ŭ������ ���� ���� �� �� ����
	// 1. �ڽ�Ŭ������ �̿��Ѵ�
	// 2. �޼ҵ带 �̿��Ѵ�
	// 3. �͸� �̳�Ŭ������ �̿��Ѵ�
}