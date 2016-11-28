package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DerivativeTest {
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDerivative() {
	Derivative derivative = new Derivative("3","x");
	String tmp = derivative.Result();
	assertEquals(tmp,"0");
    }

    @Test
    public void testDerivative1() {
	Derivative derivative = new Derivative("3*x","x");
	String tmp = derivative.Result();
	assertEquals(tmp,"3");
    }
    @Test
    public void testDerivative2() {
	Derivative derivative = new Derivative("3*x+2*y","x");
	String tmp = derivative.Result();
	assertEquals(tmp,"3");
    }
    @Test
    public void testDerivative3() {
	Derivative derivative = new Derivative("3*x-2*y+3","y");
	String tmp = derivative.Result();
	assertEquals(tmp,"-2");
    }
    @Test
    public void testDerivative4() {
	Derivative derivative = new Derivative("3*x*x*z+2*y*y","x");
	String tmp = derivative.Result();
	assertEquals(tmp,"6*z*x");
    }
    @Test
    public void testDerivative5() {
	Derivative derivative = new Derivative("3*letters","letters");
	String tmp = derivative.Result();
	assertEquals(tmp,"3");
    }
    @Test
    public void testDerivative6() {
	Derivative derivative = new Derivative("3*letters+2*hello","letters");
	String tmp = derivative.Result();
	assertEquals(tmp,"3");
    }
    @Test
    public void testDerivative7() {
	Derivative derivative = new Derivative("3*letters+2*hello+4","letters");
	String tmp = derivative.Result();
	assertEquals(tmp,"3");
    }
    @Test
    public void testDerivative8() {
	Derivative derivative = new Derivative("3*letters*letters*z+2*hello+4","letters");
	String tmp = derivative.Result();
	assertEquals(tmp,"6*z*letters");
    }
    @Test
    public void testDerivative9() {
	Derivative derivative = new Derivative("3*letters*letters+2*hello+4","outofletter");
	String tmp = derivative.Result();
	assertEquals(tmp,"inputError");
    }
    @Test
    public void testDerivative10() {
	Derivative derivative = new Derivative("3*letters*letters+2*hello+4","+");
	String tmp = derivative.Result();
	assertEquals(tmp,"inputError");
    }
    @Test
    public void testDerivative11() {
	Derivative derivative = new Derivative("3*letters*letters+2*hello+4","3");
	String tmp = derivative.Result();
	assertEquals(tmp,"inputError");
    }
   

}
