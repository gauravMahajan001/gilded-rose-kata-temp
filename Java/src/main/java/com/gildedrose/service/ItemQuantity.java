package com.gildedrose.service;

import com.gildedrose.model.Item;

public class ItemQuantity {
	
	public boolean hasPositiveQuantity(Item item) {
		return item.quality > 0;
	}

	public void decreaseQuantity(Item item) {
		item.quality--;
	}

	public boolean hasQuantityLessThan50(Item item) {
		return item.quality < 50;
	}

	public void increaseQuantity(Item item) {
		item.quality++;
	}
	
	public  void quantityLessThan50IncreaseQuantity(Item item) {
		if (hasQuantityLessThan50(item)) {
			item.quality++;
		}

	}

}
