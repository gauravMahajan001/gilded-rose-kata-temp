package com.gildedrose.service;

import java.util.Arrays;
import java.util.stream.Stream;

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

		Arrays.stream(items).forEach(item ->{

			if (itemSpecificName.isSpecficItemNamesNotMatch(item)) {

				calculateQuantity.quantityPositiveAndItemNameNotMatchDecreaseQuantity(item,
						ApplicationConstant.ITEM_NAME);
			} else {

				calculateQuantity.itemQuantityLess50(item);
			}

			if (itemSpecificName.isSpecficItemNameNotMatchWithGivenName(item, ApplicationConstant.ITEM_NAME)) {

				itemSellin.decreaseSellin(item);
			}

			calculateSellin.itemSellinLessThanZero(item);
		});
	}

}
