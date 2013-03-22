/**
 * 
 */
package JuegoCartas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import prueba.Counter;

/**
 * @author Pablo Blopap
 *
 */
public class JUnitTest {

	/**
	 * Test method for 
	 * {@link JuegoCartas.Baraja#numCartas()}.
	 */
	private Baraja b=new Baraja();

	@Test
	public void testNumCartas() {
		assertEquals(b.numCartas(),16);
	}
}


