import java.util.HashMap;
import java.util.Map;
//fruit in baskets - 2 baskets hence only two types of fruits - LC #904

//This code is similar to
//1.Consecutive Characters: find the maximum length of a non-empty substring that contains only one unique character- LC - #1446
//2. Longest-substring-with-at-most-two-distinct-characters - 2 unique characters - LC #159
public class fruitsInBasket {

    static int getLength(int[] nums){
        int n = nums.length;
        if(n == 0 || nums == null)
            return 0;
        int i = 0, j = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(j < n)
        {
            if(map.size() <= 2) //since atmost 2 types of fruits can be picked
                map.put(nums[j], j++); //records the last occurrence index of a type of fruit
            if(map.size() > 2)
            {
                int min = n - 1;
                for(int value: map.values())
                    min = Math.min(min, value); //find min index after type 1 fruit is found.
                i = min + 1; //set start to min index + 1
                map.remove(nums[min]); //remove the type 1 fruit found earlier.
            }
            max = Math.max(max, j - i); //update max to find the longest length for consecutive fruits of 2 types.
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(getLength(nums));
    }
}
