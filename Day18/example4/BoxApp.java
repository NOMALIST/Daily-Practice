package example4;

public class BoxApp {

	public static void main(String[] args) {
		// 문자열을 저장하는 NormailBox의 GenericBox 만들기
		
		// 박스 객체 생성하기
		NormalBox nomal = new NormalBox();
		GenericBox<String> generic1 = new GenericBox<String>();
		GenericBox<String> generic2 = new GenericBox<String>();
		GenericBox<Integer> generic3 = new GenericBox<Integer>();
		
		nomal.setItem("자바 생각보다 재밌음");
		System.out.println(nomal.getItem());
		System.out.println("글자수: " + ((String)nomal.getItem()).length() + "글자");
		System.out.println();
		
		generic1.setItem("근데 문법배우는거 약간 지겨움, 그래도 이거 모르면 아예 시작도 못하니까...");
		System.out.println(generic1.getItem());
		System.out.println("글자수: " + generic1.getItem().length() + "글자");
		System.out.println();
		
		generic2.setItem("이거는 <>선언 안했는데 String이 되나?.. 안되네 Object로 인식된듯?");
		System.out.println(generic2.getItem());
		System.out.println("글자수: " + generic2.getItem().length() + "글자");
		System.out.println();
		
		generic3.setItem(1000);
		System.out.println(generic3.getItem());
		System.out.println("최소값: " + generic3.getItem().MIN_VALUE);
		System.out.println("최대값: " + generic3.getItem().MAX_VALUE);

	}
}
