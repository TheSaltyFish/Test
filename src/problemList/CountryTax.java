package problemList;

public class CountryTax {
	public static void main(String[] args) 
	{
		new JapanTax(99).printinfor();
	}
}
abstract class User{
	int tax;
	void printinfor()
	{
		System.out.println(tax);
	}
}
interface Tax{
	
}
class JapanTax extends User implements Tax{
	JapanTax(int tax)
	{
		this.tax = tax;
	}
}