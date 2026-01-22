// Rectangle.java
public class Rectangle {
    // Properties
    private double width;
    private double height;

    // Default constructor (1x1 rectangle)
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    // Constructor with width and height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Constructor with single size (square)
    public Rectangle(double size) {
        this.width = size;
        this.height = size;
    }

    // Method to calculate area
    public double calculateArea() {
        return width * height;
    }

    // Optional: Getters and Setters
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

    // Test the class
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(); // default 1x1
        Rectangle r2 = new Rectangle(4, 5); // width=4, height=5
        Rectangle r3 = new Rectangle(3); // square 3x3

        System.out.println("Area of r1: " + r1.calculateArea());
        System.out.println("Area of r2: " + r2.calculateArea());
        System.out.println("Area of r3: " + r3.calculateArea());
    }
}
