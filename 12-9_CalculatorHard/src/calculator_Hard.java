import javax.swing.JFrame;

/**
 * This class creates a new calculator that runs until the user closes it.
 * @author Michael Ubert
 */
public class calculator_Hard
{
	/**
	 * This method will be automatically called when the class is run.
	 * @param args Command line arguments
	 */
	public static void main(String[] args)
	{
		calculator calc = new calculator();
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calc.setSize(200, 200);
		calc.setVisible(true);
	} // end main method
} // end class calculator_Hard
