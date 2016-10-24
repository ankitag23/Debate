package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Elec.Elec_Result;

public class Election_DayTest {

	@Test
	public void Result_Test_Failed() {
		//fail("Not yet implemented");
		Elec_Result er=new Elec_Result();
		er.setNum_of_aga(46);
		er.setNum_of_for(45);
		er.setResult();
		
		assertEquals("FAILED",er.getResult());
	}
		
	@Test
	public void Result_Test_Passes() {
		//fail("Not yet implemented");
		Elec_Result er=new Elec_Result();
			
		er.setNum_of_aga(34);
		er.setNum_of_for(45);
		er.setResult();
		assertEquals("PASSED",er.getResult());
	}
	@Test
	public void Result_Test_Tied() {
		
		Elec_Result er=new Elec_Result();
			
		er.setNum_of_aga(45);
		er.setNum_of_for(45);
		er.setResult();
		assertEquals("TIED",er.getResult());
	}
	@Test
	public void Count_All_For_Vote() {
		
		Elec_Result er=new Elec_Result();
			
		er.Count_Votes_Lmt_Reached("Yeas");
		er.Count_Votes_Lmt_Reached("Yeas");
		er.Count_Votes_Lmt_Reached("Yeas");
		
		assertEquals(3,er.getNum_of_for());
	}
	@Test
	public void Count_All_Against_Vote() {
		
		Elec_Result er=new Elec_Result();
			
		er.Count_Votes_Lmt_Reached("Nays");
		er.Count_Votes_Lmt_Reached("Nays");
		er.Count_Votes_Lmt_Reached("Nays");
		
		assertEquals(3,er.getNum_of_aga());
	}
	@Test
	public void Count_For_Against_Vote() {
		
		Elec_Result er=new Elec_Result();
			
		er.Count_Votes_Lmt_Reached("Nays");
		er.Count_Votes_Lmt_Reached("Nays");
		er.Count_Votes_Lmt_Reached("Nays");
		er.Count_Votes_Lmt_Reached("Yeas");
		er.Count_Votes_Lmt_Reached("Yeas");
		er.Count_Votes_Lmt_Reached("Yeas");
		
		assertEquals(3,er.getNum_of_aga());
		assertEquals(3,er.getNum_of_for());
	}
}
