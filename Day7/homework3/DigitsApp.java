package homework3;

public class DigitsApp {

	public static void main(String[] args) {
		
		Digits digit = new Digits();
		
		long number =123455;
		
		int answer = digit.calc(number);
		
		System.out.println(answer);
	}
}
