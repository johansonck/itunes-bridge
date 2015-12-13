package be.sonck.itunes.api.model;

import com.google.common.base.MoreObjects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

public class Item {

	private final String persistentId;
	private final String name;

	
    public Item(ItemBuilder builder) {
        this((GenericItemBuilder<?>) builder);
    }

    protected Item(GenericItemBuilder<?> builder) {
        checkNotNull(builder.persistentId);

        this.persistentId = builder.persistentId;
        this.name = builder.name;
    }

    public String getPersistentId() {
		return persistentId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
        return getStringHelper().toString();
	}

    protected MoreObjects.ToStringHelper getStringHelper() {
        return toStringHelper(this)
                .add("persistentId", persistentId)
                .add("name", name);
    }
}
