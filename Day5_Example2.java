
public class Day5_Example2 {

	// 2. 배열 (최대값, 최소값 구하기) (ArrayDemo5.java)
	public static void main(String[] args) {
		
		// 배열에 저장된 값을 대상으로 최소값, 최대값 구하기
		// int[] scores = {79, 88, 91, 100, 55, 99};		
		// 최소값을 구할 때는 해당값이 가질 수 있는 가장 큰 값을 초기값으로 지정한다.
		// 최대값을 구할 때는 해당값이 가질 수 있는 가장 작은 값을 초기값으로 지정한다.
		// 최소값은 변수 min에 저장된 값보다 배열에서 조회한 값이 더 작을 때만 min의 값을 배열의 값으로 바꾼다.
		// 최대값은 변수 max에 저장된 값보다 배열에서 조회한 값이 더 클 때만 max의 값을 배열의 값으로 바꾼다.
		
		int[] scores = {79, 88, 91, 100, 55, 99};
		
		int min = 100;
		int max = 0;
		
		for(int x : scores) {
			if(min > x) min = x;
			if(max < x) max = x;
		}
		System.out.println("최소값: " + min);
		System.out.println("최대값: " + max);
		
	}
}
