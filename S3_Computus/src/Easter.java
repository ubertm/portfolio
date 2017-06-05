import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This class contains methods to get Easter date and month and day
 * @author Michael Ubert
 */
public class Easter 
{
	private Date date; // variable for constructor and methods
	private Calendar cal = Calendar.getInstance(); // variable to extract month and day
	
	/**
	 * Constructor for an Easter object for a given year.
	 * @param year The year Easter occurred.
	 */
	public Easter(int year)
	{
		date = getEasterDate(year);
	} // end constructor
	
	/**
	 * This method sets the date of Easter for a different year.
	 * @param year The year Easter occurred.
	 */
	public void setDate(int year)
	{
		date = getEasterDate(year);
	} // end setDate method
	
	/**
	 * This method gets the month of the year of Easter.
	 * @return The month on a 1-12 scale.
	 */
	public int getMonth()
	{
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return month + 1; // add 1 to month because Calendar.MONTH returns January as 0
	} // end getMonth method
	
	/**
	 * This method gets the day of the month of Easter.
	 * @return The day of the month.
	 */
	public int getDay()
	{
		cal.setTime(date);
		int day = cal.get(Calendar.DATE);
		return day;
	} // end getDay method
	
	@Override // overriding Object's toString method
	public String toString()
	{
		return String.format("%s %d", (this.getMonth() == 3 ? "March" : "April"), this.getDay());
	} // end toString method
	
	/**
	 * Meeus/Jones/Butcher Gregorian algorithm implemented from Wikipedia.
	 * @param year The year Easter occurred.
	 * @return The date of Easter.
	 */
	public static Date getEasterDate(int year) // Meeus/Jones/Butcher Gregorian algorithm implemented from Wikipedia
	{
		int a = year % 19;
		int b = year / 100;
		int c = year % 100;
		int d = b / 4;
		int e = b % 4;
		int f = (b + 8) / 25;
		int g = (b - f + 1) / 3;
		int h = (19 * a + b - d - g + 15) % 30;
		int i = c / 4;
		int k = c % 4;
		int l = (32 + 2 * e + 2 * i - h - k) % 7;
		int m = (a + 11 * h + 22 * l) / 451;
		int n = (h + l - 7 * m + 114) / 31;
		int p = (h + l - 7 * m + 114) % 31;
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.clear();
		calendar.set(year, n - 1, p + 1);
		return calendar.getTime();
	} // end getEasterDate method
} // end Easter class