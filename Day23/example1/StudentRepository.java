package example1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentRepository {

	ArrayList<Student> students = new ArrayList<Student>();
	
	public StudentRepository() {
		
		loadData();
	}
	
	public void loadData() {
	
		try(FileReader fileReader = new FileReader("src/example1/data.txt");
				BufferedReader reader = new BufferedReader(fileReader);) {
			
			String text;
			
			while((text=reader.readLine()) != null) {
				String[] input = text.split(",");
				
				String name = input[0];
				int kor = Integer.parseInt(input[1]);
				int eng = Integer.parseInt(input[2]);
				int math = Integer.parseInt(input[3]);
				
				students.add(new Student(name, kor, eng, math));
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveData() {
		try(PrintWriter writer = new PrintWriter("src/example1/data.txt")) {
			
			for(Student s : students) {
				StringBuilder sb = new StringBuilder();
				
				sb.append(s.getName())
					.append(",")
					.append(s.getKor())
					.append(",")
					.append(s.getEng())
					.append(",")
					.append(s.getMath());
				
				String text = sb.toString();
				
				writer.println(text);
				}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> getAllStudent() {
		
		if(students.isEmpty()) return null;
		
		return students;
	}
	
	public void insertStudent(Student student) {
		
		students.add(student);
		
	}
	
	public void deletStudentByName(String name) {
		
		Student student = null;
		
		for(Student s : students) {
			if(s.getName().equals(name)) {
				student = s;
				break;
			}
		}
		
		if(student == null) {
			System.out.println("[오류] 학생을 찾을수 없습니다");
			return;
		} else {
			students.remove(student);
		}
		
		
	}
	
	public Student getStudentByName(String name) {
		
		Student student = null;
		for(Student s : students) {
			if(s.getName().equals(name)) {
				student = s;
				break;
			}
		}
		
		return student;
	}
	
}
