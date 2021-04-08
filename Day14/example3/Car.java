package example3;

public interface Car {

	int MAX_HIGH_SPEED = 300;
	int MIN_LOW_SPEED = 0;
	
	public void drive();
	public void stop();
	public void speedUp();
	public void speedDown();
}
