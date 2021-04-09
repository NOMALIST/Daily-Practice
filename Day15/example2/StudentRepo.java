package example2;

public class StudentRepo implements Repo{


	private Student[] students = new Student[10];

	StudentRepo() {
		students[0] = new Student("학생01", 70, 50, 50);
		students[1] = new Student("학생02", 50, 70, 80);
		students[2] = new Student("학생03", 90, 90, 20);
		students[3] = new Student("학생04", 40, 80, 60);
		students[4] = new Student("학생05", 80, 90, 100);
		students[5] = new Student("학생06", 40, 20, 30);
		students[6] = new Student("학생07", 100, 100, 90);
		students[7] = new Student("학생08", 90, 80, 80);
		students[8] = new Student("학생09", 100, 100, 100);
		students[9] = new Student("학생10", 80, 70, 70);
	}

	@Override
	public Stats getStats() {
		return new StudentStats();
	}
	
	public Student[] getStudents() {
		return students;
	}
	
	private class StudentStats implements Stats{
		@Override
		public int total() {
			int total = 0;
			for(Student x : students) {
				total += x.getKor() + x.getEng() + x.getMath(); 
			}
			return total;
		}

		@Override
		public int average() {
			return this.total()/(3*students.length);
		}
	}

}

