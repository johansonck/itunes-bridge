package be.sonck.itunes.impl.service;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.api.service.ITunesBridge;
import be.sonck.itunes.impl.executor.GetAllPlaylistsExecutor;
import be.sonck.itunes.impl.executor.GetTrackExecutor;
import be.sonck.itunes.impl.executor.GetTracksExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.SortedSet;

@Service
public class DefaultITunesBridge implements ITunesBridge {

    @Autowired
    private GetAllPlaylistsExecutor getAllPlaylistsExecutor;

    @Autowired
    private GetTracksExecutor getTracksExecutor;

    @Autowired
    private GetTrackExecutor getTrackExecutor;


	@Override
	public SortedSet<Playlist> getAllPlaylists() {
		return getAllPlaylistsExecutor.getAllPlaylists();
	}

	@Override
	public SortedSet<FileTrack> getTracks(Playlist playlist) {
        return getTracksExecutor.getTracks(playlist);
	}

	@Override
	public FileTrack getTrack(String name, String album, String artist) {
		return getTrackExecutor.getTrack(name, album, artist);
	}
}
