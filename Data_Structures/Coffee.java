/**
 *  @author Renzo Svartz
 */

package Data_Structures;

import Data_Structures.Beverage.SIZE;
import Data_Structures.Beverage.TYPE;

/**
 * This class serves as a subclass of the Beverage superclass to represent a Coffee object with
 * relevant attributes including extra coffee options and prices.
 */
public class Coffee extends Beverage
{
	private boolean extraShot = false;
	private boolean extraSyrup = false;
	private final double EXTRA_SHOT_PRICE = .50;
	private final double EXTRA_SYRUP_PRICE = .50;
	
	/**
	 * Constructor to build a Coffee object
	 * @param name Beverage name
	 * @param size Beverage size
	 * @param extraShot If the customer wants an extra shot
	 * @param extraSyrup If the customer wants extra syrup
	 */
	public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup)
	{
		super(name, TYPE.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	/**
	 * toString method used to print out the pertinent information about each drink
	 * @return a string, the information about the drink
	 */
	@Override
	public String toString()
	{
		return super.toString() + "Extra Shot: " + (extraShot ? "Yes" : "No") + ", Extra Syrup: " + (extraSyrup ? "Yes" : "No") + ", Price: " + calcPrice();
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
		
		if (extraShot)
		{
			sum += EXTRA_SHOT_PRICE;
		}
		if (extraSyrup)
		{
			sum += EXTRA_SYRUP_PRICE;
		}
		
		return sum;
	}
	
	/**
	 * Method used to determine if an argument object is the same as the instance object
	 * @param o2 the object to compare to
	 * @return a boolean, whether the objects are the same
	 */
	public boolean equals(Coffee o2)
	{
		boolean status = false;
		
		if (!super.equals(o2))
		{
			return status;
		}
		else if (this.extraShot == o2.extraShot && this.extraSyrup == o2.extraSyrup)
		{
				status = true;
		}
		
		return status;
	}
	
	/**
	 * Setter to set whether the customer wants an extra shot
	 * @param extraShot whether the customer wants an extra shot
	 */
	public void setShot(boolean extraShot)
	{
		this.extraShot = extraShot;
	}
	
	/**
	 * Setter to set whether the customer wants extra syrup
	 * @param extraSyrup whether the customer wants extra syrup
	 */
	public void setSyrup(boolean extraSyrup)
	{
		this.extraSyrup = extraSyrup;
	}
	
	/**
	 * Getter to get whether the customer wants an extra shot
	 * @return a boolean, whether the customer wants an extra shot
	 */
	public boolean getShot()
	{
		return extraShot;
	}
	
	/**
	 * Getter to get whether the customer wants extra syrup
	 * @return a boolean, whether the customer wants extra syrup
	 */
	public boolean getSyrup()
	{
		return extraSyrup;
	}
}
