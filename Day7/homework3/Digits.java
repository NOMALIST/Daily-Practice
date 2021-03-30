package homework3;

public class Digits {

	int calc(long input) {
		int sum = 0;
		
		for(int i = 1; i<input; i*=10) {
			long x = (input%(i*10)) / i;
			sum += (int) x;
		}
		
		return sum;
	}
}
