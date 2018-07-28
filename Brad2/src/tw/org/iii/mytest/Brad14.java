package tw.org.iii.mytest;

public class Brad14 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(start);
		for (int i=1; i<=100; i++) {
			boolean isPrime = true;
			for (int j=2; j<=i/2; j++) {
				if (i % j == 0) {
					// 抓到了
					isPrime = false;
					break;
				}
			}
			
			System.out.print(i + (isPrime?"*":" ") + " ");
			if (i % 10 ==0) System.out.println();
		}
		System.out.println(System.currentTimeMillis()-start);
	}
}
