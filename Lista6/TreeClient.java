public class TreeClient {
    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(12);
        tree.insert(5);
        tree.insert(18);
        tree.insert(2);
        tree.insert(9);
        tree.insert(15);
        tree.insert(19);
        tree.insert(13);
        tree.insert(17);

        tree.print();

    }
}
