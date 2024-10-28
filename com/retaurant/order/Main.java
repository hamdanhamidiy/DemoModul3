package modul3.tugas.com.retaurant.order;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("=== Restoran Sederhana ===");
        String input;
        do {
            System.out.print("Masukkan nama makanan: ");
            String name = scanner.nextLine();
            System.out.print("Masukkan harga: ");
            double price = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            order.addMenu(new Menu(name, price));

            System.out.print("Tambah pesanan lagi? (y/n): ");
            input = scanner.nextLine();
        } while (input.equalsIgnoreCase("y"));

        order.displayOrder();
        System.out.printf("Total: Rp%.2f%n", order.calculateTotal());
        System.out.printf("Total dengan pajak dan diskon: Rp%.2f%n", order.calculateWithTaxAndDiscount());
    }
}

