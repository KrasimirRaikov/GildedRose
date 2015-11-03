/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ItemStatus {
  public int updateSellIn(Item item){
    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
      return item.getSellIn() - 1;
    }

    if (item.getSellIn() < 0) {
      if (!"Aged Brie".equals(item.getName())) {
        if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
          if (item.getQuality() > 0) {
            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
              return item.getQuality() - 1;
            }
          }
        } else {
          return  0;
        }
      } else {
        if (item.getQuality() < 50) {
          return item.getQuality() + 1;
        }
      }
    }
    return 101;
  }
}
