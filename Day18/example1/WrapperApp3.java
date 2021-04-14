package example1;

public class WrapperApp3 {

	public static void main(String[] args) {
		// 문자열을 실수로 변환하기
		
		String value1 = "150000";
		String value2 = "3";
		String value3 = "0.01";
		
				
		// value의 문자열들을 int와 double형으로 바꾸기 {price, amount, savePointRate}
		int price = Integer.parseInt(value1);
		int amount = Integer.parseInt(value2);
		double savePointRate = Double.parseDouble(value3);
		
		// price와 amount로 합 구하기
		// 총합으로 포인트계산하기
		// 출력
		System.out.println("가격: " + price);
		System.out.println("수량: " + amount);
		System.out.println("포인트: " + amount*price*savePointRate);
		
	}
}
