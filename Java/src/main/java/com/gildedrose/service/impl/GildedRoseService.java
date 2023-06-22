package com.gildedrose.service.impl;

import com.gildedrose.constant.ApplicationConstant;
import com.gildedrose.model.Item;
import com.gildedrose.service.ItemSellin;

public class GildedRoseService {
	
	private Item[] items;
	private ItemSellin itemSellin;
	private ItemSpecificNameImpl itemSpecificName;
	private CalculateQuantityImpl calculateQuantity;
	private CalculateSellinImpl calculateSellin;

	public GildedRoseService(Item[] items, ItemSellin itemSellin, ItemSpecificNameImpl itemSpecificName,
			CalculateQuantityImpl calculateQuantity, CalculateSellinImpl calculateSellin) {
		this.items = items;
		this.itemSellin = itemSellin;
		this.itemSpecificName = itemSpecificName;
		this.calculateQuantity = calculateQuantity;
		this.calculateSellin = calculateSellin;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {

			if (itemSpecificName.isSpecficItemNamesNotMatch(items[i])) {

				calculateQuantity.quantityPositiveAndItemNameNotMatchDecreaseQuantity(items[i],
						ApplicationConstant.ITEM_NAME);
			} else {

				calculateQuantity.itemQuantityLess50(items[i]);
			}

			if (itemSpecificName.isSpecficItemNameNotMatchWithGivenName(items[i], ApplicationConstant.ITEM_NAME)) {

				itemSellin.decreaseSellin(items[i]);
			}

			calculateSellin.itemSellinLessThanZero(items[i]);
		}
	}

}
