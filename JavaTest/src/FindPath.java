import java.util.ArrayList;

/**
 * 叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);//回溯的步骤，把路径还原
    }
}
