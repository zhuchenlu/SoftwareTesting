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
		assertEquals(-1,caculator.isTriangle(1,5,7));//����������
		assertEquals(0,caculator.isTriangle(3,4,5));//ֱ��������
		assertEquals(1,caculator.isTriangle(5,5,5));//�ȱ�������
		assertEquals(2,caculator.isTriangle(5,5,6));//����������
		assertEquals(3,caculator.isTriangle(4,5,6));//��ͨ������
	}

}
