package be.sonck.itunes.interpreter;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListInterpreterTest {

	@Test
	public void testSplitSimpleValues() {
		List<String> list = new ListInterpreter().interpret("{123, 456, 789}");
		
		Assert.assertNotNull(list);
		Assert.assertEquals(3, list.size());

		findValue(list, "123");
		findValue(list, "456");
		findValue(list, "789");
	}
	
	@Test
	public void testSplitStringValues() {
		List<String> list = new ListInterpreter().interpret("{\"123\", \"456\", \"789\"}");
		
		Assert.assertNotNull(list);
		Assert.assertEquals(3, list.size());
		
		findValue(list, "\"123\"");
		findValue(list, "\"456\"");
		findValue(list, "\"789\"");
	}
	
	@Test
	public void testSplitListValues() {
		List<String> list = new ListInterpreter().interpret("{{123, 456}, {456, 789}, {789, 123}}");
		
		Assert.assertNotNull(list);
		Assert.assertEquals(3, list.size());
		
		findValue(list, "{123, 456}");
		findValue(list, "{456, 789}");
		findValue(list, "{789, 123}");
	}
	
	@Test
	public void testSplitMixedValues() {
		List<String> list = new ListInterpreter().interpret("{{123, 456}, 789, \"123\"}");
		
		Assert.assertNotNull(list);
		Assert.assertEquals(3, list.size());
		
		findValue(list, "{123, 456}");
		findValue(list, "789");
		findValue(list, "\"123\"");
	}

	private void findValue(List<String> list, String string) {
		for (String entry : list) {
			if (entry.equals(string)) { return; }
		}
		
		Assert.fail("no entry '" + string + "' could be found");
	}
}
