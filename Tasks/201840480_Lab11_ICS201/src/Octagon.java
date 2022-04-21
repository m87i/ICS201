
public class Octagon extends GeometricObject implements Comparable<Octagon> , Cloneable  {
private double side;
	
	

	
	public Octagon(double side) {
		this.side=side;
	}

	@Override
	public double getArea() {
		
		return (2+(4/Math.sqrt(2)))*side*side;
	}

	@Override
	public double getPerimeter() {
		return side*8;
	}
	
	
	public double getSide() {
		return side;
	}
	
	
	
	
	
	public int compareTo(Octagon oc) {
		if(getArea() > oc.getArea())
			return 1;
		else if (getArea() == oc.getArea())
			return 0 ;
		else return -1;
	}
	
	public Octagon clone() throws CloneNotSupportedException {
		
	return (Octagon) super.clone();
		
	}


	
	
}
