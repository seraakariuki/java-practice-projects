package Homework;

public class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(int productId, String name, double price, int quantity) {
        setProductId(productId);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters with validation
    public void setProductId(int productId) {
        if (productId <= 0) {
            throw new IllegalArgumentException("Product ID must be positive");
        }
        this.productId = productId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        this.name = name.trim();
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    // Inventory operations
    public void addStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to add must be positive");
        }
        this.quantity += amount;
        System.out.println("Added " + amount + " units of " + name + ". New quantity: " + quantity);
    }

    public boolean removeStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to remove must be positive");
        }
        if (amount > quantity) {
            System.out.println("Error: Not enough stock. Available: " + quantity + ", Requested: " + amount);
            return false;
        }
        this.quantity -= amount;
        System.out.println("Removed " + amount + " units of " + name + ". New quantity: " + quantity);
        return true;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public boolean isInStock() {
        return quantity > 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + name + '\'' +
                ", price=$" + String.format("%.2f", price) +
                ", quantity=" + quantity +
                ", totalValue=$" + String.format("%.2f", getTotalValue()) +
                ", inStock=" + isInStock() +
                '}';
    }

    // Demo main
    public static void main(String[] args) {
        System.out.println("=== Inventory System Demo ===\n");

        // Create products
        Product laptop = new Product(1, "Laptop", 999.99, 5);
        Product mouse = new Product(2, "Mouse", 29.99, 50);
        Product keyboard = new Product(3, "Keyboard", 79.99, 0);

        // Display initial products
        System.out.println(laptop.toString());
        System.out.println(mouse.toString());
        System.out.println(keyboard.toString());

        // Test inventory operations
        System.out.println("\n--- Inventory Operations ---");
        laptop.addStock(3);
        mouse.removeStock(10);
        keyboard.addStock(20);
        keyboard.removeStock(5);

        // Final state
        System.out.println("\n--- Final Inventory ---");
        System.out.println(laptop.toString());
        System.out.println(mouse.toString());
        System.out.println(keyboard.toString());

        // Calculate total inventory value
        System.out.println("\n--- Inventory Summary ---");
        double totalValue = laptop.getTotalValue() + mouse.getTotalValue() + keyboard.getTotalValue();
        System.out.printf("Total Inventory Value: $%.2f\n", totalValue);
    }
}
