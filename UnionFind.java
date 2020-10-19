import java.util.Arrays;
//1101. The Earliest Moment When Everyone Become Friends

public class UnionFind {
    public static void main(String[] args) {
        int[][] logs={{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int N=6;
        System.out.println(earliestAcq(logs,N));
    }


        public static int earliestAcq(int[][] logs, int N) {
            Arrays.sort(logs,(a, b)->(a[0]-b[0]));
            UF obj=new UF(N);

            for(int[] log:logs){
                obj.union(log[1],log[2]);
                if(obj.res==1) return log[0];
            }
            return -1;
        }
    }

    class UF {
        int[] parent;
        int res;

        public UF(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            res = N;
        }

        private int find(int i) {
            while (i != parent[i]) i = parent[i];
            return i;
        }

        void union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);
            if (p1 != p2) {
                parent[p1] = p2;
                res--;
            }
        }
    }

