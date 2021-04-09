package example1;

public class NaverMail implements Mail{

	@Override
	public void sendMail(String to, String from, String title, String content) {
		System.out.println("-------------- Naver Mail 보내기 -------------");
		System.out.println("받는사람: " + to);
		System.out.println("보낸사람: " + from);
		System.out.println("제    목: " + title);
		System.out.println("내    용: " + content);
		System.out.println("----------------------------------------------");
	}
}
