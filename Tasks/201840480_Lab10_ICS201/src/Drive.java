import java.util.Scanner;
public class Drive {
//Mohammed Alharthi
	public static void main(String[] args) {
		try {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter 3 values of the sides  ");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		double c = kb.nextDouble();
		if(a+b<=c || b+c<=a ||a+c<=b ) {
			throw new IllegalArgumentException();
		} 
		System.out.println("Enter the color of the triangle: ");
		String color = kb.next();
		System.out.println("Is it filled? answer with (true or false) ");
		boolean filled = kb.nextBoolean();
		
		Triangle triangle = new Triangle(a,b,c,color,filled);
		
		System.out.println("The area of the triangel = "+triangle.getArea()+"\nThe area of the triangel = "+triangle.getPerimeter());
		System.out.println(triangle);
		}catch(IllegalArgumentException e) {
			System.out.println("Please enter valid values ");
		} catch(Exception e) {System.out.println("Enter valid value!");}
	}

}
