package amusementPark;

public class TicketConstant {
	private String fileName = "TicketSales.csv";
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private String dirName = System.getProperty("user.home");
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
}

enum WritingTitle {
	DATE(0, "일자"), 
	TICKET_TYPE(1, "권종"), 
	AGE(2, "연령"), 
	QUANTITY(3, "수량"), 
	AMOUNT(4, "매출"), 
	DISCOUNT(5, "우대사항");
	
	public final int order;
	public final String receipt;
	WritingTitle(int order, String receipt) {
		this.order = order;
		this.receipt = receipt;
		// TODO Auto-generated constructor stub
	}

	public static String KorOfVal(String input) {
		for (WritingTitle x : values()) {
			if (x == WritingTitle.valueOf(input)) {
				return x.receipt;
			}
		}
		return null;
	}
}

enum TicketType {
	DAYTIME(1, "주간권"), NIGHTTIME(2, "야간권");
	public final int menu;
	public final String receipt;
	TicketType(int menu, String receipt) {
		this.menu = menu;
		this.receipt = receipt;
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

	public static String KorOfVal(String input) {
		for (TicketType x : values()) {
			if (x == TicketType.valueOf(input)) {
				return x.receipt;
			}
		}
		return null;
	}
}

enum Discount {
	NONE(1, 0.00f, "*우대 적용 없음"), CHALLENGED(2, 0.40f, "*장애인 우대 적용"), 
	NAT_MERIT(3, 0.50f, "*국가 유공자 우대 적용"), MULTI_CHILD(4, 0.20f, "*다자녀 우대 적용"), 
	PREGNANCY(5, 0.15f, "*임산부 우대 적용");
	public final int menu;
	public final float rate;
	public final String receipt;
	
	Discount(int menu, float rate, String receipt) {
		this.menu = menu;
		this.rate = rate;
		this.receipt = receipt;
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
		return age;
	}
	
	public static String KorOfVal(String input) {
		for (Discount x : values()) {
			if (x == Discount.valueOf(input)) {
				return x.receipt;
			}
		}
		return null;
	}
}

enum QtyMinMax {
	MAX(10), MIN(1);
	public final int qty;
	QtyMinMax(int qty) {
		this.qty = qty;
	}
}
	
enum ASL {      // can use it for statistics
	C19_MALE(9, 18, false), C19_FEMALE(0, 18, true),
	C20_MALE(1, 19, false), C20_FEMALE(2, 19, true),
	C21_MALE (3, 20, false), C21_FEMALE(4, 20, true),
	C20_MALE_FOREIGN(5, 19, false), C20_FEMALE_FOREIGN(6, 19, true),
	C21_MALE_FOREIGN(7, 20, false), C21_FEMALE_FOREIGN(8, 20, true);
	
	public final int seventhDigit;
	public final int yearStart;
	public final boolean female;		// if false, pregancy dc n/a
	ASL(int seventhDigit, int yearStart, boolean female) {
		this.seventhDigit = seventhDigit;
		this.yearStart = yearStart;
		this.female = female;
	}

	public static String yearOfBirth(int seventh) {
		for (ASL x : values()) {
	    	if (x.seventhDigit == seventh) {
	        	return x.yearStart+"";
	        }
	    }
	    return (String) null;
	}
	
	public static ASL valueOfLabel(int input) {
		for (ASL x : values()) {
	    	if (x.seventhDigit == input) {
	        	return x;
	        }
	    }
	    return null;
	}
}

enum AgeGroup {
//	ADULT, ADOLESCENT, CHILD, ELDERLY, INFANT;
	ADULT(64, 56000, 46000,"성인"), ADOLESCENT(18,47000,40000,"청소년"), 
	CHILD(12, 44000, 37000, "어린이"), ELDERLY(999, 44000, 37000,"노인"), 
	INFANT(2,0,0,"유아");
	public final int maxAge, dayPrice, nightPrice;
	public final String receipt;
	AgeGroup(int maxAge, int dayPrice, int nightPrice, String receipt){
		this.maxAge = maxAge;
		this.dayPrice = dayPrice;
		this.nightPrice = nightPrice;
		this.receipt = receipt;
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
				return x.receipt;
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
	
	public static AgeGroup getAgeGroup(AgeGroup age) {
		// TODO Auto-generated method stub
		return age;
	}
}

enum Session {
	NEW(1, true), CLOSE(2, false);
	public final int menu;
	public final boolean bool;
	Session(int menu, boolean bool) {
		this.menu = menu;
		this.bool = bool;
	}

	public static boolean boolOfLabel(int input) {
		boolean bool = true;
		for (Session x : values()) {
	    	if (x.menu == input) {
	    		bool = x.bool;
	        	if (bool == true) {
	        		System.out.println("Starting new session......");
	        	}
	        	break;
	        } else {  
	    		bool = false;
	    		System.out.println("Closing program......");
	    		break;
	        }
	    }
		return bool;
	}
}