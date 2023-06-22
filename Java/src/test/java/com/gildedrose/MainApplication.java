package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.CalculateQuantity;
import com.gildedrose.service.CalculateSellin;
import com.gildedrose.service.ItemQuantity;
import com.gildedrose.service.ItemSellin;
import com.gildedrose.service.ItemSpecificName;
import com.gildedrose.service.impl.CalculateQuantityImpl;
import com.gildedrose.service.impl.CalculateSellinImpl;
import com.gildedrose.service.impl.GildedRoseService;
import com.gildedrose.service.impl.ItemSpecificNameImpl;

public class MainApplication {

	public static void main(String[] args) {
		System.out.println("OMGHAI!");

		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		ItemSpecificName itemSpecificName = new ItemSpecificNameImpl();
		ItemQuantity itemQuantity = new ItemQuantity();
		ItemSellin itemSellin = new ItemSellin();

		CalculateQuantity calculateQuantity = new CalculateQuantityImpl(itemSellin, itemSpecificName, itemQuantity);
		CalculateSellin calculateSellin = new CalculateSellinImpl(itemSellin, itemSpecificName, itemQuantity,
				calculateQuantity);
		
		  GildedRoseService gildedRoseService = new GildedRoseService(items,
		  itemSellin, itemSpecificName, calculateQuantity, calculateSellin);
		 

		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (Item item : items) {
				System.out.println(item);
			}
			System.out.println();
			gildedRoseService.updateQuality();
		}
	}

}
