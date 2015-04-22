package be.sonck.itunes.api.model;

public class Item {

	private final String persistentId;
	private final String name;

	
	public Item(String persistentId, String name) {
		this.persistentId = persistentId;
		this.name = name;
	}

	public String getPersistentId() {
		return persistentId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Item [persistentId=" + persistentId + ", name=" + name + "]";
	}
}
