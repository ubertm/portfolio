import java.util.Scanner;

/**
 * This class continues to reading user temperatures and scales and converts to the opposite temperature scale until the user quits.
 * @author Michael Ubert
 */
public class tempConv_Easy
{
	
	private static int temp; // variable to store the user entered temperature
	private static String s; // variable to store the user entered string
	private static int i; // variable to ensure the user is entering a valid scale
	private static int j; // variable to continue running until the user quits
	
	/**
	 * This method will automatically be called when the class is run.
	 * @param args Command line arguments
	 */
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in); // Scanner to read input from the user
		
		do // do-while to continue looping the program until the user decides to quit
		{
			System.out.print("Please enter a temperature: "); // prompt the user for a starting temperature
			temp = input.nextInt(); // read the temperature from the user
		
			System.out.print("Please enter whether the temperature is in C or F: "); // prompt the user for a starting scale
			s = input.next(); // read the scale from the user
			s = s.toUpperCase(); // convert the user scale to upper case letters
			
			i = 1; // counter to run the while loop			
			while(i > 0) // run until the user enters C or F
			{
				if(s.equals("C")) // convert from Celsius to Fahrenheit
				{
					temperatureConversion.fahrenheit(temp);
					i = 0; // break out of the while loop
				} // end if
			
				else if(s.equals("F")) // convert from Fahrenheit to Celsius
				{
					temperatureConversion.celsius(temp);
					i = 0; // break out of the while loop
				} // end else if
				
				else // something other than C or F was entered by the user
				{
					System.out.print("Error. Please enter C for Celsius or F for Fahrenheit: ");
					s = input.next();
					s = s.toUpperCase();
				} // end else
			} // end while
			
			System.out.println("Do you wish to continure?"); // ask the user if they want to convert another temperature or quit
			System.out.print("Enter 0 to quit or 1 to convert another temperature: "); // prompt the user for their choice
			j = input.nextInt(); // read the user's choice
			while(j != 0 && j != 1) // run until the user enters 0 or 1
			{
				System.out.print("Error. Please enter either 0 to quit or 1 to continue converting temperatures: ");
				j = input.nextInt();
			} // end while
		} while(j == 1); // end do-while
		
		input.close();
	} // end main method
} // end tempConv_Easy class
