import java.util.*;

public class BuySellStock {
	public int maxProfit(int[] prices) {
		int maxpro = Integer.MIN_VALUE;
		int minbuy = Integer.MAX_VALUE;
		for(int price: prices){
			minbuy = Math.min(minbuy, price);
			maxpro = Math.max(maxpro, price-minbuy);
		}
		return maxpro;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7, 1, 5, 3, 6, 4};
		BuySellStock obj = new BuySellStock();
		System.out.println(obj.maxProfit(prices));
	}

}
