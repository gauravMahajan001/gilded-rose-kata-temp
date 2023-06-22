package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gildedrose.model.Item;
import com.gildedrose.service.impl.ItemSpecificNameImpl;

class ItemSpecificNameTest {
	
	private ItemSpecificNameImpl itemSpecificNameImpl = new ItemSpecificNameImpl();
	
	@DisplayName("should check Item name not match")
	@Test
	void testIsSpecficItemNamesNotMatch() {
		Item item = new Item("Test", 2, 2);
		String ItemNameNotMatch = "Age";
		String ItemNameValNotmatch = "Temp";
		
		Boolean result = itemSpecificNameImpl.isSpecficItemNamesNotMatch(item, ItemNameNotMatch, ItemNameValNotmatch);
		assertEquals(Boolean.TRUE, result);
	}

}
