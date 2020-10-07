/*
 * Author: Kaden Payne
 * Date: 10/01/2020
 * 
 * Adding breathFirstTraversal mehtod and height method to Exercise25_01
 */

/**
 *
 * @author kjpay
 */
public class BinaryTreeExercise {
    public static void main(String[] args) {
        new BinaryTreeExercise();
    }
    
    public BinaryTreeExercise() {
        BinaryTree<String> tree = new BinaryTree<>(); 
        System.out.print("The height of tree is " + tree.height());
        
        tree.insert("Red");
        System.out.print("\nThe height of tree is " + tree.height());

        tree.insert("Green");
        System.out.print("\nThe height of tree is " + tree.height());
        
        BinaryTree<String> tree1 = new BinaryTree<>(new String[]
        {"Tom", "George", "Jean", "Jane", "Kevin", "Peter", "Susan", 
          "Jen", "Kim", "Michael", "Michelle"});
        System.out.print("\nThe breadth-first traversal for tree1 is ");
        tree1.breathFirstTraversal();
        System.out.print("\nThe height of tree1 is " + tree1.height());
        
        BinaryTree<Integer> tree2 = new BinaryTree<>(new Integer[]{50, 45, 35, 48, 59, 51, 58});
        System.out.print("\nThe breadth-first traversal for tree2 is ");
        tree2.breathFirstTraversal();
        System.out.print("\nThe height of tree2 is " + tree2.height());
        System.out.println();
    }
    
    public class BinaryTree<E extends Comparable<E>> extends AbstractTree<E> {
        protected TreeNode<E> root;
        protected int size = 0;
        
        //Constructors
        public BinaryTree() {
            
        }
        public BinaryTree(E[] objects) {
            for (int i = 0; i < objects.length; i++) {
                insert(objects[i]);
            }
        }
        
        //Returning height of tree
        public int height() {
            return height(root);
        }
        protected int height(TreeNode<E> root) {
            //int count = 1;
            if (root == null) {
                return 0;
            }
            else {
                return 1 + Math.max(height(root.left), height(root.right));
            }
            /*else if (height(root.left) < height(root.right)) {
                count++;
            }
            else if (height(root.left) > height(root.right)) {
                count++;
            }
            
            return count;*/
        }
        
        //Display tree with breathFirstTraversal
        public void breathFirstTraversal() {
            java.util.LinkedList<TreeNode<E>> queue = new java.util.LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                TreeNode<E> current = queue.getFirst();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                
                System.out.print(queue.pop().element + " ");
            }
        }
        
        //Search if element is in tree
        @Override
        public boolean search(E e) {
            TreeNode<E> current = root;
            
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                }
                else if ( e.compareTo(current.element) > 0) {
                    current = current.right;
                }
                else {
                    return true;
                }
            }
            return false;
        }
        
        //Adding element to tree
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
        
        //Creating new Node
        protected TreeNode<E> createNewNode(E e) {
            return new TreeNode<E>(e);
        }
        
        //Traversing the tree in order
        @Override
        public void inorder() {
            inorder(root);
        }
        protected void inorder(TreeNode<E> root) {
            if (root == null) 
                return;
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
        
        //Traversing the tree in post order
        @Override
        public void postorder() {
            postorder(root);
        }
        protected void postorder(TreeNode<E> root) {
            if (root == null)
                return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element + " ");
        }
        
        //Traversing the tree in preorder
        @Override
        public void preorder() {
            preorder(root);
        }
        protected void preorder(TreeNode<E> root) {
            if (root == null)
                return;
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }
        
        //TreeNode Class
        public class TreeNode<E extends Comparable<E>> {
            E element;
            
            TreeNode<E> left;
            
            TreeNode<E> right;
            
            public TreeNode(E e) {
                element = e;
            }
        }
        
        //Returning size of tree
        @Override
        public int getSize() {
            return size;
        }
        
        //Returning root of the tree
        public TreeNode getRoot() {
            return root;
        }
        
        //Returning path from the root to a specified element
        public java.util.ArrayList<TreeNode<E>> path(E e) {
            java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<> ();
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
        
        //Deleting an element from the tree
        @Override
        public boolean delete(E e) {
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
                    break;
                }
            }
            
            if (current == null) {
                return false;
            }
            
            //Case 1: no left children
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
                //Case 2: has left child
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;
                
                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right;
                }
                
                current.element = rightMost.element;
                
                if (parentOfRightMost.right == rightMost) {
                    parentOfRightMost = rightMost.left;
                }
                else if (parentOfRightMost == current) {
                    parentOfRightMost.left = rightMost.left;
                }
            }
            
            size--;
            return true;
        }
        
        //Obtain an iterator in order
        @Override
        public java.util.Iterator iterator() {
            return inorderIterator();
        }
        public java.util.Iterator inorderIterator() {
            return new InorderIterator();
        }
        
        class InorderIterator implements java.util.Iterator {
            private java.util.ArrayList<E> list = new java.util.ArrayList<>();
            
            private int current = 0;
            
            //Constructor
            public InorderIterator() {
                inorder();
            }
            
            //Traversing in order
            private void inorder() {
                inorder(root);
            }
            private void inorder(TreeNode<E> root) {
                if (root == null)
                    return;
                inorder(root.left);
                list.add(root.element);
                inorder(root.right);
            }
            
            //Check if there's a next element
            @Override
            public boolean hasNext() {
                if (current < list.size()) {
                    return true;
                }
                
                return false;
            }
            
            //Return next object
            @Override
            public Object next() {
                return list.get(current++);
            }
            
            @Override
            public void remove() {
                delete(list.get(current));
                list.clear();
                inorder();
            }
        }
        
        //Clearing tree of elements
        public void clear() {
            root = null;
            size = 0;
        }
    }
    
    public interface Tree<E extends Comparable<E>> {
        //Search if element is in tree
        public boolean search(E e);
        
        //Adding to the tree
        public boolean insert(E e);
        
        //Removing from the tree
        public boolean delete(E e);
        
        //Traversings
        public void inorder();
        
        public void postorder();
        
        public void preorder();
        
        //Return size of tree
        public int getSize();
        
        //Check if tree is empty
        public boolean isEmpty();
        
        //Return iterator
        public java.util.Iterator iterator();
    }
    
    public abstract class AbstractTree<E extends Comparable<E>> implements Tree<E> {
        @Override
        public void inorder() {
            
        }
        @Override
        public void postorder() {
            
        }
        @Override
        public void preorder() {
            
        }
        
        @Override
        public boolean isEmpty() {
            return getSize() == 0;
        }
        
        @Override
        public java.util.Iterator iterator() {
            return null;
        }
    }
}
