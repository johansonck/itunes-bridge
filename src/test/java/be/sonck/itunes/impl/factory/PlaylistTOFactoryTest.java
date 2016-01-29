package be.sonck.itunes.impl.factory;

import be.sonck.itunes.impl.model.PlaylistTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class PlaylistTOFactoryTest {

    @Test
    public void testWithStringInput() {
        List<PlaylistTO> list = new PlaylistTOFactory().createList(
                "{\"88B8104E2454F85F	Archief	folder	BBAD9CD81AB3F76A\", \"B7B824C51C44D75F	88 - Lotuk	none	88B8104E2454F85F\"}");

        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());

        findPlaylist(list, "88B8104E2454F85F", "Archief", "folder", "BBAD9CD81AB3F76A");
        findPlaylist(list, "B7B824C51C44D75F", "88 - Lotuk", "none", "88B8104E2454F85F");
    }

    @Test
    public void testWithListInput() {
        List<PlaylistTO> list = new PlaylistTOFactory().createList(Arrays.asList(
                "88B8104E2454F85F\tArchief\tfolder\tBBAD9CD81AB3F76A",
                "B7B824C51C44D75F\t88 - Lotuk\tnone\t88B8104E2454F85F"
        ));

        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());

        findPlaylist(list, "88B8104E2454F85F", "Archief", "folder", "BBAD9CD81AB3F76A");
        findPlaylist(list, "B7B824C51C44D75F", "88 - Lotuk", "none", "88B8104E2454F85F");
    }

    private void findPlaylist(List<PlaylistTO> list, String id, String name, String type, String parentId) {
        for (PlaylistTO playlist : list) {
            if (!id.equals(playlist.getId())) {
                continue;
            }

            Assert.assertEquals(name, playlist.getName());
            Assert.assertEquals(type, playlist.getType());
            Assert.assertEquals(parentId, playlist.getParentId());

            return;
        }

        Assert.fail("no playlist found with id " + id);
    }
}
