package tw.org.iii.mytest;

import java.util.LinkedList;

public class Brad72 {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<>();
		names.add("Brad");
		names.add("Brad");
		names.add("Tony");
		names.add("Eric");
		names.add("Mary");
		System.out.println(names.size());
		System.out.println(names);
		for (String name: names) {
			System.out.println(name);
		}
		System.out.println(names.get(3));
		
		
		
		
		
	}

}
