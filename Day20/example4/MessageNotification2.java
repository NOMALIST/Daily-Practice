package example4;

import java.util.HashMap;

public class MessageNotification2 {

	
	HashMap<String, MessageSender> messageSenders = new HashMap<String, MessageSender>();

	//MessageNotification2() 생성자
	//HashMap<String, MessageSender> 객체에 MessageSender 인터페이스를 구현한 객체를 저장

	public MessageNotification2() {
		messageSenders.put("sms", new SmsMessageSender());
		messageSenders.put("katalk", new KakaoTalkSender());
		messageSenders.put("email", new EmailMessageSender());
	}
	
	
	//notice(customer,from,title,content) 메소드 (for문)
	
	public void notice(Customer customer, String from, String title, String content) {
		String[] messageTypes = customer.getMessages();
		
		for(String messageType : messageTypes) {
			MessageSender sender = messageSenders.get(messageType);
			sender.sendMessage("시스템", "사용자", "시스템점검", "이번 주말 48동안 시스템을 점검할 예정입니다.");
		}
	}
	
}
