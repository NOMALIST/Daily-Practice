package example3;

public class Reporter {

	private Chart chart;
	
	public Reporter(Chart chart) {
		this.chart = chart;
	}
	
	public void setChart(Chart chart) {
		this.chart = chart;
	}
	
	public void creatChart() {
		System.out.println(chart.getTitle());
		chart.draw();
	}
}
