public class TreeNode<Type extends Comparable<Type>> {

    private Type value;
    private TreeNode<Type> left;
    private TreeNode<Type> right;

    public TreeNode(Type value) {
        this.value = value;
        left = null;
        right = null;
    }

    public String toString() {
        return value.toString(); 
    }
    public Type getValue() { 
        return value; 
    }
    public void setValue(Type newValue) { 
        value = newValue; 
    }
    public TreeNode<Type> getLeft() { 
        return left; 
    }
    public TreeNode<Type> getRight() { 
        return right; 
    }
    public void setLeft(TreeNode<Type> newLeft) { 
        left = newLeft; 
    }
    public void setRight(TreeNode<Type> newRight) { 
        right = newRight; 
    }
}