package Homework;

public class Circle {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle(radius=" + radius + ", circumference=" + String.format("%.4f", getCircumference())
                + ", area=" + String.format("%.4f", getArea()) + ")";
    }

    // Demo main
    public static void main(String[] args) {
        Circle c = new Circle(3.0);
        System.out.println(c.toString());
        System.out.printf("Radius: %.2f\nCircumference: %.4f\nArea: %.4f\n", c.getRadius(), c.getCircumference(), c.getArea());
    }
}
