package be.sonck.itunes.api.model;

import com.google.common.base.MoreObjects;

public class Track extends Item {

	private final String album;
	private final String artist;
	private final Integer trackNumber;
	private final Integer discNumber;


    public Track(TrackBuilder builder) {
        this((GenericTrackBuilder<?>) builder);
    }

    protected Track(GenericTrackBuilder<?> builder) {
        super(builder);

        this.album = builder.album;
        this.artist = builder.artist;
        this.trackNumber = builder.trackNumber;
        this.discNumber = builder.discNumber;
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

    @Override
    protected MoreObjects.ToStringHelper getStringHelper() {
        return super.getStringHelper()
                .add("album", album)
                .add("artist", artist)
                .add("trackNumber", trackNumber)
                .add("discNumber", discNumber);
    }
}
