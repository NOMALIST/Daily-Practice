package example5;

import java.util.Scanner;

public class DateApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		
		String[] arr = input.split("\\.");
		int year = Integer.valueOf(arr[0]);
		int month = Integer.valueOf(arr[1]);
		int day = Integer.valueOf(arr[2]);

		System.out.printf("%04d.%02d.%02d",year,month,day);
	}
}
