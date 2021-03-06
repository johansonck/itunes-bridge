package be.sonck.itunes.bridge.api.service;

import be.sonck.itunes.bridge.api.model.FileTrack;
import be.sonck.itunes.bridge.api.model.Playlist;

import java.util.SortedSet;

public interface ITunesBridge {

	SortedSet<Playlist> getAllPlaylists();
	SortedSet<FileTrack> getTracks(Playlist playlist);
	FileTrack getTrack(String name, String album, String artist);
	void setTrackRating(String persistentId, int rating);
	void setAlbumRating(String persistentId, int rating);
}