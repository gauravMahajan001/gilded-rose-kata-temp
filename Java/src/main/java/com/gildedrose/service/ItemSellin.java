package com.gildedrose.service;

import com.gildedrose.model.Item;

public class ItemSellin {

	public boolean isItemSellInLessThanGivenNumber(Item item, int number) {

		return item.sellIn < number;
	}

	public void decreaseSellin(Item item) {
		item.sellIn--;
	}

	public boolean hasItemSellinNegative(Item item) {

		return item.sellIn < 0;
	}
}
