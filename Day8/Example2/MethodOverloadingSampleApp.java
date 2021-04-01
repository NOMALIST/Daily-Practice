package Example2;

public class MethodOverloadingSampleApp {

	public static void main(String[] args) {
		
		MethodOverloadingSample s1 = new MethodOverloadingSample(5, 5);
		
		MethodOverloadingSample s2 = new MethodOverloadingSample(5.0, 5);
		
		MethodOverloadingSample s3 = new MethodOverloadingSample(5, 5.0);
		
		MethodOverloadingSample s4 = new MethodOverloadingSample(5.0, 5.0);
		
		MethodOverloadingSample s5 = new MethodOverloadingSample(5, 5, 5);
	}
}
