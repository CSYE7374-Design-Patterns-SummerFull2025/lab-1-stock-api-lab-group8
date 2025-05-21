package edu.neu.csye7374;

public abstract class Stock {
    private String name;
    private double price;
    private String description;

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String calculateMetric();

    @Override
    public String toString() {
        return "Stock{" +
                "Stock Name='" + name + '\'' +
                ",Stock Price=" + String.format("%.2f", price) +
                ", Description='" + description + '\'' +
                ", Metric=" + calculateMetric() +
                '}';
    }
}