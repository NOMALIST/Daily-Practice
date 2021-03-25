
public class Example7 {

	// 7. 배열 활용 (향상된 for문 사용 - ArrayDemo3.java)
	
	public static void main(String[] args) {
		 
		
		String[] names = {"김유신", "이순신", "홍길동"};
		int[] korScores = {100, 80, 30};
		int[] engScores = {80, 100, 50};
		int[] mathScores = {80, 100, 20};
		
		// 이번에 수업에 참여한 모든 학생의 이름을 출력하시오.
		
		int numberStudent = names.length;
		
		System.out.println("수업에 참여한 학생");
		System.out.println("=============================");
		
		for(int i=0; i<numberStudent; i++) {
			System.out.println(names[i]);
		}
		System.out.println("=============================");
		
		System.out.println();
		
		
		// 김유신/이순신/홍길동 학생의 성적을 전부 출력하시오.
		System.out.println("모든학생의 성적");
		System.out.println("=============================");
		System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학");
		for(int i=0; i<numberStudent; i++) {
			System.out.println(names[i] + "\t" + korScores[i] + "\t" + engScores[i] + "\t" +  mathScores[i]);
		}
		System.out.println("=============================");
		System.out.println();
		
		// 국어 점수의 평균을 출력하시오.
		
		int korSum = 0;
		for(int x : korScores) {
			korSum += x;
		}
		int korAvg = korSum/korScores.length; 
		
		System.out.println("=============================");
		System.out.println("국어점수 평균 : " + korAvg);
		System.out.println("=============================");
		System.out.println();
		
		// 수학 점수의 평균을 출력하시오.
		
		int mathSum = 0;
		for(int x : mathScores) {
			mathSum += x;
		}
		int mathAvg = mathSum/mathScores.length; 
		
		System.out.println("=============================");
		System.out.println("수학점수 평균 : " + mathAvg);
		System.out.println("=============================");
		System.out.println();
		
		// 영어 점수의 평균을 출력하시오.
		
		int engSum = 0;
		for(int x : engScores) {
			engSum += x;
		}
		int engAvg = engSum/engScores.length; 
		
		System.out.println("=============================");
		System.out.println("영어점수 평균 : " + engAvg);
		System.out.println("=============================");
		System.out.println();
		
		// 각 학생별 학생이름, 국어, 영어, 수학점수, 총점, 평균점수를 출력하시오.
		
		System.out.println("모든학생의 성적, 총점, 평균");
		System.out.println("===============================================");
		System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점" + "\t" + "평균");
		for(int i=0; i<names.length; i++) {
			int perSum = korScores[i] + engScores[i] + mathScores[i];
			int perAvg = perSum/3;
			System.out.println(names[i] + "\t" + korScores[i] + "\t" + engScores[i] + "\t" + mathScores[i] + "\t" +  perSum + "\t" + perAvg);
		}
		System.out.println("===============================================");
	}
}
