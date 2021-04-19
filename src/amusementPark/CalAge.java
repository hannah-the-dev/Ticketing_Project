package amusementPark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalAge {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//	TicketConstant constant = new TicketConstant();
	public String bDay() throws ParseException {
//			eg. if id_num[6] == 1, birthday gets 19------ ...
		int index = SaveData.ID_NUM[6]; // if 1, 2 = 19 ; 3, 4 = 20 ...
		String bDay = ASL.yearOfBirth(index);		// 2 digits so far
		
		for (int i = 0; i < 6; i++) {
			bDay += SaveData.ID_NUM[i];				// 8 digits 
		}
		return bDay;
	}
		
//	public AgeGroup age(Date birthDay, Date today) throws ParseException {
//		
////		Date birthDay = ;
////		Date today = cal.getTime();						// today
////		
//		
//		AgeGroup ageGroup = ageChecks(birthDay, today);
//		
//		return ageGroup;
//	}
	
	public AgeGroup ageChecks(Date birthDay, Date today) {
//		Date birthDayTemp;
		AgeGroup ageGroup = null;
		try {
//			birthDayTemp = sdf.parse(birthDay);
//			Date today = cal.getTime();						// today
		
			Date infantChecker = ageChecker(birthDay, AgeGroup.INFANT);				// date not to be an infant
			Date childChecker = ageChecker(birthDay, AgeGroup.CHILD);				// date not to be a child
			Date adolescentChecker = ageChecker(birthDay, AgeGroup.ADOLESCENT);		// date not to be am adolescent
			Date adultChecker = ageChecker(birthDay, AgeGroup.ADULT);				// date not to be an adult(before elderly).
			
			if (today.before(infantChecker)) {			
				ageGroup = AgeGroup.INFANT;// infant
			} else if (today.before(childChecker)) {									
				ageGroup = AgeGroup.CHILD;
			} else if (today.before(adolescentChecker)) {								
				ageGroup = AgeGroup.ADOLESCENT;
			} else if (today.before(adultChecker)){
				ageGroup = AgeGroup.ADULT;
			} else {				
				ageGroup = AgeGroup.ELDERLY;
			}
		} catch (ParseException e) {
			System.out.println("Wrong ID format: impossible date of birth");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				// date not to be baby.
		return ageGroup;
		
	}
	
	public Date ageChecker(Date baseDate, AgeGroup ageGroup) throws ParseException {
		cal.setTime(baseDate);						// set the calendar
		cal.add(Calendar.YEAR, ageGroup.getMaxAge());
		Date ageChecker = cal.getTime();			// date to be elderly.
		return ageChecker;
	}
	
	public boolean todayChecker(Date birthDay) {
		if(SaveData.getToday().before(birthDay)) {
			System.out.println("Invalid ID. The day of birth is before today. Try again.");
			
			for (int x : SaveData.ID_NUM) {
				x = 0;
			} 
			return false;
		} else return true;
	}
}