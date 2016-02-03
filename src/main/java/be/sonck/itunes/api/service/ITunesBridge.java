package be.sonck.itunes.api.service;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;

import java.util.SortedSet;

public interface ITunesBridge {

	SortedSet<Playlist> getAllPlaylists();
	SortedSet<FileTrack> getTracks(Playlist playlist);
	FileTrack getTrack(String name, String album, String artist);
}