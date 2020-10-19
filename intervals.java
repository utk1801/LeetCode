import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class intervals {
    public static void main(String[] args) {
        int[][] interval={{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(mergeInterval(interval)));
        System.out.println(meetingRoomsI(interval));
        System.out.println(meetingRoomsII(interval));
        System.out.println(eraseOverlapinterval(interval));
        System.out.println(removeCoveredinterval(interval));
        System.out.println(Arrays.deepToString(insertInterval(interval,new int[]{10,12})));
        int[][] points={{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }

    //LC-56
    static int[][] mergeInterval(int[][] interval){
        Arrays.sort(interval,(a,b)->(a[0]-b[0]));
        int n=interval.length;
        int[] curInt=interval[0];
        List<int[]> res=new ArrayList();
            res.add(curInt);
            for(int i=1;i<n;i++){
            if(curInt[1]>=interval[i][0]){
                curInt[1]=Math.max(curInt[1],interval[i][1]);
            }
            else {
                curInt=interval[i];
                res.add(curInt);
            }
        }
           return res.toArray(new int[res.size()][2]);
    }

    //LC-252
    static boolean meetingRoomsI(int[][] interval) {
        Arrays.sort(interval,(a,b)->(a[0]-b[0]));
        int n=interval.length;
        if(n==0) return true;
        int curEnd=interval[0][1];
        for(int i=1;i<n;i++){
            if(curEnd>interval[i][0])
                return false;
            else curEnd=interval[i][1];
        }
        return true;
    }

    //LC-253
    static int meetingRoomsII(int[][] interval) {
        int n=interval.length;
        if(n==0) return 0;
        Arrays.sort(interval,(a,b)->(a[0]-b[0]));
        PriorityQueue<Integer> q=new PriorityQueue();
        q.add(interval[0][1]);
        for(int i=1;i<n;i++){
            if(interval[i][0]>=q.peek())
                q.poll();
            q.add(interval[i][1]);
        }
        return q.size();
    }

    //LC-452
    static int findMinArrowShots(int[][] points) {
        int n=points.length;
        if(n==0) return 0;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int count=1;

        int temp=points[0][1];
        for(int i=1;i<n;i++){
            if(points[i][0]<=temp){
                continue;
            }else{
                count++;
                temp=points[i][1];
            }
        }
        return count;
    }

    //LC-435
    static int eraseOverlapinterval(int[][] interval) {
        int n=interval.length;
        if(n==0) return 0;
        Arrays.sort(interval,(a,b)->(a[1]-b[1]));
        int count=1;
        int temp=interval[0][1];
        for(int i=1;i<n;i++){
            //find count of non-overlapping interval
            if(interval[i][0]>=temp){
                count++;
                temp=interval[i][1];
            }
        }
        return n-count; //subtract count from total interval
    }

    //LC-1288
    static int removeCoveredinterval(int[][] interval) {
        Arrays.sort(interval,(a,b)->(a[0]-b[0]));
        int left=-1,right=-1;
        int res=0;
        //if the next interval has both higher start & end time than previous, then its not overlapping i.e not covered.
        for(int[] i:interval){
            if(i[0]>left && i[1]>right){
                res++;
                left=i[0]; //update left to current intervals start
            }
            right=Math.max(right,i[1]); // update right as we iterate through sorted intervals.
        }
        return res;
    }

    //LC-57
    static int[][] insertInterval(int[][] interval, int[] newInterval) {
        Arrays.sort(interval,(a,b)->(a[0]-b[0]));
        int n=interval.length;
        List<int[]> res=new ArrayList();

        //if the new interval's end time is prior the start time of existing intervals
        for(int[] i:interval){
            if(newInterval[1]<i[0]){
                res.add(newInterval);
                newInterval=i;
            }
            else if(newInterval[0]>i[1])
                res.add(i);
            else{
                newInterval[0]=Math.min(newInterval[0],i[0]);
                newInterval[1]=Math.max(newInterval[1],i[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][2]);
    }
}
