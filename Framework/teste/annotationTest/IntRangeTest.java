package annotationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import annotation.IntRange;
import framework.Validator;

public class IntRangeTest {

	TestClass testClass;
	Validator validator;
	
	@Before
	public void init(){
		testClass = new TestClass();
		validator = new Validator();
	}
	
	public class TestClass{
		
		@IntRange(min=5, max=10)
		private int intNumber;

		public int getIntNumber() {
			return intNumber;
		}

		public void setIntNumber(int intNumber) {
			this.intNumber = intNumber;
		}

	}
	
	@Test
	public void testNotValidMinRange() {
		testClass.setIntNumber(4);
		validator.validate(testClass);
		assertTrue(validator.isNotValid());
		assertEquals(1, validator.getErrors().size());
	}
	
	@Test
	public void testNotValidMaxRange() {
		testClass.setIntNumber(11);
		validator.validate(testClass);
		assertTrue(validator.isNotValid());
		assertEquals(1, validator.getErrors().size());
	}
	
	@Test
	public void testValidRange() {
		testClass.setIntNumber(8);
		validator.validate(testClass);
		assertTrue(validator.isValid());
		assertEquals(0, validator.getErrors().size());
	}

}
