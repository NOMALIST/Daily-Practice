package example1;

import java.util.HashSet;
import java.util.Random;

public class HashSetApp2 {
	//로또 번호 생성하기
	//Random 객체 생성
	//while문으로 랜덤값 생성(1~45)
	//출력
	public static void main(String[] args) {

		HashSet<Integer> lotto = new HashSet<Integer>();
		
		Random random = new Random();
		
		while((lotto.size() < 6)) {
			int number = random.nextInt(45)+1;
			System.out.print(number + " ");
			lotto.add(number);
		}
		System.out.println();
		
		System.out.println(lotto);
	}
}
