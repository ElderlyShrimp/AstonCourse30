package org.example;

import java.util.*;

public class PhoneBook {
    Map<String, List<String>> book = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        if (book.containsKey(lastName)) {
            List<String> phones = book.get(lastName);
            phones.add(phoneNumber);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phoneNumber);
            book.put(lastName, phones);
        }
    }

    public List<String> get(String lastName) {
        if (book.containsKey(lastName)) {
            return book.get(lastName);
        } else {
            return new ArrayList<>();
        }
    }
}