import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class permSequence {
    public static void main(String[] args) {
        int n=4,k=9;
        System.out.println(permSeq(n,k));
    }

    private static String permSeq(int n,int k){
        StringBuilder res=new StringBuilder("");

        //Build an arrayList for storing factorial of first N natural numbers (also 0!)
        int[] fact=new int[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++)
            fact[i]=fact[i-1]*i;

//        List<Integer> nums= IntStream.range(1,n+1).mapToObj(x->x).collect(Collectors.toList());
        List<Integer> nums=new ArrayList<>();
        for(int i=1;i<=n;i++) nums.add(i);

        k--; // since K is 1-indexed, while we need k-1th indexed permutation as result.
        for(int i=1;i<=n;i++){
            int idx=k/fact[n-i];
            res.append(nums.get(idx));
            nums.remove(idx);
            k-=idx * fact[n-i];
        }
        return res.toString();
    }
}
