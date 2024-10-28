package modul3.tugas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Antarmuka untuk pengelolaan daftar tugas.
 * Menyediakan operasi dasar seperti menambah, menampilkan, dan menghapus tugas.
 */

interface TaskManager {

    /**
     * Menambahkan tugas baru ke daftar.
     *
     * @param task Tugas yang akan ditambahkan.
     */
    void addTask(String task);

    /**
     * Menampilkan semua tugas dalam daftar.
     */
    void displayAllTasks();

    /**
     * Menghapus tugas berdasarkan indeks yang diberikan.
     *
     * @param index Indeks tugas yang akan dihapus (dimulai dari 1).
     */
    void removeTaskByIndex(int index);
}

/**
 * Kelas untuk mengelola daftar tugas (To-do List).
 * Mengimplementasikan antarmuka {@link TaskManager}.
 */
public class TodoList implements TaskManager {
    private ArrayList<String> tasks;
    private static final int EXIT_OPTION = 4;

    /**
     * Konstruktor untuk membuat objek TodoList baru.
     * Menginisialisasi daftar tugas sebagai {@link ArrayList}.
     */
    public TodoList() {
        tasks = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTask(String task) {
        tasks.add(task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayAllTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    /**
     * {@inheritDoc}
     * Jika indeks tidak valid, akan menampilkan pesan kesalahan.
     *
     * @param index Indeks tugas yang akan dihapus (dimulai dari 1).
     */
    @Override
    public void removeTaskByIndex(int index) {
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    /**
     * Menangani input dari pengguna dan memproses pilihan menu.
     *
     * @param todo Objek {@link TodoList} yang akan digunakan untuk mengelola tugas.
     */
    private static void handleUserInput(TodoList todo) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Display tasks");
            System.out.println("3. Remove task");
            System.out.println(EXIT_OPTION + ". Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumsi karakter newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    todo.addTask(task);
                    break;
                case 2:
                    todo.displayAllTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to remove: ");
                    int index = scanner.nextInt();
                    todo.removeTaskByIndex(index);
                    break;
                case EXIT_OPTION:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Metode utama untuk menjalankan program TodoList.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        TodoList todo = new TodoList();
        handleUserInput(todo);
    }
}
