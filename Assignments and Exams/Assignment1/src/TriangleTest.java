import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class TriangleTest {

	public static void main(String[] args) {
		try { 
		Scanner kb = new Scanner (System.in);
		kb.useLocale(Locale.US);
		System.out.println("Choose \n1- Defualt triangle\n2- Custom triangle");
		int ch = kb.nextInt();
		if(ch==1) {
			Triangle DefTriangle = new Triangle();
			System.out.println(DefTriangle);}
		else {
		System.out.println("Enter the value of side1(in cm):");
		double side1 = kb.nextDouble();
		System.out.println("Enter the value of side2(in cm):");
		double side2 = kb.nextDouble();
		System.out.println("Enter the value of side3(in cm):");
		double side3 = kb.nextDouble();
		System.out.println("Enter the color of the triangle:");
		String color = kb.next();
		System.out.println("Is the triangle filled? (yes/no)");
		String isFilled = kb.next();
		boolean Filled;
		if (isFilled.trim().equalsIgnoreCase("NO"))
			Filled = false;
		else if(isFilled.trim().equalsIgnoreCase("YES")) 
			Filled = true;
		else throw new IllegalArgumentException(); 
		
		Triangle CostumTriangle = new Triangle(side1,side2,side3,color,Filled);
		System.out.println(CostumTriangle);
		}
		}catch(IllegalTriangleException e) {System.out.println(e);}
		catch(IllegalArgumentException es) {System.out.println("please enter a valid input!!");}
		catch(InputMismatchException ei) {System.out.println(ei+": please enter valid input!");}
		
	}

}
