package be.sonck.itunes.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
abstract class GenericItemBuilder<B extends GenericItemBuilder<B>> {

    String persistentId;
    String name;

    public B persistentId(String persistentId) {
        this.persistentId = persistentId;
        return (B) this;
    }

    public B name(String name) {
        this.name = name;
        return (B) this;
    }
}
