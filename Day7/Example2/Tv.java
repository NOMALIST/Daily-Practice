package Example2;

public class Tv {
	private int channel = 10;
	private boolean power;

	/**
	 * Tv 객체의 power상태를 true로 설정한다.
	 */

	// power의 값을 true로 설정한다
	// 변경작업 - 반환타입 : void
	// 매개변수 - 필요없음
	public void on() {
		power = true;
	}

	/**
	 * Tv 객체의 power상태를 false로 설정한다.
	 */

	// power의 값을 false로 설정한다. 
	// 변경작업 - 반환타입 : void
	// 매개변수 - 필요없음
	public void off() {
		// tv객체의 전원상태를 false로 설정한다.
		power = false;
	}

	/**
	 * Tv 객체의 channel 숫자를 1 감소시킨다.
	 */

	// 채널숫자를 1 감소시킨다. 
	// 변경작업 - 반환타입 : void
	// 매개변수 - 필요없음
	public void channelDown() {
		// 
		channel--;
		if(channel < 1) channel = 100;
	}

	/**
	 * Tv 객체의 channel 숫자를 1 증가시킨다.
	 */

	// 채널숫자를 1 증가시킨다. 
	// 변경작업 - 반환타입 : void
	// 매개변수 - 필요없음
	public void channelUp() {
		channel++;
		if(channel > 100) channel = 1;
	}

	/**
	 * Tv 객체의 channel 숫자를 입력값으로 변환한다.
	 * @param channelNumber 변경할 채널 번호
	 */

	// OO 채널로 변경한다.
	// 변경작업 - 반환타입 : void
	// 매개변수 - 채널번호(정수)
	public void changechannel(int channelNumber) {
		if(channelNumber >= 1 && channelNumber <= 100)	channel = channelNumber;
	}

	/**
	 * Tv 객체의 channel를 조회하여 return시킨다.
	 * @return 현재 채널번호(1~100 사이의 정수값)
	 */

	// 현재 시청중인 채널번호를 조회한다. 
	// 조회작업-반환타입 : 채널번호(정수)
	public int getCurrentChannel() {
		if(power) return channel;
		else return -1;
	}
}
