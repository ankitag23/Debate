package Elec;

public class Voters extends Voters_Desig{
private String name;
private String dl_Id;
private int age;

public Voters()
{
	name="";
	dl_Id="";
	age=0;
	
}

public Voters(String nm,String dl,int age_in)
{
	name=nm;
	dl_Id=dl;
	age_in=age;
	
}
public String getName() {
	return name;
}
public boolean setName(String name) {
	
	if(name.matches("^[a-zA-Z].*"))
	{
		this.name = name;
		return true;
	}
	else
	{
		return false;
	}
}
public String getDl_Id() {
	return dl_Id;
}
public boolean setDl_Id(String dl_Id) {
	if(dl_Id.length() >= 7)
	{
		this.dl_Id = dl_Id;
		return true;
	}
	else
		return false;
}
public int getAge() {
	return age;
}
public boolean set_valid_Age(int age) {
	if(age > 18)
	{
		this.age = age;
		return true;
	}
	else
		return false;
}
public void set_designation(String Ch)
{
	if(Ch.equals("Y"))
		designation="Vice President";
	else
		designation= "Other Memebers";
	
}


}
