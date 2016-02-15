package be.sonck.itunes.bridge.interpreter;

import be.sonck.itunes.bridge.BasicSpringTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StringListInterpreterTest extends BasicSpringTest {

	@Autowired
    private StringListInterpreter interpreter;

	@Test
	public void test() {
		String value = "\"2B205008870E001D	91 - All Hope Is Gone	none	88B8104E2454F85F\"";
		List<String> list = interpreter.interpret(value);
		
		Assert.assertNotNull(list);
		Assert.assertEquals(4, list.size());
		
		Assert.assertTrue(list.contains("2B205008870E001D"));
		Assert.assertTrue(list.contains("91 - All Hope Is Gone"));
		Assert.assertTrue(list.contains("none"));
		Assert.assertTrue(list.contains("88B8104E2454F85F"));
	}
	
	@Test
	public void testEmptyValue() {
		String value = "\"2B205008870E001D	91 - All Hope Is Gone	none	\"";
		List<String> list = interpreter.interpret(value);
		
		Assert.assertNotNull(list);
		Assert.assertEquals(4, list.size());
		
		Assert.assertTrue(list.contains("2B205008870E001D"));
		Assert.assertTrue(list.contains("91 - All Hope Is Gone"));
		Assert.assertTrue(list.contains("none"));
	}
}
