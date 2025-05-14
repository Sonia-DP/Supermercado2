

public class help {
    public static void main(String[] args) {
        // Bill Header
        System.out.println("SuperMart Supermarket");
        System.out.println("123 Fresh Street, Cityville, 12345");
        System.out.println("Tel: (555) 123-4567\n");
        System.out.println("Date: May 8, 2025");
        System.out.println("Time: 12:34 PM\n");

        // Table Header
        System.out.printf("%-25s %-10s %-12s %-10s%n", "ITEM DESCRIPTION", "QUANTITY", "UNIT PRICE", "TOTAL");
        System.out.println("---------------------------------------------------------------");

        // Items
        printItem("Milk (1L)", 2, 1.50);
        printItem("Bread (Whole Wheat)", 1, 2.20);
        printItem("Eggs (Dozen)", 1, 3.00);
        printItem("Apples (1kg)", 3, 2.50);
        printItem("Tomatoes (500g)", 2, 1.80);
        printItem("Rice (2kg)", 1, 4.00);
        printItem("Chicken Breasts (500g)", 2, 5.00);
        printItem("Carrots (1kg)", 1, 1.70);

        // Subtotal and tax
        double subtotal = 35.00;
        double tax = subtotal * 0.08;
        double total = subtotal + tax;

        System.out.println("\n---------------------------------------------------------------");
        System.out.printf("%-49s $%6.2f%n", "Subtotal", subtotal);
        System.out.printf("%-49s $%6.2f%n", "Sales Tax (8%)", tax);
        System.out.printf("%-49s $%6.2f%n", "Total", total);

        // Footer
        System.out.println("\nThank you for shopping with us!");
        System.out.println("Visit us again soon.");
    }

    public static void printItem(String name, int quantity, double unitPrice) {
        double total = quantity * unitPrice;
        System.out.printf("%-25s %-10d $%-11.2f $%-9.2f%n", name, quantity, unitPrice, total);
    }
}