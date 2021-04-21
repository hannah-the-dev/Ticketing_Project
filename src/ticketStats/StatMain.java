package ticketStats;

public class StatMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		From_DBTicketSales from = new From_DBTicketSales();
		DailySales daily = new DailySales(); 
		try {
			from.getFromDBSales();
			daily.calDailyAndDc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
