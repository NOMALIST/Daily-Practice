package example2;

public class Game {

	private String name;
	private int win;
	public Game(String name, int win) {
		super();
		this.name = name;
		this.win = win;
	}
	
	public String getName() {
		return name;
	}
	public int getWin() {
		return win;
	}
}
