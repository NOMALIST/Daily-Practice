package example3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatApp {

	public static void main(String[] args) {
		Date today = new Date();
		System.out.println("날짜 시간정보 : " + today);
		
		//SimpleDateFormat 객체 생성으로 아래의 값들 출력하기
		//2021-04-14
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat1.format(today));
		
		//2021년 4월 14일 수요일
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy년 M월 d일 EEEE");
		System.out.println(dateFormat2.format(today));
		
		//12:22:18
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("hh:mm:ss");
		System.out.println(dateFormat3.format(today));
		
		//오후 12시 23분 33초
		SimpleDateFormat dateFormat4 = new SimpleDateFormat("a hh시 m분 s초");
		System.out.println(dateFormat4.format(today));
		
		//PM 12:28:19
		SimpleDateFormat dateFormat5 = new SimpleDateFormat("a hh:mm:ss" , Locale.CANADA);
		System.out.println(dateFormat5.format(today));
		
	}
}
