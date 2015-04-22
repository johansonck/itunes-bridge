package be.sonck.itunes.impl.model;

public class PlaylistTO {

	private final String id;
	private final String name;
	private final String type;
	private final String parentId;

	public PlaylistTO(String id, String name, String type, String parentId) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.parentId = parentId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getParentId() {
		return parentId;
	}
}
