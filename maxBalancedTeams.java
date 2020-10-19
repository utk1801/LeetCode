import java.util.*;

public class maxBalancedTeams {
    public static void main(String[] args) {
        int[] dev={5,3,0,2,2,1};
        int maxHires=3;
        System.out.println(maxBalanced(dev,maxHires));
    }

    static int maxBalanced(int[] developers, int maxNewHires){
        Arrays.sort(developers);
        int ans= 0;
        int n = developers.length;
        int count , temp ;
        for(int i = n-1 ; i >=0 ; i--){
            count = 1; temp = maxNewHires;
            for(int j = i-1 ; j>=0 ; j--){
                int val = developers[i] - developers[j];
                if(val <= temp){
                    temp -= val ;
                    count++;
                }else break;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
