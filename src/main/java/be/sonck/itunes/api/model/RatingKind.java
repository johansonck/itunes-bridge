package be.sonck.itunes.api.model;

/**
 * Created by johansonck on 04/02/16.
 */
public enum RatingKind {
    COMPUTED("computed"), USER("user");

    private final String value;

    private RatingKind(String value) {
        this.value = value;
    }

    public static RatingKind fromValue(String value) {
        for (RatingKind entry : values()) {
            if (entry.value.equals(value)) {
                return entry;
            }
        }

        throw new IllegalArgumentException("No " + RatingKind.class.getSimpleName() + " found for value '" + value + "'");
    }
}
