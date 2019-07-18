package problemList;

public class Stu {
	public static void main(String[] args) {
		student Lizer = new student("Lizer","20185304","Èí¼þ",-1);
		student Huangzhi = new student("Huangzhi","20185062","Èí¼þ",-2);
		double GPA1 = Lizer.GetGPA();
		System.out.println(GPA1);
		double GPA2 = Huangzhi.GetGPA();
		System.out.println(GPA2);
	}
}
class student{
	String name;
	String ID;
	String Major;
	double GPA;
	student(String name, String ID, String Major,double GPA){
		this.name = name;
		this.ID = ID;
		this.Major = Major;
		this.GPA = GPA;
	}
	public double GetGPA() {
		return GPA;
	}
	public String GetMajor() {
		return Major;
	}
}