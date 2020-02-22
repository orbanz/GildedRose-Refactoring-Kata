package com.gildedrose;

public class AgedBrieItem extends CustomItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        // "Aged Brie" actually increases in Quality the older it gets
        increaseItemQualityByOne();
        deceraseItemSellIn();
        if (isItemPassedSellInDate()) {
            increaseItemQualityByOne();
        }
    }

}
