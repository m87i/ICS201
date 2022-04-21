class Vehicle {
	private double maximum_peed ;
	private int number_of_wheels;
	
	public Vehicle() {
		
	}
	
	public Vehicle(double maximum_peed , int number_of_wheels) {
		this.maximum_peed=maximum_peed;
		this.number_of_wheels=number_of_wheels;
	}

	public Vehicle(int number_of_wheels ,double maximum_peed ) {
		this.maximum_peed=maximum_peed;
		this.number_of_wheels=number_of_wheels;
}
	
	public String toString() {
		return "\nthe vehicle's maximum speed: "+maximum_peed + " \nnumber of wheels: "+number_of_wheels; 
	}
} 

class Bicycle extends Vehicle {
	private int num_gears ; 
	private static  int bweals = 2;
	
	public Bicycle() {
		
	}
	public Bicycle(double maximum_peed ,  int num_gears ) {
		super(maximum_peed ,  bweals);
		this.num_gears=num_gears;
	}
	
	
	
	public String toString() {
		return super.toString()+" \n the number of gears on the bike: "+num_gears ; 
	}
}



public class Test1ProgrammingQ1 {

	public static void main(String[] args) {
		try {
		Vehicle[] v = new Vehicle[4];
		v[0] = new Vehicle(250.0 , 4);
		v[1] = new Vehicle(3 , 110.0);
		v[2] = new Bicycle(130.0 , 6);
		v[3] = new Bicycle(70.0 , 3);
		
		for(int i = 0 ; i<v.length ; i++) {
			System.out.println(v[i]);
		}
		
		} catch(Exception e) {System.out.println(e);}
	}

}
