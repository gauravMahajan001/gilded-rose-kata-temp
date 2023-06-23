package com.gildedrose;

import com.gildedrose.model.Item;

public class Generaltem implements ItemUpate {

	@Override
	public void update(Item item) {

		if (item.quality > 0) {
			item.quality--;

		}
		item.sellIn--;

		if (item.sellIn < 0 && item.quality > 0) {

				item.quality--;
			}
		

	}

}
