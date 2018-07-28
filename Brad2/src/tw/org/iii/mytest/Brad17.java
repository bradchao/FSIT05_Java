package tw.org.iii.mytest;

public class Brad17 {
	public static void main(String[] args) {
		int[] p = new int[7];
		
		for (int i=0; i<1000000; i++) {
			int point = (int)(Math.random()*9) +1;
			if (point>=1 && point <=9) {
				p[point>=7?point-3:point]++;
			}else {
				p[0]++;
			}
		}
		if (p[0]==0) {
			for (int i=1; i<p.length; i++) {
				System.out.println(i + "點出現" + p[i] + "次");
			}
		}else {
			System.out.println("XX");
		}
		
		
	}
}
