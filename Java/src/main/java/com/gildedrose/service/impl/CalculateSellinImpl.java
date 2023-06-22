package com.gildedrose.service.impl;

import com.gildedrose.model.Item;
import com.gildedrose.service.CalculateQuantity;
import com.gildedrose.service.CalculateSellin;
import com.gildedrose.service.ItemQuantity;
import com.gildedrose.service.ItemSellin;
import com.gildedrose.service.ItemSpecificName;

public class CalculateSellinImpl implements CalculateSellin {

	private ItemSellin itemSellin;
	private ItemSpecificName itemSpecificName;
	private ItemQuantity itemQuantity;
	private CalculateQuantity calculateQuantity;

	public CalculateSellinImpl(ItemSellin itemSellin, ItemSpecificName itemSpecificName, ItemQuantity itemQuantity,
			CalculateQuantity calculateQuantity) {
		this.itemSellin = itemSellin;
		this.itemSpecificName = itemSpecificName;
		this.itemQuantity = itemQuantity;
		this.calculateQuantity = calculateQuantity;

	}

	@Override
	public void itemSellinLessThanZero(Item item, String givenItemName, String itemName, String itemNameVal) {

		if (itemSellin.hasItemSellinNegative(item)) {

			if (itemSpecificName.isSpecficItemNameNotMatchWithGivenName(item, givenItemName)) {

				calculateQuantity.itemNameNotMatchThanDecreaseQuantity(item, itemName, itemNameVal);
			} else {
				itemQuantity.quantityLessThan50IncreaseQuantity(item);
			}
		}
	}
}
