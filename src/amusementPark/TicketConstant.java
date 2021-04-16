package amusementPark;

public class TicketConstant {
	private String filePath = "C:\\Users\\kopo21\\Desktop\\TicketSales.csv";

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}


enum WritingTitle {
	DATE(0, "일자"), TICKET_TYPE(1, "권종"), AGE(2, "연령"), QUANTITY(3, "수량"), AMOUNT(4, "매출"), DISCOUNT(5, "우대사항");
	
	private int order;
	private String receipt;
	WritingTitle(int order, String receipt) {
		this.order = order;
		this.receipt = receipt;
		// TODO Auto-generated constructor stub
	}
	public int getOrder() {
		return order;
	}
	public String getReceipt() {
		return receipt;
	}
	public static String KorOfVal(String input) {
		for (WritingTitle x : values()) {
			if (x == WritingTitle.valueOf(input)) {
				return x.getReceipt();
			}
		}
		return null;
	}
}

enum TicketType {
	DAYTIME(1, "주간권"), NIGHTTIME(2, "야간권");
	private int menu;
	private String receipt;
	TicketType(int menu, String receipt) {
		this.menu = menu;
		this.receipt = receipt;
	}
	public int getMenu() {
		return menu;
	}
	public static TicketType valueOfLabel(int label) {	//determine which time
		TicketType returnValue = null;
		for (TicketType t : values()) {
	    	if (t.menu == label) {
	    		returnValue = t;
	        } 
	    }
		return returnValue;
	}
	public String getReceipt() {
		return receipt;
	}
	public static String KorOfVal(String input) {
		for (TicketType x : values()) {
			if (x == TicketType.valueOf(input)) {
				return x.getReceipt();
			}
		}
		return null;
	}
}

enum Discount {
	NONE(1, 0.00f, "*우대 적용 없음"), CHALLENGED(2, 0.40f, "*장애인 우대 적용"), 
	NAT_MERIT(3, 0.50f, "*국가 유공자 우대 적용"), MULTI_CHILD(4, 0.20f, "*다자녀 우대 적용"), 
	PREGNENCY(5, 0.15f, "*임산부 우대 적용");
	private int menu;
	private float rate;
	private String receipt;
//	private boolean apply;
	
	Discount(int menu, float rate, String receipt) {
		this.menu = menu;
		this.rate = rate;
		this.receipt = receipt;
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
	public String getReceipt() {
		return receipt;
	}
	// determine which dc option
	public static Discount valueOfLabel(int label) {
		Discount returnValue = null;
		for (Discount d : values()) {
	    	if (d.menu == label) {
	    		returnValue = d;
	        }
	    }
	    return returnValue;
	}
	public static Discount getDiscount(Discount age) {
		// TODO Auto-generated method stub
		return age;
	}
	public static String KorOfVal(String input) {
		for (Discount x : values()) {
			if (x == Discount.valueOf(input)) {
				return x.getReceipt();
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
	public static String yearOfBirth(int seventh) {
		for (ASL x : values()) {
	    	if (x.seventhDigit == seventh) {
	        	return x.getYearStart()+"";
	        }
	    }
	    return (String) null;
	}
}

enum AgeGroup {
//	ADULT, ADOLESCENT, CHILD, ELDERLY, INFANT;
	ADULT(64, 56000, 46000,"성인"), ADOLESCENT(18,47000,40000,"청소년"), 
	CHILD(12, 44000, 37000, "어린이"), ELDERLY(999, 44000, 37000,"노인"), 
	INFANT(2,0,0,"유아");
	private int maxAge, dayPrice, nightPrice;
	private String receipt;
	AgeGroup(int maxAge, int dayPrice, int nightPrice, String receipt){
		this.maxAge = maxAge;
		this.dayPrice = dayPrice;
		this.nightPrice = nightPrice;
		this.receipt = receipt;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public String getReceipt() {
		return receipt;
	}
	public static AgeGroup valueOfLabel(int input) {
		for (AgeGroup x : values()) {
	    	if (x.maxAge == input) {
	        	return x;
	        }
	    }
	    return null;
	}
	public static String KorOfVal(String input) {
		for (AgeGroup x : values()) {
			if (x == AgeGroup.valueOf(input)) {
				return x.getReceipt();
			}
		}
		return null;
	}
	@SuppressWarnings("null")
	public int getAnytime(TicketType ticketType) {
		if (ticketType == TicketType.DAYTIME) {
			return dayPrice;
		} else if (ticketType == TicketType.NIGHTTIME) {
			return nightPrice;
		} else return (Integer) null;
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
	public static AgeGroup getAgeGroup(AgeGroup age) {
		// TODO Auto-generated method stub
		return age;
	}
}

enum Session {
	NEW(1, true), CLOSE(2, false);
	private int menu;
	private boolean bool;
	Session(int menu, boolean bool) {
		this.menu = menu;
		this.bool = bool;
	}
	public int getMenu() {
		return menu;
	}
	public boolean isBool() {
		return bool;
	}
	public static boolean boolOfLabel(int input) {
		boolean bool = true;
		for (Session x : values()) {
	    	if (x.getMenu() == input) {
	        	bool = x.isBool();
	        	break;
	        } else {  
	    		bool = false;
	    		break;
	        }
	    }
		return bool;
	}
}