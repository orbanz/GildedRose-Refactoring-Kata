package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final int ITEM_MAXIMUM_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isAgedBrie(item)
                    && !isBackstagePass(item)) {
                if (isQualityGreaterThanZero(item)) {
                    if (!isSulfuras(item)) {
                        decreaseItemQuality(item);
                    }
                }
            } else {
                if (isItemQualityLessThanMaximum(item)) {
                    increaseItemQuality(item);

                    if (isBackstagePass(item)) {
                        if (item.sellIn < 11) {
                            if (isItemQualityLessThanMaximum(item)) {
                                increaseItemQuality(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (isItemQualityLessThanMaximum(item)) {
                                increaseItemQuality(item);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                decreaseItemQuality(item);
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePass(item)) {
                        if (isQualityGreaterThanZero(item)) {
                            if (!isSulfuras(item)) {
                                decreaseItemQuality(item);
                            }
                        }
                    } else {
                        decreaseItemQuality(item);
                    }
                } else {
                    if (isItemQualityLessThanMaximum(item)) {
                        increaseItemQuality(item);
                    }
                }
            }
        }
    }

    private boolean isQualityGreaterThanZero(Item item) {
        return item.quality > 0;
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private void decreaseItemQuality(Item item) {
        changeItemQuality(item, -1);
    }

    private void increaseItemQuality(Item item) {
        changeItemQuality(item, 1);
    }

    private void changeItemQuality(Item item, int value) {
        item.quality = item.quality + value;
    }

    private boolean isItemQualityLessThanMaximum(Item item) {
        return isItemQualityLessThanValue(item.quality, ITEM_MAXIMUM_QUALITY);
    }
    private boolean isItemQualityLessThanValue(int p, int itemMaximumQuality) {
        return p < itemMaximumQuality;
    }
}