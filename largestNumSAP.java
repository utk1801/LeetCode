import java.util.LinkedList;
import java.util.Queue;

public class largestNumSAP {
    public static void main(String[] args) {
        System.out.println(largestNum(54567));
        System.out.println(largestSequentialNum(54567));
    }

    //1st Approach: Using substring.
    private static int largestNum(int n) {
        int max=0;
        String s="123456789";
        for(int l=2;l<=s.length();l++){
            for(int i=0;i<=s.length()-l;i++){
                int num=Integer.parseInt(s.substring(i,i+l));
                if(num>n) return max;
                else max=Math.max(num,max);
            }
        }
        return max;
    }

    //2nd Approach: using Queue.
    private static int largestSequentialNum(int n){
        Queue<Integer> q=new LinkedList<>();
        int maximum=0;
        for(int i=1;i<10;i++) q.add(i);
        while(!q.isEmpty()){
            int cur=q.poll();
            int lastDigit=cur%10;
            int next=cur*10+lastDigit+1;
            if(next>n) return maximum;
            if(lastDigit<9 && next<=n) {
                q.add(next);
                maximum=Math.max(maximum,next);
            }
        }
        return maximum;
    }
}
