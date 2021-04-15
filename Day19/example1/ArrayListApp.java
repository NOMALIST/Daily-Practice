package example1;

import java.util.ArrayList;

public class ArrayListApp {
	/*ArrayListApp1*/
	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		
		// ArrayList 객체에 데이터(문자열 데이터) 저장하기 (add)
		names.add("강감찬");
		names.add("이순신");
		names.add("김좌진");
		names.add("최무선");
		names.add("홍범도");
		names.add("유관순");
		names.add("방정환");
		names.add("정약용");
		names.add("김춘추");
		
		// ArrayList 객체에 저장된 데이터 갯수 조회하기 (size)
		System.out.println("ArrayList의 크기: " + names.size());
		System.out.println();
		
		// ArrayList 객체에 저장된 데이터 전부 출력하기
		System.out.println("=====ArrayList의 내용 출력=====");
		for(String name : names) {
			System.out.println(name);
		}
		System.out.println();
		System.out.println("========toString으로 출력하기======");
		System.out.println(names.toString());
		System.out.println();
		
		//ArrayList객체에 "김유신" 데이터가 존재하는지 확인하기 (contain)
		System.out.println("김유신이 포함되어있는가? " + names.contains("김유신"));
		
		//ArrayList객체에서 "강감찬" 데이터 삭제하기 (remove)
		names.remove("강감찬");
		
		// ArrayList 객체에 저장된 데이터 전부 출력하기 
		System.out.println(names.toString());
		System.out.println();
		
		//ArrayList객체에 저장된 모든 데이터 삭제하기 (clear)
		names.clear();
		
		// ArrayList 객체에 저장된 데이터 전부 출력하기 
		System.out.println(names.toString());
		System.out.println();
		
		// ArrayList가 비어있는지 확인하기 (isEmpty)
		System.out.println("ArrayList가 비어있는가? " + names.isEmpty());
		
		
		
	}
}
