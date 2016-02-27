package be.sonck.itunes.bridge.api.model;

import java.util.Calendar;

/**
 * Created by johansonck on 13/12/15.
 */
class GenericTrackBuilder<B extends GenericTrackBuilder<B>> extends GenericItemBuilder<B> {

    String album;
    String artist;
    Integer trackNumber;
    Integer discNumber;
    Integer rating;
    RatingKind ratingKind;
    Integer albumRating;
    RatingKind albumRatingKind;
    Calendar playedDate;


    protected GenericTrackBuilder() {
        super();
    }

    protected GenericTrackBuilder(Track track) {
        super(track);
        album(track.getAlbum());
        artist(track.getArtist());
        trackNumber(track.getTrackNumber());
        discNumber(track.getDiscNumber());
        rating(track.getRating());
        ratingKind(track.getRatingKind());
        albumRating(track.getAlbumRating());
        albumRatingKind(track.getAlbumRatingKind());
        playedDate(track.getPlayedDate());
    }

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

    public B rating(Integer rating) {
        this.rating = rating;
        return (B) this;
    }

    public B albumRating(Integer albumRating) {
        this.albumRating = albumRating;
        return (B) this;
    }

    public B albumRatingKind(RatingKind albumRatingKind) {
        this.albumRatingKind = albumRatingKind;
        return (B) this;
    }

    public B ratingKind(RatingKind ratingKind) {
        this.ratingKind = ratingKind;
        return (B) this;
    }

    public B playedDate(Calendar playedDate) {
        this.playedDate = playedDate;
        return (B) this;
    }
}