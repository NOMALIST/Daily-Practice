package example2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesApp1 {
	//properties파일에 정의된 설정정보를 처리하는 Properties객체 생성하기
	//database.properties파일을 읽어오는 FileReader객체를 생성한다.
	//Properties객체의 load()메소드로 properties파일을 읽어온다.

	//properties파일에 설정된 설정정보 조회하기
	//### 데이터베이스 연결관련 설정정보 출력
	//### 파일업로드 관련 설정정보 출력
	
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		
		FileReader reader = new FileReader("src/example2/database.properties");
		
		prop.load(reader);
		
		String value1 = prop.getProperty("db.driver-classNmae");
		String value2 = prop.getProperty("db.url");
		String value3 = prop.getProperty("db.usernamee");
		String value4 = prop.getProperty("db.password");
		String value5 = prop.getProperty("file.upload.max-upload-size");
		String value6 = prop.getProperty("file.upload.save-directory");
				
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		System.out.println(value5);
		System.out.println(value6);
	}
}
