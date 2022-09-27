package ch.bfo.m_223.contract;

import java.util.ArrayList;

public class OrderDto {
    private final ArrayList<Integer> bookIds = new ArrayList<Integer>();
    private float customerId;


    // Getter Methods

    public float getCustomerId() {
        return customerId;
    }

    // Setter Methods

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void addBook(int bookId) {
        bookIds.add(bookId);
    }
}