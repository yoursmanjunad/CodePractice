package myPackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student st = new Student();

        try {
            // Initialize the database and table (createDB and createTb methods).
//            st.createDB();
//            st.createTb();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Display a menu to choose the CRUD operation
                System.out.println("Choose an operation:");
                System.out.println("1. Create Data");
                System.out.println("2. Read Data");
                System.out.println("3. Update Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Create Data
                        st.createData();
                        break;
                    case 2:
                        // Read Data
                        st.readData();
                        break;
                    case 3:
                        // Update Data
                        st.updateData();
                        break;
                    case 4:
                        // Delete Data
                        st.deleteData();
                        break;
                    case 5:
                        // Exit the program
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid operation.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
