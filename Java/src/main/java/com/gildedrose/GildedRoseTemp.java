package com.gildedrose;

import com.gildedrose.model.Item;

public class GildedRoseTemp {
	Item[] items;

	public GildedRoseTemp(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {

			if (!items[i].name.equals("Aged Brie")
					&& !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

				if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {

					items[i].quality = items[i].quality - 1;
				}
			} else {
				if (items[i].quality < 50) {
					items[i].quality = items[i].quality + 1;

					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

						if (items[i].sellIn < 11 && items[i].quality < 50) {
							items[i].quality = items[i].quality + 1;

						}

						if (items[i].sellIn < 6 && items[i].quality < 50) {
							items[i].quality = items[i].quality + 1;

						}
					}
				}
			}

			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0 && items[i].name.equals("Aged Brie") && items[i].quality < 50) {

				items[i].quality = items[i].quality + 1;
			}

			if (items[i].sellIn < 0 && !items[i].name.equals("Aged Brie")
					&& items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

				items[i].quality = 0;
			}
			if (items[i].sellIn < 0 && items[i].quality > 0 && items[i].name.equals("Aged Brie")
					&& !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {

				items[i].quality = items[i].quality - 1;

			}

		}

	}

}