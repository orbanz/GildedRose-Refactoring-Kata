package com.gildedrose;

// "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
//	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
//	Quality drops to 0 after the concert
public class BackstagePassItem extends CustomItem {

    public BackstagePassItem(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        increaseItemQuality();
        deceraseItemSellIn();
        if (isItemPassedSellInDate()) {
            this.item.quality = 0;
        }
    }

    void increaseItemQuality() {
        increaseItemQualityByOne();
        if (this.item.sellIn < 11) {
            if (isItemQualityLessThanMaximum()) {
                increaseItemQualityByOne();
            }
        }
        if (this.item.sellIn < 6) {
            if (isItemQualityLessThanMaximum()) {
                increaseItemQualityByOne();
            }
        }
    }
}
