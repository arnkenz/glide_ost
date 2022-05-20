package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			updateQuality(item);
		}
	}

	private void updateQuality(Item item) {
		if (isBackstage(item)) {
			increaseQuality(item);
			if (item.sellIn < 11) {
				increaseQuality(item);
			}
			if (item.sellIn < 6) {
				increaseQuality(item);
			}

		} else if (isAgedBrie(item)) {
			increaseQuality(item);
		} else if (isLegendary(item)) {
		} else {
			decreaseQuality(item);
		}
		if (!isLegendary(item)) {
			decreaseSellIn(item);
		}
		if (isExpired(item)) {
			handleDatePassed(item);
		}
	}

	private void handleDatePassed(Item item) {
		if (isAgedBrie(item)) {
			increaseQuality(item);
		} else if (isBackstage(item)) {
			item.quality = 0;
		} else if (isLegendary(item)) {
			return;
		} else {
			decreaseQuality(item);
		}
	}
	
	private int decreaseQuality(Item item) {
		if (isPositiveQuality(item)) {
			return item.quality = item.quality - 1;
		}
		return item.quality;
	}

	private int decreaseSellIn(Item item) {
		return item.sellIn = item.sellIn - 1;
	}

	private boolean isLegendary(Item item) {
		return item.name.equals("Sulfuras");
	}

	private int increaseQuality(Item item) {
		if (isUnderHighestQuality(item)) {
			return item.quality = item.quality + 1;
		}
		return item.quality;
	}

	public boolean isBackstage(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}


	private boolean isExpired(Item item) {
		return item.sellIn < 0;
	}

	private boolean isPositiveQuality(Item item) {
		return item.quality > 0;
	}

	private boolean isAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}

	private boolean isUnderHighestQuality(Item item) {
		return item.quality < 50;
	}
}