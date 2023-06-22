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
	
	@DisplayName("should decrease quantity")
	@Test
	void testDecreaseQuantity() {
		
		Item item = new Item("Test", 2, 10);
		int expectedQuantity = 9;
		
		itemQuantity.decreaseQuantity(item);
		assertEquals(expectedQuantity, item.quality);
	}
	
	@DisplayName("should return true when quantity less than 50")
	@Test
	void testQuantityLessThan50() {
		
		Item item = new Item("Test", 2, 10);
		Boolean result = itemQuantity.hasQuantityLessThan50(item);
		 assertEquals(Boolean.TRUE, result);
	}
	
	@DisplayName("should return false when quantity greater than 50")
	@Test
	void testQuantityGreaterThan50() {
		
		Item item = new Item("Test", 2, 50);
		Boolean result = itemQuantity.hasQuantityLessThan50(item);
		 assertEquals(Boolean.FALSE, result);
	}
	
	@Test
	void testOuantityIncrease() {
		
		Item item = new Item("Test", 2, 10);
		int expectedQuantity = 11;
		itemQuantity.increaseQuantity(item);
		
		assertEquals(expectedQuantity, item.quality);
		
	}
	
}
