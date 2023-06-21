package com.gildedrose.service;

import com.gildedrose.constant.ApplicationConstant;
import com.gildedrose.model.Item;

public class GildedRoseService {
	
	private Item[] items;
	private ItemSellin itemSellin;
	private ItemSpecificName itemSpecificName;
	private CalculateQuantity calculateQuantity;
	private CalculateSellin calculateSellin;

	public GildedRoseService(Item[] items, ItemSellin itemSellin, ItemSpecificName itemSpecificName,
			CalculateQuantity calculateQuantity, CalculateSellin calculateSellin) {
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
