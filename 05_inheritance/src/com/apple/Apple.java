package com.apple;

import com.zoo.Zoo;
// ��Ű���� �ٸ��� ȣ�����ֱ� ���� import�� �̿���
// com.zoo�ȿ� Zoo�� �ִٴ� �� �˷���

public class Apple {

	public static void main(String[] args) {
		System.out.println("���� ���");

		// �������� ȣ���̸� ȣ���Ͻÿ�
		Zoo z = new Zoo();
		z.tiger();
		// z.giraffe();
		// z.elephant();
		// z.lion();

		// lion�� private�̱� ������ ȣ���� �� �� ����
		// private�� ������ �ڽ��� Ŭ����������
	}

}
