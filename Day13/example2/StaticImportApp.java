package example2;

import static java.lang.Math.*;

public class StaticImportApp {

	public static void main(String[] args) {
		
		System.out.println("### StaticImport Test ###");
		System.out.println("random() : " + random());
		System.out.println();
		System.out.println("abs(-2) : " + abs(-2));
		System.out.println("abs(3.54) : " + abs(3.54));
		System.out.println("abs(-156515.154) : " + abs(-156515.154));
		System.out.println();
		System.out.println("floor(3.999) : " + floor(3.999));
		System.out.println("floor(3.001) : " + floor(3.001));
		System.out.println("floor(4.151) : " + floor(4.151));
		System.out.println("round(3.142) : " + round(3.142));
		System.out.println("round(-3.14) : " + round(-3.14));
		System.out.println("round(3.999) : " + round(3.999));
		System.out.println("ceil(10.001) : " + ceil(10.001));
		System.out.println("ceil(10.999) : " + ceil(10.999));
		System.out.println("ceil(-10.01) : " + ceil(-10.01));
		System.out.println();
		
		System.out.println("max(2,9) : " + max(2,9));
		System.out.println("max(2.7, 19.0) : " + max(2.7 , 19.0));
		System.out.println("max(-2,-9) : " + max(-2,-9));
		System.out.println("min(2,9) : " + min(2,9));
		System.out.println("min(2.7, 19.0) : " + min(2.7 , 19.0));
		System.out.println("min(-2,-9) : " + min(-2,-9));
		System.out.println();
		
		System.out.println("pow(2,2) : " + pow(2,2));
		System.out.println("pow(2,4) : " + pow(2,4));
		System.out.println("sqrt(25) : " + sqrt(25));
		System.out.println("sqrt(144) : " + sqrt(144));
		System.out.println();
		
		System.out.println("round(sin(PI)) : " + round(sin(PI)));
		System.out.println("round(cos(PI)) : " + round(cos(PI)));
		System.out.println("round(tan(PI)) : " + round(tan(PI)));	
		
	}
}
