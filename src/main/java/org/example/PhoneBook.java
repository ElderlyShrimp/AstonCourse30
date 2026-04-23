package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phonebook;

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String surname, String number){
        if (phonebook.containsKey(surname)) {
            List<String> numbers = phonebook.get(surname);
            numbers.add(number);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(number);
            phonebook.put(surname, numbers);
        }
    }

    public List<String> get(String surname) {
        return phonebook.get(surname);
    }
}