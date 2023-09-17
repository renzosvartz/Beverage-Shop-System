/**
 *  @author Renzo Svartz
 */

package Data_Structures;

import java.util.ArrayList;
import java.util.Random;

import Data_Structures.Beverage.SIZE;
import Data_Structures.Beverage.TYPE;
import Interfaces.OrderInterface;

/**
 * This class represents an Order, and includes fields for
 * the order name, order time, order day, the customer to whom the order belongs to,
 * and the list of beverages they ordered.
 */
public class Order implements OrderInterface
{
	public enum DAY {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
	
	private int orderNumber;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> Bevs;
	
	/**
	 * Standard constructor to build an Order object
	 * @param orderTime
	 * @param orderDay
	 * @param customerName
	 * @param customerAge
	 */
	public Order(int orderTime, DAY orderDay, String customerName, int customerAge)
	{
		this.orderNumber = randomNumber();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = new Customer(customerName, customerAge);
		this.Bevs = new ArrayList<Beverage>();
	}
	
	/**
	 * Copy constructor to build an Order object
	 * @param o2 the object to copy
	 */
	public Order(Order o2)
	{
		this.orderNumber = o2.getOrderNumber();
		this.orderTime = o2.getOrderTime();
		this.orderDay = o2.getOrderDay();
		this.customer = new Customer(o2.getCustomer());
		this.Bevs = new ArrayList<Beverage>(o2.Bevs);
	}
	
	/**
	 * Method to determine if the order day is on a weekend
	 * @return a boolean, whether the order day is a weekend or not
	 */
	public boolean isWeekend()
	{
		if (this.orderDay == DAY.SATURDAY || this.orderDay == DAY.SUNDAY)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Method to get a beverage from the beverage list
	 * @param itemNo the item number
	 * @return a Beverage, the beverage with item number specified.
	 */
	public Beverage getBeverage(int itemNo)
	{
		return Bevs.get(itemNo);
	}
	
	/**
	 * Method to add a coffee to the beverage list
	 * @param bevName the beverage name
	 * @param size the beverage size
	 * @param extraShot whether the customer wants an extra shot
	 * @param extraSyrup whether the customer wants extra syrup
	 */
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup)
	{
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		Bevs.add(coffee);
	}
	
	/**
	 * Method to add an alcoholic drink to the beverage list
	 * @param name the name of the drink
	 * @param size the size of the drink
	 */
	public void addNewBeverage(String bevName, SIZE size)
	{
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
		Bevs.add(alcohol);
	}
	
	/**
	 * Method to add a smoothie to the beverage list
	 * @param bevName the beverage name
	 * @param size beverage size
	 * @param addProtein Whether the customer wants protein
	 * @param numOfFruits How many fruits the customer wants
	 */
	public void addNewBeverage(String bevName, SIZE size, boolean addProtein, int numOfFruits)
	{
		Smoothie smoothie = new Smoothie(bevName, size, addProtein, numOfFruits);
		Bevs.add(smoothie);
	}
	
	/**
	 * Method to calculate the total price for all of the drinks ordered
	 * @return a double, the order total
	 */
	public double calcOrderTotal()
	{
		double sum = 0;
		for (int i = 0; i < Bevs.size(); i++)
		{
			sum += Bevs.get(i).calcPrice();
		}
		return sum;
	}
	
	/**
	 * Method to determine the number of a unique beverage type for the whole order
	 * @param type the type of beverage specified
	 * @return an int, the number of beverages of the type specified that are in the order
	 */
	public int findNumOfBeveType(TYPE type)
	{
		int total = 0;
		for (int i = 0; i < Bevs.size(); i++)
		{
			if (Bevs.get(i).getType() == type)
			{
				total += 1;
			}
		}
		return total;
	}
	
	/**
	 * Method to get the total number of drinks for the entire order
	 * @return an int, the total number of drinks
	 */
	public int getTotalItems()
	{
		return Bevs.size();
	}
	
	/**
	 * Method used to generate a random number between 10000 and 90000, used as an order number
	 * @return an int, the randomly generated order number
	 */
	public int randomNumber() 
	{
		Random rand = new Random();
		int randInt = rand.nextInt(80000) + 10000;
		return randInt;
	}
	
	/**
	 * toString method used to print out the pertinent information about each of the drinks in the order and the total cost
	 * @return a string, information about each drink in the order and the total cost
	 */
	@Override
	public String toString()
	{
		String bevs = "";
		
		for (int i = 0; i < Bevs.size(); i++)
		{
			bevs = bevs.concat(Bevs.get(i).toString() + ". ");
		}
		bevs = bevs.concat("Order Total: " + calcOrderTotal());
		//System.out.println("Order Number: " + orderNumber + ", Order Time: " + orderTime + ", Order Day: " + orderDay + ", Customer Name: " + customer.getName() + ", Customer Age: " + customer.getAge() + ", Beverages: " + bevs);
		return "Order Number: " + orderNumber + ", Order Time: " + orderTime + ", Order Day: " + orderDay + ", Customer Name: " + customer.getName() + ", Customer Age: " + customer.getAge() + ", Beverages: " + bevs ;
	}
	
	/**
	 * Method used to compare the instance objects order number or another orders order number
	 * @param o2 the object to compare with
	 * @return an int, 1, -1, or 0, whether the order number of the instance object is greater, less than, or equal to, respectively, the argument object
	 */
	public int compareTo(Order o2)
	{
		if (this.orderNumber > o2.orderNumber)
		{
			return 1;
		}
		else if (this.orderNumber < o2.orderNumber)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Setter method to set the order number
	 * @param orderNumber the order number
	 */
	public void setOrderNumber(int orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	
	/**
	 * Setter method to set the order time
	 * @param orderTime the order time
	 */
	public void setOrderTime(int orderTime)
	{
		this.orderTime = orderTime;
	}
	
	/**
	 * Setter method to set the order day
	 * @param day the order day
	 */
	public void setOrderDay(DAY day)
	{
		this.orderDay = day;
	}
	
	/**
	 * Setter method to set the order's customer name and age
	 * @param customerName the customers name
	 * @param customerAge the customers age
	 */
	public void setCustomer(String customerName, int customerAge)
	{
		this.customer = new Customer(customerName, customerAge);
	}
	
	/**
	 * Getter method to get the order number
	 * @return an int, the order number
	 */
	public int getOrderNumber()
	{
		return orderNumber;
	}
	
	/**
	 * Getter method to get the order time
	 * @return an int, the order time
	 */
	public int getOrderTime()
	{
		return orderTime;
	}
	
	/**
	 * Getter method to get the order day
	 * @return a DAY, the order day
	 */
	public DAY getOrderDay()
	{
		return orderDay;
	}
	
	/**
	 * Getter method to get the customer who made this order
	 * @return a Customer, the customer who made this order
	 */
	public Customer getCustomer()
	{
		return new Customer(this.customer);
	}
}
