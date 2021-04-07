package example1;

public class PersonApp {

	
	public static void main(String[] args) {

		Student student1 = new Student("홍길동",1,"도술학과");
		Student student2 = new Student("임꺽정", "lim@gmail.com", "010-0000-1111",2,"산적학과");
		
		Professor professor1 = new Professor("이순신","정교수", "해군학");
		Professor professor2 = new Professor("유관순","korea@korea.co.kr", "010-5555-6666","조교수","독립운동학과");
		
		student1.displayInfo();
		System.out.println();
		student2.displayInfo();
		System.out.println();
		
		professor1.setEmail("Tuttleship@battle.com");
		
		professor1.displayInfo();
		System.out.println();
		professor2.displayInfo();
		System.out.println();
		
	}
	
}
