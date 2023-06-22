package com.gildedrose.service;

import com.gildedrose.model.Item;

public interface CalculateSellin {
	
	public void itemSellinLessThanZero(Item item, String givenItemName, String itemName, String itemNameVal);

}
