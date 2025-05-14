package com.trepudox;

public class Variaveis {
	public static void main(String[] args) {
		char character = 'a';
		String string = "Oi";
		final String finalString = "Oi essa aq n muda";

		// finalString = "hehe vai da erro";

		int integer = 1;
		float floatt = 1.1f;
		double doublee = 1.11111d;

		boolean bool = true;

		System.out.printf("char: %s", character);
		System.out.printf("%nString: %s", string);
		System.out.printf("%nString: %s", finalString);
		System.out.printf("%nint: %d", integer);
		System.out.printf("%nfloat: %f", floatt);
		System.out.printf("%ndouble: %.2f", doublee);
		System.out.printf("%nboolean: %b", bool);
	}
}