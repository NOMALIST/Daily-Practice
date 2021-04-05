package example1;

public class PhoneApp {

	// 클래스 상속
	
	public static void main(String[] args) {
		Phone phone = new Phone();
		FeaturePhone featurePhone = new FeaturePhone();
		SmartPhone smartPhone = new SmartPhone();
		
		// 초기화
		// 부모객체도 초기화 해줘야함
		phone.setTel("010-1111-2222");
		featurePhone.setPixel(700);
		featurePhone.setTel("010-3333-4444");
		smartPhone.setIp("192.0.0.1");
		smartPhone.setEmailAddress("aaa@naver.com");
		smartPhone.setTel("010-5555-6666");
		
		// 전화 걸기
		
		System.out.println("### 각 객체에서 전화걸기 ###");
		System.out.print("phone 객체 : ");
		phone.call();
		System.out.print("featurePhone 객체 : ");
		featurePhone.call();
		System.out.print("smartPhone 객체 : ");
		smartPhone.call();
		System.out.println();
		
		// featurePhone 객체 메소드
		System.out.println("### fearutePhone 객체에서 전화걸기 ###");
		featurePhone.takePicture();
		System.out.println();
		
		// smartPhone 객체 메소드
		System.out.println("### smartPhone 객체 인터넷/메일 기능 ###");
		smartPhone.web();
		smartPhone.mail();
	}
}
