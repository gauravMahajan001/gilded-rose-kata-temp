package com.gildedrose.service;

import com.gildedrose.constant.ApplicationConstant;
import com.gildedrose.model.Item;

public class ItemSpecificName {
	
	public boolean isSpecficItemNamesNotMatch(Item item) {

		return !item.name.equals("Aged Brie") && !item.name.equals( ApplicationConstant.ITEM_NAME_VAL);
	}
	
	public  boolean isSpecficItemNameMatchWithGivenName(Item item, String itemName) {
		
		return item.name.equals(itemName);
	}
	
	public boolean isSpecficItemNameNotMatchWithGivenName(Item item, String itemName) {
		
		return !item.name.equals(itemName);
	}
}
