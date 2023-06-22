package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gildedrose.model.Item;
import com.gildedrose.service.ItemQuantity;

class ItemQuantityTest {
	
	private ItemQuantity itemQuantity = new ItemQuantity();
	
	@DisplayName("should return turn when Quantity is positive")
	@Test
	void testItemQuantityPositiveReturnTrue() {
		
		Item item = new Item("Test", 2, 10);
		
		Boolean result = itemQuantity.hasPositiveQuantity(item);
        assertEquals(Boolean.TRUE, result);
	}

	@DisplayName("should return false when Quantity is negative")
	@Test
	void testItemQuantityNegative() {
		
		Item item = new Item("Test", 2, -10);
		
		Boolean result = itemQuantity.hasPositiveQuantity(item);
        assertEquals(Boolean.FALSE, result);
	}
}
