package be.sonck.itunes.api.model;

/**
 * Created by johansonck on 13/12/15.
 */
public class FileTrackBuilder extends GenericFileTrackBuilder<FileTrackBuilder> {

    public FileTrackBuilder() {
        super();
    }

    public FileTrackBuilder(FileTrack track) {
        super(track);
    }

    public FileTrack build() {
        return new FileTrack(this);
    }
}
