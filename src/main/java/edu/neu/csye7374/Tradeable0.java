package edu.neu.csye7374;

public interface Tradeable0 extends Tradable {

    @Override
    default void setBid(String bid) {
        String[] parts = bid.split(" ");
        if (parts.length != 2) {
            System.out.println("Try 'BUY <quantity>' or 'SELL <quantity>'.");
            return;
        }

        String action = parts[0];
        int quantity;
        try {
            quantity = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity in bid.");
            return;
        }

        if (action.equalsIgnoreCase("BUY")) {
            setPrice(getPrice() + (quantity * 0.5));
        } else if (action.equalsIgnoreCase("SELL")) {
            setPrice(getPrice() - (quantity * 0.5));
        } else {
            System.out.println("Invalid action in bid. Use 'BUY' or 'SELL'.");
        }
    }

    @Override
    default String getMetric() {
        return String.format("%.2f", getPrice() / 100);
    }

    // Methods to be defined in implementing classes
    double getPrice();
    void setPrice(double price);
}
