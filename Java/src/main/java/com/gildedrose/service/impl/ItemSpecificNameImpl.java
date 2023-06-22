package com.gildedrose.service.impl;

import java.util.function.Predicate;

import com.gildedrose.model.Item;
import com.gildedrose.service.ItemSpecificName;

public class ItemSpecificNameImpl  implements ItemSpecificName{

	@Override
	public boolean isSpecficItemNamesNotMatch(Item item, String itemName, String itemNameVal) {

		return !item.name.equals(itemName) && !item.name.equals(itemNameVal);
	}

	@Override
	public boolean isSpecficItemNameMatchWithGivenName(Item item, String itemName) {

		return getPredicateName(itemName).test(item.name);
	}
	
	@Override
	public boolean isSpecficItemNameNotMatchWithGivenName(Item item, String itemName) {

		return getPredicateName(itemName).negate().test(item.name);
	}

	private Predicate<String> getPredicateName(String name) {

		return itemName -> itemName.equals(name);
	}
}
