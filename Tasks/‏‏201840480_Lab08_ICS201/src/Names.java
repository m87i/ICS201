import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Names {

	public static void main(String[] args) {
		try {
		File file = new File ("NamesWithoutMod.txt");
		Scanner rd = new Scanner (file);
		int size=0 ;
		while(rd.hasNextLine()){
			rd.next();
			size++;
		}
		rd.close();
		String [] names = new String[size/2];
		
		Scanner rd1 = new Scanner(file);
		
		for (int i = 0 ; i<names.length ; i++) {
			String fName = rd1.next();
			String lName = rd1.next();
			names[i]= fName +" "+lName;
		}
	         
		FileOutputStream file1 = new FileOutputStream("NewNames.txt") ;
		PrintWriter pw = new PrintWriter(file1);
		
		Arrays.sort(names);
		
		for(int i = 0 ; i<names.length ; i++) {
			pw.println(names[i]);
		}
		rd1.close(); pw.close();
		} catch(FileNotFoundException e) {
			System.out.println("The file is not exist");
		}
		
		
		
		
	}

}
