import java.util.Scanner;

public class RecursionDrive {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String str = kb.next(); 
		System.out.println("Enter a Character: ");
		char a = kb.next().charAt(0);
		
		System.out.println("\n# of occurrences of character "+a+" on count1 is: "+count1(str,a));
		System.out.println("# of occurrences of character "+a+" on count2 is: "+count2(str,a));
		
		
	}
	
	
	public static int count1(String str, char a) {
		if(str.length() == 0) 
			return 0 ; 
		else if (str.charAt(0)==a)
			return 1 + count1(str.substring(1),a);
		else
			return count1(str.substring(1),a);
		
	}
	
	public static int count2(String str, char a){
   return count2(str,a,0);
	}
	
	public static int count2(String str, char a,int index) {
		if (index == str.length())
			return 0 ;
		else if (str.charAt(index)==a)
			return 1 + count2(str, a, index+1);
		else 
			return count2(str, a, index+1);
	}


}
