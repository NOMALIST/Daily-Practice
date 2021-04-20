package example3;

import java.io.FileWriter;

public class ExceptionApp2 {

	public static void main(String[] args) {
		//try ~ catch 구문을 사용해서 예외처리를 직접 수행함.
		//throws 키워드를 사용해서 예외처리를 이 메소드를 호출하는 측에게 예외처리를 위임(떠넘기기)함
		//main
		//예외를 직접처리하는 메소드를 사용하는 경우
		//예외를 직접처리하지 않고 떠넘기는 메소드를 사용하는 경우
		
		try {
			System.out.println("### 샘픓1.txt 파일에 내용 기록하기");
			
			FileWriter writer = new FileWriter("src/day1/샘플1.txt");
			
			System.out.println("### 샘플1.txt 파일에 내용을 기록하는 FileWriter객체 생성하기");
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("오류 메세지: " + e.getMessage());
		}
	}
}
