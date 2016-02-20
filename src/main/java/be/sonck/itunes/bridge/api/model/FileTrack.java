package be.sonck.itunes.bridge.api.model;

import com.google.common.base.MoreObjects;

import java.io.File;

public class FileTrack extends Track {

	private final File location;


	public FileTrack(FileTrackBuilder builder) {
		this((GenericFileTrackBuilder<?>) builder);
	}

	public FileTrack(GenericFileTrackBuilder<?> builder) {
		super(builder);

		this.location = builder.location;
	}

	public File getLocation() {
		return location;
	}

	public boolean isRated() {
		Integer rating = getRating();
		if (rating > 0) return true;

		Integer albumRating = getAlbumRating();
		if (albumRating == 0) return false;

		RatingKind albumRatingKind = getAlbumRatingKind();
		return albumRatingKind == RatingKind.USER;
	}

    @Override
    protected MoreObjects.ToStringHelper getStringHelper() {
        return super.getStringHelper().add("location", location);
    }
}
