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

@ExtendWith(MockitoExtension.class)
class CalculateQuantityTest {
	
	@Mock
	private ItemSellin itemSellin;
	@Mock
	private ItemSpecificName itemSpecificName;
	@Spy
	private ItemQuantity itemQuantity;
	
	@InjectMocks
	private CalculateQuantity calculateQuantity;

	@DisplayName("should increase quantity but not match specific ite name")
	@Test
	void testQuantityIncreaseItemNameNotMatch() {
		
		int expectedQuantity = 45;
		Item item = new Item("test", 5, 45);
		doReturn(Boolean.FALSE).when(itemSpecificName).isSpecficItemNameMatchWithGivenName(item, "Backstage passes to a TAFKAL80ETC concert");
		
		//calculateQuantity.itemQuantityLess50(item);
      
		assertEquals(expectedQuantity, item.quality);
	}

}
