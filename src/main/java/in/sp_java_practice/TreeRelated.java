package in.sp_java_practice;

import java.util.ArrayList;
import java.util.List;

public class TreeRelated {
    TreeRelated(){}
    public static TreeNode root = new TreeNode(10,
            new TreeNode(5,new TreeNode(2,new TreeNode(1),new TreeNode(4)),new TreeNode(8, new TreeNode(7), new TreeNode(9)))
            ,new TreeNode(17, new TreeNode(14),new TreeNode(22, new TreeNode(21,new TreeNode(18),new TreeNode()),new TreeNode(25))));
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root)
            return false;
        return isTheSumPresent(root,targetSum);
    }

    private static boolean isTheSumPresent(TreeNode root, int targetSum) {
        if (targetSum == 0 && null == root)
            return true;
        else if (targetSum != 0 && null == root){
            return false;
        }
        if (isTheSumPresent(root.left, targetSum-root.val)){
            return true;
        } else return isTheSumPresent(root.right, targetSum - root.val);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(result, root);
        postorderTraversal(result, root);
        inorderTraversal(result, root);
        return result;
    }

    private static void preorderTraversal(List<Integer> result, TreeNode root) {
        if (null == root || root.val == 0)
            return;
        result.add(root.val);
        preorderTraversal(result, root.left);
        preorderTraversal(result, root.right);
    }

    private static void postorderTraversal(List<Integer> result, TreeNode root) {
        if (null == root || root.val == 0)
            return;
        preorderTraversal(result, root.left);
        preorderTraversal(result, root.right);
        result.add(root.val);
    }

    private static void inorderTraversal(List<Integer> result, TreeNode root) {
        if (null == root || root.val == 0)
            return;
        preorderTraversal(result, root.left);
        result.add(root.val);
        preorderTraversal(result, root.right);
    }

    public static int height(TreeNode root) {

        return 0;
    }
}

