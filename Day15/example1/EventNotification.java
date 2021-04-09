package example1;

public class EventNotification {

	private Mail mail;
	private Messenger messenger;
	private SNS sns;
	
	
	public EventNotification() { }
	
	public void setMail(Mail mail) {
		this.mail = mail;
	}
	public void setMessenger(Messenger messenger) {
		this.messenger = messenger;
	}
	public void setSns(SNS sns) {
		this.sns = sns;
	}
	
	public void SendMail(String to, String from, String title, String content) {
		mail.sendMail(to, from, title, content);
	}
	
	public void SendMessage(String to, String from, String text) {
		messenger.sendMessenger(to, from, text);
	}
	
	public void PostSNS(String title, String content) {
		sns.post(title, content);
	}
	
	public void NoticeAll(String to, String from, String title, String contet) {
		mail.sendMail(to, from, title, contet);
		messenger.sendMessenger(to, from, contet);
		sns.post(title, contet);
	}
}
