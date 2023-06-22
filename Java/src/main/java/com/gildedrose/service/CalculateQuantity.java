package com.gildedrose.service;

import com.gildedrose.model.Item;

public interface CalculateQuantity {
	
	public void itemQuantityLess50(Item item, String itemName, int compareNumber, int compareVal);
	public void itemNameNotMatchThanDecreaseQuantity(Item item, String givenItemName, String itemName);
	public void quantityPositiveAndItemNameNotMatchDecreaseQuantity(Item item, String name);
}
