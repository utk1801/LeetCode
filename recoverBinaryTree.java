import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class recoverBinaryTree {
    public static void main(String[] args) {

    }

    //Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
      }

        static void recoverTree(TreeNode root) {
            List<Integer> res=new ArrayList();
            inorder(root,res);
            int[] swapped=findSwap(res);
            recover(root,swapped);
        }

        static void inorder(TreeNode root,List<Integer> res){
            if(root==null) return ;
            inorder(root.left,res);
            res.add(root.val);
            inorder(root.right,res);
        }

        static int[] findSwap(List<Integer> res){
            int n=res.size();
            int x=-1,y=-1;
            for(int i=0;i<n-1;i++){
                if(res.get(i)>res.get(i+1)){
                    y=res.get(i+1);
                    // first swap occurence
                    if(x==-1) x=res.get(i);
                    // second swap occurence
                    else break;
                }
            }
            return new int[]{x,y};
        }

        static void recover(TreeNode node, int[] swap) {
            if (node != null) {
                if (node.val == swap[0] || node.val == swap[1]) {
                    node.val = node.val == swap[0] ? swap[1] : swap[0];
                }
                recover(node.left, swap);
                recover(node.right, swap);
            }
        }
}
