import java.util.Deque;
import java.util.LinkedList;

//Leetcode 862. Shortest Subarray with Sum at Least K (HARD)
public class shortestSubarraySum {
    public static void main(String[] args) {
        int[] A={2,-1,2};
        int K=3;
        System.out.println(shortestSubarray(A,K));
    }

    public static int shortestSubarray(int[] A, int K) {
            int n=A.length;
            int[] prefixSum=new int[n];
            prefixSum[0]=A[0];
            for(int i=1;i<n;i++)
                prefixSum[i]=prefixSum[i-1]+A[i];

            int ans=n+1; //initialize

        //Initialize doubly-ended queue since it allows 0(1) insertion and deletion at both ends of the queue, while maintaining FIFO.
            Deque<Integer> q=new LinkedList();
            for(int i=0;i<n;i++){
                // finding y's which make prefixSum till this y >=K
                if(prefixSum[i]>=K){
                    ans=Math.min(ans,i+1); //update ans for indexes parsed till y,starting from 0 in an attempt to search for best start point(i.e x).
                }

                int y=prefixSum[i]; //prefixSum[y]
                int x=y-K; //threshold per eqn: pre[y]-pre[x]>=K
                //=> pre[x]<=pre[y]-K

                //search from the queue,from the min value in q, all valid x's
                while(q.size()>0 && prefixSum[q.peekFirst()]<=x){
                    ans=Math.min(ans,i-q.pollFirst()); //remove that el since we wont need for next iteration of y.
                }

                //maintaining increasing order in q
                while(q.size()>0 && prefixSum[q.peekLast()]>=prefixSum[i])
                    q.pollLast();

                //prefix of y added to the end of queue.
                q.addLast(i);
            }
            return ans<=n?ans:-1;
        }
    }

