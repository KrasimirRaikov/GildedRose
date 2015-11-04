import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ItemStatus {
  public void updateItemStatusList(List<Item> items) {
    for (Item item : items) {

      item.setQuality(updateQuality(item));

      item.setSellIn(updateSellIn(item));
    }

  }

  public void updateItemStatus(Item item) {
    item.setQuality(updateQuality(item));

    item.setSellIn(updateSellIn(item));
  }

  public int updateSellIn(Item item) {
    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
      return item.getSellIn() - 1;
    } else {
      return specialUpdateSellIn(item);
    }
  }

  public int specialUpdateSellIn(Item item) {
    if (item.getSellIn() < 0) {
      if (!"Aged Brie".equals(item.getName())) {
        if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
          if (item.getQuality() > 0 && (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))) {
            return item.getQuality() - 1;
          }
        } else {
          return 0;
        }
      } else {
        if (item.getQuality() < 50) {
          return item.getQuality() + 1;
        }
      }
    }
    return 101;
  }

  public int updateQuality(Item item) {
    if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
      if (item.getQuality() > 0) {
        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
          if (item.getSellIn() < 0) {
            return item.getQuality() - 2;
          }
          return item.getQuality() - 1;
        }
      }
    } else {
      if (item.getQuality() < 50) {


        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
          if (item.getSellIn() < 11) {
            if (item.getQuality() < 50) {
              return item.getQuality() + 1;
            }
          }

          if (item.getSellIn() < 6) {
            if (item.getQuality() < 50) {
              return item.getQuality() + 1;
            }
          }
        }
        return item.getQuality() + 1;
      } else return item.getQuality();
    }
    return item.getQuality();
  }
}
