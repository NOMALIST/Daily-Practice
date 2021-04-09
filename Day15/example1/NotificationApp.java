package example1;

public class NotificationApp {

	public static void main(String[] args) {
		EventNotification notice1 = new EventNotification();
		EventNotification notice2 = new EventNotification();
		
		GoogleMail google = new GoogleMail();
		NaverMail naver = new NaverMail();
		
		Kakaotalk kakao = new Kakaotalk();
		Line line = new Line();
		
		Instagram insta = new Instagram();
		Facebook fabook = new Facebook();
		
		notice1.setMail(naver);
		notice1.setMessenger(line);
		notice1.setSns(insta);
		
		notice2.setMail(google);
		notice2.setMessenger(kakao);
		notice2.setSns(fabook);
		
		notice1.SendMail("홍길동", "삼성전자", "최종합격", "20201년 공개채용에 최종합격 하셨습니다.");
		System.out.println();
		notice1.SendMessage("홍길동", "유관순", "5/1 오전 10시 신입사원 교육예정입니다.");
		System.out.println();
		notice1.PostSNS("쿠팡 개발자 공개채용", "신입 개발자 공개채용을 진행합니다. 경력무관. 업계최고대우 약속.");
		System.out.println();
		
		notice2.NoticeAll("someone", "HYUNDAI", "2021 봄 특별행사", "전차종 20% 파격 할인");
		
	}
}
