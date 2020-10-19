import java.util.*;

public class twoSum {
    public static void main(String[] args) {
        int[] arr={20, 50, 40, 25, 30, 10};
        int sum=60;
        System.out.println(twoSum(arr,sum));
    }

    static List<Integer> twoSum(int[] arr,int sum){
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap();
        List<Integer> res=Arrays.asList(-1,-1);
        int largest=0;
        for(int i=0;i<n;i++){
            if((arr[i] >largest || sum-arr[i]>largest) && map.containsKey(sum-arr[i])) {
                res.set(0, map.get(sum - arr[i]));
                res.set(1, i);
                largest = Math.max(arr[i], sum - arr[i]);
            }
            map.put(arr[i],i);
        }
        return res;
    }
}
