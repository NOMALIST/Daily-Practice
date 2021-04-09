package example2;

public class GameRepo implements Repo{

	private Game[] games = new Game[10];
	
	GameRepo() {
		games[0] = new Game("1일 경기",0);
		games[1] = new Game("2일 경기",1);
		games[2] = new Game("3일 경기",1);
		games[3] = new Game("4일 경기",0);
		games[4] = new Game("6일 경기",1);
		games[5] = new Game("7일 경기",1);
		games[6] = new Game("8일 경기",1);
		games[7] = new Game("10일 경기",0);
		games[8] = new Game("11일 경기",1);
		games[9] = new Game("12일 경기",0);
	}
	
	@Override
	public Stats getStats() {
		return new GameStats();
	}
	
	public Game[] getGames() {
		return games;
	}
	
	
	private class GameStats implements Stats {
		@Override
		public int total() {
			int total = 0;
			for(Game x : games) {
				total += x.getWin();
			}
			return total;
		}
		@Override
		public int average() {
			return this.total()*100/games.length;
		}
	}
	
	
}
