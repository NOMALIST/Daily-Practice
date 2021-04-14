package example3;

import java.text.DecimalFormat;

public class DecimalFormatApp {

	public static void main(String[] args) {
		
		//숫자 3자리마다 ,찍기
		int number = 10000000;
		//DecimalFormat 객체 생성 후 아래의 값들 출력하기
		//결과값 : 10,000,000

		DecimalFormat decimal1 = new DecimalFormat("###,###");
		System.out.println(decimal1.format(number));
		
		//실수 출력하기
		double number2 = 123.456;
		DecimalFormat decimal2 = new DecimalFormat("#.00");
		System.out.println(decimal2.format(number2));
		decimal2 = new DecimalFormat("0.0000");
		System.out.println(decimal2.format(number2));
		//결과값 : 123.46 (3번째 자리에서 반올림되어 값출력됨)
		//결과값 : 123.4560

		
		double value = 1.0/3.0;
		DecimalFormat decimal3 = new DecimalFormat("0.00");
		System.out.println(decimal3.format(value));
		//결과값 : 0.33
		
		
	}
}
