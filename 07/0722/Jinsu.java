class Jinsu {
	public static void main(String[] args) {
		int dec = 250;

		String binary = Integer.toBinaryString(dec);
		String octal = Integer.toOctalString(dec);
		String hexa = Integer.toHexString(dec);

		System.out.println("10���� =" + dec);
		System.out.println("2���� =" + binary);
		System.out.println("8���� =" + octal);
		System.out.println("16���� =" + hexa);
	}
}
