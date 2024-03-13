/*
Created by: Dany
Created on 12/03/2024 : 17:12
This is program to
*/

import java.io.*;
import java.util.*;

public class InventoryManager {
    private static final String INVENTORY_FILE_PATH = "csv/inventory.csv";

    // Reads the inventory from the CSV file and returns it as a Map of MenuItem objects
    public static Map<String, MenuItem> readInventory() {
        Map<String, MenuItem> menuItems = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INVENTORY_FILE_PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(", ");
                if (values.length == 2) {
                    menuItems.put(values[0].toLowerCase().trim(), new MenuItem(values[0].trim(), Double.parseDouble(values[1].trim())));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the inventory: " + e.getMessage());
        }
        return menuItems;
    }

    // Writes the current inventory (Map of MenuItem objects) back to the CSV file
    public static void writeInventory(Map<String, MenuItem> menuItems) {
        try (PrintWriter out = new PrintWriter(new FileWriter(INVENTORY_FILE_PATH))) {
            for (MenuItem item : menuItems.values()) {
                out.println(item.getName() + ", " + item.getPrice());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the inventory: " + e.getMessage());
        }
    }

    // Adds a new item to the inventory or updates it if it already exists
    public static void addItemToInventory(String itemName, double itemPrice) {
        Map<String, MenuItem> menuItems = readInventory();
        menuItems.put(itemName, new MenuItem(itemName, itemPrice));
        writeInventory(menuItems);
    }

    // Removes an item from the inventory by its name
    public static void removeItemFromInventory(String itemName) {
        Map<String, MenuItem> menuItems = readInventory();
        if (menuItems.containsKey(itemName)) {
            menuItems.remove(itemName);
            writeInventory(menuItems);
            System.out.println(itemName + " removed successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    // Prints the inventory items in column format
    public static void printInventory(Map<String, MenuItem> menuItems) {
        System.out.printf("%-20s %s\n", "Item", "Price");
        System.out.println("--------------------------------");
        for (MenuItem item : menuItems.values()) {
            System.out.printf("%-20s $%.2f\n", item.getName(), item.getPrice());
        }
    }
}

