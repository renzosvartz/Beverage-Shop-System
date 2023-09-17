/**
 *  @author Renzo Svartz
 */

package Data_Structures;

/**
 * This abstract class serves as a superclass for three beverage types and includes
 * relevant attributes including sizes, types, and prices.
 */
public abstract class Beverage 
{
	public enum SIZE {SMALL, MEDIUM, LARGE}
	public enum TYPE {COFFEE, ALCOHOLIC, SMOOTHIE}
	
	private String bevName;
	private TYPE type;
	private SIZE size;
	protected final double BASE_PRICE = 2;
	protected final double SMALL_PRICE = 2;
	protected final double MEDIUM_PRICE = 3;
	protected final double LARGE_PRICE = 4;
	
	/**
	 * Standard constructor for a Beverage class item
	 * @param bevName beverage name
	 * @param type beverage type
	 * @param size beverage size
	 */
	public Beverage(String bevName, TYPE type, SIZE size)
	{
		this.bevName = new String(bevName);
		this.type = type;
		this.size = size;
	}
	
	/**
	 * Copy constructor for a Beverage class object
	 * @param o2 object to copy
	 */
	public Beverage(Beverage o2)
	{
		this.bevName = new String(o2.bevName);
		this.type = o2.type;
		this.size = o2.size;
	}
	
	/**
	 * abstract method for calculating the price of each individual drink
	 * @return a double, the price of the drink
	 */
	public abstract double calcPrice();
	
	/**
	 * toString method used to print out the pertinent information about each drink
	 * @return a string, the information about the drink
	 */
	@Override
	public String toString()
	{
		return "Beverage Name: " + bevName + ", Type: " + type + ", Size: " + size + " ";
	}
	
	/**
	 * Method used to determine if an argument object is the same as the instance object
	 * @param o2 the object to compare to
	 * @return a boolean, whether the objects are the same
	 */
	public boolean equals(Beverage o2)
	{
		boolean status = false;
		
		if (this.bevName.equals(o2.bevName) && this.type.equals(o2.type) && this.size.equals(o2.size))
		{
			status = true;
		}
		
		return status;
	}
	
	/**
	 * Setter to set the beverage name
	 * @param bevName beverage name
	 */
	public void setBevName(String bevName)
	{
		this.bevName = new String(bevName);
	}
	
	/**
	 * Setter to set the type
	 * @param type drink type
	 */
	public void setType(TYPE type)
	{
		this.type = type;
	}
	
	/**
	 * Setter to set the size
	 * @param size drink size
	 */
	public void setSize(SIZE size)
	{
		this.size = size;
	}
	
	/**
	 * Getter to get beverage name
	 * @return a string, the beverage name
	 */
	public String getBevName()
	{
		return bevName;
	}
	
	/**
	 * Getter to get beverage type
	 * @return a type, the beverage type
	 */
	public TYPE getType()
	{
		return type;
	}
	
	/**
	 * Getter to get beverage size
	 * @return a size, the beverage size
	 */
	public SIZE getSize()
	{
		return size;
	}
	
	/**
	 * Getter to get base price
	 * @return a double, the base price
	 */
	public double getBasePrice() 
	{
		return BASE_PRICE;
	}
}
