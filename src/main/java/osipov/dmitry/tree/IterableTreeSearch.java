package osipov.dmitry.tree;

import osipov.dmitry.fifo_lifo.SimpleQueue;
import osipov.dmitry.fifo_lifo.SimpleStack;

public class IterableTreeSearch {
    public static void main(String[] args) {
        Tree root = new Tree(20,
                new Tree(7,
                        new Tree(4, null, new Tree(6)),
                        new Tree(9)),
                new Tree(35,
                        new Tree(31, new Tree(28), null),
                        new Tree(40, new Tree(38), new Tree(52))));
        System.out.println(root.sumDeep());  // Обход дерева в глубину
        System.out.println(root.sumWide());  // Обход дерева в ширину
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

        public int sumDeep() {
            SimpleStack<Tree> stack = new SimpleStack<>();
            stack.push(this);

            var sum = 0;
            while (!stack.isEmpty()) {
                Tree node = stack.pop();
                sum += node.value;

                if (node.left != null) {
                    stack.push(node.left);
                }

                if (node.right != null) {
                    stack.push(node.right);
                }
            }

            return sum;
        }

        public int sumWide() {
            SimpleQueue<Tree> queue = new SimpleQueue<>();
            queue.add(this);

            var sum = 0;
            while (!queue.isEmpty()) {
                Tree node = queue.remove();
                sum += node.value;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            return sum;
        }
    }
}
