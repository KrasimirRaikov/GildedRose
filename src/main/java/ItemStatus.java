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
    if (!item.getName().contains("Sulfuras")) {
      return item.getSellIn() - 1;
    } else {
      return item.getSellIn();
    }
  }



  public int updateQuality(Item item) {
    if ((!item.getName().contains("Aged Brie")) && !item.getName().contains("Backstage passes")) {
      if (item.getQuality() > 0) {
        if (!item.getName().contains("Sulfuras")) {
          if (item.getSellIn() < 0 || item.getName().contains("Conjured")) {
            return item.getQuality() - 2;
          }
          return item.getQuality() - 1;
        }
      }
    } else {
      return specialUpdateQuality(item);
    }
    return item.getQuality();
  }

  private int specialUpdateQuality(Item item) {
    if (item.getQuality() < 50) {
      if (item.getName().contains("Backstage passes")) {
        if(item.getSellIn()<1){return 0;}
        if (item.getSellIn() < 6) {
          if (item.getQuality() < 50) {
            return item.getQuality() + 3;
          }
        }
        if (item.getSellIn() < 11) {
          if (item.getQuality() < 50) {
            return item.getQuality() + 2;
          }
        }
      }
      return item.getQuality() + 1;
    } else return item.getQuality();
  }
}
