package example3;

public class ReporterApp {

	public static void main(String[] args) {
		
		BasicChart chart1 = new BasicChart();
		chart1.setTitle("거래량 차트");
		
		LineChart chart2 = new LineChart();
		chart2.setTitle("120일 선");
		
		Reporter report1 = new Reporter(chart1);
		Reporter report2 = new Reporter(chart2);
		
		report1.creatChart();
		report2.creatChart();	
	}
}
