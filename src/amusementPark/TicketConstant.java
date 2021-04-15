package amusementPark;

import java.util.Arrays;
import java.util.List;

public class TicketConstant {
	private final static String[] GENERATIONS = {"18","19","19","20","20","19","19","18"};
//										ID_NUM[6]: 	0	1	2	3	4	5	6	7	8	9	
	static int[] ID_NUM = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};		// calculates ages 
//	private static char[] ID_NUM = new char[13];		// calculates ages 
	public static String[] salesData = {"Date", "Ticket Type", "Age", "Quantity", "Amount", "Discount"};
	
//	public final static int DATE = 0;
//	public final static int TICKET_TYPE = 1;
//	public final static int AGE = 2;
//	public final static int QUANTITY = 3;
//	public final static int PRICE = 4;
//	public final static int DISCOUNT= 5;
//	

	
	public static int[] getID_NUM() {
		return ID_NUM;
	}
	public static void setID_NUM(int[] iD_Str) {
		ID_NUM = iD_Str;
	}
	public static String getGenerations(int index) {
		return GENERATIONS[index];
	}
	public static String[] getGenerations() {
		return GENERATIONS;
	}
}

enum WritingTitle {
	DATE, TICKET_TYPE, AGE, QUANTITY, AMOUNT, DISCOUNT;
}


enum TicketType {
	DAYTIME(1), NIGHTTIME(2);
	private int menu;
	TicketType(int menu) {
		this.setMenu(menu);
	}
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}
	public static TicketType valueOfLabel(int label) {
		for (TicketType t : values()) {
	    	if (t.menu == label) {
	        	return t;
	        }
	    }
	    return null;
	}

}

enum Discount {
	NONE(1, 0.00f, false), CHALLENGED(2, 0.40f, false), 
	NAT_MERIT(3, 0.50f, false), MULTI_CHILD(4, 0.20f, false), PREGNENCY(5, 0.15f, false);
	private int menu;
	private float rate;
	private boolean apply;
	
	Discount(int menu, float rate, boolean apply) {
		this.setMenu(menu);
		this.setRate(rate);
		this.setApply(apply);
	}
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public boolean isApply() {
		return apply;
	}
	public void setApply(boolean apply) {
		this.apply = apply;
	}

	public static Discount valueOfLabel(int label) {
		for (Discount d : values()) {
	    	if (d.menu == label) {
	    		d.setApply(true);
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
	
//enum ASL {      // can use it for statistics
//	VERY_OLD_MALE(9), VERY_OLD_FEMALE(0),
//	OLD_MALE(1), OLD_FEMALE(2),
//	YOUNG_MALE (3), YOUNG_FEMALE(4),
//	OLD_MALE_FOREIGN(5), OLD_FEMALE_FOREIGN(6),
//	YOUNG_MALE_FOREIGN(7), YOUNG_FEMALE_FOREIGN(8);
//	
//	private int seventhDigit;
//	ASL(int seventhDigit) {
//		this.setSeventhDigit(seventhDigit);
//	}
//	public int getSeventhDigit() {
//		return seventhDigit;
//	}
//	public void setSeventhDigit(int seventhDigit) {
//		this.seventhDigit = seventhDigit;
//	}
//}

enum AgeChecker {
	INFANT(2),		// 0-2
	CHILD(12),		// 3-12 if younger (inclusive)
	ADOLESCENT(18),	// 13-18 if younger (inclusive)
	ELDERLY(65);	// 65- if older	  (inclusive)
	private int age;
	AgeChecker(int age) {
		this.setAge(age);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
//	public static AgeChecker valueOfLabel(int label) {
//		for (AgeChecker a : values()) {
//	    	if (a.age == label) {
//	        	return a;
//	        }
//	    }
//	    return null;
//	}
}

enum Century {
	CENTURY_20("19"), CENTURY_21("20");
	private String yearStarts;
	Century(String yearStarts) {
		this.setYearStarts(yearStarts);
	}
	public String getYearStarts() {
		return yearStarts;
	}
	public void setYearStarts(String yearStarts) {
		this.yearStarts = yearStarts;
	}
}

enum AgeGroup {
//	ADULT, ADOLESCENT, CHILD, ELDERLY, INFANT;
	ADULT(0), ADOLESCENT(1), CHILD(2), ELDERLY(3), INFANT(4);
	private int index;
	AgeGroup(int index){
		this.setIndex(index);
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public static AgeGroup valueOfLabel(int input) {
		for (AgeGroup x : values()) {
	    	if (x.index == input) {
	        	return x;
	        }
	    }
	    return null;
	}
}

enum Ticket {
	DAYTIME ("Daytime", Arrays.asList(56000,47000,44000,44000,0)),
	NIGHTTIME ("Nighttime", Arrays.asList(46000,40000,37000,37000,0));
	private String name;
	private List<Integer> price;
	Ticket(String string, List<Integer> price){
		this.setPrice(price);
	}
	public List<Integer> getPrice() {
		return price;
	}
	public int getOnePrice(int index) {
		return price.get(index);
	}
	public void setPrice(List<Integer> price) {
		this.price = price;
	}

}

enum Day_Ticket {
	ADULT(56000), ADOLESCENT(47000), CHILD(44000), ELDERLY(44000), INFANT(0);
	private int price;
	Day_Ticket(int price){
		this.setPrice(price);
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
enum Night_Ticket {
	ADULT(46000), ADOLESCENT(40000), CHILD(37000), ELDERLY(37000), INFANT(0);
	private int price;
	Night_Ticket(int price){
	this.setPrice(price);
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

