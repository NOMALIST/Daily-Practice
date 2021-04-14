package example1;

public class WrapperApp2 {

	public static void main(String[] args) {
		Integer[] scores = {100, 100, 80, 100, 50, 60, 70, 80, 50, 60};
		
		// 합계 저장할 변수 선언
		Integer total1 = 0;
		// 향상된 for문 타입 Integer로 배열의 합계 구하기
		for(Integer x : scores) {
			total1 += x;
		}
		System.out.println("합계: " + total1);
		
		
		// 합계 저장할 변수 2선언
		int total2 = 0;
		// 향상된 for문에 기본형 int로 배열의 합계 구하기
		for(int x : scores) {
			total2 += x;
		}
		System.out.println("합계: " + total2);
		
	}
}
