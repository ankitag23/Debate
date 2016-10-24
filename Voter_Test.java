package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Elec.Voters;

public class Voter_Test {

	@Test
	public void Voters_age_Fail() {
		Voters vt = new Voters();
		assertEquals(false,vt.set_valid_Age(17));
	}
	@Test
	public void Voters_age_Pass() {
		Voters vt = new Voters();
		assertEquals(true,vt.set_valid_Age(19));
	}
	@Test
	public void Voters_name_Pass() {
		Voters vt = new Voters();
		assertEquals(true,vt.setName("JOHN"));
	}
	@Test
	public void Voters_name_Fail() {
		Voters vt = new Voters();
		assertEquals(false,vt.setName("_JOHN"));
		assertEquals(false,vt.setName("1"));
		assertEquals(false,vt.setName(""));
	}
	@Test
	public void Voters_DL_Pass() {
		Voters vt = new Voters();
		assertEquals(true,vt.setDl_Id("5237652854243"));
		assertEquals(true,vt.setDl_Id("adfsa76876543"));
		assertEquals(true,vt.setDl_Id("ufuieriwyq"));
	}
	@Test
	public void Voters_DL_Fail() {
		Voters vt = new Voters();
		assertEquals(false,vt.setDl_Id("42552"));
		assertEquals(false,vt.setDl_Id(""));
		assertEquals(false,vt.setDl_Id("456321"));
	}
}
