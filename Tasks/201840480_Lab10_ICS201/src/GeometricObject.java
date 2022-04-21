
public abstract class GeometricObject {
private String color ;
private String filled ;

	public GeometricObject(String color , boolean filled) {
		this.color=color;
		if(filled)
		this.filled="Filled";
		else 
		this.filled="NotFilled";
	}
	
	public abstract double getArea() ;
	public abstract double getPerimeter();

	
	public String toString() {
		return"The color is: "+color+" and it's "+filled;
	};
}
