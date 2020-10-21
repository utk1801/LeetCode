import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class rearrangeString {
    public static void main(String[] args) {
        String s="aabbcc";
        int k=2;
        System.out.println(rearrange(s,k));
    }

    static String rearrange(String s, int k) {
        int[] freq=new int[26];
        int n=s.length();
        char[] ch=s.toCharArray();
        //create char frequency map.
        for(char c:ch){
            freq[c-'a']++;
        }

        StringBuilder sb=new StringBuilder();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[1]-a[1]); //for sorting and storing characters , on max-freq basis
        Queue<int[]> q=new LinkedList(); //for holding elements in q till the cooldown(k) is reached.
        for(int i=0;i<26;i++) {
            if(freq[i]>0) pq.add(new int[]{i,freq[i]});
        }

        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            sb.append((char)(cur[0]+'a'));
            cur[1]--;
            q.add(cur);
            //once q size exceeds k, we can start polling elements from it to push to pq.
            if(q.size()>=k){
                int[] front=q.poll();
                if(front[1]>0) pq.add(front);
            }
        }
        return sb.length()==s.length()?sb.toString():"";
    }
}

