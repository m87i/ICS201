import java.util.ArrayList;

public class Test1ProgrammingQ2 {

	public static void main(String[] args) {
		try {
		ArrayList <Integer> list1 = new ArrayList<>();
		list1.add(2);list1.add(3);list1.add(1);list1.add(5);
		ArrayList <Integer> list2 = new ArrayList<>();
		list2.add(2);list2.add(3);list2.add(1);list2.add(5);list2.add(4);list2.add(6);
		System.out.println(union(list1,list2));
		} catch(Exception e) {System.out.println(e);}
		
	}
	
	public static ArrayList<Integer> union( ArrayList<Integer> list1, ArrayList<Integer> list2){
		ArrayList <Integer> t = new ArrayList<>();
		for(int i = 0 ; i<list1.size() ; i++) {
			if(!t.contains(list1.get(i))) t.add(list1.get(i));
		}
		for(int i = 0 ; i<list2.size() ; i++) {
			if(!t.contains(list2.get(i))) t.add(list2.get(i));
		}
		
		return t;
		
	}

}
