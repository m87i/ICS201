import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SumOfvalues {

	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("Assignment3.dat");
			DataInputStream dataInput = new DataInputStream(file);
			double Sum = sum(dataInput);
			dataInput.close();
			System.out.println("The sum is = "+ Sum);
		} catch (FileNotFoundException e) {
			System.out.println("File is not found!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static double sum(DataInputStream dataInput) throws IOException {
		if (dataInput.available()==0)
			return 0 ;
		else
		return dataInput.readDouble()+sum(dataInput);
		
	}

}
