import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class countSmall {
    public static void main(String[] args) {
        int[] arr={5,2,6,1};
        System.out.println(countSmaller(arr));
    }

    static List<Integer> countSmaller(int[] arr){
        int n=arr.length;
        int[] res=new int[n];
        List<Integer> tempList=new ArrayList<>();
        LinkedList<Integer>  result=new LinkedList<>();
        //we do a binary search for each element in the array starting from the end. Now as we iterate and look up its
        //correct position in the array, we append the result to result array(addFirst). So in this way we have track of how many number smaller
        //in the future we have for the current element in the array.
        for(int i=n-1;i>=0;i--){
            // find the position at which the arr[i] can be placed which will be our result value.
            res[i]=insertVal(tempList,arr[i]);
            // as soon as we find the position where the arr[i] would go, we insert same in our final
            // result list and using LinkedList to append values at the head as we go.
            result.addFirst(res[i]);
        }
        return result;
    }

    static int insertVal(List<Integer> tempList,int num){
        int l=0;
        int r=tempList.size()-1;
        while (l<=r){
            // find best index to insert "num" and add to list and return idx value
            int mid=l+(r-l)/2;
            int midVal=tempList.get(mid);
            if(num<=midVal)
                r=mid-1;
            else
                l=mid+1;
        }
        tempList.add(l,num);
        return l;
    }
}
