package be.sonck.itunes.bridge.api.model;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.random;

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

        Assert.assertThat(item.getPersistentId(), CoreMatchers.is(persistentId));
        Assert.assertThat(item.getName(), CoreMatchers.is(name));
    }
}