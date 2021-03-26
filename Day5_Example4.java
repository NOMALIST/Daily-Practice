
public class Day5_Example4 {

	// 4. 다차원배열
	public static void main(String[] args) {
		
		/* 다차원배열(2행 3열 다차원 배열) 생성하기 */
		
		int[][] arr = new int[2][3];
		
		arr[0][0] = 15;
		arr[0][1] = 37;
		arr[0][2] = 39;
		arr[1][0] = 46;
		arr[1][1] = 94;
		arr[1][2] = 11;
		
		
		// 다차원 배열의 값 출력하기 (System.out.println)
		System.out.println("### 다차원 배열 출력하기 ###");
		System.out.println(arr[0][0]);
		System.out.println(arr[0][1]);
		System.out.println(arr[0][2]);
		System.out.println(arr[1][0]);
		System.out.println(arr[1][1]);
		System.out.println(arr[1][2]);
		System.out.println();
		
		// for문을 사용해서 다차원 배열의 모든 값을 출력하기

		System.out.println("### for문을 사용해서 출력하기 ###");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%3d",arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		

		/* 3행*X열 2차원 배열 생성하기 */
		// 위에서 정의한 배열의 0번째, 1번째, 2번째 행에 포함될 배열을 생성하기(각 배열의 크기가 서로 다름)
		// 위에서 정의한 names배열의 0번째, 1번째, 2번째에 각각의 배열을 대입시키기
		
		String[][] names = new String[3][];
		
		String[] arr1 = {"바나나", "딸기", "수박", "오렌지", "파인애플", "멜론"};
		String[] arr2 = {"자동차", "비행기", "기차"};
		String[] arr3 = {"삼성", "엘지", "네이버", "한화", "카카오"};
		
		names[0] = arr1;
		names[1] = arr2;
		names[2] = arr3;
		
		
		// 행과 열의 크기 확인하기
		
		System.out.println("### 행과 열의 크기 출력하기 ###");
		System.out.println("names 배열의 행의 크기: " + names.length);
		System.out.println("1번째 열의 크기: " + names[0].length);
		System.out.println("2번째 열의 크기: " + names[1].length);
		System.out.println("3번째 열의 크기: " + names[2].length);
		System.out.println();
		
		// 일반 for문으로 생성한 배열의 모든 값 출력하기
		
		System.out.println("### 일반 for문으로 배열 출력하기 ###");
		for(int i=0; i<names.length; i++) {
			for(int j=0; j<names[i].length; j++) {
				System.out.printf(names[i][j] +"\t");
			}
			System.out.println();
		}
		System.out.println();
		
		
		// 향상된 for문으로 생성한 배열의 모든 값 출력하기
		System.out.println("### 향상된 for문으로 배열 출력하기 ###");
		for(String[] x : names) {
			for(String y : x) {
				System.out.printf(y +"\t");
			}
			System.out.println();
		}
	}
}
