package basic;


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

public class JodaTime {

	public static void main(String[] args) {

			DateTime nowUTC = new DateTime(DateTimeZone.UTC);
			int day = nowUTC.getDayOfMonth();
			int month = nowUTC.getMonthOfYear();
		
			int year = nowUTC.getYear();
			System.out.println(year + "-" + month + "-" + day);
			
	}

}
