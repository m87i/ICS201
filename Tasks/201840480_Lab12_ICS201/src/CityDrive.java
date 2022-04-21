import java.util.Arrays;

public class CityDrive {

	public static void main(String[] args) {
		
		City [] C={new City("Jeddah", 35),new City("Khobar", 38),new City("Taif", 28),new City("Riyadh", 40),  };
			Arrays.sort(C);
			
			for(int i = 0 ; i<C.length ; i++)
				System.out.println(C[i]);
	}

}
