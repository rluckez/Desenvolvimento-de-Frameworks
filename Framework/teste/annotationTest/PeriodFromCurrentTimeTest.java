package annotationTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import annotation.PeriodFromCurrentTime;
import framework.Validator;

public class PeriodFromCurrentTimeTest {

	TestClass testClass;
	Validator validator;
	DateTime dateToManage;
	
	@Before
	public void init(){
		testClass = new TestClass();
		validator = new Validator();
		dateToManage = new DateTime();
	}
	
	public class TestClass{
		
		@PeriodFromCurrentTime(numberOfDays=1)
		private Date date;
		@PeriodFromCurrentTime(numberOfDays=1)
		private Calendar calendar;
		
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Calendar getCalendar() {
			return calendar;
		}
		public void setCalendar(Calendar calendar) {
			this.calendar = calendar;
		}

	}
	
	@Test
	public void testValidPeriodAsDateAndCalendar() {
		testClass.setDate(dateToManage.toDate());
		testClass.setCalendar(dateToManage.toCalendar(null));
		validator.validate(testClass);
		assertTrue(validator.isValid());
		assertEquals(0, validator.getErrors().size());
	}
	
	@Test
	public void testInvalidPeriodAsDateAndCalendar() {
		testClass.setDate(dateToManage.plusDays(5).toDate());
		testClass.setCalendar(dateToManage.plusDays(5).toCalendar(null));
		validator.validate(testClass);
		assertTrue(validator.isNotValid());
		assertEquals(2, validator.getErrors().size());
	}
	
	@Test
	public void testInvalidPeriodAsDate() {
		testClass.setDate(dateToManage.plusDays(3).toDate());
		testClass.setCalendar(dateToManage.toCalendar(null));
		validator.validate(testClass);
		assertTrue(validator.isNotValid());
		assertEquals(1, validator.getErrors().size());
	}
	
	@Test
	public void testInvalidPeriodAsCalendar() {
		testClass.setDate(dateToManage.toDate());
		testClass.setCalendar(dateToManage.plusDays(3).toCalendar(null));
		validator.validate(testClass);
		assertTrue(validator.isNotValid());
		assertEquals(1, validator.getErrors().size());
	}
	
	

}
