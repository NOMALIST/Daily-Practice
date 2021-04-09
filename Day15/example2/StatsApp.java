package example2;

public class StatsApp {

	public static void main(String[] args) {
		
		StudentRepo student = new StudentRepo();

		System.out.println("---------Student----------");
		System.out.println("학생수: " + student.getStudents().length);
		System.out.println("합  계: " + student.getStats().total());
		System.out.println("평  균: " + student.getStats().average());
		System.out.println();
		
		GameRepo game = new GameRepo();
		System.out.println("-----------Game-----------");
		System.out.println("경기수: " + game.getGames().length);
		System.out.println("승  수: " + game.getStats().total());
		System.out.println("승  률: " + game.getStats().average() + "%");
		System.out.println();
		
		SalesRepo sales = new SalesRepo();
		System.out.println("-------SalesResult--------");
		System.out.println("실적수: " + sales.getItems().length);
		System.out.println("총순익: " + sales.getStats().total());
		System.out.println("평  균: " + sales.getStats().average() + " 원/건");
		System.out.println();
	}

}
