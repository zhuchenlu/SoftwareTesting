package cn.tju.scs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CaculatorTest {
	private static Caculator caculator = new Caculator();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsTriangle() {
		assertEquals(-1,caculator.isTriangle(1,5,7));//不是三角形
		assertEquals(0,caculator.isTriangle(3,4,5));//直角三角形
		assertEquals(1,caculator.isTriangle(5,5,5));//等边三角形
		assertEquals(2,caculator.isTriangle(5,5,6));//等腰三角形
		assertEquals(3,caculator.isTriangle(4,5,6));//普通三角形
	}

}
