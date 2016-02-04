package be.sonck.itunes.impl.service;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.api.service.ITunesBridge;
import be.sonck.itunes.impl.SpringConfig;
import be.sonck.itunes.impl.executor.GetAllPlaylistsExecutor;
import be.sonck.itunes.impl.executor.GetTrackExecutor;
import be.sonck.itunes.impl.executor.GetTracksExecutor;
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
