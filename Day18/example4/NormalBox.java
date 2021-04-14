package example4;

/*
 * 제네릭 적용되어 있지 않은 박스 설계도
 * 		1. 타입안정석이 좋지 않다.
 * 		2. 저장된 객체가 Ibject로 형변환 되어서 저장한다.
 * 		   (실제로 저장된 객체를 참조하는 것이 아니라, 저장된 객체의 Object객체를 참조한다)
 */

public class NormalBox {

	private Object item;
	
	public NormalBox() {}

	public NormalBox(Object item) {
		super();
		this.item = item;
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	};
	
	
}
