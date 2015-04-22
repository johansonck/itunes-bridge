package be.sonck.itunes.impl.factory;

import java.util.ArrayList;
import java.util.List;

import be.sonck.itunes.impl.model.FileTrackTO;
import be.sonck.itunes.interpreter.AliasInterpreter;
import be.sonck.itunes.interpreter.ListInterpreter;
import be.sonck.itunes.interpreter.StringInterpreter;
import be.sonck.itunes.interpreter.StringListInterpreter;

public class FileTrackTOFactory {

	private ListInterpreter listInterpreter = new ListInterpreter();
	private StringListInterpreter stringListInterpreter = new StringListInterpreter();
	private StringInterpreter stringInterpreter = new StringInterpreter();
	private AliasInterpreter aliasInterpreter = new AliasInterpreter();

	public List<FileTrackTO> createList(String tracks) {
		List<FileTrackTO> list = new ArrayList<FileTrackTO>();

		List<String> entries = listInterpreter.interpret(tracks);
		for (String entry : entries) {
			list.add(create(stringListInterpreter.interpret(entry)));
		}

		return list;
	}

	public List<FileTrackTO> createFromTrackInfos(String trackInfos) {
		List<FileTrackTO> list = new ArrayList<FileTrackTO>();

		int i = 0;
		List<String> trackInfoList = listInterpreter.interpret(trackInfos);
		
		List<String> ids = listInterpreter.interpret(trackInfoList.get(i++));
		List<String> names = listInterpreter.interpret(trackInfoList.get(i++));
		List<String> albums = listInterpreter.interpret(trackInfoList.get(i++));
		List<String> artists = listInterpreter.interpret(trackInfoList.get(i++));
		List<String> trackNumbers = listInterpreter.interpret(trackInfoList.get(i++));
		List<String> discNumbers = listInterpreter.interpret(trackInfoList.get(i++));
		List<String> locations = listInterpreter.interpret(trackInfoList.get(i++));

		for (i = 0; i < ids.size(); i++) {
			list.add(new FileTrackTO(stringInterpreter.interpret(ids.get(i)), 
					stringInterpreter.interpret(names.get(i)), 
					stringInterpreter.interpret(albums.get(i)),
					stringInterpreter.interpret(artists.get(i)), 
					trackNumbers.get(i), discNumbers.get(i), 
					aliasInterpreter.interpret(locations.get(i))));
		}

		return list;
	}

	private FileTrackTO create(List<String> list) {
		int i = 0;

		String id = list.get(i++);
		String name = list.get(i++);
		String album = list.get(i++);
		String artist = list.get(i++);
		String trackNumber = list.get(i++);
		String discNumber = list.get(i++);
		String location = list.get(i++);

		return new FileTrackTO(id, name, album, artist, trackNumber, discNumber, location);
	}
}
