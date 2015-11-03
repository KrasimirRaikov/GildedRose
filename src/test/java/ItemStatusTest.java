import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ItemStatusTest {
  @Test
  public void testUpdateItemStatus() {
    ItemStatus updater=new ItemStatus();
    Item item=new Item("really boring something", 4, 6);
    int origQuality=item.getQuality();
    int origSellIn=item.getSellIn();
    updater.updateItemStatus(item);
    assertThat(item.getQuality(), is(equalTo(origQuality-1)));
    assertThat(item.getSellIn(), is(equalTo(origSellIn-1)));
  }

}
