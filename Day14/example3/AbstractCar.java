package example3;

public abstract class AbstractCar implements Car{

	private int currentSpeed = 0;
	
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
	@Override
	public void drive() {
		System.out.println("Start Driving.");
		currentSpeed = 10;
	}
	@Override
	public void stop() {
		System.out.println("Stop Driving");
		currentSpeed = 0;
	}
	@Override
	public void speedDown() {
		currentSpeed -= 10;
		if(currentSpeed < MIN_LOW_SPEED) currentSpeed = MIN_LOW_SPEED;
		
	}
	@Override
	public void speedUp() {
		currentSpeed += 10;
		if(currentSpeed > MAX_HIGH_SPEED) currentSpeed = MAX_HIGH_SPEED;
	}
}
