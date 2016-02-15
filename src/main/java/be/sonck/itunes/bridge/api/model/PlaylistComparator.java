package be.sonck.itunes.bridge.api.model;

import java.util.Comparator;


public class PlaylistComparator implements Comparator<Playlist> {

	@Override
	public int compare(Playlist arg0, Playlist arg1) {
		// folders should come before actual playlists
		if (arg0 instanceof FolderPlaylist) {
			if (!(arg1 instanceof FolderPlaylist)) { 
				return -1; 
			}
		} else if (arg1 instanceof FolderPlaylist) {
			return 1;
		}
		
		return arg0.getName().compareTo(arg1.getName());
	}

}
