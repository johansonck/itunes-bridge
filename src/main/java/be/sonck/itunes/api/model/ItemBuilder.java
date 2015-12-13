package be.sonck.itunes.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
public class ItemBuilder extends GenericItemBuilder<ItemBuilder> {

    public Item build() {
        return new Item(this);
    }
}