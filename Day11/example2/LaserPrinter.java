package example2;

public class LaserPrinter extends Printer{

	@Override
	public void refill() {
		System.out.println("토너를 교체합니다");
	}
}
