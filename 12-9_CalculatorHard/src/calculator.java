import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

/**
 * This class defines a calculator GUI and how to perform calculations.
 * @author Michael Ubert
 */
public class calculator extends JFrame
{
	private final JTextField calcDisplay; // text field for calculator display
	private static final String[] buttonValues = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"}; // calculator button names
	private final JPanel buttons; // panel to store the calculator buttons
	private final JButton[] calcButtons; // array to store the calculator buttons
	private double num1 = 0; // variable to store the value after math operations
	private double num2 = 0; // variable to store the value before math operations
	private String symbol = "="; // variable to know what math operation to perform
	private double result = 0; // variable to store the value from 1 math operation
	
	/**
	 * Constructor for a calculator GUI.
	 */
	public calculator()
	{
		super("Calculator");
		setLayout(new BorderLayout());
		
		// create the calculator display window
		calcDisplay = new JTextField(10);
		calcDisplay.setEditable(false);
		calcDisplay.setHorizontalAlignment(JTextField.RIGHT);
		add(calcDisplay, BorderLayout.CENTER);
		
		// create the calculator buttons and add them to the calculator
		calcButtons = new JButton[buttonValues.length];
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(4, 4, 5, 5));
		add(buttons, BorderLayout.SOUTH);
		for(int i = 0; i < buttonValues.length; i++)
		{
			calcButtons[i] = new JButton(buttonValues[i]);
			buttons.add(calcButtons[i]);
		} // end for
		
		// assign buttons handlers to the calculator buttons
		CalculatorHandler handler = new CalculatorHandler();
		for(int i = 0; i < buttonValues.length; i++)
		{
			calcButtons[i].addActionListener(handler);
		} // end for
	} // end constructor
	
	/**
	 * Inner class for button event handling.
	 * @author Michael Ubert
	 */
	private class CalculatorHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{			
			// determine what button was clicked
			if(event.getActionCommand() == "+")
			{
				symbol = "+";
				num2 = Double.parseDouble(calcDisplay.getText());
			} // end if
			else if(event.getActionCommand() == "-")
			{
				if(symbol == "=")
				{
					num1 = Double.parseDouble(calcDisplay.getText());
					calcDisplay.setText("");
					symbol = "-";
				} // end if
				else
				{
					symbol = "-";
					num2 = Double.parseDouble(calcDisplay.getText());
				} // end else
			} // end else if
			else if(event.getActionCommand() == "*")
			{
				if(symbol == "=")
				{
					num1 = Double.parseDouble(calcDisplay.getText());
					calcDisplay.setText("");
					symbol = "*";
				} // end if
				else
				{
					symbol = "*";
					num2 = Double.parseDouble(calcDisplay.getText());
				} // end else
			} // end else if
			else if(event.getActionCommand() == "/")
			{
				if(symbol == "=")
				{
					num1 = Double.parseDouble(calcDisplay.getText());
					calcDisplay.setText("");
					symbol = "/";
				} // end if
				else
				{
					symbol = "/";
					num2 = Double.parseDouble(calcDisplay.getText());
				} // end else
			} // end else if
			else if(event.getActionCommand() == "=")
			{
				num2 = Double.parseDouble(calcDisplay.getText());
			} // end else if
			else if(event.getActionCommand() == ".")
			{
				if(!calcDisplay.getText().contains(".")) // don't allow double decimal points
				{
					calcDisplay.setText(calcDisplay.getText() + event.getActionCommand());
				} // end if
			} // end else if
			else
			{
				calcDisplay.setText(calcDisplay.getText() + event.getActionCommand());
			} // end else
			
			// perform math operations after two numbers have been entered
			while(num2 != 0)
			{
				if(event.getActionCommand() == "=")
				{
					num1 = Calculate(num1, num2, symbol);
					calcDisplay.setText(Double.toString(num1));
					num1 = 0;
					num2 = 0;
					symbol = "=";
				} // end if
				else
				{
					num1 = Calculate(num1, num2, symbol);
					num2 = 0;
				} // end else
			} // end while
		} // end ActionPerformed method
	} // end CalculatorHandler class
	
	/**
	 * This method will perform a calculation depending on what buttons the user clicked.
	 * @param num1 the previously calculated number
	 * @param num2 the new number to be calculated with
	 * @param symbol the math symbol to determine what operation to compute
	 * @return the result of the calculation
	 */
	private double Calculate(double num1, double num2, String symbol)
	{		
		// calculate result of given math operation
		if(symbol == "+")
		{
			result = num1 + num2;
			calcDisplay.setText("");
		} // end if
		else if(symbol == "-")
		{
			result = num1 - num2;
			calcDisplay.setText("");
		} // end else if
		else if(symbol == "*")
		{
			result = num1 * num2;
			calcDisplay.setText("");
		} // end else if
		else
		{
			result = num1 / num2;
			calcDisplay.setText("");
		} // end else
		return result;
	} // end Calculate method
} // end calculator class