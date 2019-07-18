package problemList;

public class ExtendTest {
	public static void main(String[] args) {
		Livingbeing a = new fish();
		a.getEnergy();
		
		fish b = (fish)a;
		//a.getEnergy();
		b.getEnergy();
		b.Energy();
	}
}
class Livingbeing{
	int energy;
	Livingbeing(int energy){
		this.energy = energy;
	}
	void getEnergy() {
		energy++;
	}
}
class animal extends Livingbeing{
	animal(){
		super(8);
	}
}
class fish extends animal{
	int x;
	fish(){
		x++;
	}
	public void Energy() {
		energy++;
		System.out.println(energy);
	}
}
