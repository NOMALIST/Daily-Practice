package example1;

public class Instagram implements SNS{

	@Override
	public void post(String title, String content) {
		System.out.println("------------- Instargram 게시하기 ------------");
		System.out.println("제    목: " + title);
		System.out.println("내    용: " + content);
		System.out.println("----------------------------------------------");
		
	}
}
