package com.gildedrose.service;

import com.gildedrose.constant.ApplicationConstant;
import com.gildedrose.model.Item;

public class CalculateSellin {

	private ItemSellin itemSellin;
	private ItemSpecificName itemSpecificName;
	private ItemQuantity itemQuantity;
	private CalculateQuantity calculateQuantity;

	public CalculateSellin(ItemSellin itemSellin, ItemSpecificName itemSpecificName, ItemQuantity itemQuantity,
			CalculateQuantity calculateQuantity) {
		this.itemSellin = itemSellin;
		this.itemSpecificName = itemSpecificName;
		this.itemQuantity = itemQuantity;
		this.calculateQuantity = calculateQuantity;

	}

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
