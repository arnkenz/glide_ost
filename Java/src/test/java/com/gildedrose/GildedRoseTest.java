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
    	Item[] items = new Item[] {new Item("zeroquality", 0, 0)};
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertTrue(app.items[0].quality >= 0);
    }
    
    @Test
    void agedBrieIncreasesQuality() {
    	int initialQuality = 20;
    	Item[] items = new Item[] {new Item("Aged Brie", 2, initialQuality)};
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertTrue(app.items[0].quality >= initialQuality);
    }
    
    @Test
    void maxQualitity() {
    	int maxQuality = 50;
    	Item[] items = new Item[] {new Item("Aged Brie", 2, 50)};
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertTrue(app.items[0].quality <= maxQuality);
    }
    
    @Test
    void sulfurasIsConstant() {
    	int initialQuality = 80;
    	int initialSellIn = 40;
    	Item[] items = new Item[] {new Item("Sulfuras", initialSellIn, initialQuality)};
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals(initialQuality, app.items[0].quality);
    	assertEquals(initialSellIn, app.items[0].sellIn);
    }
    
    @Test
    void backStagePassIncreasesQuality() {
    	int initialQuality = 40;
    	int initialSellIn = 40;
    	Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality)};
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertTrue(app.items[0].quality >= initialQuality);
    }

}

