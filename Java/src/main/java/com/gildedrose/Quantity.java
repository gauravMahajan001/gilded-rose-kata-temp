package com.gildedrose;

import com.gildedrose.model.Item;

public class Quantity {
	
	public void  increase(Item item) {
		item.quality++;
	}
	
	public void decrease(Item item) {
		item.quality--;
	}
}
