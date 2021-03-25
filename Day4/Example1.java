
public class Example1 {

	//1. for문에 내포된 if문 (ForDemo2.java)
	
	public static void main(String[] args) {
		
		// 1 ~ 10사이의 정수 중에서 홀수만 출력하기
		
		System.out.println("1~10 사이의 정수 중 홀수 출력");
		for(int i=1; i<=10; i++) {
			if(i%2 == 1) {
				System.out.println(i);
			}
		}

		System.out.println();
		
		// 1 ~ 10사이의 정수 중에서 짝수의 총합을 계산하고, 그 결과를 출력하기

		System.out.println("1~10 사이의 정수 중 짝수의 합");
		int sum = 0;
		for(int i=1; i<=10; i++) {
			if(i%2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		System.out.println();
		
		// 1 ~ 10사이의 정수 중에서 홀수의 총합과 짝수의 총합을 계산하고, 그 결과를 출력하기
		
		System.out.println("1~10 사이의 정수 중 홀수의 총합과 짝수의 총합 출력");
		int oddSum = 0;
		int evenSum = 0;
		
		for(int i=1; i<=10; i++) {
			if(i%2 == 1) {
				oddSum += i;
			} else {
				evenSum += i;
			}
		}
		
		System.out.println("홀수 총합 : " + oddSum);
		System.out.println("짝수 총합 : " + evenSum);

	}
}
