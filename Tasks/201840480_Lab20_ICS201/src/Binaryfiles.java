import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Binaryfiles {

	public static void main(String[] args)  {

		try {
			FileOutputStream To = new FileOutputStream("Lab20.txt");
			FileOutputStream Bo = new FileOutputStream("Lab20.dat");
			PrintWriter pw = new PrintWriter(To);
			Random r = new Random();
			int number ; 
			for (int i = 0 ; i< 1000000 ; i++) {
				number = r.nextInt(255);
				Bo.write(number);
				pw.println(number);
			}
			
			
			
			System.out.println("txt file: "+To.getChannel().size());
			System.out.println("dat file: "+Bo.getChannel().size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		} 
		
	}


