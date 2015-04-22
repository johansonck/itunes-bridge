package be.sonck.itunes.impl.factory;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import be.sonck.itunes.impl.factory.PlaylistTOFactory;
import be.sonck.itunes.impl.model.PlaylistTO;


public class PlaylistTOFactoryTest {

	@Test
	public void test() {
		List<PlaylistTO> list = new PlaylistTOFactory().createList(
				"{\"88B8104E2454F85F	Archief	folder	BBAD9CD81AB3F76A\", \"B7B824C51C44D75F	88 - Lotuk	none	88B8104E2454F85F\"}");
		
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
		
		findPlaylist(list, "88B8104E2454F85F", "Archief", "folder", "BBAD9CD81AB3F76A");
		findPlaylist(list, "B7B824C51C44D75F", "88 - Lotuk", "none", "88B8104E2454F85F");
	}

	private void findPlaylist(List<PlaylistTO> list, String id, String name, String type, String parentId) {
		for (PlaylistTO playlist : list) {
			if (!id.equals(playlist.getId())) { continue; }
			
			Assert.assertEquals(name, playlist.getName());
			Assert.assertEquals(type, playlist.getType());
			Assert.assertEquals(parentId, playlist.getParentId());
			
			return;
		}
		
		Assert.fail("no playlist found with id " + id);
	}
}
