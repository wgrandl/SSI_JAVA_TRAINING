package at.edu.hti.shop;

import java.util.List;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.OrderSplitAble;
import at.edu.hti.shop.domain.Product;

public class App {
	public static void main(String[] args) {

		final String product1 = "Äpfel";
		final String product2 = "Birnen";
		
		OrderSplitAble shopOrder = new OrderSplitAble();

		OrderLine line1 = new OrderLine(new Product(1, product1, 1.2, 5, 2.0, "OBST"), 4);
		OrderLine line2 = new OrderLine(new Product(2, product2, 1.5, 4, 3.0, "OBST"), 2);

		OrderLine line3 = new OrderLine(new Product(3, "Pfirsich", 2.2, 6, 3.5, "OBST"), 5);
		OrderLine line4 = new OrderLine(new Product(4, "Kiwi", 3.5, 7, 4, "OBST_EXOTISCH"), 6);

		shopOrder.add(line1);
		shopOrder.add(line2);
		System.out.println(shopOrder.getNumberOfLines());
		System.out.println(shopOrder);

		shopOrder.setAmount(product1, 8);

		System.out.println(shopOrder.getNumberOfLines());
		System.out.println(shopOrder);

		// line is removed if quantity is set to 0!
		// shopOrder.setAmount(product2, 0);

		System.out.println(shopOrder.getNumberOfLines());
		System.out.println(shopOrder);

		shopOrder.add(line3);
		shopOrder.add(line4);
		
		//                                                                  max. weight / product group / del. time in days
		List<List<OrderLine>> linesGrouped = shopOrder.getOrderLinesGrouped(4, "OBST", 6);
		// List<List<OrderLine>> linesGrouped = shopOrder.getOrderLinesGrouped(null, "OBST", null);
		
		for( List<OrderLine> olList : linesGrouped ) {
			System.out.println("NEW LIST: ");
			for( OrderLine ol : olList ) {
				System.out.println("  ITEM: " + ol );
			}
		}
		
		System.out.println("COMBINED AGAIN:");
		for( OrderLine ol : shopOrder.combineOrderParts( linesGrouped)) {
			System.out.println("ITEM: " + ol );
		}
		

	}
}
