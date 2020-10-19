import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {
    public static void main(String[] args) {
        int[] list={10,9,2,5,3,7,101,18};
        System.out.println(LIS(list));
    }

    static List<Integer> LIS(int[] nums){
        int sum=0;
        List<Integer> list=new ArrayList();

        for(int n:nums){
            //if the current element is larger than the last element in the incremental list , we simply add it to theis list.
            if(list.size()==0||n>list.get(list.size()-1)){
                list.add(n);
            }
            else {
                int pos=binarySearch(list, 0, list.size() - 1, n);
                list.set(pos,n);
            }
        }
//        for(int i:list) sum+=i;
        return list;
    }

    //binary search for correct position of that number in the list.
    static int binarySearch(List<Integer> list,int i,int j,int n){
        while(i<=j){
            int mid=i+(j-i)/2;
            if(list.get(mid)==n)
                return mid;
            else if(list.get(mid)>n)
                j=mid-1;
            else i=mid+1;
            }
        return i;
    }
}
