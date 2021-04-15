package example3;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListApp3 {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("유관순");
		names.add("안창호");
		names.add("유관순");	
		names.add("안중근");
		names.add("김이이");
		
		System.out.println("### 이름에 '이'가 포함되는 사람을 삭제하기");
		
		System.out.println("이전 ArrayList : " + names.toString());
		Iterator<String> iter = names.iterator();
		while(iter.hasNext()) {
			String name = iter.next();
			if(name.contains("이")) {
				iter.remove();
			}
		}
		
		System.out.println("현재 ArrayList : " + names.toString());
		
	}
}
