package be.sonck.itunes.api.service;

import java.util.SortedSet;

import be.sonck.itunes.api.model.FileTrack;
import be.sonck.itunes.api.model.Playlist;

public interface ITunesBridge {

	int countTracks(Playlist playlist);
	SortedSet<Playlist> getAllPlaylists();
	SortedSet<FileTrack> getTracks(Playlist playlist);
}