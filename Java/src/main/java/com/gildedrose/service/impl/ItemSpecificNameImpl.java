package com.gildedrose.service.impl;

import com.gildedrose.constant.ApplicationConstant;
import com.gildedrose.model.Item;
import com.gildedrose.service.ItemSpecificName;

public class ItemSpecificNameImpl  implements ItemSpecificName{
	
	@Override
	public boolean isSpecficItemNamesNotMatch(Item item) {

		return !item.name.equals("Aged Brie") && !item.name.equals( ApplicationConstant.ITEM_NAME_VAL);
	}
	
	@Override
	public  boolean isSpecficItemNameMatchWithGivenName(Item item, String itemName) {
		
		return item.name.equals(itemName);
	}
	
	@Override
	public boolean isSpecficItemNameNotMatchWithGivenName(Item item, String itemName) {
		
		return !item.name.equals(itemName);
	}
}
