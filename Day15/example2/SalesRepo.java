package example2;

public class SalesRepo implements Repo{

	Sales[] items = new Sales[9];
	
	SalesRepo() {
		items[0] = new Sales("item1", 1000000);
		items[1] = new Sales("item1", -5000000);
		items[2] = new Sales("item1", 3000000);
		items[3] = new Sales("item1", 500000);
		items[4] = new Sales("item1", 10000000);
		items[5] = new Sales("item1", -7000000);
		items[6] = new Sales("item1", -6000000);
		items[7] = new Sales("item1", -2000000);
		items[8] = new Sales("item1", 15000000);

	}
	
	@Override
	public Stats getStats() {
		return new SalesStats();
	}
	
	public Sales[] getItems() {
		return items;
	}
	
	
	private class SalesStats implements Stats {
		
		@Override
		public int total() {
			int total = 0;
			for(Sales x : items) {
				total += x.getProfit();
			}
			return total;
		}
		
		@Override
		public int average() {
			return this.total()/items.length;
		}
	}
}
