package ogloszenia.baza;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Konwersje {
	
	public static LocalDateTime timestampToDateTime(Timestamp ts) {
		if(ts == null)
			return null;
		else
			return ts.toLocalDateTime();
	}

	public static Timestamp dateTimeToTimestamp(LocalDateTime d) {
		if(d == null)
			return null;
		else
			return Timestamp.valueOf(d);
	}

	public static LocalDateTime dateTimeOfString(String s) {
		if(s == null)
			return null;
		else
			return LocalDateTime.parse(s.replace(' ', 'T'));
	}

	public static String dateTimeToString(LocalDateTime d) {
		if(d == null)
			return null;
		else
			return d.toString();
	}

	public static LocalDate dateOfString(String s) {
		if(s == null)
			return null;
		else
			return LocalDate.parse(s);
	}

	public static String dateToString(LocalDate d) {
		if(d == null)
			return null;
		else
			return d.toString();
	}
}
