package example1;

import java.util.ArrayList;

public class StudentService {

	StudentRepository repo = new StudentRepository();
	
	public ArrayList<Student> getAllStudentList() {
		
		ArrayList<Student> students = repo.getAllStudent();
		
		return students;
	}
	
	public Student findStudentByName(String name) {
		
		Student student = repo.getStudentByName(name);
						
		return student;
	}
	
	public void addNewStudent(Student student) {
		
		repo.insertStudent(student);
		
	}
	
	public void deleteStudentByName(String name) {
		
		repo.deletStudentByName(name);
	}
	
	public ArrayList<Student> getSortedStudentList() {
		
		ArrayList<Student> students = repo.getAllStudent();
		
		students.sort((o1, o2) -> o2.getTotal() - o1.getTotal());
		
		return students;
	}
	
	public void saveAllStudentData() {
		repo.saveData();
	}
	
	
	
}
