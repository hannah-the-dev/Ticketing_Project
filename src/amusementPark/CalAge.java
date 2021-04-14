package amusementPark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalAge {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	public int age() throws ParseException {
//			eg. if id_num[6] == 1, birthday gets 19------ ...
		String birthDay = TicketingCVs.GENERATIONS[Integer.parseInt(TicketingCVs.ID_NUM[6]+"")];	
		
		for (int i = 0; i < 6; i++) {
			birthDay += TicketingCVs.ID_NUM[i];
		}
		
		int ageGroup = ageChecks(birthDay);
		return ageGroup;
	}
	
	public int ageChecks(String birthDay) throws ParseException {
		Date birthDayTemp = sdf.parse(birthDay);		// birthday in date format 
		Date today = cal.getTime();						// today
		
		cal.setTime(birthDayTemp);						// set the calendar
		cal.add(Calendar.YEAR, TicketingCVs.ELDERLY_CHECK);
		Date elderlyChecker = cal.getTime();			// date to be elderly.
		
		cal.setTime(birthDayTemp);						// reset the calendar
		cal.add(Calendar.YEAR, TicketingCVs.BABY_CHECK);
		Date babyChecker = cal.getTime();				// date not to be baby.
		
		cal.setTime(birthDayTemp);						// reset the calendar
		cal.add(Calendar.YEAR, TicketingCVs.YOUTH_CHECK);
		Date youthChecker = cal.getTime();				// date not to be youth.
		
		int ageGroup = 0;
		if (today.after(elderlyChecker)) {				
			ageGroup = TicketingCVs.AGE_ADULT;
		} else if (today.before(babyChecker)) {				// baby
			ageGroup = TicketingCVs.AGE_BABY;
		} else if (today.before(youthChecker)) {			// youth
			ageGroup = TicketingCVs.AGE_YOUTH;
		} else {
			ageGroup = TicketingCVs.AGE_ADULT;
		}
		return ageGroup;
	}
}
