package com.gildedrose;

public class CustomItem {

    final Item item;

    public static final int ITEM_MAXIMUM_QUALITY = 50;

    public CustomItem(Item item) {
        this.item = item;
    }

    void updateItem() {
        decreaseItemQualityByOne();
        deceraseItemSellIn();
        if (isItemPassedSellInDate()) {
            decreaseItemQualityByOne();
        }
    }

    void increaseItemQualityByOne() {
        if (isItemQualityLessThanMaximum()) {
            this.item.quality += 1;
        }
    }

    void decreaseItemQualityByOne() {
        if (this.item.quality > 0) {
            this.item.quality -= 1;
        }
    }

    void deceraseItemSellIn() {
        this.item.sellIn -= 1;
    }

    boolean isItemQualityLessThanMaximum() {
        return isItemQualityLessThanValue(this.item.quality);
    }

    boolean isItemQualityLessThanValue(int p) {
        return p < ITEM_MAXIMUM_QUALITY;
    }

    boolean isItemPassedSellInDate() {
        return this.item.sellIn < 0;
    }

}
