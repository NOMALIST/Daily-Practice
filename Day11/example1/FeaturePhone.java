package example1;

public class FeaturePhone extends Phone{

	private int pixel;

	public int getPixel() {
		return pixel;
	}

	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	
	public void takePicture() {
		System.out.println("[" + pixel + "만] 화소로 사진을 찍습니다");
	}
	
	
}
