
public class IllegalTriangleException extends Exception{
private  double side1, side2, side3;
	public IllegalTriangleException (double side1 , double side2 , double side3) {
		super("Please enter a valid values (the sum of any two sides should be greater than the other side!)\n"
				+ "your inputs are side1 = "+side1+" cm"+" side2 = "+side2+" cm"+" side3= "+side3+" cm");
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}
	

	
	

}
