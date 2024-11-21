package dynStruct;

import java.util.ArrayList;
import java.util.List;

public class BinTree {
    private TreeNode root;
    private int elems;
    private int count;
    private int index = 0;

    class SearchResult {
        TreeNode node;
        TreeNode predecessor;
        int value;

        public SearchResult(int value, TreeNode node, TreeNode predecessor) {
            this.value = value;
            this.node = node;
            this.predecessor = predecessor;
        }

        @Override
        public String toString() {
            return "SearchResult{" +
                    "value=" + value +
                    ", node=" + node +
                    ", predecessor=" + predecessor +
                    '}';
        }
    }

    public BinTree() {
        this.root = null;
        this.elems = 0;
    }

    public int size() {
        return elems;
    }

    public void clear() {
        removeTree(this.root);
        this.root = null;
        this.elems = 0;
    }

    private void removeTree (TreeNode r) {
        if (r != null)
        {
            removeTree(r.left);
            removeTree(r.right);
            r.left = null;
            r.right = null;
            this.elems--;
        }
    }

    public SearchResult find(int value) {
        return find(this.root,value);
    }

    public SearchResult find(TreeNode r, int value) {
        TreeNode p = null;
        while (r != null && r.data != value)
        {
            p = r;
            if (value < r.data)
                r = r.left;
            else
                r = r.right;
        }
        return new SearchResult(value,r,p);
    }

    public TreeNode add(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
            this.elems = 1;
            return this.root;
        }
        else
            return add(this.root,value);
    }

    private TreeNode add(TreeNode r, int value) {
        SearchResult result = find(r,value);

        if (result.node != null)
            System.out.println("Prvek s hodnotou " + value + "jiz ve strome je.");
        else
        {
            r = new TreeNode(value);
            if (value < result.predecessor.data)
                result.predecessor.left = r;
            else
                result.predecessor.right = r;
            this.elems++;
        }
        return r;
    }

    public void remove(int value)
    {
        SearchResult result = find(value);
        if (result.node == null)
            System.out.println("Prvek s hodnotou " + value + " ve strome neni!");
        else
        {
            remove(result.node, result.predecessor);
            System.out.println("Prvek s hodnotou " + value + " byl odstranen.");
        }
    }

    private void remove(TreeNode node, TreeNode predecessor)
    {
        if (node.left == null && node.right == null)
            removeLeaf(node,predecessor);
        else if (node.left == null || node.right == null)
            removeInBranch(node,predecessor);
        else
            removeInner(node);
        this.elems--;
    }

    private void removeLeaf(TreeNode q, TreeNode p) {
        if (q == this.root)
            this.root = null;
        else {
            if (q == p.left)
                p.left = null;
            else
                p.right = null;
        }
    }

    private void removeInBranch(TreeNode q, TreeNode p) {
        if (q == this.root)
            this.root = (q.left != null) ? q.left : q.right;
        else
        {
            if (q == p.left)
                p.left = (q.left != null) ? q.left : q.right;
            else
                p.right = (q.left != null) ? q.left : q.right;
        }
    }

    private void removeInner(TreeNode q) {
        TreeNode r = q.left;
        TreeNode p = q;
        while (r.right != null) {
            p = r;
            r = r.right;
        }

        q.data = r.data;
        if (r.left != null)
            removeInBranch(r,p);
        else
            removeLeaf(r,p);
    }

    private void glue(TreeNode r, StringBuilder b)
    {
        if (r != null)
        {
            glue(r.left,b);
            b.append(r.data + " ");
            glue(r.right,b);
        }
    }

    public void toArray(int[] a)
    {
       if(elems > a.length) {
           System.out.println("ERROR");
       }
       else {
           index = 0;
           sizeSubTree(this.root, a);
    }
    }

    private void sizeSubTree(TreeNode node, int[] a) {
        if(node != null) {
            sizeSubTree(node.left,a);
            for(int i = 0 ; i < node.count ; i++) {
                a[index++] = node.data;
            }
            sizeSubTree(node.right,a);
        }
    }

    private int sizeSubTree(TreeNode r) {
        /*if(r == null) {
            return 0;
        }
        else if (r.left != null) {
            sizeSubTree(r.left);
            count++;
        }
        else if (r.right != null) {
            sizeSubTree(r.right);
            count++;
        }
        else {
            return count;
        }*/
        if(r == null) {
            return 0;
        }
        else {
            return sizeSubTree(r.left) + sizeSubTree(r.right) + 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("BinTree{" +
                "elems=" + elems + ": ");
        glue(this.root,b);
        b.append("}");
        return b.toString();
    }

    public static void main(String[] args)
    {
        BinTree t = new BinTree();
        t.add(4);
        t.add(2);
        t.add(5);
        t.add(7);
        System.out.println(t);
        System.out.println(t.find(3));
        t.add(1);
        t.add(6);
        t.add(3);
        t.add(0);
        System.out.println(t);
        System.out.println(t.find(3));

        t.remove(8);
        t.remove(6);
        t.remove(6);
        t.remove(1);
        System.out.println(t);
        System.out.println(t.find(6));

        System.out.println(t.find(2));
        System.out.println("Koren stromu je: " + t.root);
        t.clear();
        System.out.println(t);
    }
}
