package be.sonck.itunes.bridge.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
public class ItemBuilder extends GenericItemBuilder<ItemBuilder> {

    public ItemBuilder() {
        super();
    }

    public ItemBuilder(Item item) {
        super(item);
    }

    public Item build() {
        return new Item(this);
    }
}