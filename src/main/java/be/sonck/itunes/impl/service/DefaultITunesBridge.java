package be.sonck.itunes.impl.service;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.api.service.ITunesBridge;
import be.sonck.itunes.impl.factory.FileTrackFactory;
import be.sonck.itunes.impl.factory.FileTrackTOFactory;
import be.sonck.itunes.impl.factory.PlaylistFactory;
import be.sonck.itunes.impl.factory.PlaylistTOFactory;
import be.sonck.itunes.impl.model.FileTrackTO;
import be.sonck.itunes.impl.model.PlaylistTO;

import java.util.List;
import java.util.SortedSet;

public class DefaultITunesBridge implements ITunesBridge {

	private AppleScriptExecutorClasspathAdapter executor = new AppleScriptExecutorClasspathAdapter();
	private PlaylistTOFactory playlistTOFactory = new PlaylistTOFactory();
	private PlaylistFactory playlistFactory = new PlaylistFactory();
	private FileTrackTOFactory fileTrackTOFactory = new FileTrackTOFactory();
	private FileTrackFactory fileTrackFactory = new FileTrackFactory();


	@Override
	public SortedSet<Playlist> getAllPlaylists() {
		String result = executor.execute(Scripts.GET_ALL_PLAYLISTS);
		List<PlaylistTO> toList = playlistTOFactory.createList(result);

		return playlistFactory.createPlaylists(toList);
	}

	@Override
	public SortedSet<FileTrack> getTracks(Playlist playlist) {
		String result = executor.execute(Scripts.GET_TRACKS, playlist.getPersistentId());
		List<FileTrackTO> toList = fileTrackTOFactory.createFromTrackInfos(result);

		return fileTrackFactory.createFileTracks(toList);
	}

	@Override
	public int countTracks(Playlist playlist) {
		String result = executor.execute(Scripts.COUNT_TRACKS, playlist.getPersistentId());
		return Integer.parseInt(result);
	}
}
