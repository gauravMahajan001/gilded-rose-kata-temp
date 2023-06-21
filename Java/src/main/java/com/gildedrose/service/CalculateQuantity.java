package com.gildedrose.service;

import com.gildedrose.constant.ApplicationConstant;
import com.gildedrose.model.Item;

public class CalculateQuantity {

	private ItemSellin itemSellin;
	private ItemSpecificName itemSpecificName;
	private ItemQuantity itemQuantity;
	
	public CalculateQuantity(ItemSellin itemSellin, ItemSpecificName itemSpecificName, ItemQuantity itemQuantity) {
		this.itemSellin = itemSellin;
		this.itemSpecificName = itemSpecificName;
		this.itemQuantity = itemQuantity;
	}

	public void itemQuantityLess50(Item item) {

		if (itemQuantity.hasQuantityLessThan50(item)) {
			itemQuantity.increaseQuantity(item);

			if (itemSpecificName.isSpecficItemNameMatchWithGivenName(item, ApplicationConstant.ITEM_NAME_VAL)) {

				itemSellInLessThanNumberAndQuantityLess50(item, 11);
				itemSellInLessThanNumberAndQuantityLess50(item, 7);
			}
		}
	}
	
	public void itemNameNotMatchThanDecreaseQuantity(Item item) {

		if (itemSpecificName.isSpecficItemNameNotMatchWithGivenName(item, ApplicationConstant.ITEM_NAME_VAL)) {

			quantityPositiveAndItemNameNotMatchDecreaseQuantity(item, ApplicationConstant.ITEM_NAME);
		} else {
			itemQuantity.decreaseQuantity(item);

		}
	}

	public void quantityPositiveAndItemNameNotMatchDecreaseQuantity(Item item, String name) {

		if (itemQuantity.hasPositiveQuantity(item) && itemSpecificName.isSpecficItemNameNotMatchWithGivenName(item, name)) {
			itemQuantity.decreaseQuantity(item);
		}
	}

	private void itemSellInLessThanNumberAndQuantityLess50(Item item, int number) {
		if (itemSellin.isItemSellInLessThanGivenNumber(item, number) && itemQuantity.hasQuantityLessThan50(item)) {

			itemQuantity.increaseQuantity(item);
		}
	}

}
