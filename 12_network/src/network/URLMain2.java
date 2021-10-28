package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain2 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.goldria.net/m/product_list.html?xcode=012");

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		int count = 0;

		while ((line = br.readLine()) != null) {
			line = line.toLowerCase();

			int index = 0;
			while ((index = line.indexOf("14k", index)) != -1) {
				index = index + "14k".length();
				count++;
			} // while
		}
		System.out.println("14kÀÇ °³¼ö = " + count);
		br.close();
	}

}
