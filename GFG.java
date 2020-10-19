// A naive recursive Java implementation  
// to count number of decodings that 
// can be formed from a given digit sequence 

class GFG {

    // Given a digit sequence of length n,
// returns count of possible decodings by 
// replacing 1 with A, 2 woth B, ... 26 with Z 
    public static int countDecoding(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<= s.length(); i++){

            int first = Character.getNumericValue(s.charAt(i-1));
            int second = Integer.parseInt(s.substring(i-2, i));
            if(first <= 9 && first >= 0){
                dp[i] += dp[i-1];
            }

            if(second >= 10 && second <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        String s="100200300";
//        char ch[]=s.toCharArray();
//        char digits[] = {'1', '2', '3', '4'};
//        int n = digits.length;
        System.out.printf("Count is %d", countDecoding(s));
    }
} 