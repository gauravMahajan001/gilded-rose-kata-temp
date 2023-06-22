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
	void testSpecficItemNamesNotMatch() {
		Item item = new Item("Test", 2, 2);
		String itemNameNotMatch = "Age";
		String itemNameValNotmatch = "Temp";
		
		Boolean result = itemSpecificNameImpl.isSpecficItemNamesNotMatch(item, itemNameNotMatch, itemNameValNotmatch);
		assertEquals(Boolean.TRUE, result);
	}
	
	@DisplayName("should return true when item name not matched")
	@Test
	void testSpecficItemNameNotMatchWithGivenName() {
		Item item = new Item("Test", 2, 2);
		String itemNameNotMatch = "Age";
		
		Boolean result = itemSpecificNameImpl.isSpecficItemNameNotMatchWithGivenName(item, itemNameNotMatch);
		assertEquals(Boolean.TRUE, result);
		
	}
	
	@DisplayName("should return false when item name  matched")
	@Test
	void testSpecficItemNameMatchWithGivenNameThenReturnFalse() {
		Item item = new Item("Test", 2, 2);
		String itemNameMatch = "Test";
		
		Boolean result = itemSpecificNameImpl.isSpecficItemNameNotMatchWithGivenName(item, itemNameMatch);
		assertEquals(Boolean.FALSE, result);
		
	}
	

}
