/*
 * Author: Kaden Payne
 * Date: 9/10/2020
 * 
 * Cirlce class the extends GeometricObject class
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
    
    //Getter and Setter
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    //getArea and getPerimeter methods
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    
    public boolean equals(Circle circle) {
        return this.radius == circle.getRadius();
    }
    
    //toString method
    @Override
    public String toString() {
        return "[Circle] radius = " + radius;
    }
}
