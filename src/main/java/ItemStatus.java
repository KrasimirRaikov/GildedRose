import java.util.List;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class ItemStatus {
  /**
   * Updates the status of a List(inventory) of items
   * @param items the list to be updated
   */
  public void updateItemStatusList(List<Item> items) {
    for (Item item : items) {

      item.setQuality(updateQuality(item));

      item.setSellIn(updateSellIn(item));
    }

  }

  /**
   * Updates the status of a single item
   * @param item the item to be updated
   */
  public void updateItemStatus(Item item) {
    item.setQuality(updateQuality(item));

    item.setSellIn(updateSellIn(item));
  }

  /**
   * calculates the new SellIn value of an item
   * @param item the item whose SellIn value needs updating
   * @return the new SellIn value
   */
  public int updateSellIn(Item item) {
    if (!item.getName().contains("Sulfuras")) {
      return item.getSellIn() - 1;
    } else {
      return item.getSellIn();
    }
  }

  /**
   * Calculates the new Quality value of an item
   * @param item the item whose Quality value needs updating
   * @return the new Quality value
   */
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

  /**
   * calculates the Quality value of a special item
   * @param item whose Quality value needs updating
   * @return the new Quality value
   */
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
