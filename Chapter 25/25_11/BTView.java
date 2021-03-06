/*
 * Author: Kaden Payne
 * Date: 10/07/2020
 * 
 * Pane that displays BST
 */
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
/**
 *
 * @author kjpay
 */
public class BTView extends Pane {
    
    private BST<Integer> tree = new BST<>();
    private double radius = 15;
    private double vGap = 50; // Gap between two levels in a tree
    
    //Constructor
    BTView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }
    
    //Returns status of tree
    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }
    
    //Displays tree
    public void displayTree() {
        this.getChildren().clear();
        if (tree.getRoot() != null) {
            displayTree(tree.getRoot(), getWidth() / 14, 115, getWidth() / 8);
        }
    }
    private void displayTree(BST.TreeNode<Integer> root, double x, double y, double hGap) {
        if (root.left != null) {
            // Draw a line to the left node
            getChildren().add(new Line(x + hGap, y - vGap, x, y));
            // Draw the left subtree recursively
            displayTree(root.left, x + hGap, y - vGap, hGap / 2);
        }
        
        if (root.right != null) {
            // Draw a line to the right node
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            // Draw the right subtree recursively
            displayTree(root.right, x + hGap, y + vGap, hGap / 2);
        }
        
        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - 6, y + 6, root.element + ""));
    }
}
