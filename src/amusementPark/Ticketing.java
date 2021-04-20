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
		CalAge ages = new CalAge();
		CalAmount amount = new CalAmount();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		while (newSession == true) {
			savingList = new ArrayList<>();
			PrintsTickets print = new PrintsTickets(savingList);
			while (keep == true) {
				SaveData save = new SaveData();						 
				
				save.setTicketType(menu.ticketTime());		//DAYTIME OR NIGHTTIME
				
				do {											// if the date is after today,
					menu.inputID();								// returns 8 digits of birthday
					save.setBirthDay(ages.bDay());				
				} while(ages.todayChecker(save.getBirthDay()) == false) ;
				save.setAge(ages.ageChecks(save.getBirthDay(), SaveData.getToday()));
				
				save.setQuantity(menu.ticketQty());
				save.setDiscount(menu.inputDiscount());
				
				long totalAmount = amount.amount(
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
			
			// saving list with getter
			print.printsEnding();	//ending gets total amount
			WritesTickets write = new WritesTickets(savingList);
			write.writingSales();			
			keep = true;
			newSession = menu.askSession();
		}
	}
}
