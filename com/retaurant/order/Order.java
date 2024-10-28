package modul3.tugas.com.retaurant.order;


import java.util.ArrayList;

public class Order {
    private ArrayList<Menu> menuList = new ArrayList<>();

    public void addMenu(Menu menu) {
        menuList.add(menu);
    }

    public void displayOrder() {
        System.out.println("=== Nota Pemesanan ===");
        for (Menu menu : menuList) {
            System.out.printf("%-20s Rp%.2f%n", menu.getName(), menu.getPrice());

        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Menu menu : menuList) {
            total += menu.getPrice();
        }
        return total;
    }

    public double calculateWithTaxAndDiscount() {
        double total = calculateTotal();
        // Custom Live Template for calculation: total * (1 + tax/100) - discount
        final double tax = 10.0;  // Pajak 10%
        final double discount = 5000;  // Diskon Rp5.000
        return (total * (1 + tax / 100)) - discount;
        // Custom Live Template: Kalkulasi Total
    }
}

