import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class findBoxes {
    public static void main(String[] args) {
        int[] arr={2,4,4,6,8,8};
        System.out.println(leftBoxes(arr));
    }

    static int leftBoxes(int[] arr){
        Arrays.sort(arr);
        int n=arr.length;
        int count=n;
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> head=list.subList(0,n/2);
        List<Integer> tail=list.subList(n/2,n);
        System.out.println(head+" "+tail);
        int i=n/2-1,j=(n-1-(n/2));
        while(i>=0 && j>=0){
            if(head.get(i)<=tail.get(j)/2){
                count--;i--;j--;
            } else
                i--;
        }

        return count;
    }
}
