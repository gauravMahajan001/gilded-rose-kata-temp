package com.gildedrose.service.impl;

import java.util.Arrays;
import java.util.stream.Stream;

import com.gildedrose.constant.ApplicationConstant;
import com.gildedrose.model.Item;
import com.gildedrose.service.CalculateQuantity;
import com.gildedrose.service.CalculateSellin;
import com.gildedrose.service.ItemSellin;
import com.gildedrose.service.ItemSpecificName;

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
		int compareNumber = 11;
		int compareVal = 7;

		Arrays.stream(items).forEach(item -> {

			if (itemSpecificName.isSpecficItemNamesNotMatch(item, ApplicationConstant.ITEM_NAME_STR,
					ApplicationConstant.ITEM_NAME_VAL)) {

				calculateQuantity.quantityPositiveAndItemNameNotMatchDecreaseQuantity(item,
						ApplicationConstant.ITEM_NAME);
			} else {

				calculateQuantity.itemQuantityLess50(item, ApplicationConstant.ITEM_NAME_VAL, compareNumber,
						compareVal);
			}

			if (itemSpecificName.isSpecficItemNameNotMatchWithGivenName(item, ApplicationConstant.ITEM_NAME)) {

				itemSellin.decreaseSellin(item);
			}

			calculateSellin.itemSellinLessThanZero(item, ApplicationConstant.ITEM_NAME_STR,
					ApplicationConstant.ITEM_NAME_VAL, ApplicationConstant.ITEM_NAME);
		});
	}

}
