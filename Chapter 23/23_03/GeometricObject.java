/*/
 * Author: Kaden Payne
 * Date: 9/28/2020
 * 
 * GeometricObject class for defining geometric objects
 */

/**
 *
 * @author kjpay
 */
public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    
    //Constructors
    protected GeometricObject() {
        
    }
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    //Getters and setters
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    //Abstract methods
    public abstract double getArea();
    public abstract double getPerimeter();
}
