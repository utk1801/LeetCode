public class maximalSquare {
    public static void main(String[] args) {
        char[][] matrix={{'1' ,'0', '1', '0', '0'},
                {'1' ,'0','1','1' ,'1'},
                {'1','1' ,'1','1','1'},
                {'1', '0','0','1','0'}};
        System.out.print(maximalSquare(matrix));
    }

        static int maximalSquare(char[][] matrix) {
            int r=matrix.length;
            if(r==0) return 0;
            int c=matrix[0].length;
            int maxLen=Integer.MIN_VALUE;

            int[][] dp=new int[r+1][c+1];
            //init dp matrix.
            for(int i=0;i<r;i++) dp[i][0]=0;
            for(int j=0;j<c;j++) dp[0][j]=0;

            //take min of left,top left, top elements for every 1 encountered in matrix, and add 1 in dp array.
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    if(matrix[i-1][j-1]=='1'){
                        dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                        maxLen=Math.max(dp[i][j],maxLen);
                    }
                }
            }
            return maxLen*maxLen;
    }
}
