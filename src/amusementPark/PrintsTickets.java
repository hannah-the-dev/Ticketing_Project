package amusementPark;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PrintsTickets {
	ArrayList<Savings> savingList = new ArrayList<Savings>();
	Savings save = new Savings();

	public void printsAmount(int amount) {
		DecimalFormat df = new DecimalFormat("###,###"); 
		System.out.println("Total price is " + df.format(amount));
		System.out.println("Thank you.");
		System.out.println();
	}
	
	public void printsEnding() {
		System.out.println("Terminating Session. Thank you.");
		System.out.println();
		
//		call method printing receipts
		printsSummary();
	}
	
	public void printsSummary() {
		System.out.printf("================ KOPOWORLD ================\n");
		for (int i = 0; i < savingList.size(); i++) {
			System.out.printf(savingList.get(i).toString());
		}
		
		
	}
	public void writingSales() throws Exception	{
//		writing title -> change to csv writer instead of print
		for(WritingTitle x: WritingTitle.values()) {
			if (x.ordinal() == WritingTitle.values().length) {
				System.out.print(x.name());
				
			} else System.out.print(x.name()+",");
		}
//		writing contents
		Savings save;
		for(WritingTitle x: WritingTitle.values()) {
			System.out.println();
			String value = toGet(x.name().toLowerCase());
			System.out.println(value);
		}
	}

	public String toGet(String name) {
		String answer = "";
		if (name.equals("date")) {
			answer = save.getDate();
		} else if (name.equals("ticket_type")) {
			answer = save.getTicketType();
		} else if (name.equals("discount")) {
			answer = save.getDiscount();
		} else if (name.equals("age")) {
			answer = save.getAge()+"";
		} else if (name.equals("quantity")) {
			answer = save.getQuantity()+"";
		} else if (name.equals("amount")) {
			answer = save.getAmount()+"";
		}
		return answer;
	}
	// every purchase time, do this
	public void toList() {
		Savings save = new Savings();
		savingList.add(save);
	}
}
