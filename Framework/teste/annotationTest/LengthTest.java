package annotationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import annotation.IntRange;
import annotation.Length;
import framework.Validator;

public class LengthTest {

	TestClass testClass;
	Validator validator;
	
	@Before
	public void init(){
		testClass = new TestClass();
		validator = new Validator();
	}
	
	public class TestClass{
		
		@Length(min=5, max=10)
		private String text;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	}
	
	@Test
	public void testEmptyString() {
		testClass.setText("");
		validator.validate(testClass);
		assertTrue(validator.isNotValid());
		assertEquals(1, validator.getErrors().size());
	}
	
	@Test
	public void testNotValidMinLength() {
		testClass.setText("1234");
		validator.validate(testClass);
		assertTrue(validator.isNotValid());
		assertEquals(1, validator.getErrors().size());
	}
	
	@Test
	public void testNotValidMaxLength() {
		testClass.setText("12345678910");
		validator.validate(testClass);
		assertTrue(validator.isNotValid());
		assertEquals(1, validator.getErrors().size());
	}
	
	@Test
	public void testValidLength() {
		testClass.setText("1234567");
		validator.validate(testClass);
		assertTrue(validator.isValid());
		assertEquals(0, validator.getErrors().size());
	}

}
