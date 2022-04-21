import java.util.*;
import java.io.*;
public class Exp_HandTest {

	public static void main(String[] args) throws FileNotFoundException {
		File input = new File ("FileTimes.txt");
		Scanner rd = new Scanner(input);
		File output = new File("FileResult.txt");
		PrintWriter pw = new PrintWriter(output);
		 pw.println("#\t24-hour\t12-hour \n Mohammed Alharthi \n ------------------------------------");
		
		int line = 0 ; boolean Check_isDigit = false ;
		while(rd.hasNextLine()) {
			try {
			String T = rd.nextLine().trim();
			line++;
			if(T.length()!=5) throw new TimeException(T , line);
				if(T.charAt(2)!=':') throw new TimeException(T , line);
					if (Character.isDigit(T.charAt(0))&&Character.isDigit(T.charAt(1))&&Character.isDigit(T.charAt(3))&&Character.isDigit(T.charAt(4))) {
						String H = T.substring(0, 2); Check_isDigit=true;
						String M = T.substring(3);
						int hour = Integer.parseInt(H);
						int min = Integer.parseInt(M);
						if(hour>= 24 || min>=60 || hour< 0 || min<0) throw new TimeException(T , line);
						if(hour<24 && min<60) {
							if(hour == 0 && min <10) {
								pw.println(line+"\t"+T+"\t12:0"+min+" AM");
							}
							else if(hour ==0 && min>9 ) {
								pw.println(line+"\t"+T+"\t12:"+min+" AM");
							}
							else if(hour <10 && hour>0 && min <10 ) {
								pw.println(line+"\t"+T+"\t0"+hour+":0"+min+" AM");	
							}
							 else if(hour<10 && hour >0 && min >9 ) {
								pw.println(line+"\t"+T+"\t12:"+min+" AM");	
							}
							 else if(hour >9 && hour<12 && min<10) {
								pw.println(line+"\t"+T+"\t"+hour+":0"+min+" AM");
							}
							 else if(hour> 9 && hour<12 && min>9) {
								pw.println(line+"\t"+T+"\t"+hour+":"+min+" AM");
							}
							 else if(hour < 22 && min<10 && hour>12) {
								pw.println(line+"\t"+T+"\t0"+(hour-12)+":0"+min+"PM");
							}
							 else if(hour <22 && min>9 && hour>12) {
								pw.println(line+"\t"+T+"\t0"+(hour-12)+":"+min+" PM");
							}
							 else if(hour>21 && min <10) {
								pw.println(line+"\t"+T+"\t"+(hour-12)+":0"+min+" PM");
							}
							 else if(hour>21 && min>9) {
								pw.println(line+"\t"+T+"\t"+(hour-12)+":"+min+" PM");
							}
							 else if(hour == 12 && min<10 ) {
								pw.println(line+"\t"+T+"\t"+hour+":0"+min+" PM");}
							 else if(hour == 12 && min>9 ) {
							pw.println(line+"\t"+T+"\t"+hour+":"+min+" PM");}	
					}
						}else if(Check_isDigit==false) throw new TimeException(T , line);  
						 else {throw new TimeException(T , line);}
			}catch(TimeException e) {pw.println(e);}
			} rd.close(); pw.close();
		
	
	
	
	}}


