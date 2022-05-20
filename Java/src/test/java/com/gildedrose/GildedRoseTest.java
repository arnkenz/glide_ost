package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("foo", app.items[0].name);
	}

	@Test
	void qualityIsNotNegative() {
		Item[] items = new Item[] { new Item("zeroquality", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertTrue(app.items[0].quality >= 0);
	}

	@Test
	void qualityIsDescreased() {
		Item[] items = new Item[] { new Item("onequality", 0, 1) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertTrue(app.items[0].quality == 0);
	}

	@Test
	void qualityIsDescreasedTwiceAfterSellIn() {
		Item[] items = new Item[] { new Item("twoquality", -1, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
	}

	@Test
	void agedBrieIncreasesQuality() {
		int initialQuality = 20;
		Item[] items = new Item[] { new Item("Aged Brie", 2, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertTrue(app.items[0].quality >= initialQuality);
	}

	@Test
	void maxQualitity() {
		int maxQuality = 50;
		Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertTrue(app.items[0].quality == maxQuality);
	}

	@Test
	void agedBrieOverMax() {
		int initialQuality = 51;
		Item[] items = new Item[] { new Item("Aged Brie", -1, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(51, app.items[0].quality);

	}

	@Test
	void agedBrieIncreasesAfterSellin() {
		int initialQuality = 40;
		Item[] items = new Item[] { new Item("Aged Brie", -1, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertTrue(app.items[0].quality > initialQuality);
	}

	@Test
	void sulfurasIsConstant() {
		int initialQuality = 80;
		int initialSellIn = 40;
		Item[] items = new Item[] { new Item("Sulfuras", initialSellIn, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(initialQuality, app.items[0].quality);
		assertEquals(initialSellIn, app.items[0].sellIn);
	}
	
	@Test
	void sulfurasIsConstantWithSellInPassed() {
		int initialQuality = 80;
		int initialSellIn = -1;
		Item[] items = new Item[] { new Item("Sulfuras", initialSellIn, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(initialQuality, app.items[0].quality);
		assertEquals(initialSellIn, app.items[0].sellIn);
	}

	@Test
	void backStagePassIncreasesQuality5Days() {
		int initialQuality = 5;
		int initialSellIn = 4;
		Item[] items = new Item[] {
				new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(initialQuality += 3, app.items[0].quality);
	}

	@Test
	void backStagePassIncreasesQuality10Days() {
		int initialQuality = 5;
		int initialSellIn = 10;
		Item[] items = new Item[] {
				new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(initialQuality += 2, app.items[0].quality);
	}

	@Test
	void backStagePassIncreasesQuality() {
		int initialQuality = 5;
		int initialSellIn = 15;
		Item[] items = new Item[] {
				new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(initialQuality += 1, app.items[0].quality);
	}

	@Test
	void backStagePassIncreasesQualityNotOverMax() {
		int initialQuality = 50;
		int initialSellIn = 5;
		Item[] items = new Item[] {
				new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertTrue(app.items[0].quality == initialQuality);
	}

	@Test
	void expiredBackStagePassIsWorthless() {
		int initialQuality = 5;
		int initialSellIn = 0;
		Item[] items = new Item[] {
				new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
	}
	
	@Test
	void conjuredItem( ) {
		int initialQuality = 5;
		int initialSellIn = 0;
		Item[] items = new Item[] {new Item("Conjured", initialSellIn, initialQuality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(3, app.items[0].quality);
	}

}
