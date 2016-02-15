package be.sonck.itunes.bridge.impl.service;

import be.sonck.itunes.bridge.api.model.FileTrack;
import be.sonck.itunes.bridge.api.model.Playlist;
import be.sonck.itunes.bridge.api.service.ITunesBridge;
import be.sonck.itunes.bridge.impl.SpringConfig;
import be.sonck.itunes.bridge.impl.executor.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.SortedSet;

public class DefaultITunesBridge implements ITunesBridge {

    private ApplicationContext applicationContext;

    @Override
	public SortedSet<Playlist> getAllPlaylists() {
        GetAllPlaylistsExecutor executor = getExecutor(GetAllPlaylistsExecutor.class);
		return executor.getAllPlaylists();
	}

	@Override
	public SortedSet<FileTrack> getTracks(Playlist playlist) {
        GetTracksExecutor executor = getExecutor(GetTracksExecutor.class);
        return executor.getTracks(playlist);
	}

	@Override
	public FileTrack getTrack(String name, String album, String artist) {
        GetTrackExecutor executor = getExecutor(GetTrackExecutor.class);
        return executor.getTrack(name, album, artist);
	}

    @Override
    public void setTrackRating(String persistentId, int rating) {
        SetRatingExecutor executor = getExecutor(SetRatingExecutor.class);
        executor.setRating(persistentId, rating);
    }

    @Override
    public void setAlbumRating(String persistentId, int rating) {
        SetAlbumRatingExecutor executor = getExecutor(SetAlbumRatingExecutor.class);
        executor.setRating(persistentId, rating);
    }

    private <T> T getExecutor(Class<T> beanClass) {
        return getApplicationContext().getBean(beanClass);
    }

    private ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        }

        return applicationContext;
    }
}
