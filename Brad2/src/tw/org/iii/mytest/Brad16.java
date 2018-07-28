package tw.org.iii.mytest;

public class Brad16 {

	public static void main(String[] args) {
		/*
		 * Array
		 * 1. Type
		 * 2. Length
		 */
		int[] a;
		a = new int[4];	// 0,1,2,3
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
		int[] b = new int[3];
		int[] c = new int[] {1,2,3,4,5};
		for (int i=0; i<c.length; i++) {
			System.out.println(c[i]);
		}
		int[] d= {1,2,3,4,5};
		for (int i=0; i<d.length; i++) {
			System.out.println(d[i]);
		}
		
		int[] e;
		int[] f;
		e = new int[] {1,2,3,4,5};
		//f = {1,2,3,4,5};
		
		
	}

}
