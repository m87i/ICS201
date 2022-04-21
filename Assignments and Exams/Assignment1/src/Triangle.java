
public class Triangle extends GeometricObject {
private double side1 , side2, side3;

	public Triangle () {
//	Default color is white and it's Not Filled. 
		super("White", false);
		this.side1=1;
		this.side2=1;
		this.side3=1;
}

	public Triangle(double side1 , double side2 , double side3 , String color , boolean filled) throws IllegalTriangleException {
		super(color , filled);
		if (side1+side2<=side3 | side1+side3<=side2 | side2+side3<=side1  )
		throw new IllegalTriangleException(side1,side2,side3);
		else {
			this.side1 = side1 ;
			this.side2 = side2 ;
			this.side3 = side3 ;
	} 
}

	public double getSide1() {
	return side1;
}

	public void setSide1(double side1) {
	this.side1 = side1;
}

	public double getSide2() {
	return side2;
}

	public void setSide2(double side2) {
	this.side2 = side2;
}

	public double getSide3() {
	return side3;
}

	public void setSide3(double side3) {
	this.side3 = side3;
}

@Override
	public double getArea() {
	double S = (getSide1() + getSide2() + getSide3())/2 ;
	return Math.sqrt(S * (S-getSide1()) * (S-getSide2()) * (S-getSide3()));
}

@Override
	public double getPerimeter() {
		
	return getSide1() + getSide2() + getSide3();
}

	public String toString() {
		return "The Area of the triangle = "+getArea()+" cm^2\nThe parameter of the triangle = "+getPerimeter()+" cm\n"+super.toString() ;
	}
	//unfortunately String.format return ???? in the output, so I put it here as a comment.
	//you can check and see the problem in this URL https://k.top4top.io/p_1758e69eh1.png 	
//String.format("The Area of the triangle = %.2f %nThe parameter of the triangle = %.2f %n%s", getArea(),getPerimeter(),super.toString());

}
