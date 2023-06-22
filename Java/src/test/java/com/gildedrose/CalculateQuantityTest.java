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

	@DisplayName("should increase quantity but not match specific ite name")
	@Test
	void testQuantityIncreaseItemNameNotMatch() {
		
		int expectedQuantity = 46;
		Item item = new Item("test", 5, 45);
		doReturn(Boolean.FALSE).when(itemSpecificName).isSpecficItemNameMatchWithGivenName(item, "test");
		
		calculateQuantityImpl.itemQuantityLess50(item,"test",2,4);
      
		assertEquals(expectedQuantity, item.quality);
	}

}
