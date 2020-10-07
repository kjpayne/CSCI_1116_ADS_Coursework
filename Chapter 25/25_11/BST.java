/*
 * Author: Kaden Payne
 * Date: 10/07/2020
 * 
 * Binary Search Tree
 */

/**
 *
 * @author kjpay
 * @param <E>
 */
public class BST<E extends Comparable<E>> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    
    //Constructors
    public BST() {
        
    }
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }
    
    //Searchs tree for element
    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        
        while (current != null) {
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
    
    //Creates a new TreeNode
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }
    
    //Travers inorder
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
    
    //Travers postorder
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
    
    //Travers preorder
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
    
    //Inner TreeNode Class
    public static class TreeNode<E> {
        
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;
        
        public TreeNode(E e) {
            element = e;
        }
    }
    
    //Returns size
    @Override
    public int getSize() {
        return size;
    }
    
    //Returns root
    public TreeNode<E> getRoot() {
        return root;
    }
    
    //Returns path to a specified element
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root;
        
        while (current != null) {
            list.add(current); // Add the node to the list
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        
        return list;
    }
    
    //Removes element for tree
    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        
        if (current == null) {
            return false;
        }
        // Case 1: current has no left child
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            // Case 2: The current node has a left child
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else // Special case: parentOfRightMost == current
            {
                parentOfRightMost.left = rightMost.left;
            }
        }
        
        size--;
        return true;
    }
    
    //Obtain iterator
    @Override
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }
    
    //Inner Class InorderIterator
    private class InorderIterator implements java.util.Iterator<E> {
        private java.util.ArrayList<E> list = new java.util.ArrayList<>();
        private int current = 0;
        
        //Constructor
        public InorderIterator() {
            inorder();
        }
        
        //Travers inorder
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
        
        //Checks if there are more element to travers
        @Override
        public boolean hasNext() {
            if (current < list.size()) {
                return true;
            }

            return false;
        }
        
        //Return next element
        @Override
        public E next() {
            return list.get(current++);
        }
        
        //Removes element
        @Override
        public void remove() {
            delete(list.get(current));
            list.clear();
            inorder();
        }
    }
    
    //Clear tree of elements
    @Override
    public void clear() {
        root = null;
        size = 0;
    }
}
