class Operator2 {
	public static void main(String[] args) {
		boolean a = 25 > 36;
		System.out.println("a =" + a);
		System.out.println("!a =" + !a);
		System.out.println();

		String b = "apple";
		String c = new String("apple"); //b와 c의 주소값이 다름.
		System.out.println("b==c : " + (b==c)); // false, 주소값 비교
		System.out.println("b.equals(c) : " + (b.equals(c))); // 문자열 비교
		System.out.println("!b.equals(c) : " + (!b.equals(c))); //현재 가져온 조건과 반대
	}
}
