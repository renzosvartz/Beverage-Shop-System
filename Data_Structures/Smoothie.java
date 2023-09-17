/**
 *  @author Renzo Svartz
 */

package Data_Structures;

import Data_Structures.Beverage.SIZE;
import Data_Structures.Beverage.TYPE;

/**
 * This class serves as a subclass of the Beverage superclass to represent a Smoothie object with
 * relevant attributes including extra smoothie options and prices.
 */
public class Smoothie extends Beverage
{
	private boolean protein = false;
	private final double PROTEIN = 1.50;
	private int numFruits = 0;
	private final double FRUIT = .50;
	
	/**
	 * Standard constructor to build a Smoothie object
	 * @param name the beverage name
	 * @param size beverage size
	 * @param protein Whether the customer wants protein
	 * @param numFruits How many fruits the customer wants
	 */
	public Smoothie(String name, SIZE size, boolean protein, int numFruits)
	{
		super(name, TYPE.SMOOTHIE, size);
		this.protein = protein;
		this.numFruits = numFruits;
	}
	
	/**
	 * toString method used to print out the pertinent information about each drink
	 * @return a string, the information about the drink
	 */
	@Override
	public String toString()
	{
		return super.toString() + "Protein: " + (protein ? "Yes" : "No") + ", Fruits: " + numFruits + ", Price: " + calcPrice();
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
		
		if (protein)
		{
			sum += PROTEIN;
		}
		
		for (int i = 0; i < numFruits; i++)
		{
			sum += FRUIT;
		}
		
		return sum;
	}
	
	/**
	 * Method used to determine if an argument object is the same as the instance object
	 * @param o2 the object to compare to
	 * @return a boolean, whether the objects are the same
	 */
	public boolean equals(Smoothie o2)
	{
		boolean status = false;
		
		if (!super.equals(o2))
		{
			return status;
		}
		else if (this.protein == o2.protein && this.numFruits == o2.numFruits)
		{
				status = true;
		}
		
		return status;
	}
	
	/**
	 * Setter method to set whether the customer wants protein
	 * @param protein a boolean, whether the customer wants protein
	 */
	public void setProtein(boolean protein)
	{
		this.protein = protein;
	}
	
	/**
	 * Setter method to set how many fruits the customer wants
	 * @param numFruits an int, the number of fruits the customer wants
	 */
	public void setFruits(int numFruits)
	{
		this.numFruits = numFruits;
	}
	
	/**
	 * Getter to get whether the customer wants protein
	 * @return a boolean, whether the customer wants protein
	 */
	public boolean getProtein()
	{
		return protein;
	}
	
	/**
	 * Getter to get the number of fruits the customer wants
	 * @return an int, the number of fruits the customer wants
	 */
	public int getFruits()
	{
		return numFruits;
	}
}
