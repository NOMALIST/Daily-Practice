package example2;

public class Score implements Comparable<Score>{

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int average;
	
	public Score() {}

	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total/3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}
	
	@Override
	public int compareTo(Score other) {
		return this.total - other.total;
	}
	
	@Override
	public String toString() {
		String toString = "[" + this.name + ", " + this.total + ", " + this.average + "]";
		return toString;
	}
	
	
	
}