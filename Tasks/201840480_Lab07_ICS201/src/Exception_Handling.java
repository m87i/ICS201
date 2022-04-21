import java.util.InputMismatchException;
import java.util.Scanner;
public class Exception_Handling {
//Mohammed Alharthi
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		String[] months = {"January", "February", "March", "April", "May", "June", 
		        "July", "August", "September", "October", "November", "December"};
		int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		boolean c=true; int n ;
do {
	try {
	System.out.println("Enter the month number: ");
	 n = kb.nextInt();
	System.out.println("The month is "+months[n-1]+" and it contains "+dom[n-1]+" days");
	c=false;
	}
	catch(ArrayIndexOutOfBoundsException e) {System.out.println("Wrong! Please enter an integer between (1-12)");}
	catch(InputMismatchException ex) {System.out.println("Wrong! please enter an integer input."); kb.nextLine();
	 }
	
}while(c);

		
	}

}
