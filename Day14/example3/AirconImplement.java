package example3;

public class AirconImplement implements Aircon{
	
	@Override
	public void temperatureDown() {
		System.out.println("The temperature has been raised.");
	}
	
	@Override
	public void temperatureUp() {
		System.out.println("The temperature has been lowered.");
	}
	
}
