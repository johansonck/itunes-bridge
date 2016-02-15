package be.sonck.itunes.bridge.api.model;

import com.google.common.base.MoreObjects;

public class Track extends Item {

	private final String album;
	private final String artist;
	private final Integer trackNumber;
	private final Integer discNumber;
    private final Integer rating;
    private final Integer albumRating;
    private final RatingKind albumRatingKind;


    public Track(TrackBuilder builder) {
        this((GenericTrackBuilder<?>) builder);
    }

    protected Track(GenericTrackBuilder<?> builder) {
        super(builder);

        this.album = builder.album == null ? "" : builder.album;
        this.artist = builder.artist == null ? "" : builder.artist;
        this.trackNumber = builder.trackNumber == null ? 0 : builder.trackNumber;
        this.discNumber = builder.discNumber == null ? 0 : builder.discNumber;
        this.rating = builder.rating == null ? 0 : builder.rating;
        this.albumRating = builder.albumRating == null ? 0 : builder.albumRating;
        this.albumRatingKind = builder.albumRatingKind == null ? RatingKind.USER : builder.albumRatingKind;
    }

    public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
	}

	public Integer getTrackNumber() {
		return trackNumber;
	}

	public Integer getDiscNumber() {
		return discNumber;
	}

    public Integer getRating() {
        return rating;
    }

    public Integer getAlbumRating() {
        return albumRating;
    }

    public RatingKind getAlbumRatingKind() {
        return albumRatingKind;
    }

    @Override
    protected MoreObjects.ToStringHelper getStringHelper() {
        return super.getStringHelper()
                .add("album", album)
                .add("artist", artist)
                .add("trackNumber", trackNumber)
                .add("discNumber", discNumber)
                .add("rating", rating);
    }
}
