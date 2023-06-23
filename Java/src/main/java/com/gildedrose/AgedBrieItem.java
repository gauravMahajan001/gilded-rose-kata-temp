package com.gildedrose;

import com.gildedrose.model.Item;

public class AgedBrieItem implements ItemUpate {

	@Override
	public void update(Item item) {
		
		if (item.quality < 50) {

			item.quality++;
		}

		item.sellIn--;

		if (item.sellIn < 0 && item.quality < 50) {
				item.quality++;
		}
	}

}
