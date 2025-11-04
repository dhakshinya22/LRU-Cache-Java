import java.util.*;
import java.util.function.*;

class AVLNode{
    int data,h;
    AVLNode left,right;
    public AVLNode(int data){
        this.data = data;
        h = 1;
    }
}

class Solution{
    AVLNode insert(AVLNode root, int x){
        if(root == null) return new AVLNode(x);
        if(x < root.data) root.left = insert(root.left,x);
        else root.right = insert(root.right,x);

        updateHeight(root);
        if(getBF(root) == -2){ // right heavy
            if(getBF(root.right) == -1){ // RR
                root = leftRotate(root);
            }
            else{ //RL
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }
        else if(getBF(root) == 2){ // left heavy
            if(getBF(root.left) == 1){ //LL
                root = rightRotate(root);
            }
            else{ //LR
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }
        return root;
    }
    AVLNode leftRotate(AVLNode root){
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        updateHeight(root);
        newRoot.left = root;
        updateHeight(newRoot);
        return newRoot;
    }
    AVLNode rightRotate(AVLNode root){
        AVLNode newRoot = root.left;
        root.left = newRoot.right;
        updateHeight(root);
        newRoot.right = root;
        updateHeight(newRoot);
        return newRoot;
    }
    void updateHeight(AVLNode root){
        if(root == null) return;
        root.h = 1 + Math.max(root.left==null ? 0 : root.left.h,root.right==null ? 0 : root.right.h);
    }
    int getBF(AVLNode root){
        if(root == null) return 0;
        return ((root.left==null ? 0 : root.left.h) - (root.right==null ? 0 : root.right.h));
    }

    void preOrder(AVLNode root){
        if(root==null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

public class AVLTree{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLNode root = null;
        Solution sol = new Solution();
        TreePrinter<AVLNode> tp = new TreePrinter<AVLNode>(
        n -> "" + n.data,
        n -> n.left,
        n -> n.right
    );
        int n = sc.nextInt();
        while(n-->0){
            int x = sc.nextInt();
            root = sol.insert(root,x);
            tp.printTree(root);
        }
    }
}

class TreePrinter<T> {
    private final Function<T, String> nodeToString;
    private final Function<T, T> leftChild;
    private final Function<T, T> rightChild;

    public TreePrinter(Function<T, String> nodeToString,
                       Function<T, T> leftChild,
                       Function<T, T> rightChild) {
        this.nodeToString = nodeToString;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void printTree(T root) {
        printTree(root, "", true);
    }

    private void printTree(T node, String prefix, boolean isTail) {
        if (node == null) return;
        System.out.println(prefix + (isTail ? "└── " : "├── ") + nodeToString.apply(node));
        T left = leftChild.apply(node);
        T right = rightChild.apply(node);
        if (left != null || right != null) {
            if (right != null)
                printTree(right, prefix + (isTail ? "    " : "│   "), false);
            if (left != null)
                printTree(left, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}

