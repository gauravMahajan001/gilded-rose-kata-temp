package com.gildedrose.service.impl;

import com.gildedrose.constant.ApplicationConstant;
import com.gildedrose.model.Item;
import com.gildedrose.service.CalculateSellin;
import com.gildedrose.service.ItemQuantity;
import com.gildedrose.service.ItemSellin;

public class CalculateSellinImpl implements CalculateSellin {

	private ItemSellin itemSellin;
	private ItemSpecificNameImpl itemSpecificName;
	private ItemQuantity itemQuantity;
	private CalculateQuantityImpl calculateQuantity;

	public CalculateSellinImpl(ItemSellin itemSellin, ItemSpecificNameImpl itemSpecificName, ItemQuantity itemQuantity,
			CalculateQuantityImpl calculateQuantity) {
		this.itemSellin = itemSellin;
		this.itemSpecificName = itemSpecificName;
		this.itemQuantity = itemQuantity;
		this.calculateQuantity = calculateQuantity;

	}

	@Override
	public void itemSellinLessThanZero(Item item) {

		if (itemSellin.hasItemSellinNegative(item)) {

			if (itemSpecificName.isSpecficItemNameNotMatchWithGivenName(item, ApplicationConstant.ITEM_NAME_STR)) {

				calculateQuantity.itemNameNotMatchThanDecreaseQuantity(item);
			} else {
				itemQuantity.quantityLessThan50IncreaseQuantity(item);
			}
		}
	}

}
