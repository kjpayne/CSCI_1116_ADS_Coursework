/*
 * Author: Kaden Payne
 * Date: 10/05/2020
 * 
 * Tetsing Tree with BSTTest class
 */
import java.util.Scanner;
/**
 *
 * @author kjpay
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter 10 numbers: ");
        for (int i = 0; i < 10; i++) {
            tree.insert(input.nextInt());
        }
        
        tree.inorder();
        System.out.println();
        
        BST<String> tree1 = new BST<>();
        tree1.insert("George");
        tree1.insert("Michael");
        tree1.insert("Tom");
        tree1.insert("Adam");
        tree1.insert("Jones");
        tree1.insert("Peter");
        tree1.insert("John");
        tree1.insert("Daniel");
        
        tree1.nonRecursiveInorder();
        System.out.println();
    }
    
    public static class BST<E extends Comparable<E>> extends AbstractTree<E> {
        protected TreeNode<E> root;
        protected int size = 0;

        //Constructors
        public BST() {

        }
        public BST(E[] objects) {
            for (int i = 0; i < objects.length; i++) {
                insert(objects[i]);
            }
        }

        //Searching if element is in tree
        @Override
        public boolean search(E e) {
            TreeNode<E> current = root;

            while( current != null) {
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                }
                else {
                    return true;
                }
            }

            return false;
        }

        //Adding an element into tree
        @Override
        public boolean insert(E e) {
            if (root == null) {
                root = createNewNode(e);
            }
            else {
                TreeNode<E> parent = null;
                TreeNode<E> current = root;
                while (current != null) {
                    if (e.compareTo(current.element) < 0) {
                        parent = current;
                        current = current.left;
                    }
                    else if (e.compareTo(current.element) > 0) {
                        parent = current;
                        current = current.right;
                    }
                    else {
                       return false; 
                    }
                }

                if (e.compareTo(parent.element) < 0) {
                    parent.left = createNewNode(e);
                }
                else {
                    parent.right = createNewNode(e);
                }
            }

            size++;
            return true;
        }

        //Creating new node into tree
        protected TreeNode<E> createNewNode(E e) {
            return new TreeNode<>(e);
        }

        //Inorder traversal
        @Override
        public void inorder() {
            inorder(root);
        }
        protected void inorder(TreeNode<E> root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
        public void nonRecursiveInorder() {
            if (root == null) {
                return;
            }
            java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
            java.util.Stack<TreeNode<E>> stack = new java.util.Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode<E> current = (TreeNode<E>) (stack.peek());
                if (current.left != null && !list.contains(current.left)) {
                    stack.push(current.left);
                }
                else {
                    stack.pop();
                    list.add(current);
                    if (current.right != null) {
                        stack.push(current.right);
                    } 
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).element + " ");
            }
        }
        
        //Postorder traversal
        @Override
        public void postorder() {
            postorder(root);
        }
        protected void postorder(TreeNode<E> root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element + " ");
        }

        //Preorder traversal
        @Override
        public void preorder() {
            preorder(root);
        }
        protected void preorder(TreeNode<E> root) {
            if (root == null) {
                return;
            }
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }

        //Inner class TreeNode
        public static class TreeNode<E extends Comparable<E>> {
            E element;
            TreeNode<E> left;
            TreeNode<E> right;

            //Constructor
            public TreeNode(E e) {
                element = e;
            }
        }

        //Returning size of tree
        @Override
        public int getSize() {
            return size;
        }

        //Returning root of tree
        public TreeNode<E> getRoot() {
            return root;
        }

        //Returning path that leads to a specified element
        public java.util.ArrayList<TreeNode<E>> path(E e) {
            java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
            TreeNode<E> current = root;

            while (current != null) {
                list.add(current);
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                }
                else {
                    break;
                }
            }

            return list;
        }

        //Removing an element from tree
        @Override
        public boolean delete(E e) {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while  (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else {
                    break;
                }
            }
            if (current == null) {
                return false;
            }

            //Case 1: current has no left children
            if (current.left == null) {
                if (parent == null) {
                    root = current.right;
                }
                else if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                }
                else {
                    parent.right = current.right;
                }
            }
            else {
                //Case 2: current node has a left child
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right;
                }

                current.element = rightMost.element;

                if (parentOfRightMost.right == rightMost) {
                    parentOfRightMost.right = rightMost.left;
                }
                else {
                    //Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
                }
            }

            size--;
            return true;
        }

        //Obtaining an iterator
        @Override
        public java.util.Iterator<E> iterator() {
            return new InorderIterator();
        }

        //Inner class InorderIterator
        private class InorderIterator implements java.util.Iterator<E> {
            private java.util.ArrayList<E> list = new java.util.ArrayList<>();
            private int current = 0;

            //Constructors
            public InorderIterator() {
                inorder();
            }

            //Inorder Traversal
            private void inorder() {
                inorder(root);
            }
            private void inorder(TreeNode<E> root) {
                if (root == null) {
                    return;
                }
                inorder(root.left);
                list.add(root.element);
                inorder(root.right);
            }

            //Checking if there is another element that is next in line
            @Override
            public boolean hasNext() {
                return current < list.size();
            }

            //Returning the element next to the current element
            @Override
            public E next() {
                return list.get(current++);
            }

            //Removing element in list
            @Override
            public void remove() {
                delete(list.get(current));
                list.clear();
                inorder();
            }
        }

        //Clear tree of all elements
        @Override
        public void clear() {
            root = null;
            size = 0;
        }
    }
}