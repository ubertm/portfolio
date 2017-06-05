/**
 * This class calculates the number of times Easter will occur on a date in the 5,700,000 year cycle.
 * @author Michael Ubert
 */
public class computusMedium
{
	private static int[] easterDate = new int[35]; // array to count the number of times Easter falls on a given day
	private static Easter e = new Easter(0); // create new Easter object
	
	/**
	 * This method is automatically called when the class in run.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args)
	{
		for(int i = 0; i <= 5700000; i++) // for loop to iterate through all 5,700,000 years of the cycle
		{
			int month = e.getMonth(); // extract the month from the date
			int day = e.getDay(); // extract the day from the date
			switch(day) // switch statement for the day of the month Easter falls on
			{ // days 1-21 can only be April, days 26-31 can only be March, days 22-25 can be either
				case 1:
					easterDate[10] += 1;
					break;
				case 2:
					easterDate[11] += 1;
					break;
				case 3:
					easterDate[12] += 1;
					break;
				case 4:
					easterDate[13] += 1;
					break;
				case 5:
					easterDate[14] += 1;
					break;
				case 6:
					easterDate[15] += 1;
					break;
				case 7:
					easterDate[16] += 1;
					break;
				case 8: 
					easterDate[17] += 1;
					break;
				case 9:
					easterDate[18] += 1;
					break;
				case 10:
					easterDate[19] += 1;
					break;
				case 11:
					easterDate[20] += 1;
					break;
				case 12:
					easterDate[21] += 1;
					break;
				case 13:
					easterDate[22] += 1;
					break;
				case 14:
					easterDate[23] += 1;
					break;
				case 15:
					easterDate[24] += 1;
					break;
				case 16:
					easterDate[25] += 1;
					break;
				case 17:
					easterDate[26] += 1;
					break;
				case 18:
					easterDate[27] += 1;
					break;
				case 19:
					easterDate[28] += 1;
					break;
				case 20:
					easterDate[29] += 1;
					break;
				case 21:
					easterDate[30] += 1;
					break;
				case 22:
					if(month == 3)
						easterDate[0] += 1;
					if(month == 4)
						easterDate[31] += 1;
					break;
				case 23:
					if(month == 3)
						easterDate[1] += 1;
					if(month == 4)
						easterDate[32] += 1;
					break;
				case 24:
					if(month == 3)
						easterDate[2] += 1;
					if(month == 4)
						easterDate[33] += 1;
					break;
				case 25:
					if(month == 3)
						easterDate[3] += 1;
					if(month == 4)
						easterDate[34] += 1;
					break;
				case 26:
					easterDate[4] += 1;
					break;
				case 27:
					easterDate[5] += 1;
					break;
				case 28:
					easterDate[6] += 1;
					break;
				case 29:
					easterDate[7] += 1;
					break;
				case 30:
					easterDate[8] += 1;
					break;
				case 31:
					easterDate[9] += 1;
					break;
			} // end switch
			e.setDate(i);
		} // end for
		
		for(int i = 0; i < 35; i++) // for loop to iterate through the array
		{
			if(i < 10) // March 22-31
			{
				System.out.print("March ");
				System.out.printf("%d - %d%n", i + 22, easterDate[i]); // print the date and the number of times Easter fell on that date
			} //end if
			else // April 1-25
			{
				System.out.print("April ");
				System.out.printf("%d - %d%n", i - 9, easterDate[i]); // print the date and the number of times Easter fell on that date
			} // end else
		} // end for
	} // end main method
} // end computusMedium class
