package tw.org.iii.mytest;

public class PokerV1 {
	public static void main(String[] args) {
		int[] poker = new int[49];
		for (int i=0; i<poker.length; i++) {
			int temp = (int)(Math.random()*49);
			
			// 檢查機制
			boolean isRepeat = false;
			for (int j=0; j<i; j++) {
				if (poker[j] == temp) {
					isRepeat = true;
					break;
				}
			}
			
			if (!isRepeat) {
				poker[i] = temp;
				System.out.println(poker[i]);
			}else {
				i--;
			}
		}
	}
}
