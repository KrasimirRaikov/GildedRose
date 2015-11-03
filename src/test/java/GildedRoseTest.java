import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class GildedRoseTest {

	@Test
	public void testSellInDegradation() {
    GildedRose.items = new ArrayList<Item>();
    GildedRose.items.add(new Item("+5 Dexterity Vest", 10, 13));
    int origSellIn=GildedRose.items.get(0).getSellIn();
    GildedRose.updateQuality();
    assertThat(origSellIn-1, is(equalTo(GildedRose.items.get(0).getSellIn())));
    GildedRose.updateQuality();
    assertThat(origSellIn-2, is(equalTo(GildedRose.items.get(0).getSellIn())));
  }

  @Test
  public void testQualityDegradation() {
    GildedRose.items=new ArrayList<Item>();
    GildedRose.items.add(new Item("+5 Dexterity Vest", 10,13));
    GildedRose.items.add(new Item("Elixir of the Mongoose", 5, 7));
    int originQuality1=GildedRose.items.get(0).getQuality();
    int originQuality2=GildedRose.items.get(1).getQuality();
    GildedRose.updateQuality();
    assertThat(originQuality1 -1, is(equalTo(GildedRose.items.get(0).getQuality())));
    assertThat(originQuality2 - 1, is(equalTo(GildedRose.items.get(1).getQuality())));
  }
}
