package view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import view.function;

public class functionTest {
	private static function fun=new function();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExpression1() {
		String str;
		str=fun.expression("+12");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression2() {
		String str;
		str=fun.expression("£¡x");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression3() {
		String str;
		str=fun.expression("£º3*y");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression4() {
		String str;
		str=fun.expression("^123");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression5() {
		String str;
		str=fun.expression("~23*x");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression6() {
		String str;
		str=fun.expression("");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression7() {
		String str;
		str=fun.expression("1_x");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression8() {
		String str;
		str=fun.expression("  _x");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression9() {
		String str;
		str=fun.expression(" 	_x");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression10() {
		String str;
		str=fun.expression("1^1");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression11() {
		String str;
		str=fun.expression("X^x");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression12() {
		String str;
		str=fun.expression("1_^x");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression13() {
		String str;
		str=fun.expression("1*x^_");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression14() {
		String str;
		str=fun.expression("x^1+_3");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression15() {
		String str;
		str=fun.expression("12*x");
		assertEquals("12*x",str);
	}
	@Test
	public void testExpression16() {
		String str;
		str=fun.expression(" 	x^2+9x");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression17() {
		String str;
		str=fun.expression(" 	x^2+x9");
		assertEquals("fail!",str);
	}
	@Test
	public void testExpression18() {
		String str;
		str=fun.expression(" 	x ^2+9*x-3");
		assertEquals("x^2+9*x-3",str);
	}

}
