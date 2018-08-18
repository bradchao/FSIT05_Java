package tw.org.iii.mytest;

import java.util.Iterator;
import java.util.TreeSet;

public class Brad71 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		while (set.size()<6) {
			set.add((int)(Math.random()*49+1));
		}
		System.out.println(set);
		
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
		System.out.println("-----");
		for (Integer num : set) {
			System.out.println(num);
		}
		
		
		
		
		
	}
}
