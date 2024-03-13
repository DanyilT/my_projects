/*
Created by: Dany
Created on 12/03/2024 : 17:12
This is program to
*/

import java.util.*;

public class Main {
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String PASSWORD = "qwerty";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        String message = "Press button ENTER";
            // ANSI color codes
            String[] colors = {"\033[31m", // Red
                               "\033[32m", // Green
                               "\033[33m", // Yellow
                               "\033[34m", // Blue
                               "\033[35m", // Purple
                               "\033[36m", // Cyan
                               "\033[37m"}; // White

        while (running) {
            for (int i = 0; i < message.length(); i++) {
                System.out.print(colors[i % colors.length] + message.charAt(i));
            }
            System.out.println("\033[0m"); // Reset to default color

            scanner.nextLine();
            scanner.nextLine();

            System.out.println("\033[0;1m+---------------------------------------+");
            System.out.println("|   ☕️  \033[0;34mWelcome to Our CoffeeShop\033[0;1m  ☕️   |");
            System.out.println("|             \033[0;34mMain Menu\033[0;1m                 |");
            System.out.println("+---------------------------------------+");
            System.out.println("| 📝  \033[0m1. \033[0;32mMake an order\033[0;1m                  |");
            System.out.println("| 🔐  \033[0m2. \033[0;32mSee/Modify the inventory file\033[0;1m  |");
            System.out.println("|                  \033[0;33m(for admin only)\033[0;1m     |");
            System.out.println("| 🚪  \033[0m3. \033[0;31mExit\033[0;1m                           |");
            System.out.println("+---------------------------------------+\033[0m");
            System.out.print("| 👉  Choose an option: ");
            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    placeOrder(scanner, InventoryManager.readInventory());
                    break;
                case 2:
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    if (PASSWORD.equals(password)) {
                        adminPanel(scanner);
                    } else {
                        System.out.println("Incorrect password. Returning to main menu...");
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    public static void placeOrder(Scanner scanner, Map<String, MenuItem> menuItems) {
        if (menuItems == null) {
            menuItems = InventoryManager.readInventory();
        }
        System.out.println("Available items:");
        InventoryManager.printInventory(menuItems);

        List<MenuItem> orderedItems = new ArrayList<>();

        System.out.print("Enter the name of the item you want to order:");
        String itemName = scanner.next().trim().toLowerCase();

        if (!menuItems.containsKey(itemName)) {
            System.out.println("Item not found. Please try again.");
        } else {
            MenuItem item = menuItems.get(itemName);
            orderedItems.add(item);
            System.out.println(item.getName() + " added to your order.");
        }

        MenuItem item = menuItems.get(itemName.toLowerCase());
        System.out.println("Total cost: $" + item.getPrice());

        System.out.println("Select payment method: 1. CASH 2. CARD");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (paymentChoice == 1) {
            double amountTendered = 0;
            do {
                System.out.print("Enter amount tendered: ");
                amountTendered = scanner.nextDouble();
                if (amountTendered < item.getPrice()) {
                    System.out.println("Amount tendered must be greater than or equal to the total cost.");
                }
            } while (amountTendered < item.getPrice());
            double changeGiven = amountTendered - item.getPrice();
            transactions.add(new Transaction(itemName, item.getPrice(), "CASH", amountTendered, changeGiven, null));
            System.out.printf("Receipt: %s, Change: %.2f\n", itemName, changeGiven);
        } else if (paymentChoice == 2) {
            System.out.println("Select card type: 1. Visa 2. Master");
            int cardChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String cardType = cardChoice == 1 ? "Visa" : "Master";
            transactions.add(new Transaction(itemName, item.getPrice(), "CARD", 0, 0, cardType));
            System.out.printf("Receipt: %s, Card Type: %s\n", itemName, cardType);
        } else {
            System.out.println("Invalid payment method.");
        }
        TransactionManager.saveTransactions(transactions);
    }

    private static void adminPanel(Scanner scanner) {
        System.out.println("1. See all inventory");
        System.out.println("2. Add new position");
        System.out.println("3. Remove item from inventory");
        System.out.print("Choose an option: ");
        int inventoryChoice = scanner.nextInt();
        switch (inventoryChoice) {
            case 1:
                InventoryManager.printInventory(InventoryManager.readInventory());
                break;
            case 2:
                System.out.print("Enter new item name: ");
                scanner.nextLine();
                String itemName = scanner.nextLine();
                System.out.print("Enter price: ");
                double itemPrice = scanner.nextDouble();
                InventoryManager.addItemToInventory(itemName, itemPrice);
                System.out.println("Adding " + itemName + ", cost $" + itemPrice);
                break;
            case 3:
                InventoryManager.printInventory(InventoryManager.readInventory());
                System.out.print("Enter item name to remove: ");
                String nameToRemove = scanner.next();
                InventoryManager.removeItemFromInventory(nameToRemove);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
