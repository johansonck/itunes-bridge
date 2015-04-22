package be.sonck.itunes.impl.service;

import java.io.File;
import java.util.List;
import java.util.SortedSet;

import be.sonck.applescript.AppleScriptException;
import be.sonck.applescript.AppleScriptExecutor;
import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.api.service.ITunesBridge;
import be.sonck.itunes.impl.factory.FileTrackFactory;
import be.sonck.itunes.impl.factory.FileTrackTOFactory;
import be.sonck.itunes.impl.factory.PlaylistFactory;
import be.sonck.itunes.impl.factory.PlaylistTOFactory;
import be.sonck.itunes.impl.model.FileTrackTO;
import be.sonck.itunes.impl.model.PlaylistTO;

public class DefaultITunesBridge implements ITunesBridge {

	private ScriptCopier scriptCopier = new ScriptCopier();
	private AppleScriptExecutor executor = new AppleScriptExecutor();
	private PlaylistTOFactory playlistTOFactory = new PlaylistTOFactory();
	private PlaylistFactory playlistFactory = new PlaylistFactory();
	private FileTrackTOFactory fileTrackTOFactory = new FileTrackTOFactory();
	private FileTrackFactory fileTrackFactory = new FileTrackFactory();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Playlist playlist = new Playlist("2B7CF7220C2C05F2", "blah");
		SortedSet<FileTrack> tracks = new DefaultITunesBridge().getTracks(playlist);

		System.out.println(System.currentTimeMillis() - start);
		
		for (FileTrack track : tracks) {
			System.out.println(track);
			File location = track.getLocation();
			if (!location.exists()) {
				throw new IllegalStateException(location.getAbsolutePath());
			}
		}
	}

	@Override
	public SortedSet<Playlist> getAllPlaylists() {
		String result = executeScript(Scripts.GET_ALL_PLAYLISTS);
		List<PlaylistTO> toList = playlistTOFactory.createList(result);

		return playlistFactory.createPlaylists(toList);
	}

	@Override
	public SortedSet<FileTrack> getTracks(Playlist playlist) {
		String result = executeScript(Scripts.GET_TRACKS, playlist.getPersistentId());
		List<FileTrackTO> toList = fileTrackTOFactory.createFromTrackInfos(result);

		return fileTrackFactory.createFileTracks(toList);
	}

	@Override
	public int countTracks(Playlist playlist) {
		String result = executeScript(Scripts.COUNT_TRACKS, playlist.getPersistentId());
		return Integer.parseInt(result);
	}

	private String executeScript(String scriptName, String... args) {
		try {
			return executor.execute(scriptCopier.copyScript(scriptName), args).trim();

		} catch (AppleScriptException e) {
			throw new RuntimeException(e);
		}
	}
}
