import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class pathSumIII {

    public static void main(String[] args) {
        TreeNode obj=new TreeNode(10);
        obj.left=new TreeNode(5);
        obj.right=new TreeNode(-3);
        obj.left.left=new TreeNode(3);
        obj.left.left.left=new TreeNode(3);
        obj.left.left.right=new TreeNode(-2);
        obj.left.right=new TreeNode(2);
        obj.left.right.right=new TreeNode(1);
        obj.right.right=new TreeNode(11);



        System.out.print(pathSum(obj,8));
    }

    static List<List<Integer>> paths = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        map.put(0, new ArrayList<>());
        pathSum(root, 0, sum, new ArrayList<>(), map);
        return paths;
    }

    static void pathSum(TreeNode root,int currSum,int target,List<Integer> currList, Map<Integer, List<Integer>>map) {
        if (root == null)
            return;

        currSum += root.val;
        currList.add(root.val);
        if (map.containsKey(currSum - target)) {
            List<Integer> prevPath = map.get(currSum - target), temp = new ArrayList<>();
            for (int i = prevPath.size(); i < currList.size(); i++)
                temp.add(currList.get(i));
            paths.add(temp);
        }
        map.put(currSum, new ArrayList<>(currList));
        pathSum(root.left, currSum, target, currList, map);
        pathSum(root.right, currSum, target, currList, map);
        currList.remove(currList.size() - 1);
    }
}
