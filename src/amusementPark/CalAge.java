package amusementPark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalAge {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//	TicketConstant constant = new TicketConstant();
	public String age() throws ParseException {
//			eg. if id_num[6] == 1, birthday gets 19------ ...
//		String birthDay = TicketConstant.getGenerations([Integer.parseInt(TicketingCVs.ID_NUM[6]);	
		int index = TicketConstant.ID_NUM[6]; // if 1, 2 = 19 ; 3, 4 = 20 ...
		String bDay = ASL.yearOfBirth(index);		// 2 digits so far
		
		for (int i = 0; i < 6; i++) {
			bDay += TicketConstant.ID_NUM[i];				// 8 digits 
		}
		
		String ageGroup = ageChecks(bDay);
//		Savings.savingStr[WritingTitle.AGE.ordinal()] = AgeGroup.valueOfLabel(ageGroup).name();
		Savings save = new Savings();
		save.setAge(ageGroup);
		return ageGroup;
	}
	
	public String ageChecks(String birthDay) throws ParseException {
		Date birthDayTemp = sdf.parse(birthDay);		// birthday in date format 
		Date today = cal.getTime();						// today
		
		
		Date infantChecker = ageChecker(birthDayTemp, AgeGroup.INFANT);				// date not to be baby.
		Date childChecker = ageChecker(birthDayTemp, AgeGroup.CHILD);				// date not to be baby.
		Date adolescentChecker = ageChecker(birthDayTemp, AgeGroup.ADOLESCENT);				// date not to be baby.
		Date adultChecker = ageChecker(birthDayTemp, AgeGroup.ADULT);				// date not to be baby.
		
		String ageGroup = "";
		if (today.before(infantChecker)) {			
			ageGroup = AgeGroup.INFANT.name();// infant
		} else if (today.before(childChecker)) {									// baby
			ageGroup = AgeGroup.CHILD.name();
		} else if (today.before(adolescentChecker)) {								// youth
			ageGroup = AgeGroup.ADOLESCENT.name();
		} else if (today.before(adultChecker)){
			ageGroup = AgeGroup.ADULT.name();
		} else {				
			ageGroup = AgeGroup.ELDERLY.name();
		}
		return ageGroup;
	}
	
	public Date ageChecker(Date baseDate, AgeGroup ageGroup) throws ParseException {
		cal.setTime(baseDate);						// set the calendar
		cal.add(Calendar.YEAR, ageGroup.getMaxAge());
		Date ageChecker = cal.getTime();			// date to be elderly.
		return ageChecker;
	}
}
