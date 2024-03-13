/*
Created by: Dany
Created on 12/03/2024 : 18:17
This is program to
*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime timestamp;
    private String itemName;
    private double price;
    private String paymentType; // "CASH" or "CARD"
    private double amountTendered; // Relevant for CASH transactions
    private double changeGiven; // Relevant for CASH transactions
    private String cardType; // Relevant for CARD transactions

    public Transaction(String itemName, double price, String paymentType, double amountTendered, double changeGiven, String cardType) {
        this.timestamp = LocalDateTime.now();
        this.itemName = itemName;
        this.price = price;
        this.paymentType = paymentType;
        this.amountTendered = amountTendered;
        this.changeGiven = changeGiven;
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if ("CASH".equals(paymentType)) {
            return String.format("%s, %s, %.2f, %.2f, %.2f", timestamp.format(formatter), itemName, price, amountTendered, changeGiven);
        } else {
            return String.format("%s, %s, %.2f, %s", timestamp.format(formatter), itemName, price, cardType);
        }
    }
}
