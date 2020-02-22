package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class CustomItemFactory {

    public CustomItemFactory() {
    }

    public static CustomItem build(Item item) {
        switch (item.name) {
            case ItemNameConst.AGED_BRIE:
                return new AgedBrieItem(item);
            case ItemNameConst.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new BackstagePassItem(item);
            case ItemNameConst.CONJURED_ITEM:
                return new ConjuredItem(item);
            case ItemNameConst.SULFURAS_HAND_OF_RAGNAROS:
                return new SulfurasItem();
            default:
                return new CustomItem(item);
        }
    }
}
