import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class StudentDrive {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("Mohammed", 20181235 , 3.5));
		list.add(new Student("Ali", 20189932 , 2.9));
		list.add(new Student("Khalid", 20183434 , 3.2));
		list.add(new Student("Hamad", 20181453 , 3.4));
		list.add(new Student("Mohamood", 20181123 , 2.7));
		
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Student.dat"));
			output.writeObject(list);
			output.close();
			
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Student.dat"));
			ArrayList<Student> list1 = (ArrayList<Student>) (input.readObject());
			for(int i = 0  ;  i<list.size() ; i++ )
				System.out.println(list1.get(i));
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Student  implements Serializable {
	private String Name;
	private int ID;
	private double GPA;
	
	public Student(String Name , int ID , double GPA){
		this.Name=Name;
		this.ID=ID;
		this.GPA=GPA;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double GPA) {
		GPA = GPA;
	}
	
	public String toString() {
		return "Name: "+ getName()+"\tID: "+getID()+"\tGPA: "+getGPA();
		
	}
	
	
}
