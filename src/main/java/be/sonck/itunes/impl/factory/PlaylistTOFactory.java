package be.sonck.itunes.impl.factory;

import java.util.ArrayList;
import java.util.List;

import be.sonck.itunes.impl.model.PlaylistTO;
import be.sonck.itunes.interpreter.ListInterpreter;
import be.sonck.itunes.interpreter.StringListInterpreter;

public final class PlaylistTOFactory {
	
	private ListInterpreter listInterpreter = new ListInterpreter();
	private StringListInterpreter stringListInterpreter = new StringListInterpreter();
	
	
	public List<PlaylistTO> createList(String libraryInfo) {
		List<PlaylistTO> list = new ArrayList<PlaylistTO>();
	
		List<String> libraryInfos = listInterpreter.interpret(libraryInfo);
		for (String entry : libraryInfos) {
			list.add(create(stringListInterpreter.interpret(entry)));
		}
		
		return list;
	}

	private PlaylistTO create(List<String> list) {
		String id = list.get(0);
		String name = list.get(1);
		String type = list.get(2);
		String parentId = list.get(3);
		
		return new PlaylistTO(id, name, type, parentId);
	}
}
