import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Node
{
    int key;
    Node left, right;

    public Node(int key)
    {
        this.key = key;
        left = right = null;
    }
}


public class ParentInforest {
    static List<List<Integer>> levels;
    Node root;
    void createNode(int[] parent,int i,Node created[]){
        if(created[i]!=null) return;

        created[i]=new Node(i);

        if(parent[i]==-1){
            root=created[i];
            return;
        }

        if(created[parent[i]]==null)
            createNode(parent,parent[i],created);

        Node p=created[parent[i]];

        if(p.left==null)
            p.left=created[i];
        else
            p.right=created[i];
    }

    Node createTree(int[] parent,int n){
        Node[] created=new Node[n];
        for(int i=0;i<n;i++){
            created[i]=null;
        }

        for(int i=0;i<n;i++)
            createNode(parent,i,created);

        return root;
    }

    public static void main(String[] args) {
        ParentInforest tree=new ParentInforest();
        int parent[] = new int[]{1, 5, 5, 2, 2, -1, 3};
        int n = parent.length;
        levels = new ArrayList<List<Integer>>();
        Node node = tree.createTree(parent, n);
        System.out.println("Inorder traversal of constructed tree ");
//        tree.levelOrder(node);
        System.out.println(node);
        tree.newLine();
    }

    private void newLine() {
        System.out.println("");
    }

    private void inorder(Node node) {
        if(node==null) return ;
        inorder(node.left);
        System.out.print(node.key+" ");
        inorder(node.right);
    }


    public void helper(Node node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.key);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    private List<List<Integer>> levelOrder(Node root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}
