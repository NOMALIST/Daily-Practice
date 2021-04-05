package example2;

public class PrinterApp {

	public static void main(String[] args) {
		Printer printer = new Printer();
		ColorPrinter colorPrinter = new ColorPrinter();
		LaserPrinter laserPrinter = new LaserPrinter(); 
		LaserColorPrinter laserColorPrinter = new LaserColorPrinter();
		
		System.out.println("### 각 객체에서 print 기능 ###");
		System.out.print("Printer : ");
		printer.print();
		System.out.print("ColorPrinter : ");
		colorPrinter.print();
		System.out.print("LaserPrinter : ");
		laserPrinter.print();
		System.out.print("laserColorPrinter : ");
		laserColorPrinter.print();
		System.out.println();
		
		System.out.println("### 각 객체에서 refill 기능 ###");
		System.out.print("Printer : ");
		printer.refill();
		System.out.print("ColorPrinter : ");
		colorPrinter.refill();
		System.out.print("LaserPrinter : ");
		laserPrinter.refill();
		System.out.print("laserColorPrinter : ");
		laserColorPrinter.refill();
	}
}
