import java.util.ArrayList;

public class GenericDrive {

	public static void main(String[] args) {
		GenericQueue<String> q = new GenericQueue();
		
		q.add("X");
		q.add("Y");
		q.add("Z");
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}

}

class GenericQueue<E> {
	private ArrayList<E> queue = new ArrayList<E>();
	
	public void add (E o) {
		queue.add(o);
	}
	
	public E remove () {
		if (queue.isEmpty())
			return null ;
		 return queue.remove(0);
	}
}
