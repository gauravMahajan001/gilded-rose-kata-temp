package com.gildedrose;

import java.util.Arrays;

import com.gildedrose.model.Item;

public class TempPzzzle {

	Item[] items;
	private Quantity quantity;
	private SellIn sellIn;

	public TempPzzzle(Item[] items, Quantity quantity, SellIn sellIn) {
		this.items = items;
		this.quantity = quantity;
		this.sellIn = sellIn;
	}

	public void updateQuality() {
		Arrays.stream(items).forEach(item -> {

			if (item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

				if (item.quality < 50) {

					quantity.increase(item);
					if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (item.sellIn < 11) {
							if (item.quality < 50) {

								quantity.increase(item);
							}
						}

						if (item.sellIn < 6) {
							if (item.quality < 50) {

								quantity.increase(item);
							}
						}
					}
				}
			} else {
				if (item.quality > 0) {
					if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {

						quantity.decrease(item);
					}
				}
			}

			if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {

				sellIn.decrease(item);
			}

			if (item.sellIn < 0) {
				if (item.name.equals("Aged Brie")) {

					if (item.quality < 50) {

						quantity.increase(item);
					}
				} else {

					if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

						item.quality = 0;
					} else {
						if (item.quality > 0) {
							if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {

								quantity.decrease(item);
							}
						}

					}

				}
			}
		});
	}

}
