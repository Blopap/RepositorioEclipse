package calcular;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculations {
	
	private Calculation cal=new Calculation();
	
	@Test
	public void testAdd() {
		assertEquals(cal.add(20,5),25);
	}
	@Test
	public void testSubtract() {
		assertEquals(cal.subtract(20,5),15);
	}

	@Test
	public void testMultiply() {
		assertEquals(cal.multiply(20,5),100);
	}

	@Test
	public void testDivide() {
		assertEquals(cal.divide(20,5),4);
	}

}
