package com.gildedrose.service.impl;

import com.gildedrose.constant.ApplicationConstant;
import com.gildedrose.model.Item;
import com.gildedrose.service.CalculateQuantity;
import com.gildedrose.service.ItemQuantity;
import com.gildedrose.service.ItemSellin;

public class CalculateQuantityImpl implements CalculateQuantity {

	private ItemSellin itemSellin;
	private ItemSpecificNameImpl itemSpecificName;
	private ItemQuantity itemQuantity;
	
	public CalculateQuantityImpl(ItemSellin itemSellin, ItemSpecificNameImpl itemSpecificName, ItemQuantity itemQuantity) {
		this.itemSellin = itemSellin;
		this.itemSpecificName = itemSpecificName;
		this.itemQuantity = itemQuantity;
	}

	@Override
	public void itemQuantityLess50(Item item) {

		if (itemQuantity.hasQuantityLessThan50(item)) {
			itemQuantity.increaseQuantity(item);

			if (itemSpecificName.isSpecficItemNameMatchWithGivenName(item, ApplicationConstant.ITEM_NAME_VAL)) {

				itemSellInLessThanNumberAndQuantityLess50(item, 11);
				itemSellInLessThanNumberAndQuantityLess50(item, 7);
			}
		}
	}
	
	@Override
	public void itemNameNotMatchThanDecreaseQuantity(Item item) {

		if (itemSpecificName.isSpecficItemNameNotMatchWithGivenName(item, ApplicationConstant.ITEM_NAME_VAL)) {

			quantityPositiveAndItemNameNotMatchDecreaseQuantity(item, ApplicationConstant.ITEM_NAME);
		} else {
			itemQuantity.decreaseQuantity(item);

		}
	}
    
	@Override
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
