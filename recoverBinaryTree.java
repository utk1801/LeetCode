
import java.util.List;


//using Morris inorder traversal.
public class recoverBinaryTree {

    //Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
      }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    static TreeNode prevNode=null;
    static TreeNode firstNode=null,lastNode=null;

    //Morris inorder traversal in O(1) space. Saves space by maintaining predecessor pointer while traversing and comparing values
    // for predecessor with current pointer, to find potential swap pair.
    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        TreeNode cur=root;
        while(cur!=null){
            //if left is null, print the node and move to current node's right.
            if(cur.left==null){
                if(prevNode!=null && prevNode.val>cur.val)
                    find(cur);
                prevNode=cur;
                cur=cur.right;
            }else{
                TreeNode predecessor=cur.left;
                //to find predecessor, keep moving to the right, till right node is not null or is not current.
                while(predecessor.right!=cur && predecessor.right!=null){
                    predecessor=predecessor.right;
                }

                //if right node is null, then go left after estabilishing link from pred to current.
                if(predecessor.right==null){
                    predecessor.right=cur;
                    cur=cur.left;
                }else{
                    //left is already visited. Remove the link established earlier, and go right after visiting current node.
                    predecessor.right=null;

                    if(prevNode!=null && prevNode.val>cur.val)
                        find(cur);
                    prevNode=cur;

                    cur=cur.right;
                }
            }
        }
        if(firstNode != null && lastNode != null)
            swap(firstNode, lastNode);
    }

    static void find(TreeNode root){
        if(firstNode == null)
            firstNode = prevNode;
        lastNode = root;
    }

    static void swap(TreeNode firstNode, TreeNode lastNode){
        int t = firstNode.val;
        firstNode.val = lastNode.val;
        lastNode.val = t;
    }
}

