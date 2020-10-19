import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode 582. Kill Process (Medium)
public class killProcess {
    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1,3,10,5);
        List<Integer> ppid = Arrays.asList(3,0,5,3);
        int kill=5;
        System.out.println(killProcess(pid,ppid,kill));
    }
        static int[]parent;

        private static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            List<Integer> res = new ArrayList<>();
            if (pid == null || pid.size() == 0 ||
                    ppid == null || ppid.size() == 0) return res;

            //if root process(ppid:0) is removed , return entire process id list
            if(ppid.get(pid.indexOf(kill))==0) return pid;


            int n=pid.size();
            int max=0;
            for(int p:pid) max=Math.max(max,p);

            parent=new int[max+1];

            for(int i=0;i<=max;i++){
                parent[i]=i;
            }

            for(int i=0;i<n;i++){
                int p=pid.get(i);
                int pp=ppid.get(i);
                if(p==kill) continue; //[0, 3, 2, 0, 4, 5, 6, 7, 8, 9, 5]
                //[0, 3, 2, 0, 4, 0, 6, 7, 8, 9, 5]

                int p0=find(p);
                int p1=find(pp);
                if(p0!=p1) union(p0,p1);
            }
            // System.out.print(Arrays.toString(parent));

            for(int pro:pid){
                if(pro==kill|| find(pro)==kill)
                    res.add(pro);
            }
            return res;
        }

        static int find(int i){
            while(i!=parent[i]) i=parent[i];
            // uncomment below for path compression:
            // int root=i;
            // while(root!=parent[root]) root=parent[root];
            // while (i != root) {
            //     int oldParent = parent[i];
            //     parent[i] = root;
            //     i = oldParent;
            // }
            return i;
        }

        static void union(int a,int b){
            int p1=find(a);
            int p2=find(b);
            if(p1==p2) return;
            parent[p1]=p2;
        }

    }

