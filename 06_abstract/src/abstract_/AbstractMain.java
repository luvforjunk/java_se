package abstract_;

public class AbstractMain extends AbstractTest {
	// �߻�Ŭ������ ����� ���� �ڽ� Ŭ������ ����������
	// �ݵ�� �ڽ�Ŭ������ ����(Override)������� �Ѵ�
	@Override
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		// AbstractTest at = new AbstractTest(); //�߻�Ŭ������
		AbstractTest at = new AbstractMain(); // �θ� = �ڽ�
		at.setName("ȫ�浿");
		System.out.println(at.getName());

	}

}