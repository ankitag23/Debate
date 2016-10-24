package Elec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Elec_Result {
	public static final int MAX_NUM_VOTES= 2;
	private int num_of_for;
	private int num_of_aga;
	private String result;
	private String open_time;
	private String close_time;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	ArrayList<Voters> arr_vtr = new ArrayList<Voters>();
public Elec_Result()
{
	num_of_for=0;
	num_of_aga=0;
	result="Not Decided";
	open_time="";
	close_time="";
	
}
public Elec_Result(int inp_num_for,int inp_num_agn,String rs,String op_tm,String cl_tm)
{
	num_of_for=inp_num_for;
	num_of_aga=inp_num_agn;
	result=rs;
	open_time=op_tm;
	close_time=cl_tm;
}
public String getOpen_time() {
	return open_time;
}
public void setElection_time() {
	
	Calendar cal = Calendar.getInstance();
	this.open_time=dateFormat.format(cal.getTime());
	
	cal.add(Calendar.DATE, 1);
	
	this.close_time=dateFormat.format(cal.getTime());
}
public String getClose_time() {
	return close_time;
}

public String getResult() {
	return result;
}
public void setResult() {
	if(num_of_for > num_of_aga)
		result = "PASSED";
	else  if(num_of_for ==  num_of_aga)
		result = "TIED";
	else
		result = "FAILED";
}
public int getNum_of_for() {
	return num_of_for;
}
public void setNum_of_for(int num_of_for) {
	this.num_of_for = num_of_for;
}
public int getNum_of_aga() {
	return num_of_aga;
}
public void setNum_of_aga(int num_of_aga) {
	this.num_of_aga = num_of_aga;
}
public boolean Count_Votes_Lmt_Reached(String choice)
{
	if (choice.equals( "Yeas"))
		setNum_of_for(++num_of_for);
	else
		setNum_of_aga(++num_of_aga);
	if((num_of_for + num_of_aga) >= MAX_NUM_VOTES)
	{
		return true;
	}
	return false;
}
public void add_voters(Voters vt)
{
	if(!arr_vtr.contains(vt))
	arr_vtr.add(vt);
}
@Override
public String toString()
{
	return  " motions is : " + getResult() + "\n"
			+" Number of Votes For Motion :  " + getNum_of_for() + "\n"
			+" Number of Votes Against Motion :  " + getNum_of_aga() + "\n"
			+"Time when Voting Opened :  " + getOpen_time() + "\n"
			+"Time when Voting Closed :  " + getClose_time() + "\n";
}
}


