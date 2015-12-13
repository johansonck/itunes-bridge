package be.sonck.itunes.api.model;

import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by johansonck on 13/12/15.
 */
public class ItemBuilderTest {

    @Test
    public void testBuilder() {
        String persistentId = random(10);
        String name = random(10);

        Item item = new ItemBuilder()
                .persistentId(persistentId)
                .name(name)
                .build();

        assertThat(item.getPersistentId(), is(persistentId));
        assertThat(item.getName(), is(name));
    }
}