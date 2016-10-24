package Elec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Election_Day {

	public static void main(String[] args) {
		
		Elec_Result res = new Elec_Result();
		res.setElection_time();
		String Motion_Open_time = "2016/10/23 12:00:00";

		 DateFormat MotionFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
		 boolean voting_lmt_reached =false; 
		 

		System.out.println("*------------------------------------*");
		System.out.println("*--------Welcome to Election day ----*");
		System.out.println("*------------------------------------*");

		Scanner scn1 = new Scanner(System.in);
		while (true)
		{
			if (Motion_Open_time.compareTo(MotionFormat.format(Calendar.getInstance().getTime())) < 1)
			{
				System.out.println("Voting System is  open to Vote for Motion \n");
				break;
			} 
			else
			{
				System.out.println("Current Tume is " + MotionFormat.format(Calendar.getInstance().getTime()));
				System.out.println("Voting System is not up , It will  be opened by "+ Motion_Open_time);
				System.exit(0);
			}
		}
		while (true)
		{
			Voters vt = new Voters();
			try
			{
				Boolean allowed = voter_input(vt,res.getResult());
				if (allowed == true) 
				{
						res.add_voters(vt);
						System.out.println("Enter Yeas and Nays  for Debate :");
						String choice = scn1.next();
						voting_lmt_reached=res.Count_Votes_Lmt_Reached(choice);
						
						if(voting_lmt_reached == true)
							break;
						Date dt1 = new Date();
						
						if (dateFormat1.format(dt1).compareTo(res.getClose_time()) > 1)
							break;
				}
			} 
			catch (InputMismatchException ee) 
			{
				System.out.println("Input type is not correct , Please reenter");
			}
		}
		res.setResult();

		if (res.getResult() == "TIED")
		{
			System.out.println("Vice President Vote Needed to decide \n Are you Vice President Y/N ");

			Voters vt = new Voters();
			Boolean  allowed = voter_input(vt,res.getResult());
			if (allowed == true)
			{
				System.out.println("Enter Yeas and Nays  for Debate :");
				String choice = scn1.next();
				voting_lmt_reached=res.Count_Votes_Lmt_Reached(choice);
				res.add_voters(vt);
				res.setResult();
			}

		}
		
		System.out.println("Result is  \n" + res);
		scn1.close();
	}

	public static Boolean voter_input(Voters vt,String reslt)
	{
		try
		{
			Scanner scn = new Scanner(System.in);
			int age;
			System.out.println("Enter Your Name :");
			String name = scn.nextLine();
	
			while (!vt.setName(name)) 
			{
				System.out.println("Renter Your Name :");
				name = scn.nextLine();
			}
			
			System.out.println("Enter Your Driving License :");
			String DL = scn.next();
			vt.setDl_Id(DL);
			while (!(vt.setDl_Id(DL)))
			{
				System.out.println("Your Dl is not Valid ,Please ReEnter Your Driving License :");
				DL = scn.next();
			}
			
	
			System.out.println("Enter Your Age :");
	
			while (!scn.hasNextInt()) {
				String input = scn.next();
				System.out.println(input + " is not a valid number Please ReEnter");
			}
			age = scn.nextInt();
			if (! vt.set_valid_Age(age)) {
				System.out.println("You are not allowed to Vote ");
				return false;
			}
			
			System.out.println("Are you Vice President Y/N ");
			String Ch = scn.next();
			if (Ch.equals("Y") && !(reslt.equals("TIED")))
			{
				System.out.println("You are not allowed to Vote ");
				return false;
			}
			vt.set_designation(Ch);
			return true;
		}
		catch(NoSuchElementException ee)
		{
			System.out.println(ee.toString());
			return false;
		}
	}

}
