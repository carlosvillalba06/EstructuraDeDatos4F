public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree tree = new BinarySearchTree();
        int[] data = {8,3,10,1,6};
        for (int i : data) {
            tree.insert(i);
        }

        tree.printInOrder();
    }
}
