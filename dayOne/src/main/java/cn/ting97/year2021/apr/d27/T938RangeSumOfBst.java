package cn.ting97.year2021.apr.d27;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T938RangeSumOfBst
 * @Description 二叉搜索树的范围和
 * @date 2021-04-27
 */
public class T938RangeSumOfBst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 二叉搜索树的范围和
     *
     * @param root 根节点
     * @param low  低
     * @param high 高
     * @return 范围和
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }
}
