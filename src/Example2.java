
public class Example2 {

	// 2. 중첩 for문 (자바의정석예제 4-11 p.114)
	public static void main(String[] args) {
		
		// 간단한 별 출력하기
		/*
		*
		**
		***
		****
		*****
		*/
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
