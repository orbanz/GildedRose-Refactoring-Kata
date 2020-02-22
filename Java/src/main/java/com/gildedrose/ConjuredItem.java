package com.gildedrose;

public class ConjuredItem extends CustomItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        // "Conjured" items degrade in Quality twice as fast as normal items
        decreaseItemQualityByOne();
        super.updateItem();
    }
}
