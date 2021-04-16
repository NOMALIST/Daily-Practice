package example1;

import java.util.HashSet;

public class HashSetApp3 {

	public static void main(String[] args) {
		
		HashSet<Contact> contacts = new HashSet<Contact>();
		
		contacts.add(new Contact("홍길동","010-1111-2222","hong@gmail.com"));
		contacts.add(new Contact("김  구","010-2222-3333","kim@gmail.com"));
		contacts.add(new Contact("최익현","010-4444-5555","choi@gmail.com"));
		contacts.add(new Contact("이성계","010-6666-7777","lee@gmail.com"));
		contacts.add(new Contact("방정환","010-8888-9999","bang@gmail.com"));
		contacts.add(new Contact("이사부","010-0000-2222","lee2@gmail.com"));
		
		for(Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}
}
