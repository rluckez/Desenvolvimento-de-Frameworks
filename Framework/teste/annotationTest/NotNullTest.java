package annotationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import annotation.NotNull;
import framework.Validator;

public class NotNullTest {

	TestClass testClass;
	Validator validator;
	
	@Before
	public void init(){
		testClass = new TestClass();
		validator = new Validator();
	}
	
	public class TestClass{
		@NotNull
		private String text;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}		
	}
	
	@Test
	public void testNullValidationOnNullField() {
		validator.validate(testClass);
		assertTrue(validator.isNotValid());
		assertEquals(1, validator.getErrors().size());
	}
	
	@Test
	public void testNullValidationOnNonNullField() {
		testClass.setText("Test");
		validator.validate(testClass);
		assertTrue(validator.isValid());
		assertEquals(0, validator.getErrors().size());
	}

}
