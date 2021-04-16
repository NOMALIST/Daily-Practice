package example1;

import java.util.HashSet;

public class HashSetApp1 {
	//### HashSet 객체에 문자열 저장하기 (add)
	//### HashSet 객체에 저장된 문자열 출력하기
	public static void main(String[] args) {
		HashSet<String> webtoons = new HashSet<String>();
		
		webtoons.add("프리드로우");
		webtoons.add("호랑이형님");
		webtoons.add("외모지상주의");
		webtoons.add("참교육");
		webtoons.add("기기괴괴");
		webtoons.add("여신강림");
		
		for(String web : webtoons) {
			System.out.println(web);
		}
	}
}
