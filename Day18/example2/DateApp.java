package example2;

import java.util.Date;

public class DateApp {

	public static void main(String[] args) {

		// 자바가 실행되고 있는 시스템의 현재 날짜와 현재 시간정보를 가진 객체를 생성 후 출력
		Date today = new Date();
		System.out.println("기본날짜 및 시간: " + today);
		
		// 유닉스 타입값 조회하기(getTime)
		long unixTime1 = today.getTime();
		System.out.println("유닉스 타임: " + unixTime1);
		
		// 유닉스 타입값 조회하기2(currentTimeMillis())
		long unixTime2 = System.currentTimeMillis();
		System.out.println("유닉스 타임: " + unixTime2);
		
	}
	
	
}
