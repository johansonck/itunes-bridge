package be.sonck.itunes.impl.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

import org.junit.Assert;
import org.junit.Test;

import be.sonck.itunes.api.model.FolderPlaylist;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.impl.factory.PlaylistFactory;
import be.sonck.itunes.impl.model.PlaylistTO;

public class PlaylistFactoryTest {

	@Test
	public void test() {
		List<PlaylistTO> toList = new ArrayList<PlaylistTO>();
		
		toList.add(new PlaylistTO("1", "PL1", "folder", ""));
		toList.add(new PlaylistTO("2", "PL2", "folder", ""));
		toList.add(new PlaylistTO("3", "PL3", "none", ""));
		
		toList.add(new PlaylistTO("4", "PL4", "folder", "1"));
		toList.add(new PlaylistTO("5", "PL5", "none", "4"));
		toList.add(new PlaylistTO("6", "PL6", "none", "5"));
		
		toList.add(new PlaylistTO("7", "PL7", "folder", "2"));
		toList.add(new PlaylistTO("8", "PL8", "folder", "2"));
		toList.add(new PlaylistTO("9", "PL9", "folder", "2"));
		
		toList.add(new PlaylistTO("10", "PL10", "folder", "7"));
		toList.add(new PlaylistTO("11", "PL11", "folder", "10"));
		toList.add(new PlaylistTO("12", "PL12", "folder", "11"));
		toList.add(new PlaylistTO("13", "PL13", "none", "12"));
		
		SortedSet<Playlist> playlists = new PlaylistFactory().createPlaylists(toList);
		
		Assert.assertNotNull(playlists);
		Assert.assertEquals(3, playlists.size());
		
		Playlist playlist = validatePlaylist(playlists, "1");
		Assert.assertEquals(FolderPlaylist.class, playlist.getClass());
		Assert.assertEquals(1, ((FolderPlaylist) playlist).getChildren().size());
		
		playlist = validatePlaylist(playlists, "2");
		Assert.assertEquals(3, ((FolderPlaylist) playlist).getChildren().size());
		
		playlist = validatePlaylist(playlists, "3");
		Assert.assertEquals(Playlist.class, playlist.getClass());
		
		playlist = validatePlaylist(playlists, "7");
		Assert.assertEquals(1, ((FolderPlaylist) playlist).getChildren().size());
		
		playlist = validatePlaylist(playlists, "10");
		Assert.assertEquals(1, ((FolderPlaylist) playlist).getChildren().size());
		
		playlist = validatePlaylist(playlists, "11");
		Assert.assertEquals(1, ((FolderPlaylist) playlist).getChildren().size());
		
		playlist = validatePlaylist(playlists, "12");
		Assert.assertEquals(1, ((FolderPlaylist) playlist).getChildren().size());
		
		playlist = validatePlaylist(playlists, "13");
		Assert.assertEquals(Playlist.class, playlist.getClass());
		
		playlist = validatePlaylist(playlists, "8");
		Assert.assertEquals(0, ((FolderPlaylist) playlist).getChildren().size());
	}
	
	@Test
	public void testSort() {
		List<PlaylistTO> toList = new ArrayList<PlaylistTO>();
		
		toList.add(new PlaylistTO("1", "PL6", "folder", ""));
		toList.add(new PlaylistTO("4", "PL3", "none", ""));
		toList.add(new PlaylistTO("2", "PL4", "folder", ""));
		toList.add(new PlaylistTO("5", "PL5", "none", ""));
		toList.add(new PlaylistTO("3", "PL2", "folder", ""));
		toList.add(new PlaylistTO("6", "PL1", "none", ""));
		
		SortedSet<Playlist> playlists = new PlaylistFactory().createPlaylists(toList);

		Assert.assertEquals(6, playlists.size());
		
		Iterator<Playlist> iterator = playlists.iterator();
		Assert.assertEquals("PL2", iterator.next().getName());
		Assert.assertEquals("PL4", iterator.next().getName());
		Assert.assertEquals("PL6", iterator.next().getName());
		Assert.assertEquals("PL1", iterator.next().getName());
		Assert.assertEquals("PL3", iterator.next().getName());
		Assert.assertEquals("PL5", iterator.next().getName());
	}

	private Playlist validatePlaylist(SortedSet<Playlist> playlists, String id) {
		Playlist playlist = findPlaylist(playlists, id);
		Assert.assertNotNull(playlist);
		return playlist;
	}
	
	private Playlist findPlaylist(SortedSet<Playlist> playlists, String id) {
		for (Playlist playlist : playlists) {
			if (playlist.getPersistentId().equals(id)) { return playlist; }
			
			if (playlist instanceof FolderPlaylist) {
				Playlist childPlaylist = findPlaylist(((FolderPlaylist) playlist).getChildren(), id);
				if (childPlaylist != null) { return childPlaylist; }
			}
		}
		
		return null;
	}
}
