package be.sonck.itunes.bridge.impl.model;


public class FileTrackTO {

    private final String persistentId;
    private final String name;
    private final String album;
    private final String artist;
    private final String trackNumber;
    private final String discNumber;
    private final String rating;
    private final String albumRating;
    private final String albumRatingKind;
    private final String location;

    public FileTrackTO(String persistentId, String name, String album, String artist, String trackNumber,
            String discNumber, String rating, String albumRating, String albumRatingKind, String location) {

        this.persistentId = persistentId;
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.trackNumber = trackNumber;
        this.discNumber = discNumber;
        this.rating = rating;
        this.albumRating = albumRating;
        this.albumRatingKind = albumRatingKind;
        this.location = location;
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
}
