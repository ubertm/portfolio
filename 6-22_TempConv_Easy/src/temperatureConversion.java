/**
 * This class contains methods to convert between Celsius and Fahrenheit and print the result to the console.
 * @author Michael Ubert
 */
public class temperatureConversion
{	
	/**
	 * This method converts from Fahrenheit to Celsius and prints it to the console.
	 * @param fahrenheit the Fahrenheit temperature to convert from
	 */
	public static void celsius(int fahrenheit)
	{
		int celsius = (int) ( 5.0 / 9.0 * (fahrenheit - 32));
		System.out.printf("%d degrees F is equal to %d degrees C.%n", fahrenheit, celsius);
	} // end celsius method
	
	/**
	 * This method converts from Celsius to Fahrenheit and prints it to the console.
	 * @param celsius the Celsius temperature to convert from
	 */
	public static void fahrenheit(int celsius)
	{
		int fahrenheit = (int) (9.0 / 5.0 * celsius + 32);
		System.out.printf("%d degrees C is equal to %d degrees F.%n", celsius, fahrenheit);
	} // end fahrenheit method
} // end temperatureConversion class