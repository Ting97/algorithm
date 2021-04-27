package cn.ting97.year2020.dec.d22;

import java.util.*;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T103
 * @Description
 * @date 2020-12-22
 */
public class T103zigzagLevelOrder {

    /**
     * TODO 优化
     * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
     * 二叉树的锯齿形层序遍历
     *
     * @param root 根结点
     * @return 锯齿形层次遍历
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        queue.offer(root);
        int curNum = 1;
        int nextNum = 0;
        int high = 1;
        while (queue.size() != 0) {
            curNum--;
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                nextNum++;
                if (high % 2 == 1) {
                    stack.push(node.left.val);
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextNum++;
                if (high % 2 == 1) {
                    stack.push(node.right.val);
                }
            }
            if (high % 2 == 1) {
                list.add(node.val);
            } else {
                list.add(stack.pop());
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                lists.add(list);
                list = new ArrayList<>();
                high++;
            }
        }
        return lists;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
