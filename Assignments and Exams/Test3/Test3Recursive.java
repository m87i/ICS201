import java.util.Scanner;

public class Test3Recursive {
	private static int MAXvalue=0;
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter # of elements");
		int x = kb.nextInt();
		int [] intArray = new int[x];
		for(int i = 0 ; i<intArray.length ; i++) {
			System.out.println("Enter the value of indx"+i+" :");
			intArray[i] = kb.nextInt();
		}
		int y = 0 ;
		System.out.println(MaxV(intArray , y ));
		
		
		

	}
	
	public static int MaxV(int [] array , int y) {
		if (y < array.length-1)
		{
			if (array[y] > MAXvalue ) {
				MAXvalue = array[y];
			}
			MaxV(array , y+1);
		}
		return MAXvalue;}

}
