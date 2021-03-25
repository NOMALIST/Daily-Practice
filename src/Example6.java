
public class Example6 {

	// 6. 배열 (ArrayDemo1.java)
	public static void main(String[] args) {
		
		// String, int, double 배열 선언 후 값을 넣고 출력해보기
		// for문 / 향상된 for문 각각 사용

		String[] arrStrings = new String[10];
		int[] arrInts = new int[10];
		double[] arrDoubles = new double[10];

		int x = arrStrings.length;
		System.out.println("배열의 크기 : " + x);
		
		System.out.println();
		for(int i=0; i< x; i++) { 
			arrStrings[i] = "문자열"+i;
			arrInts[i] = i;
			arrDoubles[i] = i;
		}
		
		for(int i=0; i< x; i++) { 
			System.out.println(arrStrings[i] + "\t\t" + arrInts[i] + "\t" + arrDoubles[i]);
		}
		
		System.out.println();
		System.out.println("향상된 for문 사용");
		
		for(String y : arrStrings ) {
			System.out.println(y);
		}
		
		
		 
	}
}
