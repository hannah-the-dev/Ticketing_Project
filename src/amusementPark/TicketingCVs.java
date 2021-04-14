package amusementPark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// constant values for the ticketing project 
public class TicketingCVs {
//	ticket types
	public static final int DAYTIME = 1;
	public static final int NIGHTTIME = 2;
// discounting options
	public static final int NONE = 1;
	public static final int CHALLENGED = 2;
	public static final int NAT_MERIT = 3;
	public static final int MULTI_CHILD = 4;
	public static final int PREGNENT = 5;
//	max and min quantities
	public static final int MAX_QTY = 10;
	public static final int MIN_QTY = 1;
//	age/sex determines
	public static final char VERY_OLD_MALE = '9';
	public static final char VERY_OLD_FEMALE = '0';
	public static final char OLD_MALE = '1';
	public static final char OLD_FEMALE = '2';
	public static final char YOUNG_MALE = '3';
	public static final char YOUNG_FEMALE = '4';
	public static final char OLD_MALE_FOREIGN = '5';
	public static final char OLD_FEMALE_FOREIGN = '6';
	public static final char YOUNG_MALE_FOREIGN = '7';
	public static final char YOUNG_FEMALE_FOREIGN = '8';
	public static final String[] GENERATIONS = {"18","19","19","20","20","19","19","18"};
//									ID_NUM[6]: 	0	1	2	3	4	5	6	7	8	9	
	public static final int BABY_CHECK = 13;		// if younger (inclusive)
	public static final int YOUTH_CHECK = 19;		// if younger (inclusive)
	public static final int ELDERLY_CHECK = 65;		// if older	  (inclusive)
	public static final String CENTURY_20 = "19";
	public static final String CENTURY_21 = "20";
//	ageGroup value
	public static final int AGE_ADULT = 0;		
	public static final int AGE_YOUTH = 1;		
	public static final int AGE_BABY = 2;		
	public static final int AGE_ELDERLY = 3;	
	
	// ticket prices accroding to the ageGroup values
//	public static final List<Integer> DAY_TICKETS = List.of(56000, 47000, 44000, 44000);
//	public static final List<Integer> NIGHT_TICKETS = List.of(46000, 40000, 37000, 37000);

	public static final List<List<Integer>> TICKETS = 
			List.of(List.of(56000, 47000, 44000, 44000),
					List.of(46000, 40000, 37000, 37000));
	
//	public static final List<Integer> DAY_TICKETS = new ArrayList<>(Arrays.asList(56000, 47000, 44000, 44000));
//	public static final Map<String, Integer> NIGHT_TICKETS = new HashMap<String, Integer>();	 
//	static {{
//		NIGHT_TICKETS.put("adult", 	46000);
//		NIGHT_TICKETS.put("youth",	40000);
//		NIGHT_TICKETS.put("baby", 	37000);
//		NIGHT_TICKETS.put("elerly",	37000);
//	}};
	
	public static final List<Float> DISCOUNTS = List.of(0.00f,		0.40f,		0.50f,		0.20f,		0.15f);
													// 	NONE	CHALLENGED	NAT_MERIT	MULTI_CHILD		PREGNENT
	
//	public static final Map<String, Float> DISCOUNTS = new HashMap<String, Float>();	 
//	static {{
//		DISCOUNTS.put("NONE", 			1.00f);				// 100 %
//		DISCOUNTS.put("CHALLENGED", 	0.40f);				//  60 %
//		DISCOUNTS.put("NAT_MERIT",		0.50f);				//  50 %
//		DISCOUNTS.put("MULTI_CHILD",	0.20f);				//	80 %	
//		DISCOUNTS.put("PREGNENT", 		0.15f);				//  85 %
//	}};

	
//	public static int[] ID_NUM = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};		// calculates ages 
	public static char[] ID_NUM = new char[13];		// calculates ages 


//	public static int DISCOUNT_STATUS = 0;
}
