package com.gildedrose.service;

import com.gildedrose.model.Item;

public interface CalculateQuantity {
	
	public void itemQuantityLess50(Item item);
	public void itemNameNotMatchThanDecreaseQuantity(Item item);
	public void quantityPositiveAndItemNameNotMatchDecreaseQuantity(Item item, String name);
}
