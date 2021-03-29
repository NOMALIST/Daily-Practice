
public class Example4 {

	public static void main(String[] args) {
		Tv t;
		t = new Tv();
		t.channel =7;
		t.channelDown();
		System.out.println("현재 채널은 " + t.channel + "입니다.");
	}
}


class Tv {
	String color;
	boolean power;
	int channel;
	
	
	// Tv의 기능(메서드)
	void power() {			// Tv 끄기
		power = !power;
	}
	
	void channelUp() {		// 채널 올리기
		++channel;
	}
	
	void channelDown() {	// 채널 내리기
		--channel;
	}
}