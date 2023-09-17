/**
 *  @author Renzo Svartz
 */

package Data_Structures;

import java.util.ArrayList;
import java.util.Collections;

import Data_Structures.Beverage.SIZE;
import Data_Structures.Beverage.TYPE;
import Data_Structures.Order.DAY;
import Interfaces.BevShopInterface;

/**
 * This class represents a BevShop object which has a Customer, Order object ArrayList, and several other pertinent attributes
 * related to running and operating the beverage shop
 */
public class BevShop implements BevShopInterface
{
	private int AlcDrinks = 0;
	private final int MAX_ORDER_FOR_ALCOHOL = 3;
	private final int MIN_AGE_FOR_ALCOHOL = 21;
	private ArrayList<Order> Orders = new ArrayList<Order>();
	private Order thisOrder;
	
	/**
	 * Method used to determine if the time the order was made at is valid
	 * @param time the time the order was made at
	 * @return a boolean, whether the time is valid or not
	 */
	public boolean validTime(int time)
	{
		if (time < BevShopInterface.MIN_TIME || time > BevShopInterface.MAX_TIME)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Method used to determine if the customer may order another alcoholic drink (up to a max of 3)
	 * @return a boolean, whether the customer may order another alcoholic drink or not
	 */
	public boolean eligibleForMore()
	{
		if (AlcDrinks == MAX_ORDER_FOR_ALCOHOL)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Method used to determine if the customer may order alcohol
	 * @param age the customers age
	 * @return a boolean, whether the customers age is valid or not
	 */
	public boolean validAge(int age)
	{
		if (age >= MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Method used to start a new order and add's it to the order list (record)
	 * @param time the order time
	 * @param day the order day
	 * @param customerName the customers name
	 * @param customerAge the customers age
	 */
	public void startNewOrder(int time, DAY day, String customerName, int customerAge)
	{
		thisOrder = new Order(time, day, customerName, customerAge);
		Orders.add(thisOrder);
	}
 
	/**
	 * Method used to add a coffee (object) to the order
	 * @param bevName Beverage name
	 * @param size Beverage size
	 * @param extraShot If the customer wants an extra shot
	 * @param extraSyrup If the customer wants extra syrup
	 */
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup)
	{
		thisOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	/**
	 * Method used to add an alcoholic drink (object) to the order
	 * @param bevName the name of the drink
	 * @param size the size of the drink
	 */
	public void processAlcoholOrder(String bevName, SIZE size)
	{
		thisOrder.addNewBeverage(bevName, size);
		AlcDrinks += 1;
	}
	
	/**
	 * Method used to add a smoothie (object) to the order 
	 * @param bevName the beverage name
	 * @param size beverage size
	 * @param numOfFruits How many fruits the customer wants
	 * @param addProtein Whether the customer wants protein
	 */
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein)
	{
		thisOrder.addNewBeverage(bevName, size, addProtein, numOfFruits);
	}

	/**
	 * Method used to find an order in the list of orders via order number
	 * @param orderNo the order number
	 * @return an int, the index of the order
	 */
	public int findOrder(int orderNo)
	{
		for (int i = 0; i < Orders.size(); i++)
		{
			if (Orders.get(i).getOrderNumber() == orderNo)
			{
				return i;
			}
		}

		return -1;
	}
	
	/**
	 * Method to calculate the total price of an order given it's order number
	 * @param orderNo the order number
	 * @return a double, the order total
	 */
	public double totalOrderPrice(int orderNo)
	{
		for (int i = 0; i < Orders.size(); i++)
		{
			if (Orders.get(i).getOrderNumber() == orderNo)
			{
				return Orders.get(i).calcOrderTotal();
			}
		}
		
		return -1;
	}
	
	/**
	 * Method to calculate the total of all orders
	 * @return a double, the total monthly sales
	 */
	public double totalMonthlySale()
	{
		double sum = 0;
		
		for (int i = 0; i < Orders.size(); i++)
		{
			sum += Orders.get(i).calcOrderTotal();
		}
		
		return sum;
	}
	
	/**
	 * Method to sort the orders using selection sort, increasing in order number
	 */
	public void sortOrders()
	{
		
		for (int i = 0; i < Orders.size(); i++)
		{
			int min = 90001;
			int index = i;
			
			for (int j = i; j < Orders.size(); j++)
			{	
				if (Orders.get(j).getOrderNumber() < min)
				{
					min = Orders.get(j).getOrderNumber();
					index = j;
				}
			}
			Collections.swap(Orders, i, index);
		}
		
	}
	
	/**
	 * Method to get an Order object listed at an index specified as the argument
	 * @param index the index at which the order is listed in the ArrayList
	 * @return an Order, the order at the specified index
	 */
	public Order getOrderAtIndex(int index)
	{
		return new Order(Orders.get(index));
	}
	
	/**
	 * toString method used to print out the pertinent information about each order
	 * @return a string, the information about each order
	 */
	@Override
	public String toString()
	{
		String orders = "Orders: ";
		
		for (int i = 0; i < Orders.size(); i++)
		{
			orders = orders.concat(Orders.get(i).toString() + ". ");
		}
		orders = orders.concat("Orders Total: " + totalMonthlySale());
		
		return orders;
	}

	/**
	 * Method used to get the current order
	 * @return an Order, a copy of the current order
	 */
	public Order getCurrentOrder() 
	{
		return new Order(thisOrder);
	}

	/**
	 * Method used to count the number of alcoholic drinks in the current order
	 * @return an int, the number of alcoholic drinks in the current order
	 */
	public int getNumOfAlcoholDrink() 
	{
		return thisOrder.findNumOfBeveType(TYPE.ALCOHOLIC);
	}

	/**
	 * Method used to get the number of total orders
	 * @return an int, the number of total order
	 */
	public int totalNumOfMonthlyOrders() 
	{
		return Orders.size();
	}

	/**
	 * Method to determine if a smoothie has ordered more than the maximum number of fruits
	 * @param i the number of fruits ordered
	 * @return a boolean, whether or not a smoothie has ordered more than the maximum number of fruits
	 */
	public boolean isMaxFruit(int i) 
	{
		if (i >= 6)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Method to get the maximum number of alcoholic drinks one can order
	 * @return an int, the maximum number of alcoholic drinks one can order
	 */
	public int getMaxOrderForAlcohol() 
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}

	/**
	 * Method to get the minimum age required to get an alcoholic drink
	 * @return an int, the minimum age required to get an alcoholic drink
	 */
	public int getMinAgeForAlcohol() 
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
}
