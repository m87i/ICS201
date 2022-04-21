import java.io.File;
import java.util.Scanner;

public class NumberOfFile {
	NumberOfFile (){
		System.out.println("cons");
	}
	
	void JUST(){
		System.out.println("Mehtod");
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("\r\n"
				+ ".___  ___.   ______    __  ___      ___       ___    ______  \r\n"
				+ "|   \\/   |  /  __  \\  |  |/  /     /   \\     / _ \\  |____  | \r\n"
				+ "|  \\  /  | |  |  |  | |  '  /     /  ^  \\   | (_) |     / /  \r\n"
				+ "|  |\\/|  | |  |  |  | |    <     /  /_\\  \\   > _ <     / /   \r\n"
				+ "|  |  |  | |  `--'  | |  .  \\   /  _____  \\ | (_) |   / /    \r\n"
				+ "|__|  |__|  \\______/  |__|\\__\\ /__/     \\__\\ \\___/   /_/     \r\n"
				+ "                                                             \r\n"
				+ "");
		System.out.println("Enter the path of the files: ");
		String Path = kb.nextLine();
		
		System.out.println("The number of files is: "+ getSize(new File (Path)));
		
		
	}
	
	public static long getSize(File file) {
		int NumFile = 0 ;
		if (file.isDirectory()) {
			 File[] files = file.listFiles(); 
			 for (int i = 0; files != null && i < files.length; i++) {
				 NumFile += getSize(files[i]); // Recursive call
			 }
			 
		} else { // Base case
				 NumFile++ ;
			 }
			
			 return NumFile;
	}

}




/*

  					___
		 _ __ ___  / _ \__
		| '_ ` _ \| | | |
		| | | | | | |_| |
		|_| |_| |_|\___/


 ▄▄       ▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄    ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ 
▐░░▌     ▐░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
▐░▌░▌   ▐░▐░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌ ▐░▌ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌
▐░▌▐░▌ ▐░▌▐░▌▐░▌       ▐░▌▐░▌▐░▌  ▐░▌       ▐░▌▐░▌       ▐░▌         ▐░▌ 
▐░▌ ▐░▐░▌ ▐░▌▐░▌       ▐░▌▐░▌░▌   ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌        ▐░▌  
▐░▌  ▐░▌  ▐░▌▐░▌       ▐░▌▐░░▌    ▐░░░░░░░░░░░▌ ▐░░░░░░░░░▌        ▐░▌   
▐░▌   ▀   ▐░▌▐░▌       ▐░▌▐░▌░▌   ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌      ▐░▌    
▐░▌       ▐░▌▐░▌       ▐░▌▐░▌▐░▌  ▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌     
▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▌ ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌    ▐░▌      
▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌   ▐░▌       
 ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀    ▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀     ▀     




*/