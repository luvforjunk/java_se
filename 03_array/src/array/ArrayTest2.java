
package array;

public class ArrayTest2 {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
			System.out.println("args[" + i + "] ���ڿ� ũ�� = " + args[i].length());
			System.out.println("args[" + i + "] ù��° ���� = " + args[i].charAt(0));
			System.out.println();
		}
		System.out.println();

		System.out.println("Ȯ�� for");
		for (String data : args) {
			System.out.println(data);
			System.out.println("���ڿ� ũ�� = " + data.length());
			System.out.println("ù��° ���� = " + data.charAt(0));
			System.out.println();
		}
		System.out.println();

	}
}
/*
 * 
 * package array;
 * 
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader;
 * 
 * public class ArrayTest2 {
 * 
 * public static void main(String[] args) throws IOException { BufferedReader br
 * = new BufferedReader(new InputStreamReader(System.in));
 * 
 * System.out.print("���ڿ� �Է� : "); String str = br.readLine();
 * 
 * int index = str.length() / 2;
 * 
 * System.out.println("��� ���� = " + str.charAt(index)); } }
 */
