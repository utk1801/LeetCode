import java.util.Arrays;

public class PopCountsBit {
    public static void main(String[] args) {
        int num = 5;
        System.out.print(Arrays.toString(count1Bits(num)));
    }

    static int[] count1Bits(int num) {
        int ans[] = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // Pop Function (count of 1's): P(x)=P(x/2) + (x mod 2)
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}

// i>>1 => i/2 ; i&1 => i%2
/*
     public int[] countBits(int num) {
        int ans[]=new int[num+1];
        for(int i=1;i<=num;i++){
            // Pop Function: P(x)=P(x & x-1) + 1
            ans[i]=ans[i&(i-1)] + 1;
        }
        return ans;
    }
*/
