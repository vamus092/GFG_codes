class Solution {
    int sum(Node root){
        if(root==null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }
    boolean isSumTree(Node root) {
        if(root == null || (root.left==null && root.right == null)) return true;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return (root.data == (leftSum + rightSum)) && (isSumTree(root.left) && isSumTree(root.right));
    }
}
