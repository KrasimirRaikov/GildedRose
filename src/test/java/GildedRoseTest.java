import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class GildedRoseTest {

  @Before
  public void setUp(){
    GildedRose.items=new ArrayList<Item>();
    GildedRose.items.add(new Item("+5 Dexterity Vest", 10, 13));
    GildedRose.items.add(new Item("Elixir of the Mongoose", 5, 7));
  }



  @Test
  public void testSellInDegradation() {
    int origSellIn = GildedRose.items.get(0).getSellIn();
    GildedRose.updateQuality();
    assertThat(origSellIn - 1, is(equalTo(GildedRose.items.get(0).getSellIn())));
    GildedRose.updateQuality();
    assertThat(origSellIn - 2, is(equalTo(GildedRose.items.get(0).getSellIn())));
  }

  @Test
  public void testQualityDegradation() {
    int originQuality1 = GildedRose.items.get(0).getQuality();
    int originQuality2 = GildedRose.items.get(1).getQuality();
    GildedRose.updateQuality();
    assertThat(originQuality1 - 1, is(equalTo(GildedRose.items.get(0).getQuality())));
    assertThat(originQuality2 - 1, is(equalTo(GildedRose.items.get(1).getQuality())));
  }

  @Test
  public void testQualityDoubleDegradationPassedSellIn() {
    GildedRose.items.add(new Item("+5 Dexterity Vest", 0, 13));
    int originQuality = GildedRose.items.get(2).getQuality();
    GildedRose.updateQuality();
    GildedRose.updateQuality();
    assertThat(GildedRose.items.get(2).getQuality(), is(equalTo(originQuality - 3)));
  }

  @Test
  public void testPositiveQualityInTimeForAgedBrie() {
    GildedRose.items.add(new Item("Aged Brie", 0, 23));
    GildedRose.updateQuality();
    assertThat(GildedRose.items.get(2).getQuality(), is(equalTo(24)));
  }

  @Test
  public void testAlwaysPositiveQuality(){
    GildedRose.items.add(new Item("+5 Dexterity Vest", 0, 0));
    GildedRose.updateQuality();
    GildedRose.updateQuality();
    assertThat(GildedRose.items.get(2).getQuality(), is(equalTo(0)));
  }

  @Test
  public void testQualityAlwaysLessThan51() {
    GildedRose.items.add(new Item("Aged Brie", 0, 50));
    GildedRose.updateQuality();
    assertThat(GildedRose.items.get(2).getQuality(), is(equalTo(50)));
  }

  @Test
  public void testLegendarySulfuras() {
    GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    GildedRose.updateQuality();
    assertThat(GildedRose.items.get(2).getQuality(), is(equalTo(80)));
  }

  @Test
  public void testBackstagePassesQualityIncrease() {
    GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20));
    GildedRose.updateQuality();
    assertThat(GildedRose.items.get(2).getQuality(),is(equalTo(22)));
    GildedRose.updateQuality();
    assertThat(GildedRose.items.get(2).getQuality(),is(equalTo(25)));
  }

}
