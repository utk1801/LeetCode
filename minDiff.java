import java.util.*;
public class minDiff{

    public static void main(String []args){
        System.out.println("Hello World");
        int[]a= {1,3,5};
        int[]b= {5,3,1};
        System.out.println("result is " + solve(a,b));

    }
    public static int solve(int[]a, int []b){
        int len = a.length;
        int[] diff= new int[len];
        int res=0;
        for (int i=0; i <len ; i++){
            diff[i] = Math.abs(a[i]-b[i]);
            res+=diff[i];
        }

        Arrays.sort(a);

        int new_mindiff=Integer.MIN_VALUE;

        for (int i=0; i <len ; i++){
            int idx= f(a, b[i]);
            int newdiff= Math.abs(a[idx]-b[i]);
            System.out.printf("bval newdelta %d %d\n", b[i],newdiff);
            new_mindiff= Math.max(diff[i]-newdiff, new_mindiff);
            System.out.println(new_mindiff);
        }

        res-=new_mindiff;
        return res;
    }

    public static int f(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }


}