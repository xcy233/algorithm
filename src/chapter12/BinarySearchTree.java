package chapter12;

/**
 * Created by john.xu at 2022-12-14 22:22
 */
public class BinarySearchTree {

    public TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = {1,8,2,7,3,6,4,5};
        for (int a: arr) {
            tree.insertNode(new TreeNode(a));
        }
        inOrderWalk(tree.root);
    }

    public static void inOrderWalk(TreeNode node) {
        if (node != null) {
            inOrderWalk(node.left);
            System.out.println(node.v);
            inOrderWalk(node.right);
        }
    }

    public static void preOrderWalk(TreeNode node) {
        if (node != null) {
            System.out.println(node.v);
            preOrderWalk(node.left);
            preOrderWalk(node.right);
        }
    }

    public static void postOrderWalk(TreeNode node) {
        if (node != null) {
            postOrderWalk(node.left);
            postOrderWalk(node.right);
            System.out.println(node.v);
        }
    }

    public TreeNode search(int target) {
        TreeNode node = root;
        while (node != null) {
            if (node.v == target) {
                return node;
            } else if (node.v < target) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    public static TreeNode searchLargest(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static TreeNode searchSmallest(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static TreeNode TreeSuccessor(TreeNode node) {
        if (node.right != null) {
            return searchSmallest(node.right);
        }
        TreeNode y = node.parent;
        while (y != null && node == y.right) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    public TreeNode TreePredecessor(TreeNode node) {
        if (node.left != null) {
            return searchLargest(node.left);
        }
        TreeNode y = node.parent;
        while (y != null && node == y.left) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    public void insertNode(TreeNode toInsert) {
        if (root == null) {
            root = toInsert;
        } else {
            TreeNode node = root;
            TreeNode nodeP = node.parent;
            while (node != null) {
                nodeP = node;
                if (toInsert.v > node.v) {
                    node = node.right;
                } else if (toInsert.v < node.v) {
                    node = node.left;
                } else {
                    return;
                }
            }
            if (toInsert.v > nodeP.v) {
                nodeP.right = toInsert;
                toInsert.parent = nodeP;
            } else {
                nodeP.left = toInsert;
                toInsert.parent = nodeP;
            }
        }
    }

    public void deleteNode(TreeNode toDelete) {
        if (toDelete.left == null) {
            //left is null
            transplant(toDelete, toDelete.right);
        } else if (toDelete.right == null) {
            //left is null
            transplant(toDelete, toDelete.left);
        } else {
            //find successor
            TreeNode successor = searchSmallest(toDelete.right);
            if (successor != toDelete.right) {
                transplant(successor, successor.right);
                successor.right = toDelete.right;
                toDelete.right.parent = successor;
            }
            transplant(toDelete, successor);
            successor.left = toDelete.left;
            toDelete.left.parent = successor;
        }
    }

    private void transplant(TreeNode u, TreeNode v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

}
