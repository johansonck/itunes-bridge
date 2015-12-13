package be.sonck.itunes.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
class GenericTrackBuilder<B extends GenericTrackBuilder<B>> extends GenericItemBuilder<B> {

    String album;
    String artist;
    Integer trackNumber;
    Integer discNumber;

    public B album(String album) {
        this.album = album;
        return (B) this;
    }

    public B artist(String artist) {
        this.artist = artist;
        return (B) this;
    }

    public B trackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
        return (B) this;
    }

    public B discNumber(Integer discNumber) {
        this.discNumber = discNumber;
        return (B) this;
    }
}