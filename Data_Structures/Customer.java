/**
 *  @author Renzo Svartz
 */

package Data_Structures;

/**
 * This class represents a customer to whom an Order belongs to, and includes fields for
 * their name and age
 */
public class Customer 
{
	private String customerName;
	private int customerAge;
	
	/**
	 * Standard constructor to build a Customer object
	 * @param customerName customer name
	 * @param customerAge customer age
	 */
	public Customer(String customerName, int customerAge)
	{
		this.customerName = new String(customerName);
		this.customerAge = customerAge;
	}
	
	/**
	 * Copy constructor
	 * @param o2 object to copy
	 */
	public Customer(Customer o2)
	{
		this.customerName = new String(o2.customerName);
		this.customerAge = o2.customerAge;
	}
	
	/**
	 * Setter method to set the customers name
	 * @param customerName the customer name
	 */
	public void setName(String customerName)
	{
		this.customerName = new String(customerName);
	}

	/**
	 * Setter method to set the customers age
	 * @param customerAge the customer age
	 */
	public void setAge(int customerAge)
	{
		this.customerAge = customerAge;
	}
	
	/**
	 * Getter method to get the customers name
	 * @return a string, the customers name
	 */
	public String getName()
	{
		return customerName;
	}
	
	/**
	 * Getter method to get the customers age
	 * @return an int, the customers age
	 */
	public int getAge()
	{
		return customerAge;
	}
	
	/**
	 * toString method used to print out the pertinent information about the customer
	 * @return a string, information about the customer
	 */
	@Override
	public String toString()
	{
		return "Customer Name: " + customerName + ", Customer Age: " + customerAge;
	}
}
