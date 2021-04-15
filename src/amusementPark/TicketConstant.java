package amusementPark;

import java.util.Arrays;
import java.util.List;

public class TicketConstant {
//	private final static String[] GENERATIONS = {"18","19","19","20","20","19","19","18"};
//										ID_NUM[6]: 	0	1	2	3	4	5	6	7	8	9	
//	public static String[] salesData = {"Date", "Ticket Type", "Age", "Quantity", "Amount", "Discount"};
	

	static int[] ID_NUM = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};		// calculates ages 
	
	public static int[] getID_NUM() {
		return ID_NUM;
	}
	public static void setID_NUM(int[] iD_Str) {
		ID_NUM = iD_Str;
	}
//	public static String getGenerations(int index) {
//		return GENERATIONS[index];
//	}
//	public static String[] getGenerations() {
//		return GENERATIONS;
//	}
}

enum WritingTitle {
	DATE(0), TICKET_TYPE(1), AGE(2), QUANTITY(3), AMOUNT(4), DISCOUNT(5);
	private int order;
	WritingTitle(int order) {
		this.order = order;
		// TODO Auto-generated constructor stub
	}
}


enum TicketType {
	DAYTIME(1), NIGHTTIME(2);
	private int menu;
	TicketType(int menu) {
		this.menu = menu;
	}
	public int getMenu() {
		return menu;
	}
	public static TicketType valueOfLabel(int label) {	//determine which time
		for (TicketType t : values()) {
	    	if (t.menu == label) {
	        	return t;
	        }
	    }
	    return null;
	}
}

enum Discount {
	NONE(1, 0.00f), CHALLENGED(2, 0.40f), 
	NAT_MERIT(3, 0.50f), MULTI_CHILD(4, 0.20f), PREGNENCY(5, 0.15f);
	private int menu;
	private float rate;
//	private boolean apply;
	
	Discount(int menu, float rate) {
		this.menu = menu;
		this.rate = rate;
//		this.apply = apply;
	}
	public int getMenu() {
		return menu;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;		//in case special discount 
	}
//	public boolean isApply() {
//		return apply;
//	}
//	public void setApply(boolean apply) {
//		this.apply = apply;
//	}
	// determine which dc option
	public static Discount valueOfLabel(int label) {
		for (Discount d : values()) {
	    	if (d.menu == label) {
	        	return d;
	        }
	    }
	    return null;
	}
}

enum QtyMinMax {
	MAX(10), MIN(1);
	private int qty;
	QtyMinMax(int qty) {
		this.setQty(qty);
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
	
enum ASL {      // can use it for statistics
	C19_MALE(9, 18, false), C19_FEMALE(0, 18, true),
	C20_MALE(1, 19, false), C20_FEMALE(2, 19, true),
	C21_MALE (3, 20, false), C21_FEMALE(4, 20, true),
	C20_MALE_FOREIGN(5, 19, false), C20_FEMALE_FOREIGN(6, 19, true),
	C21_MALE_FOREIGN(7, 20, false), C21_FEMALE_FOREIGN(8, 20, true);
	
	private int seventhDigit;
	private int yearStart;
	private boolean female;		// if false, pregancy dc n/a
	ASL(int seventhDigit, int yearStart, boolean female) {
		this.seventhDigit = seventhDigit;
		this.yearStart = yearStart;
		this.female = female;
	}
	public int getSeventhDigit() {
		return seventhDigit;
	}
	public int getYearStart() {
		return yearStart;
	}
	public boolean isFemale() {
		return female;
	}
	@SuppressWarnings("null")	// return the year born
	public static int valueOfLabel(int seventh) {
		for (ASL x : values()) {
	    	if (x.seventhDigit == seventh) {
	        	return x.getYearStart();
	        }
	    }
	    return (Integer) null;
	}
}

//enum AgeChecker {
//	INFANT(2),		// 0-2
//	CHILD(12),		// 3-12 if younger (inclusive)
//	ADOLESCENT(18),	// 13-18 if younger (inclusive)
//	ELDERLY(65);	// 65- if older	  (inclusive)
//	private int age;
//	AgeChecker(int age) {
//		this.setAge(age);
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
	
//	public static AgeChecker valueOfLabel(int label) {
//		for (AgeChecker a : values()) {
//	    	if (a.age == label) {
//	        	return a;
//	        }
//	    }
//	    return null;
//	}
//}
enum AgeGroup {
//	ADULT, ADOLESCENT, CHILD, ELDERLY, INFANT;
	ADULT(64, 56000, 46000), ADOLESCENT(18,47000,40000), 
	CHILD(12, 44000, 37000), ELDERLY(999, 44000, 37000), INFANT(2,0,0);
	private int maxAge, dayPrice, nightPrice;
	AgeGroup(int index, int dayPrice, int nightPrice){
		this.setIndex(index);
		this.setDaytime(dayPrice);
		this.setNighttime(nightPrice);
	}
	public int getIndex() {
		return maxAge;
	}
	public void setIndex(int index) {
		this.maxAge = index;
	}
	public static AgeGroup valueOfLabel(int input) {
		for (AgeGroup x : values()) {
	    	if (x.maxAge == input) {
	        	return x;
	        }
	    }
	    return null;
	}
	public int getDaytime() {
		return dayPrice;
	}
	public void setDaytime(int dayPrice) {
		this.dayPrice = dayPrice;
	}
	public int getNighttime() {
		return nightPrice;
	}
	public void setNighttime(int nightPrice) {
		this.nightPrice = nightPrice;
	}
}

//enum Ticket {
//	DAYTIME ("Daytime", Arrays.asList(56000,47000,44000,44000,0)),
//	NIGHTTIME ("Nighttime", Arrays.asList(46000,40000,37000,37000,0));
//	private String name;
//	private List<Integer> price;
//	Ticket(String string, List<Integer> price){
//		this.setPrice(price);
//	}
//	public List<Integer> getPrice() {
//		return price;
//	}
//	public int getOnePrice(int index) {
//		return price.get(index);
//	}
//	public void setPrice(List<Integer> price) {
//		this.price = price;
//	}
//
//}
