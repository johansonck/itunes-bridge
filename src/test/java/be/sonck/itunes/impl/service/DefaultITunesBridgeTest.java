package be.sonck.itunes.impl.service;

import java.util.SortedSet;

import org.junit.Test;

import be.sonck.itunes.api.model.Playlist;

public class DefaultITunesBridgeTest {

	@Test
	public void test() {
		SortedSet<Playlist> playlists = new DefaultITunesBridge().getAllPlaylists();
		for (Playlist playlist : playlists) {
			
		}
	}
}
