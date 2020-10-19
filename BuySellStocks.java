public class BuySellStocks {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 8};
        int[] prices2 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Max profit with atmost 1 txn: "+buySellAtmostOne(prices));
        System.out.println("Max profit with as many txn as possible: "+buySellAsMany(prices));
        System.out.println("Max profit with Atmost 2 txns: "+buySellAtmostTwo(prices2));
        System.out.println("Max profit with Atmost K txns: "+buySellAtmostK(prices, 3));
        System.out.println("Max profit with as many txns with 1 day cooldown: "+buySellCooldown(prices));
    }

    //find running minima and maxima along 1 pass.
    static int buySellAtmostOne(int[] prices) {
        int min=Integer.MAX_VALUE,max=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }

    //keep adding the LIS differences in pairs of txn
    static int buySellAsMany(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    //same as 1st , but for 2 txns
    static int buySellAtmostTwo(int[] prices) {
        int t1_cost=Integer.MAX_VALUE;
        int t2_cost=Integer.MAX_VALUE;
        int t1_prof=0,t2_prof=0;

        for(int p:prices){
            t1_cost=Math.min(t1_cost,p);
            t1_prof=Math.max(t1_prof,p-t1_cost);
            t2_cost=Math.min(t2_cost,p-t1_prof);
            t2_prof=Math.max(t2_prof,p-t2_cost);
        }
        return t2_prof;
    }

    //uses mix of 1,2 n 3 parts.
    static int buySellAtmostK(int[] prices, int k) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;
        int maxP = 0, minC = prices[0], prof = 0;
        if (k >= n / 2) {
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    prof += prices[i] - prices[i - 1];
            }
            return prof;
        }

        //1 txn
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            minC = Math.min(minC, prices[i]);
            maxP = Math.max(maxP, prices[i] - minC);
            profit[i] = maxP;
        }


        for (int i = 1; i < k; i++) {
            ktimes(profit, prices);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, profit[i]);
        }
        return ans;
    }

    //helper for K txns part.
    static void ktimes(int[] profit, int[] prices) {
        int min_2 = Integer.MAX_VALUE;
        int prof2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min_2 = Math.min(min_2, prices[i] - profit[i]);
            prof2 = Math.max(prof2, prices[i] - min_2);
            profit[i] = prof2;
        }
    }

    //cooldown period is 1 day
     static int buySellCooldown(int[] prices) {
            int n=prices.length;
            if(n<=1) return 0;
            if(n==2 && prices[1]>prices[0]) return prices[1]-prices[0];
            if(n==2 && prices[1]<prices[0]) return 0;

            //dp[i][j] represents current amount on day i if no stocks in hand (i.e j=0) or with stock(i.e j=1)
            int[][] dp=new int[n][2];
            dp[0][0]=0;
            dp[0][1]=-prices[0];
            dp[1][0]=Math.max(dp[0][1]+prices[1],dp[0][0]);
            dp[1][1]=Math.max(dp[0][1],dp[0][0]-prices[1]);

            for(int i=2;i<n;i++){
                dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
            }
            return dp[n-1][0];
        }
    }

