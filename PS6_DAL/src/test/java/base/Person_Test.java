package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import domain.PersonDomainModel;

public class Person_Test {
	
	private static PersonDomainModel per1 = new PersonDomainModel();
	private static UUID perUUID1 = UUID.randomUUID();
	private static  LocalDate perbirth = LocalDate.of(1995, 12, 11);
	private static PersonDomainModel per2 = new PersonDomainModel();
	private static UUID perUUID2 = UUID.randomUUID();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		per1 = new PersonDomainModel();
		per2 = new PersonDomainModel();
		per1.setFirstName("Tianyi");
		per1.setLastName("Weng");
		per1.setBirthday(perbirth);
		per1.setCity("Newark");
		per1.setPostalCode(19711);
		per1.setStreet("Main st");
		per1.setPersonID(perUUID1);
		

		per2.setFirstName("Bingqing");
		per2.setLastName("Zhu");
		per2.setBirthday(perbirth);
		per2.setCity("Newark");
		per2.setPostalCode(19711);
		per2.setStreet("Main st");
		per2.setPersonID(perUUID2);
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		per1=null;
		per2=null;
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	
	}
	

	@Test
	public void testadd() throws Exception {
			PersonDAL.addPerson(per1);
	}

	@Test
	public void testget() throws Exception{
		if(PersonDAL.getPerson(perUUID1)==null){
			PersonDAL.addPerson(per1);
		}
		String LastName = per1.getLastName();
		assertEquals("Zhu",LastName);
	}
	
	@Test
	public void testupdate() throws Exception{
		if(PersonDAL.getPerson(perUUID2)==null){
			PersonDAL.addPerson(per2);
		}
		per2.setLastName("Weng");
		PersonDAL.updatePerson(per2);
		assertEquals(PersonDAL.getPerson(perUUID2).getLastName(),"Weng");

	}
	
	@Test
	public void TestDeletePerson() throws Exception{
		if(PersonDAL.getPerson(perUUID1)==null){
			PersonDAL.addPerson(per1);
		}
		PersonDAL.deletePerson(per1.getPersonID());

}
}