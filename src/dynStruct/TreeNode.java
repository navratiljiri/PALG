package dynStruct;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    int count;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.count = 1;
    }

    @Override
    public String toString() {
        return "TreeElem{" +
                "data=" + data +
                '}';
    }
}
