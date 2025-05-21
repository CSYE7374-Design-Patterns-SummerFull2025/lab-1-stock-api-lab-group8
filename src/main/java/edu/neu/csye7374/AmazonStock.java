package edu.neu.csye7374;

public class AmazonStock extends Stock implements Tradeable1 {
    private double priceFactor;

    public AmazonStock(String name, double price, String description, double priceFactor) {
        super(name, price, description);
        this.priceFactor = priceFactor;
    }

    @Override
    public void setBid(String bid) {
        String[] parts = bid.split(" ");
        if (parts.length != 2) {
            System.out.println("Invalid bid format. Use 'BUY <quantity>' or 'SELL <quantity>'.");
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
            setPrice(getPrice() + (quantity * 0.4));
        } else if (action.equalsIgnoreCase("SELL")) {
            setPrice(getPrice() - (quantity * 0.4));
        } else {
            System.out.println("Invalid action in bid. Use 'BUY' or 'SELL'.");
        }
    }

    @Override
    public String getMetric() {
        return Tradeable1.super.getMetric();
    }

    @Override
    public String calculateMetric() {
        return String.format("Price Factor: %.2f", priceFactor);
    }
}