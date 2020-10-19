import java.util.Arrays;

public class balancedArrayVMWare {
    public static void main(String[] args) {
        int[] arr={1,7,3,6,5,6};
        System.out.println(isBalanced(arr));
    }

    static int isBalanced(int[] arr) {
        int cdf=0;
        int n=arr.length;
        if(n==0) return -1;
          for(int i=0;i<n;i++) {
            cdf+=arr[i];
          }

          int leftSum=0,rightSum=0;
          for(int i=0;i<n;i++) {
                rightSum=cdf-arr[i]-leftSum;
                if(rightSum==leftSum)
                    return i;
                leftSum+=arr[i];
          }
          return -1;
    }
}