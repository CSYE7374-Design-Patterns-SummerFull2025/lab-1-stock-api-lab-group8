package edu.neu.csye7374;

public class MicrosoftStock extends Stock implements Tradeable0{

    private double earningsPerShare;

    public MicrosoftStock(String name, double price, String description, double earningsPerShare) {
        super(name, price, description);
        this.earningsPerShare = earningsPerShare;
    }


    @Override
    public String calculateMetric() {
        if (earningsPerShare == 0) {
            return "Undefined";
        }
        double peRatio = getPrice() / earningsPerShare;
        return String.format("PE Ratio: %.2f", peRatio);
    }

    @Override
    public void setBid(String bid) {
        Tradeable0.super.setBid(bid);
    }

    @Override
    public String getMetric() {
        return Tradeable0.super.getMetric();
    }
}
