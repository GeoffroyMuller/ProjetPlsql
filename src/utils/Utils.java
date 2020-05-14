package utils;

import java.sql.Timestamp;

public class Utils {
	
	public static Timestamp convertirDate(String _date) {
		if(!_date.contains("-")) {
			_date = _date+"-00:00";
		}
		String dateHeur[] = _date.split("-");

		String jjmmyyyy[] = dateHeur[0].split("/");
		String hhmm[] = dateHeur[1].split(":");
		@SuppressWarnings("deprecation")
		Timestamp tsp = new Timestamp(
				Integer.valueOf(jjmmyyyy[2])-1900,
				Integer.valueOf(jjmmyyyy[1])-1,
				Integer.valueOf(jjmmyyyy[0]),
				Integer.valueOf(hhmm[0]),
				Integer.valueOf(hhmm[1]),
				00,
				00);
		return tsp;
	}
}
