
public class Triangle extends GeometricObject {
private double a ;
private double b ; 
private double c ;

	public Triangle(double a, double b, double c, String color, boolean filled) {
		super(color, filled);
		this.a =a;
		this.b=b;
		this.c=c;
				
	}
	@Override
	public double getArea() {
		double S = (a + b + c) / 2;
		double area = Math.sqrt(S*(S-a)*(S-b)*(S-c));
		return area;
	}
	@Override
	public double getPerimeter() {
		double perimeter = a+b+c; 
		return perimeter;
	}
	
	public String toString() {
		return super.toString()+"\nside a = "+a+" side b = "+b+" side c = "+c;
	}

}
