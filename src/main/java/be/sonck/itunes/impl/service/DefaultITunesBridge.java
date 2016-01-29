package be.sonck.itunes.impl.service;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.api.service.ITunesBridge;

import java.util.SortedSet;

public class DefaultITunesBridge implements ITunesBridge {

	private ClasspathAppleScriptExecutor executor = new ClasspathAppleScriptExecutor();
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

	@Override
	public int countTracks(Playlist playlist) {
		String result = (String) executor.execute(Scripts.COUNT_TRACKS, playlist.getPersistentId());
		return Integer.parseInt(result);
	}
}
