package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			if (isBackstage(item) || isAgedBrie(item)) {
				if (isUnderHighestQuality(item)) {
					increaseQuality(item);
					if (isBackstage(item)) {
						if (item.sellIn < 11) {
								increaseQuality(item);						
						}
						if (item.sellIn < 6) {
								increaseQuality(item);
						}
					}
				}
			
			} else {
				if (isPositiveQuality(item)) {
					if (!isLegendary(item)) {
						decreaseQuality(item);
					}
				}
			}

			if (!isLegendary(item)) {
				decreaseSellIn(item);
			}

			handleDatePassed(item);
		}
	}

	private int decreaseQuality(Item item) {
		return item.quality = item.quality - 1;
	}

	private int decreaseSellIn(Item item) {
		return item.sellIn = item.sellIn - 1;
	}

	private boolean isLegendary(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros") || item.name.equals("Sulfuras");
	}

	private int increaseQuality(Item item) {
		return item.quality = item.quality + 1;
	}

	public boolean isBackstage(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private void handleDatePassed(Item item) {
		if (item.sellIn < 0) {
			if (isAgedBrie(item)) {
				if (isUnderHighestQuality(item)) {
					increaseQuality(item);
				}
			} else {
			 if (isBackstage(item)) {
					item.quality = 0;
				}
			 else {
					if (isPositiveQuality(item)) {
						if (!isLegendary(item)) {
							decreaseQuality(item);
						}
					}
				}
			}
		}
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