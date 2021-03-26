import java.util.Arrays;

public class Day5_Example5 {

	// 5. 배열 예제
	public static void main(String[] args) {
		/*
		 * 학생들의 이름을 저장하는 1차원 배열이 있다.
		 * 학생들의 국어, 영어, 수학, 점수를 저장하는 2차원 배열이 있다.
		 * 
		 * ["김유신", "강감찬", "이순신", "류관순"]
		 * 
		 * 국어		영어		수학 <-- 실제 배열에 저장되는 값은 아님
		 * 100		100		100	<-- 김유신의 성적
		 *  90		 70		 80 <-- 강감찬의 성적
		 *  70		 60		 40 <-- 이순신의 성적
		 * 100		 80		 90	<-- 류관순의 성적
		 * 
		 */

		String[] names = {"김유신", "강감찬", "이순신", "류관순"};
		int[][] scores = { {100, 100, 100,},
							{90, 70, 80},
							{70, 60, 40},
							{100, 80, 90}};

		
		//### 김유신 학생의 성적정보 출력하기 ###
		
		System.out.println("### 김유신 학생의 성적정보 출력하기 ###");
		System.out.println(Arrays.toString(scores[0]));
		System.out.println();		
		
		//### 국어과목의 총점과 평균을 계산하고, 출력하기 ###
		System.out.println("### 국어과목의 총점과 평균을 계산하고, 출력하기 ###");
		int sum = 0;
		for(int i=0; i<names.length; i++) {
			sum += scores[i][0];
		}
		int avg = sum/names.length;
		System.out.println("국어점수 총접: " + sum);
		System.out.println("국어점수 평균: " + avg);
		System.out.println();	
		
				
		/*
		 ============ 학생 성적 정보 ============
		 이름	  국어	영어  수학	총점  평균
		 김유신	   100	100	   100	 300   100
		 강감찬     90	 70	    80	 240    80
		 이순신     70	 60	    40	 170    56
		 류관순    100	 80	    90	 270    90
		 ========================================
		출력하기
		 */
		
		System.out.println("============== 학생 성적 정보 ===============");
		System.out.printf("%5s%5s%5s%5s%5s%5s\n","이름","국어","영어","수학","총점","평균");
		
		for(int i=0; i<names.length; i++) {
			System.out.printf("%5s",names[i]);
			int personSum = 0;
			for(int x : scores[i]) {
				personSum += x; 
			}
			int personAvg = personSum/scores[i].length;
			
			System.out.printf("%6d%7d%7d%7d%7d",scores[i][0],scores[i][1],scores[i][2],personSum,personAvg);
			
			System.out.println();
		}
		
		System.out.println("=============================================");
		
		

	}
}

