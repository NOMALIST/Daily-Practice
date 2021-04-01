package Example2;

public class MethodOverloadingSample {
	
	//int x, double y
	//double x, int y
	//int x, int y
	//int x,y,z
	//double x, double y

	MethodOverloadingSample(int x, int y) {
		System.out.println(x+y);
	}
	
	MethodOverloadingSample(int x, int y, int z) {
		System.out.println(x+y+z);
	}
	
	MethodOverloadingSample(double x, int y) {
		System.out.println(x+y);
	}
	
	MethodOverloadingSample(int x, double y) {
		System.out.println(x+y);
	}
	
	MethodOverloadingSample(double x, double y) {
		System.out.println(x+y);
	}
	
}
