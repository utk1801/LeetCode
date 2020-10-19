import java.util.Scanner;

public class longestAPGoogleCodeJam {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int num=sc.nextInt();
            int[] arr=new int[num];
            for(int j=0;j<num;j++){
                arr[j]=sc.nextInt();
            }
            System.out.println("Case #" + (int)(i+1) + ": "+findLongestAPLength(arr,num));
        }
    }

    private static int findLongestAPLength(int[] arr,int num) {
        int res = 2, cur = 2;
        int cDiff = arr[1] - arr[0];
        for (int k = 2; k < num; k++) {
            if (cDiff == arr[k] - arr[k-1]) {
                cur++;
            } else {
                res = Math.max(cur, res);
                cur = 2;
                cDiff = arr[k] - arr[k - 1];
            }
        }
        res = Math.max(res, cur);
        return res;
    }
}
