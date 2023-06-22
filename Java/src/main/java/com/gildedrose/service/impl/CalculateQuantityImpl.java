package com.gildedrose.service.impl;

import com.gildedrose.model.Item;
import com.gildedrose.service.CalculateQuantity;
import com.gildedrose.service.ItemQuantity;
import com.gildedrose.service.ItemSellin;
import com.gildedrose.service.ItemSpecificName;

public class CalculateQuantityImpl implements CalculateQuantity {

	private ItemSellin itemSellin;
	private ItemSpecificName itemSpecificName;
	private ItemQuantity itemQuantity;

	public CalculateQuantityImpl(ItemSellin itemSellin, ItemSpecificName itemSpecificName, ItemQuantity itemQuantity) {
		this.itemSellin = itemSellin;
		this.itemSpecificName = itemSpecificName;
		this.itemQuantity = itemQuantity;
	}

	@Override
	public void itemQuantityLess50(Item item, String itemName, int days, int daysVal) {

		if (itemQuantity.hasQuantityLessThan50(item)) {
			itemQuantity.increaseQuantity(item);

			if (itemSpecificName.isSpecficItemNameMatchWithGivenName(item, itemName)) {

				itemSellInLessThanGivenDaysAndQuantityLess50(item, days);
				itemSellInLessThanGivenDaysAndQuantityLess50(item, daysVal);
			}
		}
	}

	@Override
	public void itemNameNotMatchThanDecreaseQuantity(Item item, String givenItemName, String itemName) {

		if (itemSpecificName.isSpecficItemNameNotMatchWithGivenName(item, givenItemName)) {

			quantityPositiveAndItemNameNotMatchDecreaseQuantity(item, itemName);
		} else {
			item.quality = 0;
		}
	}

	@Override
	public void quantityPositiveAndItemNameNotMatchDecreaseQuantity(Item item, String givenItemName) {

		if (itemQuantity.hasPositiveQuantity(item)
				&& itemSpecificName.isSpecficItemNameNotMatchWithGivenName(item, givenItemName)) {
			itemQuantity.decreaseQuantity(item);
		}
	}

	@Override
	public void itemSellInLessThanGivenDaysAndQuantityLess50(Item item, int givenDays) {
		if (itemSellin.isItemSellInLessThanGivenNumber(item, givenDays) && itemQuantity.hasQuantityLessThan50(item)) {

			itemQuantity.increaseQuantity(item);
		}
	}

}
