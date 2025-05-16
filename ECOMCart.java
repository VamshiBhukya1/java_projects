import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " " + price;
    }
}

public class ECOMCart {
    ArrayList<Product> cart;

    ECOMCart() {
        cart = new ArrayList<>();
    }

    public void addProduct(Product p) {
        for (Product existingProduct : cart) {
            if (existingProduct.getName().equalsIgnoreCase(p.getName())) {
                System.out.println("Product already exists in the cart.");
                return;
            }
        }
        cart.add(p);
        System.out.println("Product added to cart.");
    }

    public void removeProduct(String name) {
        for (Product p : cart) {
            if (p.getName().equalsIgnoreCase(name)) {
                cart.remove(p);
                System.out.println("Product removed from the cart.");
                return;
            }
        }
        System.out.println("Product name not found.");
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        for (Product p : cart) {
            System.out.println(p);
        }
    }

    public void calculate() {
        double total = 0.0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        double discount = (total >= 100000) ? 0.1 * total : 0.0;
        System.out.println("Total cost: " + total);
        System.out.println("Discount given: " + discount);
        System.out.println("Final cost: " + (total - discount));
    }

    public static int menu() {
        System.out.println("\n1. Add\n2. Remove\n3. Display\n4. Calculate\n5. Exit");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        return ch;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ECOMCart obj = new ECOMCart();

        while (true) {
            try {
                int ch = menu();
                switch (ch) {
                    case 1:
                        System.out.println("Enter product name and price:");
                        String n = sc.next();
                        double pr = sc.nextDouble();
                        Product p = new Product(n, pr);
                        obj.addProduct(p);
                        break;

                    case 2:
                        System.out.println("Enter product name to remove:");
                        String nameToRemove = sc.next();
                        obj.removeProduct(nameToRemove);
                        break;

                    case 3:
                        System.out.println("Cart contents:");
                        obj.displayCart();
                        break;

                    case 4:
                        System.out.println("Calculating total:");
                        obj.calculate();
                        break;

                    case 5:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Wrong input.");
                sc.nextLine();
            }
        }
    }
}
