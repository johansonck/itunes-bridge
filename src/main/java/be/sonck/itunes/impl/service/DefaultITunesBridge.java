package be.sonck.itunes.impl.service;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.api.service.ITunesBridge;
import be.sonck.itunes.impl.executor.GetAllPlaylistsExecutor;
import be.sonck.itunes.impl.executor.GetTracksExecutor;

import java.util.SortedSet;

public class DefaultITunesBridge implements ITunesBridge {

    private GetAllPlaylistsExecutor getAllPlaylistsExecutor = new GetAllPlaylistsExecutor();
    private GetTracksExecutor getTracksExecutor = new GetTracksExecutor();


	@Override
	public SortedSet<Playlist> getAllPlaylists() {
		return getAllPlaylistsExecutor.getAllPlaylists();
	}

	@Override
	public SortedSet<FileTrack> getTracks(Playlist playlist) {
        return getTracksExecutor.getTracks(playlist);
	}
}
