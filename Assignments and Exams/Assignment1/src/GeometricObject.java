
public class GeometricObject {
private String color ;
private String filled ;

	public GeometricObject(String color , boolean filled) {
			this.color=color;
			if(filled)
			this.filled="Filled";
			else 
			this.filled="Not Filled";
		}
	
	public double getArea() {
		return 0;
		
	} 
	public double getPerimeter() {
		return 0;
		
	}
	
	
	public String toString() {
		return"The Color is: "+color+" and it's "+filled;
	}
	
}
