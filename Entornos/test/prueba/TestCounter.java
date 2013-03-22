package prueba;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCounter {

	private Counter c=new Counter();
	@Before
	
	public void setUp()
	{
		c.count();
	}
	
	
	@Test
	public void testGetResult() {
		assertEquals(c.getResult(),5050);
	}

}
