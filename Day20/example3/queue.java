package example3;

import java.util.LinkedList;
import java.util.Queue;

public class queue {

	public static void main(String[] args) {
		
		LinkedList<String> queue = new LinkedList<String>();
		
		queue.offer("문자열1");
		queue.offer("문자열6");
		queue.offer("문자열2");
		queue.offer("문자열5");
		queue.offer("문자열4");
		queue.offer("문자열3");
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		System.out.println("Queue는 선입선출로 값이 나오는 것 확인");
	}
}
