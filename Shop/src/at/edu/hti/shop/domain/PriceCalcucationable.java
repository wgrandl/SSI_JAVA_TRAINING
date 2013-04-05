package at.edu.hti.shop.domain;

import java.util.List;

public interface PriceCalcucationable {

	public abstract double calculatePrice(List<OrderLine> lines);
	
}
