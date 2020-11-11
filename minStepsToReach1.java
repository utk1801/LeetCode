import java.util.Arrays;

public class minStepsToReach1 {
    //TC- O(k^n) here k=1+1/2+1/3 without memo , O(n) with memo
    //SC- O(n)
    public static void main(String[] args) {
        System.out.println("Min steps needed to reach 1: "+minStepsRecursive(10));
        System.out.println("Min steps needed to reach 1: "+minStepsIterative(10));

    }

    //iterative (Bottom Up) much faster than Memoisation.
    private static int minStepsIterative(int n) {
        int[] tab=new int[n+1];
        tab[1]=0;

        for(int i=2;i<=n;i++){
            int res=tab[i-1];
            if(i%2==0)
                res=Math.min(res,tab[i/2]);
            if(i%3==0)
                res=Math.min(res,tab[i/3]);

            int steps=1+res;
            tab[i]=steps;
        }
        return tab[n];
    }

    //Top Down Memoization solution (with recursion)
    private static int minStepsRecursive(int n){
        if(n==1) return 0;

        //Memoise
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        if(memo[n]!=-1)
            return memo[n];
        int res=minStepsRecursive(n-1);
        if(n%2==0)
            res=Math.min(res,minStepsRecursive(n/2));
        if(n%3==0)
            res=Math.min(res,minStepsRecursive(n/3));

        int steps=1+res;
        memo[n]=steps;
        return steps;
    }
}
