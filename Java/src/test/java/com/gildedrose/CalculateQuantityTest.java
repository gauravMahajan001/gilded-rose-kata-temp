package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gildedrose.model.Item;
import com.gildedrose.service.CalculateQuantity;
import com.gildedrose.service.ItemQuantity;
import com.gildedrose.service.ItemSellin;
import com.gildedrose.service.ItemSpecificName;
import com.gildedrose.service.impl.CalculateQuantityImpl;

@ExtendWith(MockitoExtension.class)
class CalculateQuantityTest {
	
	@Mock
	private ItemSellin itemSellin;
	@Mock
	private ItemSpecificName itemSpecificName;
	@Spy
	private ItemQuantity itemQuantity;
	
	@InjectMocks
	private CalculateQuantityImpl calculateQuantityImpl;

	@DisplayName("should increase quantity but item name not match")
	@Test
	void testQuantityIncreaseItemNameNotMatch() {
		
		int expectedQuantity = 46;
		Item item = new Item("test", 5, 45);
		doReturn(Boolean.FALSE).when(itemSpecificName).isSpecficItemNameMatchWithGivenName(item, "test");
		
		calculateQuantityImpl.itemQuantityLess50(item,"test",2,4);
      
		assertEquals(expectedQuantity, item.quality);
		
	}
	
	@DisplayName("should increase quantity when item sellin less given days and qauntity less 50")
	@Test
	void testitemSellInLessThanGivenDaysAndQuantityLess50() {
		Item item = new Item("test", 5, 9);
		int days =11;
		int expected  = 10;
		doReturn(Boolean.TRUE).when(itemSellin).isItemSellInLessThanGivenNumber(item, days);
		
		calculateQuantityImpl.itemSellInLessThanGivenDaysAndQuantityLess50(item, days);
		assertEquals(expected, item.quality);
	}

	@DisplayName("should remain same quantity when item sellin greater than given days and qauntity greater than 50")
	@Test
	void testitemSellInNotLessThanGivenDaysAndQuantityNotLess50() {
		Item item = new Item("test", 15, 50);
		int days =11;
		int expected  = 50;
		doReturn(Boolean.TRUE).when(itemSellin).isItemSellInLessThanGivenNumber(item, days);
		
		calculateQuantityImpl.itemSellInLessThanGivenDaysAndQuantityLess50(item, days);
		assertEquals(expected, item.quality);
	}
}
