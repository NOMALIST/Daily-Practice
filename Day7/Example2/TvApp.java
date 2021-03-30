package Example2;

public class TvApp {

	public static void main(String[] args) {
		Tv remote = new Tv();
		int channel;
		
		System.out.println("Tv 전원 on");
		remote.on();
		channel = remote.getCurrentChannel();
		System.out.println("현재 채널 : " + channel);
		System.out.println();
		
		System.out.println("채널 down");
		remote.channelDown();
		channel = remote.getCurrentChannel();
		System.out.println("현재 채널 : " + channel);
		System.out.println();
		
		System.out.println("채널 up");
		remote.channelUp();
		channel = remote.getCurrentChannel();
		System.out.println("현재 채널 : " + channel);
		System.out.println();
		
		System.out.println("채널 변경");
		remote.changechannel(55);
		channel = remote.getCurrentChannel();
		System.out.println("현재 채널 : " + channel);
		System.out.println();
		
		System.out.println("Tv 전원 off");
		remote.off();
		channel = remote.getCurrentChannel();
		System.out.println("현재 채널 : " + channel + "(전원 꺼짐)");
	}
}
