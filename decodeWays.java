public class decodeWays {
    public static void main(String[] args) {
        String s="126";
        System.out.print(decodeWays(s));
    }

    static int decodeWays(String s){
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='1'?1:0;

        for(int i=2;i<=n;i++){
            if(s.charAt(i-1)!='0')
                dp[i]+=dp[i-1];

            int twoDigit=Integer.parseInt(s.substring(i-2,i));
            if(twoDigit>=10 && twoDigit<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }
}
