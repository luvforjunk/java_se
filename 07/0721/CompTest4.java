class CompTest4 {
	public static void main(String[] args) {
		char ch = 'T';

		//ch������ ���� �����Ͱ� �빮���̳�?
						//�빮�� : A ~ Z : 65 ~ 90
						//�ҹ��� : a ~ z : 97 ~ 122
		//ch>=65 && ch<=90 ?
		int result = ch>='A' && ch<='Z' ? ch+32 : ch-32;
		//char result = ch>='A' && ch<='Z' ? (char)(ch+32) : (char)(ch-32);
		System.out.println(ch + "��" + (char)result);
	}
}


class CompTest4 {
	public static void main(String[] args) {
		char ch = 'e';
		int result = ch>='a' && ch<='z' ? ch+32 : ch-32;
		System.out.println(ch + "��" + (char)result);
	}
}