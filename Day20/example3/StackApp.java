package example3;

import java.util.Stack;


public class StackApp {

	//Stack 객체에 값 저장(push)
	//### Stack객체에서 값 꺼내기 (while, pop)

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		stack.push("문자열1");
		stack.push("문자열6");
		stack.push("문자열2");
		stack.push("문자열5");
		stack.push("문자열3");
		stack.push("문자열4");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println("선입후출로 출력되는 것 확인");
	}
}
