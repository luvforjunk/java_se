package basic;

public class ComputeMain2 {

	public static void main(String[] args) {
		Compute[] ar = new Compute[3]; // 按眉 硅凯 积己
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new Compute(); // 努贰胶 积己
		}
		/*
		 ar [0] = new Compute(); //努贰胶 积己
		 ar [1] = new Compute();
		 ar [2] = new Compute();
		 */
		ar[0].setX(320);
		ar[0].setY(258);

		ar[1].setX(236);
		ar[1].setY(125);

		ar[2].setX(539);
		ar[2].setY(327);

		for (int i = 0; i < ar.length; i++) {
			ar[i].calc();

			System.out.println(ar[i].getX() + "\t" + ar[i].getY() + "\t" + ar[i].getSum() + "\t" + ar[i].getSub() + "\t"
					+ ar[i].getMul() + "\t" + String.format("%.2f", ar[i].getDiv()));
		} // for i
	}
}

/*
System.out.println("X\tY\tSum\tSub\tMul\tDiv");

Compute aa = new Compute(); //按眉 积己
aa.setX(320);
aa.setY(258);
aa.calc();
System.out.println(aa.getX() + "\t"
				 + aa.getY() + "\t"
				 + aa.getSum() + "\t"
				 + aa.getSub() + "\t"
				 + aa.getMul() + "\t"
				 + String.format("%.2f", aa.getDiv()));

Compute bb = new Compute(); //积己
bb.setX(236);
bb.setY(125);
bb.calc();
System.out.println(bb.getX() + "\t"
				 + bb.getY() + "\t"
				 + bb.getSum() + "\t"
				 + bb.getSub() + "\t"
				 + bb.getMul() + "\t"
				 + String.format("%.2f", bb.getDiv())); 

Compute cc = new Compute(); //积己
cc.setX(539);
cc.setY(327);
cc.calc();
System.out.println(cc.getX() + "\t"
				 + cc.getY() + "\t"
				 + cc.getSum() + "\t"
				 + cc.getSub() + "\t"
				 + cc.getMul() + "\t"
				 + String.format("%.2f", cc.getDiv())); 
}

}
*/
