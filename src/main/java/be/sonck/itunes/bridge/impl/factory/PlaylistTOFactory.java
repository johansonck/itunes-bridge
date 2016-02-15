package be.sonck.itunes.bridge.impl.factory;

import be.sonck.itunes.bridge.impl.model.PlaylistTO;
import be.sonck.itunes.bridge.interpreter.ListInterpreter;
import be.sonck.itunes.bridge.interpreter.StringListInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class PlaylistTOFactory {
	
    @Autowired
	private ListInterpreter listInterpreter;

    @Autowired
	private StringListInterpreter stringListInterpreter;
	
	
	public List<PlaylistTO> createList(String libraryInfo) {
		List<String> libraryInfos = listInterpreter.interpret(libraryInfo);
		return createList(libraryInfos);
	}

	public List<PlaylistTO> createList(List<String> libraryInfos) {
		List<PlaylistTO> list = new ArrayList<PlaylistTO>();

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
