class Variable {
	public static void main(String[] args) {
		byte a;
		a=65;
		System.out.println("a="+a);

		short b;
		b=65;
		System.out.println("b="+b);

		int c;
		c='A';
		System.out.println("c="+c); //65

		char d; //2byte => 16bit
		d='A';
		System.out.println("d="+d);

		char e;
		e=65;
		System.out.println("e="+e); //A

		boolean f;
		f=25>36;
		System.out.println("f="+f);

		float g;
		// g=43.8; -error
		g=43.8f;
		System.out.println("g="+g);
		//�ذ���
		/*
		1. double g;
			g=43.8;

		2. float g;
			g=(float)43.8; - 43.8�� double�� ���
			g= 43.8f; - 43.8�� float�� ���
		*/

		byte h=0; //1byte = -128 ~ +127
		//h= 128; -error
		System.out.println("h="+h);

		long i;
		i = 30L; //long�� ���
		System.out.println("i="+i);

		int j = 35;
		//long i; - error
		i = j;
		System.out.println("i="+i);
	}
}

