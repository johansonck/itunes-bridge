package be.sonck.itunes.impl.factory;

import be.sonck.itunes.api.model.FolderPlaylistBuilder;
import be.sonck.itunes.api.model.Playlist;
import be.sonck.itunes.api.model.PlaylistBuilder;
import be.sonck.itunes.api.model.PlaylistComparator;
import be.sonck.itunes.impl.model.PlaylistTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlaylistFactory {
	
	private static final String NONE = "none";
	private static final String FOLDER = "folder";
	

	public SortedSet<Playlist> createPlaylists(List<PlaylistTO> toList) {
		SortedSet<Playlist> set = new TreeSet<Playlist>(new PlaylistComparator());
		
		List<PlaylistTO> rootList = createRootList(toList);
		Map<String, List<PlaylistTO>> toMap = createMap(toList);
		
		for (PlaylistTO to : rootList) {
			Playlist playlist = create(to, toMap);
			if (playlist != null) {
				set.add(playlist);
			}
		}
		
		return set;
	}
	
	private Playlist create(PlaylistTO to, Map<String, List<PlaylistTO>> toMap) {
		String type = to.getType();
		
		if (FOLDER.equals(type)) {
			return new FolderPlaylistBuilder()
                    .persistentId(to.getId())
                    .name(to.getName())
                    .children(getChildren(to.getId(), toMap))
                    .build();

		} else if (NONE.equals(type)) {
            return new PlaylistBuilder()
                    .persistentId(to.getId())
                    .name(to.getName())
                    .build();

		} else {
			return null;
		}
	}

	private SortedSet<Playlist> getChildren(String id, Map<String, List<PlaylistTO>> toMap) {
		SortedSet<Playlist> set = new TreeSet<Playlist>(new PlaylistComparator());
		
		List<PlaylistTO> toList = toMap.get(id);
		if (toList == null) { return set; }
		
		for (PlaylistTO to : toList) {
			Playlist playlist = create(to, toMap);
			if (playlist != null) {
				set.add(playlist);
			}
		}
		
		return set;
	}
	
	private Map<String, List<PlaylistTO>> createMap(List<PlaylistTO> toList) {
		HashMap<String, List<PlaylistTO>> map = new HashMap<String, List<PlaylistTO>>();
		
		for (PlaylistTO playlist : toList) {
			String parentId = playlist.getParentId();
			if (StringUtils.isBlank(parentId)) { continue; }
			
			List<PlaylistTO> list = map.get(parentId);
			if (list == null) {
				list = new ArrayList<PlaylistTO>();
				map.put(parentId, list);
			}
			
			list.add(playlist);
		}
		
		return map;
	}

	private List<PlaylistTO> createRootList(List<PlaylistTO> toList) {
		ArrayList<PlaylistTO> list = new ArrayList<PlaylistTO>();
		
		for (PlaylistTO playlist : toList) {
			if (StringUtils.isBlank(playlist.getParentId())) {
				list.add(playlist);
			}
		}
		
		return list;
	}
}
