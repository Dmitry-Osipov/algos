package osipov.dmitry.tree;

public class RecursionTreeSearch {
    public static void main(String[] args) {
        Tree root = new Tree(20,
                new Tree(7,
                        new Tree(4, null, new Tree(6)),
                        new Tree(9)),
                new Tree(35,
                        new Tree(31, new Tree(28), null),
                        new Tree(40, new Tree(38), new Tree(52))));
        System.out.println(root.sum());
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value) {
            this.value = value;
        }

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int sum() {
            var sum = value;

            if (left != null) {
                sum += left.sum();
            }

            if (right != null) {
                sum += right.sum();
            }

            return sum;
        }
    }
}
