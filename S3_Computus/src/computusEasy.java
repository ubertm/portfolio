import java.util.Scanner;

/**
 * This class calculates the date of Easter for a given year.
 * @author Michael Ubert
 */
public class computusEasy 
{	
	/**
	 * This method will automatically be called when the class is run.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); // Scanner to read input from the console
		
		System.out.print("Enter Year: "); // prompt user for year to calculate Easter date
		int year = input.nextInt(); // read and store the year from console
		Easter e = new Easter(year); // create new Easter object for given year
		
		System.out.print("Easter: "); 
		System.out.println(e + ", " + year);  // print out the date of Easter to the console
		
		input.close(); // close the Scanner
	} // end main method
} // end computusEasy class