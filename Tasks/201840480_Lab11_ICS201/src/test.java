
public class test {

	public static void main(String[] args) throws CloneNotSupportedException {
		Octagon oc = new Octagon(5);
		System.out.println("The Octagon area is: "+oc.getArea());
		System.out.println("The Octagon perimeter is: "+oc.getPerimeter());
		Octagon oc1 = oc.clone();
		int compare = oc.compareTo(oc1);
		if(compare ==0)
			System.out.println("The first octagon is equal to the second octagon");
		else if (compare==1) 
			System.out.println("The first octagon is greater than  the second octagon");
		else System.out.println("The first octagon is smaller than  the second octagon");
	}

}
