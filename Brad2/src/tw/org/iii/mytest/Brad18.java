package tw.org.iii.mytest;

public class Brad18 {
	public static void main(String[] args) {
		int[][] a = new int[2][3];
		int[][] b = new int[2][];
		b[0] = new int[3];
		b[1] = new int[2];
		
		for (int i=0; i<b.length; i++) {
			for (int j=0; j<b[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---");
		int[] c = {1,3,4,7,3};
		for (int brad: c) {
			System.out.println(brad);
		}
		System.out.println("---");
		for (int[] bb:b) {
			for (int bbb : bb) {
				System.out.print(bbb + " ");
			}
			System.out.println();
		}
		
		
		
		
		
	}
}
