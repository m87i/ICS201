//import java.util.*;
//import java.io.*;
//public class Exp_HanTest {
//
//	public static void main(String[] args) throws FileNotFoundException {
//		File input = new File("FileTimes.txt");
//		Scanner rd= new Scanner(input);
//        PrintWriter pr = new PrintWriter("FileResult.txt");
//        pr.println("#\t24-hour\t12-hour \n ------------------------------------");
//        int line =0;
//		while(rd.hasNextLine()) {
//			try {
//				String x = rd.nextLine().trim();
//				line++;
//				if(x.charAt(2) != ':') {
//					throw new TimeException(line+"\t"+x+"\tTime Exception");
//				}
//				int hour1 ;
//				int min1;
//				if(x.length()==5) {
//					if(x.charAt(2)==':') {
//						 { if(Character.isDigit(x.charAt(0)) && Character.isDigit(x.charAt(1))&& Character.isDigit(x.charAt(3))&& Character.isDigit(x.charAt(4))) {
//							String hour = x.substring(0, 2);
//							String min = x.substring(3);
//							 hour1 = Integer.parseInt(hour);
//							 min1 = Integer.parseInt(min);
//							 if(hour1>= 24 || min1>=60 || hour1< 0 || min1<0) {
//									throw new TimeException(line+"\t"+x+"\tTime Exception");
//								}
//							if(hour1<24 && min1<60) {
//								if(hour1 == 0 && min1 <10) {
//									pr.println(line+"\t"+x+"\t12:0"+min1+" AM");
//								}
//								if(hour1 ==0 && min1>9 ) {
//									pr.println(line+"\t"+x+"\t12:"+min1+" AM");
//								}
//								if(hour1 <10 && min1 <10 && hour1>0) {
//									pr.println(line+"\t"+x+"\t0"+hour1+":0"+min1+" AM");	
//								}
//								if(hour1<10 && min1 >9 && hour1 >0) {
//									pr.println(line+"\t"+x+"\t12:"+min1+" AM");	
//								}
//								if(hour1 >9 && hour1<12 && min1<10) {
//									pr.println(line+"\t"+x+"\t"+hour1+":0"+min1+" AM");
//								}
//								if(hour1> 9 && hour1<12 && min1>9) {
//									pr.println(line+"\t"+x+"\t"+hour1+":"+min1+" AM");
//								}
//								if(hour1 < 22 && min1<10 && hour1>12) {
//									pr.println(line+"\t"+x+"\t0"+(hour1-12)+":0"+min1+"PM");
//								}
//								if(hour1 <22 && min1>9 && hour1>12) {
//									pr.println(line+"\t"+x+"\t0"+(hour1-12)+":"+min1+" PM");
//								}
//								if(hour1>21 && min1 <10) {
//									pr.println(line+"\t"+x+"\t"+(hour1-12)+":0"+min1+" PM");
//								}
//								if(hour1>21 && min1>9) {
//									pr.println(line+"\t"+x+"\t"+(hour1-12)+":"+min1+" PM");
//								}
//								if(hour1 == 12 && min1<10 ) {
//									pr.println(line+"\t"+x+"\t"+hour1+":0"+min1+" PM");}
//							if(hour1 == 12 && min1>9 ) {
//								pr.println(line+"\t"+x+"\t"+hour1+":"+min1+" PM");}
//							
//						}
//						}
//					 
//					}
//				}  if(!Character.isDigit(x.charAt(0)) || !Character.isDigit(x.charAt(1))|| !Character.isDigit(x.charAt(3))|| !Character.isDigit(x.charAt(4))) {
//					throw new TimeException(line+"\t"+x+"\tTime Exception");
//				}
//				
//				}else {throw new TimeException(line+"\t"+x+"\tTime Exception");}
//				}catch(TimeException e) {
//				pr.println(e);}
//		
//		}
//		pr.close();
//		rd.close();
//	}}
//
//
