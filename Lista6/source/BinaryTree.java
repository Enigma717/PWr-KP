public class BinaryTree<Type extends Comparable<Type>> {

    private TreeNode<Type> node;

    public BinaryTree() {
        node = null;
    }

    public void insert(Type value) {
        node = nodeInsert(node, value);
    }

    public boolean search(Type value) {
        return nodeSearch(node, value);
    }

    public void delete(Type value) {
        node = nodeDelete(node, value);
    }

    public void print() { 
        System.out.print(drawTree(node));
        System.out.print("\n");
    }


    private TreeNode<Type> nodeInsert(TreeNode<Type> node, Type value) {
        if(node == null) {
            return new TreeNode<Type>(value);
        }

        if(value.compareTo(node.getValue()) < 0) {
            node.setLeft(nodeInsert(node.getLeft(), value));
        }
        else if(value.compareTo(node.getValue()) > 0 || value.compareTo(node.getValue()) == 0) {
            node.setRight(nodeInsert(node.getRight(), value));
        }

        return node;
    }

    private boolean nodeSearch(TreeNode<Type> node, Type value) {
        if(node == null) {
            return false;
        }

        if(value.compareTo(node.getValue()) == 0) {
            return true;
        }

        return value.compareTo(node.getValue()) < 0
            ? nodeSearch(node.getLeft(), value) 
            : nodeSearch(node.getRight(), value);
    }

    private TreeNode<Type> nodeDelete(TreeNode<Type> node, Type value) {
        if(value == null) {
            return null;
        }

        if(value.compareTo(node.getValue()) == 0) {
            if(node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if(node.getLeft() == null) {
                return node.getRight();
            }
            if(node.getRight() == null) {
                return node.getLeft();
            }

            Type minValue = findSmallestNode(node.getRight());
            node.setValue(minValue);
            node.setRight(nodeDelete(node.getRight(), minValue));
        }
        if(value.compareTo(node.getValue()) < 0) {
            node.setLeft(nodeDelete(node.getLeft(), value));
        }
        else {
            node.setRight(nodeDelete(node.getRight(), value));
        }

        return node;
    }

    private Type findSmallestNode(TreeNode<Type> node) {
        return node.getLeft() == null ? node.getValue() : findSmallestNode(node.getLeft()); 
    }

    private String drawTree(TreeNode<Type> node) {
        if(node != null) {
            return "(" + node.getValue() + ":" + drawTree(node.getLeft()) + ":" + drawTree(node.getRight()) + ")";
        }
        return "()";
    }
}
