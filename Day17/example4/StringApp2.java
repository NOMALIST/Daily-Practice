package example4;

public class StringApp2 {

	public static void main(String[] args) {
		String str1 = "My Car Is White Car";
		String str2 = "abcdefghijflmnopqrstuvwxyz";
		String str3 = "";
		
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		
		System.out.println();
		System.out.println("str1.length() : " + str1.length());
		System.out.println("str2.length() : " + str2.length());
		System.out.println("str3.length() : " + str3.length());
		
		System.out.println();
		System.out.println("str1.isEmpty() : " + str1.isEmpty());
		System.out.println("str2.isEmpty() : " + str2.isEmpty());
		System.out.println("str3.isEmpty() : " + str3.isEmpty());
		
		System.out.println();
		System.out.println("str1.contains(\"Car\") : " + str1.contains("Car"));
		System.out.println("str2.contains(\"Car\") : " + str2.contains("Car"));
		
		System.out.println();
		System.out.println("str1.indexOf(\"Car\") : " + str1.indexOf("Car"));
		System.out.println("str2.indexOf(\"abc\") : " + str2.indexOf("abc"));
		
		System.out.println();
		System.out.println("str1.lastIndexOf(\"Car\") : " + str1.lastIndexOf("Car"));
		System.out.println("str2.lastIndexOf(\"abc\") : " + str2.lastIndexOf("abc"));
		
		System.out.println();
		System.out.println("str1.substring(3) : " + str1.substring(3));
		System.out.println("str2.substring(20) : " + str2.substring(20));
		
		System.out.println();
		System.out.println("str1.replace(\"Car\", \"House\") : " + str1.replace("Car", "House"));
		
		System.out.println();
		System.out.println("str1.toLowerCase() : " + str1.toLowerCase());
		System.out.println("str2.toLowerCase() : " + str2.toLowerCase());
		
		System.out.println();
		System.out.println("str1.toUpperCase() : " + str1.toUpperCase());
		System.out.println("str2.toUpperCase() : " + str2.toUpperCase());
		
		System.out.println();
		System.out.println("str1.startsWith(\"Car\") : " + str1.startsWith("Car"));
		System.out.println("str1.endsWith(\"Car\") : " + str1.endsWith("Car"));
	}
}
