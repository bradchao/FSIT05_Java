package tw.org.iii.mytest;

import java.util.Arrays;

public class PokerV2 {
	public static void main(String[] args) {
		int[] poker = new int[52];
		boolean isRepeat;
		int temp;
		for (int i=0; i<poker.length; i++) {
			do {
				temp = (int)(Math.random()*52);
				
				// 檢查機制
				isRepeat = false;
				for (int j=0; j<i; j++) {
					if (poker[j] == temp) {
						isRepeat = true;
						break;
					}
				}
			}while (isRepeat);
			poker[i] = temp;
			//System.out.println(poker[i]);
		}
		System.out.println("----");
		int[][] players = new int[4][13];
		for(int i=0; i<poker.length; i++) {
			players[i%4][i/4] = poker[i];
		}
		
		String[] suits = {"黑桃","紅心","方塊","梅花"};
		String[] values = {"A ","2 ","3 ","4 ","5 ","6 ","7 ","8 "
				,"9 ","10","J ","Q ","K "};
		
		for (int[] player: players) {
			Arrays.sort(player);
			for (int card : player) {
				System.out.print(suits[card/13]+ values[card%13] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
