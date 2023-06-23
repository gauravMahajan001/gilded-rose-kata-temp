package com.gildedrose;

import com.gildedrose.model.Item;

public class BackstageItem implements ItemUpate {

	@Override
	public void update(Item item) {
		
		if (item.quality < 50) {
			item.quality++;

			if (item.sellIn < 11 && item.quality < 50) {

				item.quality++;
			}

			if (item.sellIn < 6 && item.quality < 50) {

				item.quality++;
			}
		}

			item.sellIn--;

			if (item.sellIn < 0) {
				item.sellIn = 0;
			}
	}

}
