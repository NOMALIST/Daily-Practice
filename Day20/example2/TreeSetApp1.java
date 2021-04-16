package example2;

import java.util.TreeSet;

public class TreeSetApp1 {

	public static void main(String[] args) {
		
		TreeSet<Score> scores = new TreeSet<Score>();
		
		scores.add(new Score("홍범도", 100, 100, 100));
		scores.add(new Score("김좌진", 90, 60, 70));
		scores.add(new Score("트럼프", 40, 50, 60));
		scores.add(new Score("바이든", 60, 20, 20));
		scores.add(new Score("시진핑", 50, 40, 30));
		
		for(Score score : scores) {
			System.out.println(score.toString());
		}
	}
}
