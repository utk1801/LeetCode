public class numberOfLIS {

    static int getCount(int[] nums){
        int n = nums.length;
        if(n == 0 || nums == null)
            return 0;
        int[] len = new int[n];
        //len[i] = 1 => upto i the length of LIS is 1
        //cnt[i] = 2 => upto nums[i] the count of LIS is 2
        int[] cnt = new int[n];
        int max_len = 0;
        int result = 0;
        for(int i = 0; i < n; i++){
            //since length of 1
            len[i] = cnt[i] = 1;
            //go from first till i
            for(int j = 0; j < i; j++)
            {
                //if current length = prev length + 1
                if(nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1)
                        cnt[i] += cnt[j];
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i])
                result += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                result = cnt[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(getCount(nums));
    }
}
