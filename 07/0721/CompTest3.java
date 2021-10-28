class CompTest3 {
	public static void main(String[] args){
		int num = 30;

		//num에 들어있는 데이터가 짝수이냐?
		//num에 들어있는 데이터가 2의 배수?
		//num에 들어있는 데이터가 2로 나누었을 때 나머지가 0이냐?

		String result = num % 2 == 0 ? "짝수이다" : "홀수이다";

		System.out.println(num + "는(은)" + result);
	}
}
