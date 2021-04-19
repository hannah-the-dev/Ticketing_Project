package amusementPark;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Ticketing {
	public static ArrayList<Object> savingEach;
	public static ArrayList<ArrayList<Object>> savingList;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		savingList = new ArrayList<ArrayList<Object>>();
		boolean keep = true;
		boolean newSession = true;
		Menu menu = new Menu();
		PrintsTickets print = new PrintsTickets(savingList);
		CalAge ages = new CalAge();
		CalAmount amount = new CalAmount();
		SaveData save = new SaveData();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		while (newSession == true) {
			while (keep == true) {
	//			ticket type > id > qty > discount > print price >continue? >>> close > print receipt > terminate? > report
				
				save.setTicketType(menu.ticketTime());		//DAYTIME OR NIGHTTIME
				
				do {											// if the date is after today,
					menu.inputID();								// returns 8 digits of birthday
					save.setBirthDay(ages.bDay());				//
				} while(ages.todayChecker(save.getBirthDay()) == false) ;
				save.setAge(ages.ageChecks(save.getBirthDay(), SaveData.getToday()));
				
				save.setQuantity(menu.ticketQty());
				save.setDiscount(menu.inputDiscount());
				
				long totalAmount = amount.amount(save.getAge(), save.getTicketType(), save.getQuantity(), save.getDiscount());
				save.setAmount(totalAmount);
				print.printsAmount(totalAmount);
	
				
				save.setDate(sdf.format(Calendar.getInstance().getTime()));
				savingEach = save.getAny();
				savingList.add(savingEach);
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
