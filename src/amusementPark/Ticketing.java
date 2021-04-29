package amusementPark;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Ticketing {
	public static ArrayList<SaveData> savingList;
	
	public static void main(String[] args) throws Exception {
		boolean keep = true;
		boolean newSession = true;
		Menu menu = new Menu();
		Calculation calcul = new Calculation();
//		CalAmount amount = new CalAmount();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		while (newSession == true) {
			savingList = new ArrayList<>();
			PrintsTickets print = new PrintsTickets(savingList);
			while (keep == true) {
				SaveData save = new SaveData();						 
				
				save.setTicketType(menu.ticketTime());		//DAYTIME OR NIGHTTIME
				
				do {											// if the date is after today,
					menu.inputID();								// returns 8 digits of birthday
					save.setBirthDay(calcul.bDay());				
				} while(calcul.todayChecker(save.getBirthDay()) == false) ;
				save.setAge(calcul.ageChecks(save.getBirthDay(), SaveData.getToday()));
				
				save.setQuantity(menu.ticketQty());
				save.setDiscount(menu.inputDiscount());
				
				long totalAmount = calcul.amount(
						save.getAge(), 
						save.getTicketType(), 
						save.getQuantity(), 
						save.getDiscount());
				save.setAmount(totalAmount);
				print.printsAmount(totalAmount);
	
				
				save.setDate(sdf.format(Calendar.getInstance().getTime()));
				savingList.add(save);					
				keep = menu.keeping();		//call Menu.menu(), if menu returns false, break
			}
			
			print.printsEnding();	//ending gets total amount
//	if .csv files wanted, enable 2 lines below
//			WritesTickets write = new WritesTickets(savingList);
//			write.writingSales();			
			To_DBTicketSales io = new To_DBTicketSales(savingList);
			io.outToDBSales();
			keep = true;
			newSession = menu.askSession();
		}
	}
}
