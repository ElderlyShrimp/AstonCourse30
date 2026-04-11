package org.example;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String name;
    private String location;
    private List<Attraction> attractions;

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
        this.attractions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    class Attraction{
        private String name;
        private double price;
        private String operatingMode;

        public Attraction(String name, double price, String operatingMode) {
            this.name = name;
            this.price = price;
            this.operatingMode = operatingMode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getOperatingMode() {
            return operatingMode;
        }

        public void setOperatingMode(String operatingMode) {
            this.operatingMode = operatingMode;
        }
    }
}
