package example4;

public class HashMapApp {

	public static void main(String[] args) {
		
		MessageNotification1 notice1 = new MessageNotification1();
		MessageNotification2 notice2 = new MessageNotification2();
		
		Customer customer1 = new Customer("홍길동", new String[] {"sms","email","katalk"});
		Customer customer2 = new Customer("임꺽정", new String[] {"email","katalk"});
		Customer customer3 = new Customer("전우치", new String[] {"katalk"});
		
		System.out.println("-------------------------------------------------------------------------------------");
		notice1.notice(customer1, "인사팀", "연봉계약", "2021년 연봉계약을 순차 진행합니다. 메일확인 부탁드립니다.");
		System.out.println("-------------------------------------------------------------------------------------");
		notice1.notice(customer2, "꽃배달", "주소지 확인", "@@@시 $$동 &&아파트 1동 1호로 꽃이 배달됩니다. 주소이상있을 경우 연락바랍니다.");
		System.out.println("-------------------------------------------------------------------------------------");
		notice1.notice(customer3, "고급레스토랑", "이벤트당첨", "무료식사 이벤트에 당첨되었습니다. 희망방문 시간을 알려주세요");
		System.out.println("-------------------------------------------------------------------------------------");
		
		System.out.println("----------------- HashMap 사용 ----------------------");
		System.out.println("-------------------------------------------------------------------------------------");
		notice2.notice(customer1, "인사팀", "연봉계약", "2021년 연봉계약을 순차 진행합니다. 메일확인 부탁드립니다.");
		System.out.println("-------------------------------------------------------------------------------------");
		notice2.notice(customer2, "꽃배달", "주소지 확인", "@@@시 $$동 &&아파트 1동 1호로 꽃이 배달됩니다. 주소이상있을 경우 연락바랍니다.");
		System.out.println("-------------------------------------------------------------------------------------");
		notice2.notice(customer3, "고급레스토랑", "이벤트당첨", "무료식사 이벤트에 당첨되었습니다. 희망방문 시간을 알려주세요");
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
