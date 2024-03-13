/*
Created by: Dany
Created on 12/03/2024 : 18:17
This is program to
*/

import java.io.*;
import java.util.*;

public class TransactionManager {
    private static final String TRANSACTION_FILE_PATH = "csv/transactions.csv";

    // Method to append transactions to the transactions file
    public static void saveTransactions(List<Transaction> transactions) {
        try (FileWriter fileWriter = new FileWriter(TRANSACTION_FILE_PATH, true);
             PrintWriter out = new PrintWriter(fileWriter)) {
            for (Transaction transaction : transactions) {
                out.println(transaction);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving transactions: " + e.getMessage());
        }
    }
}
