package be.sonck.itunes.bridge.impl.model;


import java.util.Calendar;

public class FileTrackTO {

    private final String persistentId;
    private final String name;
    private final String album;
    private final String artist;
    private final String trackNumber;
    private final String discNumber;
    private final String rating;
    private final String ratingKind;
    private final String albumRating;
    private final String albumRatingKind;
    private final String location;
    private final Calendar playedDate;


    private FileTrackTO(Builder builder) {
        this.persistentId = builder.persistentId;
        this.name = builder.name;
        this.album = builder.album;
        this.artist = builder.artist;
        this.trackNumber = builder.trackNumber;
        this.discNumber = builder.discNumber;
        this.rating = builder.rating;
        this.ratingKind = builder.ratingKind;
        this.albumRating = builder.albumRating;
        this.albumRatingKind = builder.albumRatingKind;
        this.location = builder.location;
        this.playedDate = builder.playedDate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getPersistentId() {
        return persistentId;
    }

    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public String getDiscNumber() {
        return discNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getRating() {
        return rating;
    }

    public String getAlbumRating() {
        return albumRating;
    }

    public String getAlbumRatingKind() {
        return albumRatingKind;
    }

    public String getRatingKind() {
        return ratingKind;
    }

    public Calendar getPlayedDate() {
        return playedDate;
    }

    public static final class Builder {
        private String persistentId;
        private String name;
        private String album;
        private String artist;
        private String trackNumber;
        private String discNumber;
        private String rating;
        private String ratingKind;
        private String albumRating;
        private String albumRatingKind;
        private String location;
        private Calendar playedDate;

        private Builder() {
        }

        public FileTrackTO build() {
            return new FileTrackTO(this);
        }

        public Builder persistentId(String persistentId) {
            this.persistentId = persistentId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder album(String album) {
            this.album = album;
            return this;
        }

        public Builder artist(String artist) {
            this.artist = artist;
            return this;
        }

        public Builder trackNumber(String trackNumber) {
            this.trackNumber = trackNumber;
            return this;
        }

        public Builder discNumber(String discNumber) {
            this.discNumber = discNumber;
            return this;
        }

        public Builder rating(String rating) {
            this.rating = rating;
            return this;
        }

        public Builder ratingKind(String ratingKind) {
            this.ratingKind = ratingKind;
            return this;
        }

        public Builder albumRating(String albumRating) {
            this.albumRating = albumRating;
            return this;
        }

        public Builder albumRatingKind(String albumRatingKind) {
            this.albumRatingKind = albumRatingKind;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder playedDate(Calendar playedDate) {
            this.playedDate = playedDate;
            return this;
        }
    }
}
