package example1;

public class Line implements Messenger{

	@Override
	public void sendMessenger(String to, String from, String text) {
		System.out.println("------------- Line Messeage 보내기 -----------");
		System.out.println("받는사람: " + to);
		System.out.println("보낸사람: " + from);
		System.out.println("내    용: " + text);
		System.out.println("----------------------------------------------");
		
	}
}
