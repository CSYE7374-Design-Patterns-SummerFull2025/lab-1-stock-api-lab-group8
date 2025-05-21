package edu.neu.csye7374;

public interface Tradeable1 extends Tradable{

    @Override
    default String getMetric() {
        return String.format("%.2f", getPrice() - 50);
    }

    double getPrice();
    void setPrice(double price);
}
