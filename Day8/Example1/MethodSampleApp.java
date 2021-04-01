package Example1;

public class MethodSampleApp {

	public static void main(String[] args) {
		//기본자료형 타입 매개변수(x,y)를 가진 method  선언
		//x,y값 출력
		// 참조자료형 타입 매개변수(MyNumber number)를 가진 method선언
		//number안의 x,y값 출력
		
		int num1 = 100;
		int num2 = 200;
		
		MethodSample sample = new MethodSample();
		
		sample.print1(num1, num2);
		
		
		MyNumber mn = new MyNumber();
		
		
		mn.x = 10;
		mn.y = 20;
		
		sample.print2(mn);
		
		
	}
}
