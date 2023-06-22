package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gildedrose.model.Item;
import com.gildedrose.service.ItemSellin;

class ItemSellinTest {

	private ItemSellin itemSellin = new ItemSellin();
	
	@DisplayName("Item Sellin decrease By 1")
	@Test
	void testDecreaseSellin() {
		
		Item item = new Item("Test", 4, 6);
		int expectedDay = 3;
		itemSellin.decreaseSellin(item);
		
	    assertEquals(expectedDay, item.sellIn);	
		
	}
	    
}
