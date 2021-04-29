package ticketStats;

public class StatMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		From_DBTicketSales from = new From_DBTicketSales();
		DailySales daily = new DailySales(); 
		WritesStats write = new WritesStats(); 
		try {
			from.getFromDBSales();
			daily.calDailyAndDc();
			write.dailySales();
			write.ageSales();
			write.ageSalesByTime();
			write.discountSalesByTime();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
