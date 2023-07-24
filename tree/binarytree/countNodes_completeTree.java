package tree.binarytree;

// complete tree is all kind of binary tree
// it's all nodes can be full filed or half filed also
// to find the total node -1) if tree is full of nodes means all nodes has childs then return 2^level-1 
//////////////////////////--2) if not then devide the tree into left and right then add 1 till root==null 

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        TreeNode left = right = null;
    }

}

public class countNodes_completeTree {

    static int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = getleftheight(root);
        int right = getrightheight(root);

        if (left == right)
            return (int) Math.pow(2, left) - 1;
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

    }

    static int getrightheight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    static int getleftheight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode Root = new TreeNode(1);
        Root.left = new TreeNode(2);
        Root.right = new TreeNode(3);
        Root.left.left = new TreeNode(4);
        Root.left.right = new TreeNode(5);
        Root.right.left = new TreeNode(6);
        Root.right.right = new TreeNode(7);

        System.out.println(countNodes(Root));
    }

}
