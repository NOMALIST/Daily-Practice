package example1;

import java.util.HashSet;

public class HashSetApp {

	public static void main(String[] args) {
		
		HashSet<String> names = new HashSet<String>();
		
		names.add("강감찬");
		names.add("이순신");
		names.add("김좌진");
		names.add("최무선");
		names.add("최무선");
		names.add("유관순");
		names.add("최무선");
		names.add("최무선");
		names.add("홍범도");
		names.add("유관순");
		names.add("유관순");
		names.add("방정환");
		names.add("유관순");
		names.add("유관순");
		names.add("방정환");
		names.add("정약용");
		names.add("김춘추");
		
		System.out.println("=======HashSet의 크기==========");
		System.out.println(names.size());
		System.out.println("HashSet은 중복되는 데이터를 넣지 않는다.");
		
	}
}
