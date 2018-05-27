package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Throwable{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int count = 0;
		for (int i = 1; i <= n; i *= 10) {
			int a = n / i,b = n % i;
			count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
		}
		System.out.println(count);
	}
}