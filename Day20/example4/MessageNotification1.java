package example4;

public class MessageNotification1 {

	private KakaoTalkSender katalk = new KakaoTalkSender();
	private EmailMessageSender email = new EmailMessageSender();
	private SmsMessageSender sms = new SmsMessageSender();
	
	public void notice(Customer customer, String from, String title, String content) {
		
		String[] messageTypes = customer.getMessages();
		
		for(String messageType : messageTypes) {
			if(messageType.equals("sms")) {
				sms.sendMessage(from, customer.getName(), title, content);
			} else if(messageType.equals("katalk")) {
				katalk.sendMessage(from, customer.getName(), title, content);
			} else if(messageType.equals("email")) {
				email.sendMessage(from, customer.getName(), title, content);
			}
		}
	}
}
