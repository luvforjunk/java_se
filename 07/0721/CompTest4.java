class CompTest4 {
	public static void main(String[] args) {
		char ch = 'T';

		//ch변수에 들어온 데이터가 대문자이냐?
						//대문자 : A ~ Z : 65 ~ 90
						//소문자 : a ~ z : 97 ~ 122
		//ch>=65 && ch<=90 ?
		int result = ch>='A' && ch<='Z' ? ch+32 : ch-32;
		//char result = ch>='A' && ch<='Z' ? (char)(ch+32) : (char)(ch-32);
		System.out.println(ch + "→" + (char)result);
	}
}


class CompTest4 {
	public static void main(String[] args) {
		char ch = 'e';
		int result = ch>='a' && ch<='z' ? ch+32 : ch-32;
		System.out.println(ch + "→" + (char)result);
	}
}