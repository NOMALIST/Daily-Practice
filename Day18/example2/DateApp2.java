package example2;

import java.util.Calendar;
import java.util.Date;

public class DateApp2 {

	public static void main(String[] args) {
		
		// 현재 날짜 및 시간정보를 포함하고 있는 Date객체 생성하기
		Date today = new Date();
		
		// 현재 날짜 및 시간정보를 포함하고 있는 Calendar 객체 생성하기(getInstance())
		Calendar cal1 = Calendar.getInstance();	// Calendar는 추상클래스이기때문에 new를 못함
		
		// 특정 날짜와 시간정보를 포함하는 Calendar 객체 생성하기(getInstance()/set())
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2021, 04, 15, 12, 16);
		
		
		// Calendar객체로부터 Date객체 조회하기(getTime())
		System.out.println(cal1.getTime());
		System.out.println(cal2.getTime());
		
		
		// Calendar객체로부터 유닉스타임 조회하기(getTimeInMillis())
		System.out.println(cal1.getTimeInMillis());
		
		// 유닉스타임값으로 Date객체 생성하기
		today = new Date(cal1.getTimeInMillis()); 
		System.out.println(today);
		today = new Date(9009999900000L);
		System.out.println(today);
		
	}
}
