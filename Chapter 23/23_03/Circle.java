/*
 * Author: Kaden Payne
 * Date: 9/28/2020;
 * 
 * Geometric circle, part of GeometricObject
 */

/**
 *
 * @author kjpay
 */
public class Circle extends GeometricObject {
    private double radius;
    
    //Constructors
    public Circle() {
        this(1.0);
    }
    public Circle(double radius) {
        this(radius, "white", false);
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    
    //Getters and Setters
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    //Implementing getArea and getPerimeter methods
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    
    //Overriding the equals method
    public boolean equals(Circle circle) {
        return this.radius == circle.getRadius();
    }
    
    //Overriding the toString method
    @Override
    public String toString() {
        return "[Circle] radius = " + radius;
    }
}
