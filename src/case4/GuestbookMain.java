package case4;

import java.util.ArrayList;
import java.util.List;

public class GuestbookMain {

	private static List<Guestbook> guestbooks = new ArrayList<>();
		
	
	public static void main(String[] args) {
		Guestbook g1 = new Guestbook("Hello");
		guestbooks.add(g1);
		System.out.println(guestbooks);
		
		Guestbook g2 = new Guestbook("goooood");
		guestbooks.add(g2);
		System.out.println(guestbooks);
		
	}

}
