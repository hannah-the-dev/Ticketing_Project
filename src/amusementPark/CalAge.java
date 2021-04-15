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
		String bDay = TicketConstant.getGenerations(index);		// 2 digits so far
		
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
		
		cal.setTime(birthDayTemp);						// set the calendar
		cal.add(Calendar.YEAR, AgeChecker.ELDERLY.getAge());
		Date elderlyChecker = cal.getTime();			// date to be elderly.
		
		cal.setTime(birthDayTemp);						// reset the calendar
		cal.add(Calendar.YEAR, AgeChecker.CHILD.getAge());
		Date babyChecker = cal.getTime();				// date not to be baby.
		
		cal.setTime(birthDayTemp);						// reset the calendar
		cal.add(Calendar.YEAR, AgeChecker.ADOLESCENT.getAge());
		Date youthChecker = cal.getTime();				// date not to be youth.
		
		cal.setTime(birthDayTemp);						// reset the calendar
		cal.add(Calendar.YEAR, AgeChecker.INFANT.getAge());
		Date infantChecker = cal.getTime();				// date not to be infant.
		
		String ageGroup = "";
		if (today.after(elderlyChecker)) {				
			ageGroup = AgeGroup.valueOfLabel(AgeGroup.ELDERLY.getIndex()).name();
		} else if (today.before(infantChecker)) {			
			ageGroup = AgeGroup.valueOfLabel(AgeGroup.INFANT.getIndex()).name();// infant
		} else if (today.before(babyChecker)) {									// baby
			ageGroup = AgeGroup.valueOfLabel(AgeGroup.CHILD.getIndex()).name();
		} else if (today.before(youthChecker)) {								// youth
			ageGroup = AgeGroup.valueOfLabel(AgeGroup.ADOLESCENT.getIndex()).name();
		} else {
			ageGroup = AgeGroup.valueOfLabel(AgeGroup.ADULT.getIndex()).name();
		}
		return ageGroup;
	}
}
