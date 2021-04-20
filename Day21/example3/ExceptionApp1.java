package example3;

public class ExceptionApp1 {

	public static void main(String[] args) {
		System.out.println("### 각종 Exception ###");
		
		
		
		try {
			//String text = null;
			//System.out.println(text.length());
			
			// int arr[] = {1,2,3,4,5};
			// System.out.println(arr[6]);
			
			// int a = 10/0;
			
			Phone p1 = new FeaturePhone();
			SmartPhone p2 = (SmartPhone) p1;
			
		} catch (NullPointerException e1) {
			System.out.println(e1);
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println(e2);
		} catch (ArithmeticException e3) {
			System.out.println(e3);
		} catch (ClassCastException e4) {
			System.out.println(e4);
		}
		
	}
	
	static class Phone {}
	static class FeaturePhone extends Phone {}
	static class SmartPhone extends Phone {}
}
