package com.gildedrose;

import static com.gildedrose.ItemNameConst.SULFURAS_HAND_OF_RAGNAROS;

public class SulfurasItem extends CustomItem {
    // "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.

    public SulfurasItem() {
        super(new Item(SULFURAS_HAND_OF_RAGNAROS, 1, 80));
    }

    @Override
    public void updateItem() {
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    }
}
