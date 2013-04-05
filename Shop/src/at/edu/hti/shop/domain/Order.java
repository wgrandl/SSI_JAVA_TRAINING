package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private static final long serialVersionUID = 1L;

	protected List<OrderLine> orderLines; //  = new ArrayList<>();
	
	private PriceCalcucationable priceCalcable = new StandardPriceCalculator();
	
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	public Order() {
		super();
		orderLines = new ArrayList<OrderLine>(100);
	}

	public int getNumberOfLines() {
		return orderLines.size();
	}
	
	public boolean add(OrderLine e) {

		if (null == e)
			return false;

		// return super.add(e);
		return orderLines.add(e);
	}

	public double calcPrize() {
		
		return priceCalcable.calculatePrice(orderLines);
		
		/*
		double sum = 0;
		for(OrderLine line : orderLines) {
			sum += line.getProduct().getPrize()* line.getAmount() ;
		}
		return sum;
		*/
	}

	public String toString() {
	
		//return super.toString() + " \n =>" +calcPrize();
		return orderLines.toString() + " \n =>" +calcPrize();
	}
	
	public boolean setAmount(String productName, int amount) {
		
		if( amount < 0)
		{
			System.out.println("amount " + amount + " invalid, discard");
			return false;
		}
		
		if( null == productName || productName.isEmpty()) {
			System.out.println("invalid productname given: " + productName );
		}
		
		OrderLine olFound = null;
		for(OrderLine ol : orderLines ) {
			if( ol.getProduct().getName().equalsIgnoreCase(productName)) {
				ol.setAmount(amount);
				olFound = ol;
				break;
			}
		}
		
		if( 0 == amount && null != olFound ) {
			orderLines.remove(olFound);
			System.out.println("removed line " + olFound + " since new amount was 0");
		}
		
		System.out.println("product " + productName + " not found in order for setting amount " + amount);
		
		return false;
	}
	
	
}
