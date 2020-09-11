/*
 * Author: Kaden Payne
 * Date: 9/11/2020
 * 
 * Rectangle class that extends GeometricObject class
 */

/**
 *
 * @author kjpay
 */
public class Rectangle extends GeometricObject {
    private double width;
    private double height;
    
    //Constructors
    public Rectangle() {
        
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }
    
    //Getters and setters
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    
    //Area and perimeter methods
    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    //toString method
    @Override
    public String toString() {
        return "[Rectangle] width = " + width + " and height = " + height;
    }
}
