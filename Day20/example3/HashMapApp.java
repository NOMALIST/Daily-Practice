package example3;

import java.util.HashMap;

public class HashMapApp {

	public static void main(String[] args) {
		/*HashMapApp1*/
		
		//### Map객체에 key,value 저장하기(put)
		//### Map객체에 저장된 Entry(key와 value의 쌍) 삭제하기 (remove)
		//### Map객체에 저장된 값 출력해보기 (get)
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(10, "홍길동");
		map.put(20, "이몽룡");
		map.put(30, "성춘향");
		map.put(40, "변사또");
		map.put(50, "암행어사");
		
		map.remove(50);
		
		System.out.println(map.get(10));
		System.out.println(map.get(20));
		System.out.println(map.get(30));
		System.out.println(map.get(40));
		System.out.println(map.get(50));
	}
}
