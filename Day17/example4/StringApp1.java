package example4;

public class StringApp1 {

	public static void main(String[] args) {
		
		String a = "안녕";
		String b = "안녕";
		String c = new String("안녕");
		String d = new String("안녕");
		
		System.out.println("a:" + a + "  b:" + b + "  c:" + c + "  d:" + d);
		
		System.out.println("a == b : " + (a == b));
		System.out.println("a.equals(b) :" + a.equals(b));
		System.out.println("c == d :" + (c == d));
		System.out.println("c.equals(d) :" + c.equals(d));
	}
}
