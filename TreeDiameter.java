import java.util.ArrayList;
import java.util.List;

public class TreeDiameter {
    static int diameter;
    public static void main(String[] args) {
        int[][] edges={{0,1},{1,2},{2,3},{1,4},{4,5}};
        diameter=0;
        treeDiameter(edges);
        System.out.print(diameter);
    }


    static public int treeDiameter(int[][] edges) {
        int n=edges.length;
        List<Integer>[] graph=new ArrayList[n+1];
        for(int i=0;i<=n;i++) graph[i]=new ArrayList();

        for(int[] e:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        diameter=0;
        depth(0,-1,graph);
        return diameter;
    }

    //Depth of the tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
    static int depth(int node,int parent,List<Integer>[] graph){
        int max1st=0,max2nd=0;
        for(int child:graph[node]){
            if(child==parent) continue; //can only traverse from parent to child and not vice versa
            int childDepth=depth(child,node,graph);
            if(childDepth>max1st){
                max2nd=max1st;
                max1st=childDepth;
            }
            else if(childDepth>max2nd){
                max2nd=childDepth;
            }
        }
        int maxDepth=max1st+max2nd; //the number of nodes in the longest path-1
        diameter=Math.max(diameter,maxDepth);
        return max1st+1; //max current depth
    }
}

