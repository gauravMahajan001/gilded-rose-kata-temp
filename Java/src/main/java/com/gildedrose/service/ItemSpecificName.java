package com.gildedrose.service;

import com.gildedrose.model.Item;

public interface ItemSpecificName {
	
	public boolean isSpecficItemNamesNotMatch(Item item, String itemName, String itemNameVal);
		
	public  boolean isSpecficItemNameMatchWithGivenName(Item item, String itemName);
	
	public boolean isSpecficItemNameNotMatchWithGivenName(Item item, String itemName);

}
