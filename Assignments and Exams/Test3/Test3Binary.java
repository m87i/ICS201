import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test3Binary {
	
	private static double sum=0;
	private static int numOfL=0;
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("Test3Binary.dat");
			DataInputStream input = new DataInputStream(file);
			String s ;

			while (input.available()!=0) {
				s= input.readUTF();
			 if (s.equals("A+")) {
					sum+=4;
					numOfL++;
				}else if (s.equals("A")) {
					sum+=3.75;
					numOfL++;
				}else if (s.equals("B+")) {
					sum+=3.5;
					numOfL++;
				}else if (s.equals("B")) {
					sum+=3;
					numOfL++;
				}else if (s.equals("C+")) {
					sum+=2.5;
					numOfL++;
				}else if (s.equals("C")) {
					sum+=2;
					numOfL++;
				}else if (s.equals("D+")) {
					sum+=1.5;
					numOfL++;
				}else if (s.equals("D")) {
					sum+=1;
					numOfL++;
				}else if (s.equals("F")) {
					sum+=0;
					numOfL++;
				}
			}
			input.close();
			double GPA = sum/numOfL;
			System.out.println("GPA = "+ GPA );
			
				
			
			
			
				
			
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
