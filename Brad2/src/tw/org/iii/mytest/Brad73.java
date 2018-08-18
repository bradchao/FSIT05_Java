package tw.org.iii.mytest;

import java.util.LinkedList;

public class Brad73 {

	public static void main(String[] args) {
		LinkedList<Integer> nums = new LinkedList<>();
		for (int i=0; i<10; i++) {
			nums.add(0,i);
		}
		System.out.println(nums);
		// [9,8,7,6,5,4,3,2,1,0]
	}

}
