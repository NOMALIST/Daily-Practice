
public class Day5_Example1 {

	// 1. 배열 복습 (ArrayDemo4.java)
	public static void main(String[] args) {

		// 복습
		// ###배열 만들기
		// 학과명을 저장하는 배열을 생성하기
		// 학과명은 "컴퓨터공학과", "통계학과", "수학과", "전자공학과", "정보통신공학과"다.
		// 학과명 배열은 문자열 5개 저장하는 배열을 new 연산자를 사용해서 생성하고,
		// 0번부터 4번까지 순서대로 학과명을 배열에 저장하기

		String[] majors = new String[5];
		majors[0] = "컴퓨터공학과";
		majors[1] = "통계학과";
		majors[2] = "수학과";
		majors[3] = "전자공학과";
		majors[4] = "정보통신공학과";
			

		
		// 학생들의 이름을 저장하는 배열을 생성하기
		// 학생명은 "이순신", "김유신", "강감찬", "류관순"이다.
		// 학생명 배열은 배열표현식을 {값, 값, 값, ...}을 사용해서 배열을 생성하기

		String[] names = {"이순신", "김유신", "강감찬", "류관순"};
		
		
		// 학생들의 학점을 저장하는 배열을 생성하기
		// 학생들의 성적은 3.1, 3.0, 4.0, 4.3이다.
		// 학생성적 배열은 배열표현식을 사용해서 배열을 생성하기

		double[] scores = {3.1, 3.0, 4.0, 4.3};
		
		// ### 배열의 값 출력하기
		// 학과명 배열의 모든 값을 for문을 사용해서 화면에 출력하기
		System.out.println("### 학과명 출력하기 ###");
		for(int i=0; i<majors.length; i++) {
			System.out.println(majors[i]);
		}
		System.out.println();
		
		// 학생이름 배열의 모든 값을 향상된 for문을 사용해서 화면에 출력하기
		System.out.println("### 학생이름 출력하기 ###");
		for(String x : names) {
			System.out.println(x);
		}
		System.out.println();
		
		// 학생성적 배열의 모든 값을 향상된 for문을 사용해서 화면에 출력하기
		System.out.println("### 학생성적 출력하기 ###");
		for(double x : scores) {
			System.out.println(x);
		}		
		System.out.println();
		
		// 학생명 배열에서 0번째에 저장된 학생의 이름과, 학생성적 배열에서 0번째에 저장된 학생의 성적 출력하기
		System.out.println("### 학생성적 출력하기 ###");
		System.out.println(majors[0] +" "+ names[0] +" "+ scores[0]);
		System.out.println();
		
		
		// 성적에 대한 총점과 평균출력하기
		System.out.println("### 성적 총점과 평균 출력하기 ###");
		double sum = 0.0;
		
		for(double x : scores) {
			sum += x;
		}
		
		double avg = sum/scores.length;
		sum = sum*10/10;
		avg = avg*10/10;
		System.out.println("성적 총점: " + sum);
		System.out.println("성적 평균: " + avg);
		System.out.println();
		
		
		
	}
}









