/**
 *  @author Renzo Svartz
 */

package Data_Structures;

import Data_Structures.Beverage.SIZE;
import Data_Structures.Beverage.TYPE;

/**
 * This class serves as a subclass of the Beverage superclass to represent an Alcohol object with
 * relevant attributes including weekend availability and prices.
 */
public class Alcohol extends Beverage
{
	private boolean WeekendAvailability = false;
	private final double WEEKENDCHARGE = .60;
	
	/**
	 * Standard constructor to build an Alcohol object
	 * @param name the name of the drink
	 * @param size the size of the drink
	 * @param WeekendAvailability whether the drink is available on the weekend
	 */
	public Alcohol(String name, SIZE size, boolean WeekendAvailability)
	{
		super(name, TYPE.ALCOHOLIC, size);
		this.WeekendAvailability = WeekendAvailability;
	}
	
	/**
	 * toString method used to print out the pertinent information about each drink
	 * @return a string, the information about the drink
	 */
	@Override
	public String toString()
	{
		return super.toString() + "Weekend Availability: " + (WeekendAvailability ? "Yes" : "No") + ", Price: " + calcPrice();
	}
	
	/**
	 * Method for calculating the price of each individual drink
	 * @return a double, the price of the drink
	 */
	@Override
	public double calcPrice()
	{
		double sum = 0;
		
		switch (this.getSize())
		{
			case SMALL: sum += this.SMALL_PRICE;
						break;
			case MEDIUM: sum += this.MEDIUM_PRICE;
						break;
			case LARGE: sum += this.LARGE_PRICE;
						break;
		}
		
		if (WeekendAvailability)
		{
			sum += WEEKENDCHARGE;
		}
		
		return sum;
	}
	
	/**
	 * Method used to determine if an argument object is the same as the instance object
	 * @param o2 the object to compare to
	 * @return a boolean, whether the objects are the same
	 */
	public boolean equals(Alcohol o2)
	{
		boolean status = false;
		
		if (!super.equals(o2))
		{
			return status;
		}
		else if (this.WeekendAvailability == o2.WeekendAvailability)
		{
				status = true;
		}
		
		return status;
	}
	
	/**
	 * Setter to set whether the drink is available on the weekend
	 * @param WeekendAvailability whether the drink is available on the weekend
	 */
	public void setWeekendAvailability(boolean WeekendAvailability)
	{
		this.WeekendAvailability = WeekendAvailability;
	}

	/**
	 * Getter to get whether the drink is available on the weekend
	 * @return a boolean, whether the drink is available on the weekend
	 */
	public boolean getWeekendAvailability()
	{
		return WeekendAvailability;
	}
}
