package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {



    // - Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void whenSellDatePassedQualityDegrades2x() {
        Item[] items = new Item[] { new Item("foo", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    //	- The Quality of an item is never negative
    @Test
    void qualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    //	- "Aged Brie" actually increases in Quality the older it gets
    @Test
    void qualityOfAgedBrieIsIncreasing() {
        Item[] items = new Item[] { new Item(ItemNameConst.AGED_BRIE, 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    //	- The Quality of an item is never more than 50
    @Test
    void qualityIsNeverMoreThan50() {
        Item[] items = new Item[] { new Item(ItemNameConst.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    //	- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void qualityOfSulfurasNeverDecreases() {
        Item[] items = new Item[] { new Item(ItemNameConst.SULFURAS_HAND_OF_RAGNAROS, 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
    }

    //	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    @Test
    void qualityOfBackstagePassesIncrease() {
        Item[] items = new Item[] { new Item(ItemNameConst.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 15, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    //	- "Backstage passes", Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    @Test
    void qualityOfBackstagePassesIncreaseBy2TenDaysBeforeConcert() {
        Item[] items = new Item[] { new Item(ItemNameConst.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 6, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void qualityOfBackstagePassesIncreaseBy3ThreeDaysBeforeConcert() {
        Item[] items = new Item[] { new Item(ItemNameConst.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }
    //	- "Backstage passes", Quality drops to 0 after the concert
    @Test
    void qualityOfBackstagePassesDropsToZeroAfterTheConcert() {
        Item[] items = new Item[] { new Item(ItemNameConst.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
